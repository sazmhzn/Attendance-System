/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.College;
import Model.Course;
import Model.Section;
import Model.Semester;
import Model.Subject;
import Model.Teacher;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                College college = new College(( new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))));
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
    
    
    
    
    
    
    
    public List<College> getSubjectList(int teac_id) {
        List<College> subjectList = new ArrayList<>();
        String query = "SELECT * FROM `subject` LEFT JOIN teacher on subject.TEAC_ID = teacher.TEAC_ID LEFT JOIN section ON subject.C_ID = section.COURSE_ID where teacher.TEAC_ID=?; ";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        
        try {
            pstm.setInt(1, teac_id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setSubject( new Subject(
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

                college.setSection(new Section( rs.getInt("SECTION_ID") , rs.getString("SECTION_NAME")));
                System.out.println("College: " + college.getSubject().getSubject_name());
                subjectList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
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
    
    public College getCourseRow( int id, Subject subject ) {
        College college = null;
        String query = "SELECT SUB_ID, SUB_NAME, teacher.TEAC_ID, teacher.TEAC_NAME, course.C_ID, course.COURSE_NAME, semester.SEM_ID, semester.SEM_NAME FROM `subject` LEFT JOIN teacher on subject.TEAC_ID = teacher.TEAC_ID LEFT JOIN course on subject.C_ID = course.C_ID LEFT JOIN semester on subject.SEM_ID = semester.SEM_ID where SUB_ID=2";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                college = new College();
                college.setSubject(new Subject(rs.getInt("SUB_ID"),
                        rs.getString("SUB_NAME"), 
                        rs.getString("SUB_CODE")));
                college.setCourse(new Course(rs.getInt("SEM_ID"), rs.getString("SEM_NAME")));
                college.setSemester(new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return college;
    }
    
     //This method will insert subject in subject
    public void insertSubject(College college) {
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
    
    //This method will insert course in subject
    public void insertCourse(Course course) {
        String query = "INSERT INTO `subject`(`COURSE_NAME`) VALUES (?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, course.getName());

            System.out.println(pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    //This method will get the subject details
    
}
