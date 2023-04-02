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
