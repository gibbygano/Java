/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiii.blake.jdbcassignment.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javaiii.blake.jdbcassignment.db.*;

/**
 *
 * @author Ryan
 */
public class UserHandler {
    
    public int addUser(User newUser){
        
        int result = -1;
        
        Connection connection = DataConnection.getDbConnection();
        
        if (connection != null) {
            
            try{
                
                String preparedSql = "CALL sp_add_companyuser(?,?,?,?)";
                
                PreparedStatement ps = connection.prepareStatement(preparedSql, 
                        Statement.RETURN_GENERATED_KEYS);

                
                ps.setString(1, newUser.getUserName());
                ps.setString(2, newUser.getFirstName());
                ps.setString(3, newUser.getLastName());
                ps.setString(4, newUser.getPassword());
                
                ResultSet resultSet = ps.executeQuery();
                
                while(resultSet.next()){
                    
                    result = resultSet.getInt(1);
                    
                }
                
            } catch (SQLException ex){
              
                
                
            }
            finally{
                try{
                    connection.close();
                } catch(Exception e){}
            }
            
        }
        
        return result;
        
    }
    
    public User getUserById(int userId) {
        
       User user = null;
       
       Connection connection = DataConnection.getDbConnection();
       
       if(connection != null){
          try{              
       
              String preparedSql = ("CALL sp_get_user_by_userid(?)");
              
              PreparedStatement ps = connection.prepareStatement(preparedSql);

              ps.setInt(1, userId);
              
              
              
              // Define variables that will be used for reading the results
              String userName;
              String firstName;
              String lastName;
              
    
              ResultSet resultSet = ps.executeQuery();

              
              while(resultSet.next()){
                  
                  userName = resultSet.getString("userName");
                  firstName= resultSet.getString("firstName");
                  lastName = resultSet.getString("lastName");
                  
                  user = new User(userId, userName, firstName, lastName);
              }
          } catch(SQLException ex) {
          }
          finally{
              try{
                  connection.close();
              } catch(Exception ex) {}
          }
       }
       
       return user;
    }
    
    public User getUserLogin(String userName, String password) {
        
       User user = null;
       
       Connection connection = DataConnection.getDbConnection();
       
       if(connection != null){
          try{
        
              String preparedSql = ("CALL sp_get_user_by_name_password(?, ?)");
              
              PreparedStatement ps = connection.prepareStatement(preparedSql);

              ps.setString(1, userName);
              ps.setString(2, password);
              
              
              // Define variables that will be used for reading the results
              int userId;
              String firstName;
              String lastName;
              
              ResultSet resultSet = ps.executeQuery();
              
              while(resultSet.next()){
                  
                  userId = resultSet.getInt("userId");
                  userName = resultSet.getString("userName");
                  firstName= resultSet.getString("firstName");
                  lastName = resultSet.getString("lastName");
                  
                  user = new User(userId, userName, firstName, lastName);
              }
          } catch(SQLException ex) {
          }
          finally{
              try{
                  connection.close();
              } catch(Exception ex) {}
          }
       }
       
       return user;
    } // end method getProducts()
}
