
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;

/**
 *
 * @author Jimmy
 */
public class LoginServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Create session object
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        String existUser = (String) session.getAttribute("existUserr");
       
       //Logout message
       if(logout != null){
           session.invalidate();
           request.setAttribute("logoutMessage", "You have successfully logged out");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           
       }
       
       //check if user already exist
       if (existUser == null){
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
       } else{
           response.sendRedirect("home");
           
       }
        
  
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
       
        String username = request.getParameter("c_username");
        String password = request.getParameter("c_password");
        AccountService myUser = new AccountService();
        User existUser = myUser.login(username, password);
        
        
        //validate null values
        if(username == null || password == null){
            request.setAttribute("logoutMessage", "Please enter a username and password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        //Check if login worked
        if(existUser != null){
            session.setAttribute("existUserr", username);
            response.sendRedirect("home");
        } else{
            request.setAttribute("logoutMessage", "Invalid username or password");
            request.setAttribute("v_user", username);
            request.setAttribute("v_password",password );
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
       
   }

   

}