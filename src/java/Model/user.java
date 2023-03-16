/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class user {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String semester;
    private String section;
    private String course;
    private String username;
    private String password;
    private String role;

    public user() {
        
    }

    
//    Teacher attributes for creating it
    public user(String fullName, String email, String phone, String course, String username, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
//    Geetting the value of the teacher
    public user(int id, String fullName, String email, String phone, String semester, String username, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.semester = semester;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    //Sign up construstor
    public user(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    
}
