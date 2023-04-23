/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Hashing.HashingPassword;
import Model.College;
import Model.Course;
import Model.Report;
import Model.Section;
import Model.Semester;
import Model.Student;
import Model.Subject;
import Model.Teacher;
import Model.User;
import Services.SubjectServices;
import Services.UserServices;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

        HttpSession session = request.getSession();
        /**
         * This condition check if the page is to add a teacher
         */
        if (page.equalsIgnoreCase("addTeacher")) {
            System.out.println("\n\n===================");
            System.out.println("addTeacher method\n");
            HashingPassword h = new HashingPassword();
            
            Teacher teacher = new Teacher(); //initializing a new teacher
  
            teacher.setUser(new User(request.getParameter("fullname"), request.getParameter("email"), request.getParameter("contact"), request.getParameter("address"), request.getParameter("section"), request.getParameter("course"), request.getParameter("username"), h.hashPassword(request.getParameter("password")) , "T"));
            new UserServices().insertUser(teacher);
            
            RequestDispatcher rd = request.getRequestDispatcher("Pages/AddTeacher.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("editTeacher")) {
         
            Teacher teacher = new Teacher(); //initializing a new teacher
            teacher.setAcc_id( Integer.parseInt(request.getParameter("id")) );
            teacher.setUser(new User(
                    request.getParameter("fullname"),
                    request.getParameter("email"),
                    request.getParameter("contact"),
                    request.getParameter("address"),
                    request.getParameter("section"), 
                    "", 
                    request.getParameter("username"),
                    "", 
                    "T"));
            
            
            System.out.println("\nUserServices\n===========\n");
            new UserServices().editUser( teacher);
            System.out.println("Acc_ID: " + teacher.getAcc_id() + " Name: " + teacher.getUser().getFullName() + " \n==========");
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=Teacher");
            rd.forward(request, response);
        }
        
        /**
         * This condition will be take for delete teacher
         */
        if (page.equalsIgnoreCase("deleteTeacher")) {
            System.out.println("\n\n===================");
            System.out.println("deleteTeacher condition\n");
            
            int acc_id = Integer.parseInt( request.getParameter("accId") ) ;
            new UserServices().deleteTeacher(acc_id);
            System.out.println("The teacher accout ID to delete is: " + acc_id);
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=Teacher");
            rd.forward(request, response);
        }
        
        
        /**
         * This condition will run when the admin wants to add a student
         */
        if (page.equalsIgnoreCase("addStudent")) {
            System.out.println("addStudent method\n");
            HashingPassword h = new HashingPassword();
            Student student = new Student(); //initializing a new student

            student.setUser(new User(request.getParameter("fullname"), request.getParameter("email"), request.getParameter("contact"), request.getParameter("address"), request.getParameter("semester"), request.getParameter("section"), request.getParameter("course"), request.getParameter("username"), h.hashPassword(request.getParameter("password")) , "S"));
    
            if(new UserServices().hasSimilarUser(student.getUser())) {
                session.setAttribute("status", "Same email or phone already exists");
            } else {
                new UserServices().insertUser(student); //inserting into user table
                session.setAttribute("status", "Student added");
            }
            System.out.println("\n\n\n==================================\n" + session.getAttribute("status"));
            session.setMaxInactiveInterval(5);
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=addStudent");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("editStudent")) {
            Student student = new Student(); //initializing a new student
            student.setRoll(Integer.parseInt(request.getParameter("id")) );
            student.setUser(new User(
                    Integer.parseInt(request.getParameter("id") ), 
                    request.getParameter("fullname"), 
                    request.getParameter("email"), 
                    request.getParameter("contact"), 
                    request.getParameter("address")
                    ));
            student.setCollege(new College(
                    (new Course( Integer.parseInt( request.getParameter("course") ) , "")), 
                    (new Semester(Integer.parseInt( request.getParameter("semester") ) , "")), 
                    (new Section(Integer.parseInt( request.getParameter("section") ) , ""))
                    ));
            
            System.out.println("\nUserServices\n===========\n");
            boolean result = new UserServices().editUser(student);
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=Student");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("deleteStudent")) {
            System.out.println("\n\n===================");
            System.out.println("deleteStudent condition\n");
            
            int acc_id = Integer.parseInt( request.getParameter("accId") ) ;
            new UserServices().deleteStudent(acc_id);
            System.out.println("The student accout ID to delete is: " + acc_id);
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=Student");
            rd.forward(request, response);
        }
        
        if( page.equals("addSubject") ) {
            Teacher teacher = new UserServices().getTeacherRow( request.getParameter("teacher"));
            
            //chceck if the teacher is in the database
            if (teacher != null) {
                
                College college = new College();
                college.setSubject(new Subject(
                        request.getParameter("subject_name"),
                        request.getParameter("subject_code"),
                        teacher));
                college.setCourse(new Course(Integer.parseInt(request.getParameter("course"))));
                college.setSemester(new Semester(Integer.parseInt( request.getParameter("semester") ), "" ));
                          
                boolean similarSubject = new SubjectServices().getSimilarSubject(college);
                
                //check if the subject name or code is already inserted int he database
                if(!similarSubject) {
                    new SubjectServices().insertSubject(college);
                } else {
                  session.setAttribute("status", "fail");
                session.setAttribute("msg", "Similar subject found");  
                }
                
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=addSubject");
                rd.forward(request, response);
            }
            
                        
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=Subject");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("editSubject")) {
            
            Teacher teacher = new UserServices().getTeacherRow(request.getParameter("teacher"));
            
            College college = new College();
            college.setCourse(new Course(Integer.parseInt(request.getParameter("course")) , ""));
            college.setSemester(new Semester(Integer.parseInt(request.getParameter("semester")), ""));
            college.setSubject(new Subject(
                    request.getParameter("subject_name"),
                    request.getParameter("subject_code"),
                    teacher));
            
            
            int sub_id = Integer.parseInt(request.getParameter("subject_id"));
            System.out.println("Subject id: " + sub_id + " " + request.getParameter("teacher") + " "+ teacher.getUser().getId());
            
            new SubjectServices().editSubject(college, sub_id);
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=Subject");
            rd.forward(request, response);
            
        }
        
        
        //report section
        if (page.equalsIgnoreCase("report")) {
            
            String from =  request.getParameter("from");
            String to = request.getParameter("to");
            int id = Integer.parseInt(request.getParameter("subject_id"));
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            
            if (from != null && to != null) {
                if (from.compareTo(to) > 0) {
                    System.out.println("Date 1 occurs after Date 2");
                    System.out.println("Thsi is wrong");
                } else if (from.compareTo(to) < 0) {
                    System.out.println("Date 1 occurs before Date 2");
                } else if (from.compareTo(to) == 0) {
                    System.out.println("Both dates are equal");
                }
            }
            if(from == null) {
                from = dtf.format(now);
            }
            
            if(to == null) {
                to = dtf.format(now);
            }
            
            System.out.println("\n\nreport");
            System.out.println(from + " " + to + " " + id);
            List<Report> report = new SubjectServices().getAttendanceReport(from, to, id);
            request.setAttribute("report", report);
            
            System.out.println("\n\n");
            for(Report r : report) {
                System.out.println("report.stud.user.name : " + r.getStudent().getUser().getFullName() + " total: " + r.getTotal());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("PageChange?page=AdminReport");
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
