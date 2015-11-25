package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.DBConnection;
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
public class UserRegisterServlet extends HttpServlet {

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
        String strUsername = request.getParameter("username");
        String strPassword = request.getParameter("password");
        String strFirstname = request.getParameter("firstname");
        String strLastname = request.getParameter("lastname");
        String doublePhone = request.getParameter("phone");
        String strAddress = request.getParameter("address");

        //error message
        String message = "";
        String page = "index.jsp";
        boolean registered = false;

        DBConnection dbConn = (DBConnection) request.getServletContext().getAttribute("dbConn");

        UserDAO userDAO = new UserDAO();
        //check if user exist
        boolean exist = userDAO.userExist(dbConn.getConnection(), strUsername);
        
        if (!exist) {
            //create new user object with entered information
            User user = new User(strUsername, strPassword, strFirstname, strLastname, doublePhone, strAddress);
            //register the user, and check if its successful
            registered = userDAO.Register(dbConn.getConnection(), user);
            if (registered) {
                //set the userID
                user.setUserID(userDAO.getUserID(dbConn.getConnection(), user));
                //redirect page
                page = "welcome.jsp";
                //set into session
                request.getSession().setAttribute("user", user);
            } else {
                message = "Failed, please try again!";
                page = "error.jsp";
            }
        } else {
            message = "User already exist in database!";
            page = "error.jsp";
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
        return "Short description";
    }// </editor-fold>

}
