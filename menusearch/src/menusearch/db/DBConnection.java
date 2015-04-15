package menusearch.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;
    private static String dbString = "jdbc:mysql://localhost:3306/nypl_menus"; 
    private static String userName = "root";
    private static String password = "admin";
    
    public static void init() throws ClassNotFoundException {  
        Class.forName("com.mysql.jdbc.Driver");        
    }
    
    
    public static Connection getMyConnection() throws SQLException {
        if (conn == null)
            conn = DriverManager.getConnection(dbString,userName, password);  
        return conn;
    }    
}