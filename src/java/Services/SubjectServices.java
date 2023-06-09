/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.Attendance;
import Model.College;
import Model.Course;
import Model.Message;
import Model.Report;
import Model.Section;
import Model.Semester;
import Model.Student;
import Model.Subject;
import Model.Teacher;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class SubjectServices {

    public List<College> getCourseList() {
        List<College> collegeList = new ArrayList<>();
        String query = "SELECT * FROM `course`";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setCourse(new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME")));
                collegeList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return collegeList;
    }

    public List<College> getSemesterList() {

        List<College> semesterList = new ArrayList<>();
        String query = "SELECT * FROM `semester`";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College((new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))));
                semesterList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semesterList;

    }

    public List<Section> getSectionList() {
        List<Section> sectionList = new ArrayList<>();
        String query = "SELECT * FROM `section`";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Section section = new Section(rs.getInt("SECTION_ID"), rs.getString("SECTION_NAME"));
                sectionList.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }

        public List<College> getSubjectListWithAttendanceData() {
        List<College> subjectList = new ArrayList<>();
        String query = "SELECT * FROM `subject` LEFT JOIN teacher on subject.TEAC_ID = teacher.TEAC_ID LEFT JOIN semester on subject.SEM_ID = semester.SEM_ID; ";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setSubject(new Subject(
                        rs.getInt("SUB_ID"),
                        rs.getString("SUB_NAME"),
                        rs.getString("SUB_CODE"),
                        new Teacher(new User(
                                rs.getInt("TEAC_ID"),
                                rs.getString("TEAC_NAME"),
                                rs.getString("TEAC_EMAIL"),
                                rs.getString("TEAC_PHONE"),
                                rs.getString("teac_Address")
                        ))
                ));
                college.setAttendance(new Attendance(checkTodayAttendance(rs.getInt("SUB_ID"))));

                college.setSemester(new Semester(1, rs.getString("SEM_NAME")));
                System.out.println("College: " + college.getSubject().getSubject_name());
                subjectList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }
        
        
        
        public List<College> getSubjectList() {
        List<College> subjectList = new ArrayList<>();
        String query = "SELECT * FROM `subject` LEFT JOIN teacher on subject.TEAC_ID = teacher.TEAC_ID LEFT JOIN semester on subject.SEM_ID = semester.SEM_ID; ";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setSubject(new Subject(
                        rs.getInt("SUB_ID"),
                        rs.getString("SUB_NAME"),
                        rs.getString("SUB_CODE"),
                        new Teacher(new User(
                                rs.getInt("TEAC_ID"),
                                rs.getString("TEAC_NAME"),
                                rs.getString("TEAC_EMAIL"),
                                rs.getString("TEAC_PHONE"),
                                rs.getString("teac_Address")
                        ))
                ));
                college.setSemester(new Semester(1, rs.getString("SEM_NAME")));
                System.out.println("College: " + college.getSubject().getSubject_name());
                subjectList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    
    public List<College> getSubjectList(int teac_id) {
        List<College> subjectList = new ArrayList<>();
        String query = "SELECT * FROM `subject` LEFT JOIN teacher on subject.TEAC_ID = teacher.TEAC_ID LEFT JOIN semester on subject.SEM_ID = semester.SEM_ID where teacher.ACC_ID=?; ";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setInt(1, teac_id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setSubject(new Subject(
                        rs.getInt("SUB_ID"),
                        rs.getString("SUB_NAME"),
                        rs.getString("SUB_CODE"),
                        new Teacher(new User(
                                rs.getInt("TEAC_ID"),
                                rs.getString("TEAC_NAME"),
                                rs.getString("TEAC_EMAIL"),
                                rs.getString("TEAC_PHONE"),
                                rs.getString("teac_Address")
                        ))
                ));
                college.setAttendance(new Attendance(checkTodayAttendance(rs.getInt("SUB_ID"))));

                college.setSemester(new Semester(1, rs.getString("SEM_NAME")));
                System.out.println("College: " + college.getSubject().getSubject_name());
                subjectList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    public Subject getSubject(int sub_id) {
        System.out.println("getSubject\n");
        Subject sub = new Subject();
        String query = "SELECT * FROM `subject` where SUB_ID="+sub_id;
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
          
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                sub.setSubject_name(rs.getString("SUB_NAME"));
                sub.setSubject_code(rs.getString("SUB_CODE"));
                sub.setTeacher(new UserServices().getTeacherRow(rs.getInt("TEAC_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sub;
    }
    
    public boolean getSimilarSubject(College college) {
        String query = "SELECT * FROM `subject` where SUB_CODE=? OR SUB_NAME=?";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, college.getSubject().getSubject_code());
            pstm.setString(2, college.getSubject().getSubject_name());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public College getCourseRow(int id) {
        College college = null;
        String query = "SELECT SUB_ID, SUB_NAME, SUB_CODE, teacher.TEAC_ID, teacher.TEAC_NAME, course.C_ID, course.COURSE_NAME, semester.SEM_ID, semester.SEM_NAME FROM `subject` LEFT JOIN teacher on subject.TEAC_ID = teacher.TEAC_ID LEFT JOIN course on subject.C_ID = course.C_ID LEFT JOIN semester on subject.SEM_ID = semester.SEM_ID where SUB_ID=?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                college = new College();
                college.setSubject(new Subject(rs.getInt("SUB_ID"),
                        rs.getString("SUB_NAME"),
                        rs.getString("SUB_CODE"),
                        new Teacher(new User(rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), "T"))
                ));
                college.setCourse(new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME")));
                college.setSemester(new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return college;
    }

    //This method will insert subject in subject
    public void insertSubject(College college) {
        
        insertTotalAttendance(college.getSubject());
        
        String query = "INSERT INTO `subject`(`SUB_NAME`, `SUB_CODE`, `TEAC_ID`, `C_ID`, `SEM_id`) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {

            pstm.setString(1, college.getSubject().getSubject_name());
            pstm.setString(2, college.getSubject().getSubject_code());
            pstm.setInt(3, college.getSubject().getTeacher().getUser().getId());
            pstm.setInt(4, college.getCourse().getId());
            pstm.setInt(5, college.getSemester().getId());

            System.out.println(pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editSubject(College college, int id) {

        String query = "UPDATE `subject` SET `SUB_NAME`=?,`SUB_CODE`=?,`TEAC_ID`=?,`C_ID`=?, `SEM_ID`=? WHERE SUB_ID="+id;
        PreparedStatement pstm = new DBConnection().getStatement(query);
        
        try {
            System.out.println("\nname: " + college.getSubject().getSubject_code() +" "+ college.getSemester().getId()+" "+
                    college.getSubject().getTeacher().getUser().getId());
            
            pstm.setString(1, college.getSubject().getSubject_name());
            pstm.setString(2, college.getSubject().getSubject_code());
            pstm.setInt(3, college.getSubject().getTeacher().getUser().getId());
            pstm.setInt(4, college.getCourse().getId());
            pstm.setInt(5, college.getSemester().getId());
            
            System.out.println("The Update query: " + pstm);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //This method will insert course in subject
    public void insertCourse(Course course) {
        String query = "INSERT INTO `course`(`COURSE_NAME`) VALUES(?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, course.getName());

            System.out.println(pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertCourse(Semester semester) {
        String query = "INSERT INTO `semester`(`SEM_NAME`, `C_ID`) VALUES(?, ?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, semester.getName());
            pstm.setInt(2, semester.getId());

            System.out.println(pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkAttendance(int stud_id, String att_date) {
        String query = "SELECT * FROM `attendance` where SUB_ID=? AND ATT_DATE=?";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, stud_id);
            pstm.setString(2, att_date);
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkTodayAttendance(int SUB_ID) {
        System.out.println("checkTodayAttendance\n");
        String query = "SELECT * FROM `attendance` WHERE SUB_ID=? AND ATT_DATE=CURRENT_DATE; ";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, SUB_ID);
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Student> getAttendanceSheet(int id, int sec_id) {

        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * from subject LEFT JOIN semester ON subject.SEM_ID = semester.SEM_ID LEFT JOIN student ON semester.SEM_ID = student.SEM_ID LEFT JOIN course ON course.C_ID = student.C_ID WHERE SUB_ID=? AND SEC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, id);
            pstm.setInt(2, sec_id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setCollege(new College(
                        (new Subject(rs.getInt("SUB_ID"), rs.getString("SUB_NAME"), rs.getString("SUB_CODE"))),
                        (new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME"))),
                        (new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))),
                        (new Section(rs.getInt("SEC_ID"), "")),
                        (new Student(new User(
                                rs.getInt("STUD_ID"),
                                rs.getString("STUD_NAME"),
                                rs.getString("STUD_EMAIL"),
                                rs.getString("STUD_PHONE"),
                                rs.getString("STUD_ADD")
                        )))
                ));
                
                System.out.println("\nresults: ");
                System.out.println(" " + student.getCollege().getStudent().getUser().getFullName());
                

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    
    
    public void insertTotalAttendance(Subject sub) {
        String query = "INSERT INTO `total_attendance`( `SUB_ID`, `count`) VALUES (?,0)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
                pstm.setInt(1, sub.getSubject_id());
                System.out.println("pst: " + pstm);
                pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void updateTotalAttendance(Attendance att) {
        String query = "UPDATE total_attendance set count = count + 1 where sub_id=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
                pstm.setInt(1, att.getSub_id());
                System.out.println("pst: " + pstm);
                pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
        
    public void insertAttendance(Attendance att) {
        updateTotalAttendance(att);
        String query = "INSERT INTO `attendance`(`STU_ID`, `ACC_ID`, `SUB_ID`, `ATT_DATE`, `STATUS`) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            for (String a : att.getStu_id()) {
                pstm.setInt(1, Integer.parseInt(a));
                pstm.setInt(2, att.getTeac_id());
                pstm.setInt(3, att.getSub_id());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dateObj = sdf.parse(att.getDate());
                Timestamp timestamp = new Timestamp(dateObj.getTime());
                System.out.println("timestamp: " + timestamp + " " + dateObj);
                    pstm.setTimestamp(4, timestamp);
                pstm.setBoolean(5, true);
                System.out.println("pst: " + pstm);
                pstm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException a) {
            a.printStackTrace();
        }
    }
    
    public List<Report> getAttendanceReport() {

        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT ATT_DATE, COUNT(STU_ID) as total_Student, SUB_ID, ACC_ID FROM attendance GROUP BY ATT_DATE, SUB_ID;";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setTotal(rs.getInt("total_Student" ));
                Attendance a = new Attendance();
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                report.setAttendance(a);
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

    public List<Report> getAttendanceReport(int sub_id) {

        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT ATT_DATE, COUNT(STU_ID) as total_Student, SUB_ID, ACC_ID FROM attendance where SUB_ID=? GROUP BY ATT_DATE, SUB_ID;";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, sub_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setTotal(rs.getInt("total_Student" ));
                Attendance a = new Attendance();
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                report.setAttendance(a);
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    //SELECT STU_ID, ATT_DATE, SUB_ID, ACC_ID FROM attendance WHERE STU_ID=1 GROUP BY ATT_DATE, STU_ID ORDER BY STU_ID; 
    public List<Report> getAttendanceReport(Student student) {

        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT STU_ID, ATT_DATE, SUB_ID, ACC_ID FROM attendance WHERE STU_ID=? GROUP BY ATT_DATE, STU_ID ORDER BY STU_ID;";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, student.getRoll());
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                Attendance a = new Attendance();
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                report.setAttendance(a);
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }


    // SELECT * FROM `attendance` WHERE ATT_DATE = CURRENT_DATE GROUP BY SUB_ID; 
    public List<Report> getTodayAttendanceReport() {
        System.out.println("getTodayAttendanceReport\n");
        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM `attendance` LEFT JOIN subject on attendance.SUB_ID = subject.SUB_ID LEFT JOIN semester on subject.SEM_ID = semester.SEM_ID WHERE ATT_DATE = CURRENT_DATE GROUP BY attendance.SUB_ID";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                Attendance a = new Attendance();
                College c = new College(new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME")));
                Subject sub = new Subject();
                sub.setSubject_code(rs.getString("SUB_CODE"));
                sub.setSubject_name(rs.getString("SUB_NAME"));
                
                a.setSubject(sub);
                report.setCollege(c);
                report.setAttendance(a);
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
    
    //SELECT COUNT(attendance.STU_ID), course.COURSE_NAME, ATT_DATE FROM `attendance` LEFT JOIN subject on attendance.SUB_ID = subject.SUB_ID LEFT JOIN course on subject.C_ID = course.C_ID GROUP BY attendance.ATT_DATE, course.C_ID; 
    public List<Report> getDateWiseAttendanceReport(int c_id) {
        System.out.println("getTodayAttendanceReport\n");
        
        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT COUNT(attendance.STU_ID) as total, course.COURSE_NAME, ATT_DATE, course.C_ID FROM `attendance` LEFT JOIN subject on attendance.SUB_ID = subject.SUB_ID LEFT JOIN course on subject.C_ID = course.C_ID WHERE course.C_ID = ? GROUP BY attendance.ATT_DATE; ";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, c_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setDate(rs.getString("ATT_DATE"));
                Report report = new Report();
                report.setTotal(rs.getInt("total"));
                report.setAttendance(attendance);
                report.setCollege(new College( new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME")) ) );
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
    
    
    
    
    
    
    public List<Report> getStudentAttendanceReport(int acc_id) {

        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM `attendance` LEFT JOIN student on attendance.STU_ID = student.STUD_ID WHERE student.ACC_ID = ?; ";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setTotal(rs.getInt("total_Student" ));
                Attendance a = new Attendance();
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                report.setAttendance(a);
                report.setStudent(new Student(new User(acc_id, rs.getString("STUD_NAME"), rs.getString("STUD_EMAIL"), rs.getString("STUD_PHONE"), rs.getString("STUD_ADD"))));
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
    
    public List<Report> getStudentAttendanceReport(int acc_id, int sub_id) {

        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM `attendance` LEFT JOIN student on attendance.STU_ID = student.STUD_ID LEFT JOIN teacher on attendance.ACC_ID = teacher.ACC_ID WHERE student.ACC_ID = ? AND SUB_ID=?;  ";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            pstm.setInt(2, sub_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                
                //attendance details
                Attendance a = new Attendance();
                a.setAtt_id(rs.getInt("ATT_ID"));
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                int id = rs.getInt("TEAC_ID");
             
                report.setTeacher(new Teacher(new User(rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), query, query, query)));
                report.setAttendance(a);
                report.setStudent(new Student(new User(acc_id, rs.getString("STUD_NAME"), rs.getString("STUD_EMAIL"), rs.getString("STUD_PHONE"), rs.getString("STUD_ADD"))));
                
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
    
    public List<Report> getStudentSubject(int acc_id) {
        List<Report> subjectList = new ArrayList<>();
        String query = "SELECT subject.SUB_ID, subject.SUB_NAME, subject.SUB_CODE, COUNT(student.STUD_ID) as total FROM `attendance` LEFT JOIN student on attendance.STU_ID = student.STUD_ID LEFT JOIN `subject` ON student.SEM_ID = subject.SEM_ID WHERE student.ACC_ID=? GROUP BY subject.SUB_ID; ";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setInt(1, acc_id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                College college = new College();
                college.setSubject(new Subject(
                        rs.getInt("SUB_ID"),
                        rs.getString("SUB_NAME"),
                        rs.getString("SUB_CODE")
                ));
                college.setAttendance(new Attendance(checkTodayAttendance(rs.getInt("SUB_ID"))));
                
                report.setCollege(college);
                report.setTotal(rs.getInt("total"));
                subjectList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }
    
    
    
    
    
    
    /**
     * 
     * @param from
     * @param to
     * @return 
     */
    public List<Report> getAttendanceReport(String from, String to) {

        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT COUNT(STU_ID) as total_Attendance, SUB_ID, ACC_ID, ATT_DATE FROM `attendance` WHERE ATT_DATE BETWEEN ? AND ? GROUP BY SUB_ID; ";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, from);
            pstm.setString(2, to);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setTotal(rs.getInt("total_Attendance" ));
                Teacher teacher = new UserServices().getTeacherRow(rs.getInt("ACC_ID"));
                Attendance a = new Attendance();
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                
                report.setAttendance(a);
                report.setTeacher(teacher);
                report.setSubject(getSubject(rs.getInt("SUB_ID")));
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
    
    public List<Report> getAttendanceReport(String from, String to, int sub_id) {
        System.out.println("getAttendanceReport(from,to,int)\n");
        List<Report> attendanceList = new ArrayList<>();
        String query = "SELECT *, COUNT(STU_ID) as Total_Present FROM `attendance` LEFT JOIN student on attendance.STU_ID = student.STUD_ID WHERE attendance.SUB_ID = ? AND ATT_DATE BETWEEN ? AND ? GROUP BY stu_id; ";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, sub_id);
            pstm.setString(2, from);
            pstm.setString(3, to);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setTotal(rs.getInt("total_Present" ));
                Attendance a = new Attendance();
                a.setDate(rs.getString("ATT_DATE"));
                a.setSub_id(rs.getInt("SUB_ID"));
                a.setTeac_id(rs.getInt("ACC_ID"));
                
                report.setAttendance(a);
                report.setSubject(getSubject(rs.getInt("SUB_ID")));
//                report.setStudent(new Student(new User(rs.getInt("Stud_id"), rs.getString("STUd_NAME"), rs.getString("STUD_EMAIL"), rs.getString("STUd_PHONE"), rs.getString("STUD_ADD"))));
                report.setStudent(new UserServices().getStudentRow(rs.getInt("STUD_ID")));
                attendanceList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
    
    
    
    

    
}