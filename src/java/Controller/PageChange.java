/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.College;
import Model.Report;
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
import jakarta.servlet.http.Cookie;
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
        HttpSession session = request.getSession();
        Cookie[] cookie = request.getCookies();

        if (page.equalsIgnoreCase("register")) {

            RequestDispatcher rd = request.getRequestDispatcher("/Pages/register.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("login")) {

            RequestDispatcher rd = request.getRequestDispatcher("/Pages/login.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("forgotPassword")) {
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/ForgotPassword.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("attendanceSheet")) {
            System.out.println("\n\n=============== attendance Sheet ==============\n");
            int acc_id = 0;
            
            if(session.getAttribute("uid") != null) {
                System.out.println("Session is not null");
               acc_id = (int) session.getAttribute("uid");
            }
            
            
            if (cookie != null) {
                System.out.println("Cookie is not null");
                for (Cookie c : cookie) {
                    if (c.getName().equalsIgnoreCase("id")) {
                        acc_id = Integer.parseInt(c.getValue());
                    }
                }
            }

            System.out.println("The teacher acc_ id in attencesheet ID: " + acc_id);
            List<College> subjectList = new SubjectServices().getSubjectList(acc_id);
            request.setAttribute("subjectList", subjectList);

            
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AttendanceSheet.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("takeAttendanceSheet")) {
            System.out.println(" ====================== Take attendacnce sheet ====================== ");
            int subject_id = Integer.parseInt(request.getParameter("subject_id"));
            
            Cookie subject = new Cookie("subject_id", request.getParameter("subject_id"));
            response.addCookie(subject);
            
            //get the student that take the subject
            List<Student> studentListA = new SubjectServices().getAttendanceSheet(subject_id, 1);
            request.setAttribute("employeeListA", studentListA);

            List<Student> studentListB = new SubjectServices().getAttendanceSheet(subject_id, 2);
            request.setAttribute("employeeListB", studentListB);

            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/TakeAttendance.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("attendanceDetails")) {
            
            int acc_id = 0;
            if (cookie != null) {
                System.out.println("Cookie is not null");
                for (Cookie c : cookie) {
                    if (c.getName().equalsIgnoreCase("id")) {
                       acc_id = Integer.parseInt(c.getValue());
                    }
                }
            }

            System.out.println("The teacher acc_ id in attencesheet Details: " + acc_id);
            
            List<College> subjectList = new SubjectServices().getSubjectList(acc_id);
            request.setAttribute("subjectList", subjectList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AttendanceDetails.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("studentDetailsTeac")) {
            int teac_id = 0;
            
            for(Cookie c : cookie) {
                if(c.getName().equals("id")) {
                    teac_id = Integer.parseInt(c.getValue()) ;
                }
            }
            System.out.println("You are in studentDetailTeac");
            System.out.println("Teacher id here is: " + teac_id);
            List<Student> studentList = new UserServices().getStudentList(teac_id);
            request.setAttribute("employeeList", studentList);
            
            for( Student s : studentList ) {
                System.out.println("Name: " + s.getUser().getFullName());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/StudentDetailTeac.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("studentAttendance")) {
            Student student = new UserServices().getStudentRow(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("student", student);
            List<Report> reportList = new SubjectServices().getAttendanceReport(student);
            request.setAttribute("studentReport", reportList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/StudentAttendanceDetails.jsp");
            rd.forward(request, response);
        }
        
        
        
        if( page.equalsIgnoreCase("studentReport") ) {
            List<Report> repostList = new SubjectServices().getAttendanceReport();
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/StudentReport.jsp");
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

            Teacher teacher = new UserServices().getTeacherRow(Integer.parseInt(request.getParameter("userId"))); //This will be displayed on the form field
            request.setAttribute("teacher", teacher);

            RequestDispatcher rd = request.getRequestDispatcher("/Pages/EditTeacher.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("Student")) {

            List<Student> employeeList = new UserServices().getStudentList();
            request.setAttribute("employeeList", employeeList);

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

            Student student = new UserServices().getStudentRow(Integer.parseInt(request.getParameter("userId"))); //This will be displayed on the form field
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
            
            for(Teacher r : teacherList) {
                System.out.println("Teachers: " + r.getUser().getFullName());
            }

            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AddSubject.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("editSubject")) {
            College college = new SubjectServices().getCourseRow(Integer.parseInt(request.getParameter("subjectId")));
            request.setAttribute("college", college);

            List<College> collegeList = new SubjectServices().getCourseList();
            request.setAttribute("collegeList", collegeList);

            List<College> semesterList = new SubjectServices().getSemesterList();
            request.setAttribute("semesterList", semesterList);

            List<Teacher> teacherList = new UserServices().getTeacherList();
            request.setAttribute("teacherList", teacherList);

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

            List<User> active = new UserServices().getActiveUserList();
            request.setAttribute("activeUser", active);
            
            List<Report> todayAttendanceList = new SubjectServices().getTodayAttendanceReport();
            request.setAttribute("todayAttendanceList", todayAttendanceList);
            System.out.println("\n\nTodays attendance");
            for(Report r : todayAttendanceList) {
                System.out.println("naem: " + r.getAttendance().getSubject().getSubject_name());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AdminDashboard.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("AdminAttendanceSheet")) {
            
            List<College> subjectList = new SubjectServices().getSubjectList();
            request.setAttribute("subjectList", subjectList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AdminViewAttendance.jsp");
            rd.forward(request, response);
        }
        
        if (page.equalsIgnoreCase("AdminReport")) {
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AdminReport.jsp");
            rd.forward(request, response);
        }
        
        if( page.equalsIgnoreCase("AdminViewAttendanceSheet") ) {
            
            Cookie subject = new Cookie("subject_id", request.getParameter("subject_id"));
            response.addCookie(subject);
            
            int subject_id = Integer.parseInt(request.getParameter("subject_id"));
            System.out.println("\n\nSubject id:"  + subject_id);
            
            //get the student that take the subject
            List<Student> studentListA = new SubjectServices().getAttendanceSheet(subject_id, 1);
            request.setAttribute("employeeListA", studentListA);

            List<Student> studentListB = new SubjectServices().getAttendanceSheet(subject_id, 2);
            request.setAttribute("employeeListB", studentListB);
            System.out.println("sout: ");
            for(Student s : studentListB) {
                System.out.println("name: " + s.getCollege().getStudent().getUser().getFullName());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/Pages/AdminAttendanceSheet.jsp");
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
