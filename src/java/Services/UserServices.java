/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.Subject;
import Model.Teacher;
import Model.user;
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
    
    //Thisi will get the user from account table
      public user getUser(String username, String password) {

        System.out.println("the user is defined null");
        System.out.println("The password and user" + username + " " + password);
        user user = null;
        String query = "select * from accounts where ACC_USERNAME=? and ACC_PASSWORD=?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {   
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            System.out.println(  "get User query:" + pstm);
            while (rs.next()) {
                System.out.println("There is a user");
                user = new user();
                user.setId(rs.getInt("ACC_ID"));
//              user.setFullName(rs.getString("ACC_USERNAME"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));
                user.setRole(rs.getString("ACC_ROLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
      
      //This will insert the user into user table
      //This is used for authentication
       public void insertUser(user user) {
        String query = "insert into accounts (ACC_USERNAME,ACC_PASSWORD,ACC_ROLE)" +
                "values(?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());
            
            System.out.println(  "insert user query:" + pstm);
            
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //       insertUser method ends
       
        public List<Teacher> getUserList() {
        List<Teacher> userList = new ArrayList<>();
        String query = "select * from teacher";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();

//                teacher.setUser(new user().setId(rs.getInt("TEAC_ID") ));
//                teacher.setFull_name(rs.getString("TEAC_NAME"));
//                teacher.setUsername(rs.getString("TEAC_ADDRESS"));
//                teacher.setPassword(rs.getString("TEAC_EMAIL"));
//                teacher.setRole(rs.getString("TEAC_PHONE"));

                userList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
       
       //This method will insert teacher in teacher table
       public void insertTeacher(Teacher teacher) {
        insertUser(teacher.getUser()); //This method will insert the teacher details in Accout table
        
        
        getUser(teacher.getUser().getUsername(), teacher.getUser().getPassword());
        
        System.out.println("\n\n" + teacher.getUser().getId());
        
        String query = "INSERT INTO `teacher`(`TEAC_NAME`, `TEAC_ADDRESS`, `TEAC_EMAIL`, `TEAC_PHONE`, `ACC_ID`) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, teacher.getUser().getFullName());
            pstm.setString(2, teacher.getUser().getAddress());
            pstm.setString(3, teacher.getUser().getEmail());
            pstm.setString(4, teacher.getUser().getPhone());
            pstm.setInt(5, teacher.getUser().getId());
            System.out.println(  "insert Teacher query:" + pstm);
            
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
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
}
