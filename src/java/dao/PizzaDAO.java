/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Jackie
 */
public class PizzaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<User> getAllOrder(Connection conn) {

        String query = "SELECT * FROM Users ";
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
