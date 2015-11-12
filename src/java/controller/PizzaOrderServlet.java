/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pizza;

/**
 *
 * @author Jackie
 */
public class PizzaOrderServlet extends HttpServlet {

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

        if (request.getSession().getAttribute("cart") == null) {
            request.getSession().setAttribute("cart", new ArrayList<Pizza>());
            request.setAttribute("pizzaCount", 0);
        } else {

            ArrayList<Pizza> cart = (ArrayList<Pizza>) request.getSession().getAttribute("cart");
            Pizza pizza = new Pizza();

            //set delivery method
            boolean delivery = (request.getParameter("delivery").equals("true")) ? true : false;
            pizza.setDelivery(delivery);
            //set pizza size
            pizza.setSize(request.getParameter("pizzasize"));
            //adding toppings
            for (String t : request.getParameterValues("toppings")) {
                pizza.addTopping(t);
            }
            //calculate the price of the pizza
            pizza.getToppingCount();
            pizza.calPrice();

            //add to cart
            cart.add(pizza);

            request.getSession().setAttribute("cart", cart);
            request.setAttribute("pizzaCount", cart.size());
        }

        RequestDispatcher view = request.getRequestDispatcher("order.jsp");
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
    }

}
