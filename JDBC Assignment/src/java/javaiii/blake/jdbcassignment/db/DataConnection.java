/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiii.blake.jdbcassignment.db;

import java.sql.*;

/**
 *
 *
 */
public class DataConnection {
      
    
    /**
     * Returns a connection to the cellular_division database
     * @return 
     */
    public static Connection getDbConnection(){
        Connection connection = null;
        
        // This should be deprecated, but it may still be needed for some
        // configurations of Tomcat/Java/Operating Systems/etc.
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch(Exception e){
            System.out.println("ERROR: getting Class.forName: " + e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        
        // Get the connection object 
        try{
            String dbUrl = "jdbc:mysql://127.0.0.1:3306/cellular_division";
            String username = "celluser";
            String password = "letmein";
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch(SQLException ex) {
            System.out.println("In method getDbConnection(): " + ex.getMessage() + "\n" + ex.getStackTrace());
        }
        return connection;
    }
    
    
}
