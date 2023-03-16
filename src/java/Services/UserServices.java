/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class UserServices {
    
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

            while (rs.next()) {
                System.out.println("There is a user");
                user = new user();
                user.setId(rs.getInt("ACC_ID"));
//                user.setFullName(rs.getString("ACC_USERNAME"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));
                user.setRole(rs.getString("ACC_ROLE"));
                                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
      
       public void insertUser(user user) {
        String query = "insert into accounts (ACC_USERNAME,ACC_PASSWORD,ACC_ROLE)" +
                "values(?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());
            
            System.out.println(pstm);
            
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
