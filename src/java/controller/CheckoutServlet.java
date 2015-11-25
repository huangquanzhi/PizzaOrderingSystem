/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PizzaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBConnection;
import model.Pizza;
import model.User;

/**
 *
 * @author Jackie
 */
public class CheckoutServlet extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DBConnection dbConn = (DBConnection) request.getServletContext().getAttribute("dbConn");
        
        //get the user object from session
        User user = (User) request.getSession().getAttribute("user");
        //get the cart with pizzas from session
        ArrayList<Pizza> cart = (ArrayList<Pizza>) request.getSession().getAttribute("cart");
        
        //page to redirect
        String page = "index.jsp";
        String message = "";
        
        //if there is item in cart
        if (cart.size() > 0) {
            //create database access object
            PizzaDAO pizzaDAO = new PizzaDAO();
            //add the pizza into database, if suceesful then 
            if (pizzaDAO.addPizzaOrder(dbConn.getConnection(), user, cart)) {
                
                //count
                int deliveryQty = 0, pickupQty = 0;
                double deliveryPrice = 0, pickupPrice = 0;
                //count the total ,base on delivery or pickup
                for (Pizza p : cart) {
                    if (p.getDelivery()) {
                        deliveryQty += p.getQty();
                        deliveryPrice += p.getPrice();
                    } else {
                        pickupQty += p.getQty();
                        pickupPrice += p.getPrice();
                    }
                }
                
                //set into attribute
                request.setAttribute("deliveryQty", deliveryQty);
                request.setAttribute("pickupQty", pickupQty);
                request.setAttribute("deliveryPrice", deliveryPrice);
                request.setAttribute("pickupPrice", pickupPrice);
                request.setAttribute("totalQty", deliveryQty + pickupQty);
                request.setAttribute("totalPrice", deliveryPrice + pickupPrice);
                request.setAttribute("totalPriceAfterTax", (deliveryPrice + pickupPrice) * 1.13);
                request.setAttribute("cart", cart);
                page = "receipt.jsp";
                //order have been confirmed, reset cart
                request.getSession().setAttribute("cart", new ArrayList<Pizza>());
            } else {
                //fail to insert into database
                message = "ERROR: Order failed to insert!";
                request.setAttribute("error", message);
                page = "error.jsp";
            }
        } else {
            //if there is no order
            page = "PizzaOrder";
        }
        
        RequestDispatcher view = request.getRequestDispatcher(response.encodeURL(page));
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
