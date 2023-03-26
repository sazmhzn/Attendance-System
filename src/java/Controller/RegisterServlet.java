/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Hashing.HashingPassword;
import Model.Teacher;
import Model.User;
import Services.UserServices;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


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
            System.out.println("\n\n==============");
            String username = request.getParameter("username");
            String password = HashingPassword.hashPassword(request.getParameter("password"));
            
            
            
            User user = new UserServices().getUser(username, password); //check if there is User in dadtabse account table
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("uid", user.getId());
                session.setAttribute("fullName", user.getUsername());
                session.setAttribute("role", user.getRole());
                request.setAttribute("msg", "Login Successful!");
                System.out.println(request.getAttribute("msg"));
                System.out.println("Role" + user.getRole());
                                                
                //creating cookie to store the id of user
                //Used for editing the profile of the user
                Cookie ck = new Cookie("id", String.valueOf(user.getId()));
                Cookie ckName = new Cookie("name", String.valueOf(user.getUsername()));
                response.addCookie(ck);
                response.addCookie(ckName);
                
                    if (session.getAttribute("role").equals("T")) {
                        RequestDispatcher rd = request.getRequestDispatcher("Pages/AttendanceSheet.jsp");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("Pages/AdminDashboard.jsp");
                        rd.forward(request, response);
                    }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("error_msg", "Invalid username or passowrd");
                RequestDispatcher rd = request.getRequestDispatcher("Pages/login.jsp");
                rd.forward(request, response);
            } 
        } // --------- existing page ends here --------- 
        
         if (page.equalsIgnoreCase("newUser")) {
            User user = new User();
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
