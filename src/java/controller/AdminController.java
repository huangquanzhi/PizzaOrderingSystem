/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PizzaDAO;
import java.io.IOException;
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
public class AdminController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DBConnection dbConn = (DBConnection) request.getServletContext().getAttribute("dbConn");
        
        PizzaDAO pizzaDAO = new PizzaDAO();
        
        Object[] list = pizzaDAO.getAllOrder(dbConn.getConnection());
        
        double balance = 0 ;
        int totalQty = 0;
        int totalOrders = 0;
        
        for(Pizza p : (ArrayList<Pizza>)list[0]){
            balance += p.getPrice();
            totalQty += p.getQty();
            totalOrders ++;
        }
        
        request.setAttribute("pizzas",  (ArrayList<Pizza>)list[0]);
        request.setAttribute("users",  (ArrayList<User>)list[1]);
        request.setAttribute("balance" , balance);
        request.setAttribute("totalQty", totalQty);
        request.setAttribute("totalOrders", totalOrders);
        
        RequestDispatcher view = request.getRequestDispatcher(response.encodeURL("allOrders.jsp"));
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
