/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Hashing.HashingPassword;
import Model.user;
import Services.UserServices;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
    
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
        
        doPost(request, response);
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
        response.setContentType("text/html");
        String page = request.getParameter("page");
        System.out.println("Page: " + page );
        
        if(page.equalsIgnoreCase("existing")) {
            
            String username = request.getParameter("username");
            String password = HashingPassword.hashPassword(request.getParameter("password"));
//            String role = request.getParameter("role");
            
            user user = new UserServices().getUser(username, password);
            
            HttpSession session = request.getSession();
            
            if (user == null) {
                
                System.out.println("The pasword wrong clause");
                session.setAttribute("msg", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("Pages/login.jsp");
                rd.forward(request, response);
                
            } else {
                
                session.setAttribute("uid", user.getId());
                session.setAttribute("fullName", user.getUsername());
                session.setAttribute("role", user.getRole());
                request.setAttribute("msg", "Login Successful!");
                System.out.println(request.getAttribute("msg"));
                
                
                if (session.getAttribute("role").equals("T")) {
                    RequestDispatcher rd = request.getRequestDispatcher("Pages/AttendanceSheet.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("Pages/AdminDashboard.jsp");
                    rd.forward(request, response);
                }
     
            } 
        } // --------- existing page ends here --------- 
        
         if (page.equalsIgnoreCase("newUser")) {
            user user = new user();
            user.setFullName(request.getParameter("fname") + " " + request.getParameter("lname"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(HashingPassword.hashPassword(request.getParameter("password")));
            user.setRole(request.getParameter("role"));
            
            System.out.println("\n\n========================\nnewUser\n");
             
            System.out.println( user.getFullName() + " " + user.getUsername() + " " + user.getPassword() + " " + user.getRole() );
            new UserServices().insertUser(user);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/login.jsp");
            rd.forward(request, response);
        }
        
        
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
