/*
 * A class used to establish JDBC Connections.
 */
package model;
import java.sql.*;

/**
 *
 * 
 */
public class DBConnection {
    private String url;
    private String username;
    private String password;
    
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
    
    public static void closeJDBCObjects(Connection conn, Statement stmt) {
        closeJDBCObjects(conn, stmt, null);
    }
}
