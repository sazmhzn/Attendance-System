/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Hashing.HashingPassword;
import Model.Teacher;
import Model.user;
import Services.UserServices;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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

        String page = request.getParameter("page");

        user u = new user();// initializing a user as the user is all

        /**
         * This condition check if the page is to add a teacher
         */
        if (page.equalsIgnoreCase("addTeacher")) {
            System.out.println("\n\n===================");
            System.out.println("addTeacher method\n");
            
            HashingPassword h = new HashingPassword();
            
            Teacher teacher = new Teacher(); //initializing a new teacher

            teacher.setUser(new user(request.getParameter("fullname"), request.getParameter("email"), request.getParameter("contact"), request.getParameter("address"), request.getParameter("section"), request.getParameter("course"), request.getParameter("username"), h.hashPassword(request.getParameter("password")) , "T"));
            System.out.println(teacher.getUser().getFullName() + " " + teacher.getUser().getAddress() + " " + teacher.getUser().getUsername() + " " + teacher.getUser().getPassword());
            new UserServices().insertTeacher(teacher);
            
            RequestDispatcher rd = request.getRequestDispatcher("Pages/AddTeacher.jsp");
            rd.forward(request, response);
        }
        
        /**
         * This condition will be take for delete teacher
         */
        if (page.equalsIgnoreCase("deleteTeacher")) {
            System.out.println("\n\n===================");
            System.out.println("deleteTeacher condition\n");
            
            int acc_id = Integer.parseInt( request.getParameter("accId") ) ;
            
            System.out.println("The teacher accout ID to delete is: " + acc_id);
            
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
