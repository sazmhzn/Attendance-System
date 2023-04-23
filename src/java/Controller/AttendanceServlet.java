/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Attendance;
import Services.SubjectServices;
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
@WebServlet(name = "AttendanceServlet", urlPatterns = {"/AttendanceServlet"})
public class AttendanceServlet extends HttpServlet {

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

        System.out.println("\n =============================Youe are in attendnace sevlet ===================\n");
        HttpSession session = request.getSession();
        System.out.println("session: " + session.getAttribute("uid"));
        int teac_id = 0;

        if (session.getAttribute("uid") != null) {
            System.out.println("Session is not null");
            teac_id = (int) session.getAttribute("uid");
        }

        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            System.out.println("Cookie is not null");
            for (Cookie c : cookie) {
                if (c.getName().equalsIgnoreCase("id")) {
                    teac_id = Integer.parseInt(c.getValue());
                }
                if (c.getName().equalsIgnoreCase("name")) {
                    System.out.println("name: " + c.getValue());
                }
            }
        }
        

        String page = request.getParameter("page");
                
        if (page.equalsIgnoreCase("takeAttendance")) {
            System.out.println("Inside takeAttendance");
            String[] roll = request.getParameterValues("attendance");
            String date = request.getParameter("attendance_date");
            
            Attendance att = new Attendance();
            att.setTeac_id(teac_id);
            att.setStu_id(roll);
            for( Cookie c : cookie ) {
                if(c.getName().equalsIgnoreCase("subject_id")) {
                    att.setSub_id( Integer.parseInt( c.getValue()) );
                }
            }
            att.setDate(date);
            System.out.println("Attendance details: \n\nT_id(ACC_ID): " + att.getTeac_id() + " sub_id: "  + att.getSub_id() + " date: " + att.getDate());
            
            if( new SubjectServices().checkAttendance(att.getSub_id(), date) ) {
                System.out.println(" the value is already stored");
            } else {
                System.out.println("The students: ");
                for (String r : roll) {
                    System.out.println("roll: " + r);
                }
              new SubjectServices().insertAttendance(att);  
            }
            if( teac_id != 1  ) {
                System.out.println("Taken by teacher");
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=attendanceDetails");
            rd.forward(request, response);
        }
            System.out.println("taken by admin");
        RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=AdminAttendanceSheet");
        rd.forward(request, response);
        }//take attendance ends
        
        
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
