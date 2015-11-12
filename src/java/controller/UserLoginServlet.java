/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.connect.db.DBConnection;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Jackie
 */
public class UserLoginServlet extends HttpServlet {

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

        String strUsername = request.getParameter("username");
        String strPassword = request.getParameter("password");
        //error message
        String message = "";
        String page = "index.jsp";

        //create connection
        DBConnection dbConn = (DBConnection) request.getServletContext().getAttribute("dbConn");

        UserDAO userDAO = new UserDAO();

        boolean exist = userDAO.userExist(dbConn.getConnection(), strUsername);

        //user exist
        if (exist) {
            User user = userDAO.AuthLog(dbConn.getConnection(), strUsername, strPassword);
            //auth successful
            if (user != null) {

                if (user.getFirstName() == null || user.getLastName() == null || user.getAddress() == null) {
                    //user detail not completed
                    page = "setting.jsp";
                } else {
                    //user detail completed
                    page = "welcome.jsp";
                }
                //set user in sessions
                request.getSession().setAttribute("user", user);
            } else {
                page = "error.jsp";
                message = "Password incorrect!";
            }
        } else {
            page = "error.jsp";
            message = "User doesn't exist!";
        }

        request.setAttribute("error", message);
        RequestDispatcher view = request.getRequestDispatcher(response.encodeRedirectURL(page));
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "User Login Servlet";
    }

}
