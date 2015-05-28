/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiii.blake.jdbcassignment.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan
 */
@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        
        Boolean success = true;
        StringBuilder sb = new StringBuilder();
        User newUser = null;
        String message = null;
        String errorMessage = null;
        UserHandler myUserHandler = new UserHandler();
        int userId = 0;
       
        if (userName.length() < 2 || userName.length() > 256 || !userName.matches("^[a-zA-Z0-9]+$")) {
            
            sb.append("User Name Must Be 2 - 256 Characters Long and Alphanumeric!<br />");
            errorMessage = sb.toString();
            success = false;
        }
        if (password.length() < 8 || password.length() > 40){
            
            sb.append("Password Must be Between 8 and 40!<br />");
            errorMessage = sb.toString();
            success = false;
        }
        if (!password.matches("^(?=.*[a-z])([a-zA-Z_0-9]).{7,41}$") && !password.matches("^(?=.*[A-Z])([a-zA-Z_0-9]).{8,}$")) {
            
            sb.append("Password must only have letters(Minimum 1), numbers, and underscores!<br />");
            errorMessage = sb.toString();
            success = false;
            
        }
        if ((firstName.length() < 2 || firstName.length() > 128 || !firstName.matches("^[a-zA-Z]+$")) || 
                (lastName.length() < 2 || lastName.length() > 128 || !lastName.matches("^[a-zA-Z]+$"))) {
            
            sb.append("First and Last Name Must Contain Only letters and Be 2 - 128 Characters!<br />");
            errorMessage = sb.toString();
            success = false;
        }
        
            
        if (success) {
           
            newUser = new User(userName, firstName, lastName, password);
            userId = myUserHandler.addUser(newUser);

            
            if (userId == -1) {
                
                sb.append("User Name Already in Use!!");
                sb.append(System.lineSeparator());
                errorMessage = sb.toString();
                success = false;
                
            } else{
            
                sb.append("New User Added");
                message = sb.toString();  
            }
        }
        
        request.setAttribute("success", success);
        request.setAttribute("user", newUser);
        request.setAttribute("message", message); 
        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("userId", userId);


        request.setAttribute("userName", userName);
        request.setAttribute("password", password);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
