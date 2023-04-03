/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.College;
import Model.Student;
import Model.Subject;
import Model.Teacher;
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
import java.util.List;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "PageChange", urlPatterns = {"/PageChange"})
public class PageChange extends HttpServlet {

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

        if (page.equalsIgnoreCase("register")) {

            RequestDispatcher rd = request.getRequestDispatcher("/Pages/register.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("login")) {

            RequestDispatcher rd = request.getRequestDispatcher("/Pages/login.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("attendanceSheet")) {
            System.out.println("\n\n=============== attendance Sheet ==============\n");
            int id = Integer.parseInt(request.getParameter("teac_id"));
            System.out.println("The teaacher id int he attencesheet ID: " + id);
            List<College> subjectList = new SubjectServices().getSubjectList(id);
            request.setAttribute("subjectList", subjectList);
            
            for(College c : subjectList) {
                System.out.println("Name: " + c.getSubject().getSubject_name() + " code: " + c.getSubject().getSubject_code());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AttendanceSheet.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("takeAttendanceSheet")) {
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/TakeAttendance.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("addTeacher")) {
            List<College> collegeList = new SubjectServices().getCourseList();
            request.setAttribute("collegeList", collegeList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AddTeacher.jsp");
            rd.forward(request, response);
        }
              
        if (page.equalsIgnoreCase("Teacher")) {
            List<Teacher> employeeList = new UserServices().getTeacherList();
            request.setAttribute("employeeList", employeeList);
            List<College> collegeList = new SubjectServices().getCourseList();
            request.setAttribute("collegeList", collegeList);
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/TeacherDetails.jsp");
            rd.forward(request, response);
        }
       
        if (page.equalsIgnoreCase("editTeacher")) {
            
            Teacher teacher =  new UserServices().getTeacherRow( Integer.parseInt(request.getParameter("userId")) ); //This will be displayed on the form field
            request.setAttribute("teacher", teacher);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/EditTeacher.jsp");
            rd.forward(request, response);
        }
         
        if (page.equalsIgnoreCase("Student")) {
            
            List<Student> employeeList = new UserServices().getStudentList();
            request.setAttribute("employeeList", employeeList);
            
            HttpSession session = request.getSession();
            session.invalidate();
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/StudentDetails.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("addStudent")) {
            List<College> collegeList = new SubjectServices().getCourseList();
            request.setAttribute("collegeList", collegeList);
            
            List<College> semesterList = new SubjectServices().getSemesterList();
            request.setAttribute("semesterList", semesterList);
          
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AddStudent.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("editStudent")) {
            
            Student student =  new UserServices().getStudentRow( Integer.parseInt(request.getParameter("userId")) ); //This will be displayed on the form field
            request.setAttribute("student", student);

            List<College> college = new SubjectServices().getCourseList();
            request.setAttribute("collegeList", college);
            
            List<College> semester = new SubjectServices().getSemesterList();
            request.setAttribute("semesterList", semester);
            
            System.out.println("\nseemster: " + student.getCollege().getSemester().getName());
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/EditStudent.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("Subject")) {
            
            List<Subject> employeeList = new UserServices().getSubjectList();
            request.setAttribute("employeeList", employeeList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/SubjectDetails.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("addSubject")) {
            List<College> collegeList = new SubjectServices().getCourseList();
            request.setAttribute("collegeList", collegeList);
            
            List<College> semesterList = new SubjectServices().getSemesterList();
            request.setAttribute("semesterList", semesterList);
          
            List<Teacher> teacherList = new UserServices().getTeacherList();
            request.setAttribute("teacherList", teacherList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AddSubject.jsp");
            rd.forward(request, response);
        }          
        
        
        if (page.equalsIgnoreCase("editSubject")) {
            Subject subject = new Subject();
            College college = new SubjectServices().getCourseRow(Integer.parseInt(request.getParameter("subjectId")),  subject);
            request.setAttribute("college", college);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/EditSubject.jsp");
            rd.forward(request, response);
        }
        
        
        if (page.equalsIgnoreCase("adminDashboard")) {
            
            List<Teacher> teacherList = new UserServices().getTeacherList();
            request.setAttribute("totalTeacher", teacherList.size());
            request.setAttribute("teacherList", teacherList);
            
            List<Student> studentList = new UserServices().getStudentList();
            request.setAttribute("studentList", studentList);
            request.setAttribute("totalStudent", studentList.size());
            
            
            for(Student s : studentList) {
                System.out.println("student: " + s.getUser().getFullName());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AdminDashboard.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("Profile")) {
            
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/TeacherProfile.jsp");
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
