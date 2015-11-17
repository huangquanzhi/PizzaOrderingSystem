/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DBConnection;
import model.User;

/**
 *
 * @author Jackie
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User AuthLog(Connection conn, String strUsername, String strPassword) {
        String query = "SELECT * FROM users WHERE userName = ? AND passWord = ?";
        User user = null;
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, strUsername);
            ps.setString(2, strPassword);

            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(strUsername);
                user.setUserPassword(strPassword);
                user.setPhone(rs.getString("phone"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setAddress(rs.getString("address"));

            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }

        return user;
    }

    public boolean userExist(Connection conn, String username) {
        Boolean exist = false;
        String query = "SELECT * FROM users WHERE userName = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            rs.last();
            if (rs.getRow() > 0) {
                exist = true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }

        return exist;
    }

    public int getUserID(Connection conn, User u) {
        int uid = 0;
        String query = "SELECT userID FROM users WHERE userName = ? AND userPassword";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserPassword());

            rs = ps.executeQuery();
            if (rs.next()) {
                uid = rs.getInt(0);
            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }

        return uid;

    }

    public User getUserbyID(Connection conn, int id) {

        String query = "SELECT * FROM users WHERE userID = ?";
        User user = null;
        
        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("UserName"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }

        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        }

        return user;

    }

    public boolean Register(Connection conn, User u) {
        String query = "INSERT INTO users(userName, passWord,firstName,lastName,phone,address) VALUES(?,?,?,?,?,?)";
        boolean registered = false;
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserPassword());
            ps.setString(3, u.getFirstName());
            ps.setString(4, u.getLastName());
            ps.setString(5, u.getPhone());
            ps.setString(6, u.getAddress());

            int count = ps.executeUpdate();
            if (count > 0) {
                registered = true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }

        return registered;
    }

    public ArrayList<User> getAllUsers(Connection conn) {

        String query = "SELECT * FROM users ";
        ArrayList<User> userlist = new ArrayList<User>();

        try {

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("UserName"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                userlist.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }

        return userlist;

    }
}
