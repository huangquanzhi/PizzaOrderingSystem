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
import model.Pizza;
import model.User;

/**
 *
 * @author Jackie
 */
public class PizzaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     *
     * @param conn Database connection
     * @return Array of Object, contain Pizza and User
     */
    public Object[] getAllOrder(Connection conn) {
        //sql query
        String query = "SELECT * FROM pizzaorders ";
        //list to store pizza and user arraylist
        Object[] list = new Object[2];
        
        ArrayList<Pizza> pizzalist = new ArrayList<Pizza>();
        ArrayList<User> userlist = new ArrayList<User>();

        try {

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Pizza pizza = new Pizza();

                //makeing new pizza with database information
                pizza.setDelivery(rs.getBoolean("delivery"));
                pizza.setPrice(rs.getDouble("price"));
                pizza.setQty(rs.getInt("quantity"));
                pizza.setSize(rs.getString("pizzaSize"));
                pizza.setToppingCount(rs.getInt("toppingNum"));
                //add to arraylist
                pizzalist.add(pizza);
                
                //create new User database access object to get user information
                UserDAO userDAO = new UserDAO();
                //create new user
                User user = userDAO.getUserbyID(conn,rs.getInt("userID"));
                userlist.add(user);
                
            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }
        //set arraylist into array
        list[0] = pizzalist;
        list[1] = userlist;
        
        return list;

    }

    /**
     *
     * @param conn Database connection
     * @param user  User information
     * @param pizza Arraylist of ordered pizzas
     * @return  True if success to insert into database
     */
    public boolean addPizzaOrder(Connection conn, User user, ArrayList<Pizza> pizza) {

        boolean success = false;
        int count = 0;
        //sql query
        String query = "INSERT INTO pizzaorders (userID,pizzaSize,toppingNum,quantity,delivery,price)"
                + "VALUES (?,?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, user.getUserID());

            //insert pizza into database with looping
            for (Pizza p : pizza) {

                ps.setString(2, p.getSize());
                ps.setInt(3, p.getToppingCount());
                ps.setInt(4, p.getQty());
                ps.setBoolean(5, p.getDelivery());
                ps.setDouble(6, p.getPrice());

                int c = ps.executeUpdate();

                //count the amount of pizza being inserted
                if (c > 0) {
                    count++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("SQL Error: " + ex.getErrorCode());
        } finally {
            DBConnection.closeJDBCObjects(null, ps, rs);
        }

        return (count == pizza.size());

    }
}
