/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.Course;
import Model.Subject;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class SubjectServlet {
    
     //This method will insert subject in subject
    public void insertSubject(Subject subject) {
        String query = "INSERT INTO `subject`(`SUB_NAME`, `SUB_CODE`) VALUES (?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, subject.getSubject_name());
            pstm.setString(2, subject.getSubject_code());

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
            pstm.setString(1, course.getCourse_name());

            System.out.println(pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    //This method will get the subject details
    
}
