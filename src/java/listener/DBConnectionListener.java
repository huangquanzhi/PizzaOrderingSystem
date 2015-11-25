/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.DBConnection;

/**
 * Web application lifecycle listener.
 *
 * @author Jackie
 */
public class DBConnectionListener implements ServletContextListener {

    /**
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc = sce.getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String db = sc.getInitParameter("database");
        String user = sc.getInitParameter("dbusername");
        String pass = sc.getInitParameter("dbpassword");

        DBConnection dbConn = new DBConnection(driver,url,db,user,pass);
        sc.setAttribute("dbConn", dbConn);
    }

    /**
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
