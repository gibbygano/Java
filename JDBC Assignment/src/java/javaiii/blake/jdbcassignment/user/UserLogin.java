/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiii.blake.jdbcassignment.user;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLogin extends HttpServlet {

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
       
        String userName = request.getParameter("userNameLogin");
        String password = request.getParameter("passwordLogin");
        
        Boolean success = true;
        StringBuilder sb = new StringBuilder();
        String errorMessage = null;
        UserHandler myUserHandler = new UserHandler();

        User loggedInUser = null;
        
        
        if (userName.length() < 2 || userName.length() > 256 || !userName.matches("^[a-zA-Z0-9]+$")) {
            
            sb.append("Invalid User Name!<br />");
            errorMessage = sb.toString();
            success = false;
        }
        if (!password.matches("^(?=.*[a-z])([a-zA-Z_0-9]).{7,41}$") && !password.matches("^(?=.*[A-Z])([a-zA-Z_0-9]).{8,}$")) {
            
            sb.append("Invalid Password!<br />");
            errorMessage = sb.toString();
            success = false;
            
        }
        
        if (success) {
            
            loggedInUser = myUserHandler.getUserLogin(userName, password);
            
            if (loggedInUser == null) {
                
                sb.append("User not found.");
                errorMessage = sb.toString();
                success = false;
            }
            
        }
        
        request.setAttribute("successLogin", success);
        request.setAttribute("user", loggedInUser);
        request.setAttribute("errorMessageLogin", errorMessage);

        request.setAttribute("userNameLogin", userName);
        request.setAttribute("passwordLogin", password);   
        
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
