<%-- 
    Document   : index
    Created on : Apr 15, 2015, 5:25:43 AM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="javaiii.blake.jdbcassignment.user.*,java.util.ArrayList, java.io.*, java.io.PrintWriter" %>
<% 
        // Get any error messages
        String errorMessage = (String) request.getAttribute("errorMessage");
        String message = (String) request.getAttribute("message");
        String errorMessageLogin = (String) request.getAttribute("errorMessageLogin");
        String errorMessageLookup = (String) request.getAttribute("errorMessageLookup");
                
        // Find out whether things were successfull
        Boolean success = (Boolean) request.getAttribute("success");
        Boolean loginSuccess = (Boolean) request.getAttribute("successLogin");
        Boolean successLookup = (Boolean) request.getAttribute("successIdLookup");
        
        User user = (User) request.getAttribute("user");
        User lookupUser = (User) request.getAttribute("userLookup");
        
        String userName;
        int userId;
        String firstName;
        String lastName;
        
        String loginUserName;
        
        userName = "";
        userId = 0;
        firstName = "";
        lastName = "";
        
        if (successLookup != null) {
                
            if (successLookup) {
                
                userId = (int) request.getAttribute("userIdLookup");
                userName = lookupUser.getUserName();
                firstName = lookupUser.getFirstName();
                lastName = lookupUser.getLastName();
                  
            } else {
                
                if (request.getAttribute("userIdLookup") !=null) {
                        
                    userId = (int) request.getAttribute("userIdLookup");
                    
                }
                
            }
                    
                
            
        }
        if (loginSuccess != null) {
            
            if (loginSuccess) {
                    
                firstName = user.getFirstName();
                lastName = user.getLastName();
                
            } else {
                
                if (request.getAttribute("userName") != null) {

                    loginUserName = (String)request.getAttribute("userName");
                } 
                
            }
            
        }
        
        if (success != null) {
                
            if (success) {
            
            userId = (int) request.getAttribute("userId");
            userName = user.getUserName();
            firstName = user.getFirstName();
            lastName = user.getLastName();
            
            }else{
            
                if (request.getAttribute("userName") != null) {

                    userName = (String)request.getAttribute("userName");
                }
                if (request.getAttribute("firstName") != null) {

                    firstName = (String)request.getAttribute("firstName");
                }
                if (request.getAttribute("lastName") != null) {

                    lastName = (String)request.getAttribute("lastName");
                }
            }
        }   
    %>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>
        <header>
            
            <%  
                        if(loginSuccess == null || loginSuccess == false) {
                            if(errorMessageLogin != null){
            %>
            <div style="display:block; color:red;">
                <%= errorMessageLogin %>
            </div>
            <% 
                        } // end if erroMessageLogin != null
                            // Show the form
            %>
            <form id="login" name="login" action="UserLogin">
                <label for="userNameLogin">User Name: </label>
                <input type="text" name="userNameLogin" id="userNameLogin" value="${loginUserName}" />
                <label for="passwordLogin">Password: </label>
                <input type="password" name="passwordLogin" id="passwordLogin" />
                <input type="submit" value="Login" />
            </form>
            <% 
                        } else {         
            %>
            <h2>Welcome, <%= firstName %> <%= lastName %>!</h2>
            <a href="index.jsp" style="padding-top: 2em;display: block;">Login with another user</a>

            <% 
                        } // end if success
            %>
        </header>
                
        <h2>Enter the account information:</h2>
        
        <%  
                        if(success == null || success == false) {
                            if(errorMessage != null){
         %>
        <div class="errorMessage" style="color: red;" > 
            <%= errorMessage %>
        </div>
        <% 
                        } // end if erroMessage != null
                            // Show the form
        %>
        
        <form id ="newUserForm" name="newUserForm" action="AddUser">
        <fieldset>
            <label for="userName">User Name:</label>
            <input type="text" name="userName" id="userName" value="${userName}" /><br />
            <label for="FirstName">First Name:</label>
            <input type="text" name="firstName" id="firstName" value="${firstName}" /><br />
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" id="lastName" value="${lastName}"/><br />
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" /><br />
            <input type="submit" value="Submit" /><br />
        </fieldset>
        </form>
        <% 
                        } else {         
        %>
            
            <h2><%= message %></h2>
            <fieldset>
            <table>
                <tr>
                    <td>User ID:</td>
                    <td><%= userId %></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><%= userName %></td>
                </tr>
                 <tr>
                    <td>First Name:</td>
                    <td><%= firstName %></td>
                </tr>
                 <tr>
                    <td>Last Name:</td>
                    <td><%= lastName %></td>
                </tr>
            </table>
            </fieldset>
            <a href="index.jsp" style="padding-top: 2em;display: block;">Add another user</a>
            
            <% 
                        } // end if success
            %>
            <%  
                        if(successLookup == null || successLookup == false) {
                            if(errorMessageLookup != null){
            %>
            <div style="display:block; color: red;">
                <%= errorMessageLookup %>
            </div>
            <% 
                        } // end if erroMessageLogin != null
                            // Show the form
            %>
            <form id="userLookup" name="userLookup" action="LookupUser">
                <label for="userID">Enter a user ID to lookup: </label>
                <input type="text" name="userId" id="userId" /><br />
                <input type="submit" value="Lookup User" />
            </form>
            <% 
                        } else {         
            %>
            <fieldset>
            <table>
                <tr>
                    <td>User ID:</td>
                    <td><%= userId %></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><%= userName %></td>
                </tr>
                 <tr>
                    <td>First Name:</td>
                    <td><%= firstName %></td>
                </tr>
                 <tr>
                    <td>Last Name:</td>
                    <td><%= lastName %></td>
                </tr>
            </table>
            </fieldset>
            <a href="index.jsp" style="padding-top: 2em;display: block;">Lookup another user</a>

            <% 
                        } // end if success
            %>
    </body>
</html>
