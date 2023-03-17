/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
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

    /**
     * This will get the user from account table
     *
     * @param username
     * @param password
     * @return
     */
    public user getUser(String username, String password) {

        System.out.println("The password and user" + username + " " + password);
        user user = new user();
        String query = "select * from accounts where ACC_USERNAME=? and ACC_PASSWORD=?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            System.out.println("get User query:" + pstm);
            while (rs.next()) {
                System.out.println("This is a user");
//              user = new user();
                user.setId(rs.getInt("ACC_ID"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));
                user.setRole(rs.getString("ACC_ROLE"));
                System.out.println("Role id" + user.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * This method will insert user in accounts table
     * @param user 
     */
    public void insertUser(user user) {
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
     * This method will get user from database
     * @return userList
     */
    public List<user> getTeacherList() {
        List<user> userList = new ArrayList<>();
        String query = "SELECT * FROM `teacher` LEFT JOIN `accounts` ON teacher.ACC_ID = accounts.ACC_ID";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                //adding teacher details in user
                user user = new user();
                user.setId(rs.getInt("TEAC_ID"));
                user.setFullName(rs.getString("TEAC_NAME"));
                user.setAddress(rs.getString("TEAC_ADDRESS"));
                user.setPhone(rs.getString("TEAC_PHONE"));
                user.setEmail(rs.getString("TEAC_EMAIL"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));

                Teacher teacher = new Teacher();
                teacher.setUser(user);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    /**
     * This method will insert teacher details in account and teacher table
     * @param teacher 
     */
    public void insertTeacher(Teacher teacher) {
        insertUser(teacher.getUser()); //This method will insert the teacher details in Accout table

        user newUser = getUser(teacher.getUser().getUsername(), teacher.getUser().getPassword());

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

}
