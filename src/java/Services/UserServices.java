/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.College;
import Model.Course;
import Model.Section;
import Model.Student;
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
public class UserServices {

    /**
     * This will get the User from account table
     * This is used for authentication in login jsp
     * @param username
     * @param password
     * @return
     */
    public User getUser(String username, String password) {
        User user = null;
        String query = "select * from accounts where ACC_USERNAME=? and ACC_PASSWORD=?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            System.out.println("get User query:" + pstm);
            while (rs.next()) {
                System.out.println("This is a user");
                user = new User();
                user.setId(rs.getInt("ACC_ID"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));
                user.setRole(rs.getString("ACC_ROLE"));
                System.out.println("Role id " + user.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<Teacher> getTeacherList() {
        List<Teacher> userList = new ArrayList<>();
        String query = "SELECT * FROM `teacher` LEFT JOIN `accounts` ON teacher.ACC_ID = accounts.ACC_ID";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                Teacher teacher = new Teacher();
       
                teacher.setUser(new User(rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), rs.getString("TEAC_EMAIL"), rs.getString("TEAC_PHONE"),rs.getString("TEAC_ADDRESS") ));
                teacher.setAcc_id(rs.getInt("ACC_ID"));
                userList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User getUserRow(int id){
        User user = new User();
        String query = "select * from account where ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                
                user.setId(rs.getInt("TEAC_ID"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));
                user.setRole(rs.getString("ACC_ROLE"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    /**
     * This method will get a teacher row
     * @param id
     * @return 
     */
      public Teacher getTeacherRow(int id){
        Teacher teacher = new Teacher();
        String query = "SELECT * FROM `teacher` LEFT JOIN `accounts` ON teacher.ACC_ID = accounts.ACC_ID where teacher.ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            System.out.println("Query: " + pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
    
                teacher.setUser(new User( rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), rs.getString("TEAC_EMAIL"), rs.getString("TEAC_PHONE"), rs.getString("TEAC_ADDRESS") ));
                System.out.println("teacher from get Teahcer Row:");
                System.out.println("Full name: " + teacher.getUser().getFullName());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }
    
    /**
     * This method will insert User in accounts table
     *  This method is used in addTeacher jsp
     * @param user 
     */
    public void insertUser(User user) {
        String query = "insert into accounts (ACC_USERNAME,ACC_PASSWORD,ACC_ROLE)"
                + "values(?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());

            System.out.println("insert user query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will insert teacher details in account and teacher table
     * @param teacher 
     */
    public void insertUser(Teacher teacher) {
        insertUser(teacher.getUser()); //This method will insert the teacher details in Accout table

        User newUser = getUser(teacher.getUser().getUsername(), teacher.getUser().getPassword());

        System.out.println("\n\n The user id " + teacher.getUser().getId());

        String query = "INSERT INTO `teacher`(`TEAC_NAME`, `TEAC_ADDRESS`, `TEAC_EMAIL`, `TEAC_PHONE`, `ACC_ID`) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, teacher.getUser().getFullName());
            pstm.setString(2, teacher.getUser().getAddress());
            pstm.setString(3, teacher.getUser().getEmail());
            pstm.setString(4, teacher.getUser().getPhone());
            pstm.setInt(5, newUser.getId());
            System.out.println("insert Teacher query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    /**
     * This method will delete a user from account table
     * @param acc_id 
     */
    public void deleteUser(int acc_id) {
        String query = "DELETE FROM `user` WHERE ACC_ID = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            System.out.println("insert user query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method will delete the teacher from teacher and account table
     * @param acc_id 
     */
    public void deleteTeacher(int acc_id) {
        deleteUser(acc_id);
        String query = "DELETE FROM `teacher` WHERE ACC_ID = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            System.out.println("insert user query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editUser(int id, User user) throws SQLException {

        String query = "update users set ACC_USERNAME=?,ACC_PASSWORD=?," +
                "ACC_ROLE=? where ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getRole());
        pstm.setInt(4, user.getId());

        pstm.execute();
    }
    
    /**
     * This method will insert student in student and account tables
     * @param student 
     */
    public void insertUser(Student student) {
        insertUser(student.getUser()); //This method will insert the student details in Accout table

        User newUser = getUser(student.getUser().getUsername(), student.getUser().getPassword());
        
        System.out.println("\n\n The user id " + student.getUser().getId());

        String query = "INSERT INTO `student`(`STUD_NAME`, `STUD_ADDRESS`, `STUD_EMAIL`, `STUD_SEMESTER`, `ACC_ID`) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, student.getUser().getFullName());
            pstm.setString(2, student.getUser().getAddress());
            pstm.setString(3, student.getUser().getEmail());
            pstm.setString(4, student.getSemester());
            pstm.setInt(5, newUser.getId());
            System.out.println("insert Student query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method will get get the list of student 
     * @return 
     */
    public List<Student> getStudentList() {
        List<Student> userList = new ArrayList<>();
        String query = "SELECT * FROM `student` left JOIN course on student.C_ID = course.C_ID LEFT JOIN semester ON semester.SEM_ID = student.SEM_ID LEFT JOIN section on student.SEC_ID = section.SECTION_ID; ";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setUser(new User(rs.getInt("STUD_ID"), rs.getString("STUD_NAME"), rs.getString("STUD_EMAIL"), rs.getString("STUD_PHONE"), rs.getString("STUD_ADD"), rs.getString("SEM_NAME"), rs.getString("SECTION_NAME"), rs.getString("COURSE_NAME")));
                userList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    
    //methods for courses
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
        
        public List<Section> getSectionList() {
        List<Section> sectionList = new ArrayList<>();
        String query = "SELECT * FROM `section`";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Section section = new Section(rs.getInt("C_ID"), rs.getString("COURSE_NAME"));
                sectionList.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sectionList;
    }

}
