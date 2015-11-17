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
import model.Receipt;
import model.User;

/**
 *
 * @author Jackie
 */
public class CheckoutServlet extends HttpServlet {
    
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
        Receipt receipt = new Receipt((User) request.getSession().getAttribute("user"));
        
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<Pizza> cart = (ArrayList<Pizza>) request.getSession().getAttribute("cart");
        
        String page = "index.jsp";
        String message = "";
        
        if (cart.size() > 0) {
            PizzaDAO pizzaDAO = new PizzaDAO();
            if (pizzaDAO.addPizzaOrder(dbConn.getConnection(), user, cart)) {
                
                int deliveryQty = 0, pickupQty = 0;
                double deliveryPrice = 0, pickupPrice = 0;
                
                for (Pizza p : cart) {
                    if (p.getDelivery()) {
                        deliveryQty += p.getQty();
                        deliveryPrice += p.getPrice();
                    } else {
                        pickupQty += p.getQty();
                        pickupPrice += p.getPrice();
                    }
                }
                
                request.setAttribute("deliveryQty", deliveryQty);
                request.setAttribute("pickupQty", pickupQty);
                request.setAttribute("deliveryPrice", deliveryPrice);
                request.setAttribute("pickupPrice", pickupPrice);
                request.setAttribute("totalQty", deliveryQty + pickupQty);
                request.setAttribute("totalPrice", deliveryPrice + pickupPrice);
                request.setAttribute("totalPriceAfterTax", (deliveryPrice + pickupPrice) * 1.13);
                request.setAttribute("cart", cart);
                page = "receipt.jsp";
                //remove cart
                request.getSession().setAttribute("cart", new ArrayList<Pizza>());
            } else {
                
                message = "ERROR: Order failed to insert!";
                request.setAttribute("error", message);
                page = "error.jsp";
            }
        } else {
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
