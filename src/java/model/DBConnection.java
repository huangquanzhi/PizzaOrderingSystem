/*
 * A class used to establish JDBC Connections.
 */
package model;
import java.sql.*;

/**
 *
 * 
 * @author Jackie
 */
public class DBConnection {
    private String url;
    private String username;
    private String password;
    
    /**
     *
     * @param driver
     * @param url
     * @param database
     * @param username
     * @param password
     */
    public DBConnection(String driver, String url, String database,
            String username, String password) {
        
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            System.out.println("ERROR: Exception loading driver class");
        }

        this.url = url + database;
        this.username = username;
        this.password = password;
    }
    
    /**
     *
     * @return
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Exception creating Connection object");
        } finally {
            return conn;
        }
        
    }
    
    /**
     *
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            
            if (stmt != null) {
                stmt.close();
            }
            
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ignored) {
        }
    }
    
    /**
     *
     * @param conn
     * @param stmt
     */
    public static void closeJDBCObjects(Connection conn, Statement stmt) {
        closeJDBCObjects(conn, stmt, null);
    }
}
