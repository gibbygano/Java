/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiii.blake.jdbcassignment.user;

/**
 *
 * @author Ryan
 */
public class User {
    
    public int UserID;
    public String UserName;
    public String FirstName;
    public String LastName;
    public String Password;

    public User(String UserName, String FirstName, String LastName, String Password) {
        
        this.UserName = UserName;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
    }

    public User(int UserID, String UserName, String FirstName, String LastName, String Password) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
    }    

    public User(int UserID, String UserName, String FirstName, String LastName) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
    
    
    
    public int getUserID() {
        return UserID;
    }

    private void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    private void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFirstName() {
        return FirstName;
    }

    private void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    private void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPassword() {
        return Password;
    }

    private void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}
