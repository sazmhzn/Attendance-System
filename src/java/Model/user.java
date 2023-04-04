  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class User {
 
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String semester;
    private String section;
    private String course;
    private String username;
    private String password;
    private String role;
    private College college;
    private String status;
    private Date date;

    public User() {
    }
    
    /**
     * this constructor will be used to insert a teacher in table
     * @param id
     * @param fullName
     * @param email
     * @param phone
     * @param address 
     */
    public User(int id, String fullName, String email, String phone, String address) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    

    /**
     * 
     * @param id 
     * @param fullName
     * @param email
     * @param phone
     * @param address
     * @param college 
     */
    public User(int id, String fullName, String email, String phone, String address, College college) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.college = college;
    }

    public User(College college) {
        this.college = college;
    }

    
    
    
    /**
     * This constructor will get the Student details
     * @param id
     * @param fullName
     * @param email
     * @param phone
     * @param address
     * @param semester
     * @param section
     * @param course 
     */
    
    public User(int id, String fullName, String email, String phone, String address, String semester, String section, String course) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.semester = semester;
        this.section = section;
        this.course = course;
    }
    
    public User(String fullName, String email, String phone, String address, String section, String course, String username, String password, String role) {    
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.section = section;
        this.course = course;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    /**
     * This constructor will be used for student
     * @param fullName
     * @param email
     * @param phone
     * @param address
     * @param semester
     * @param section
     * @param course
     * @param username
     * @param password
     * @param role 
     */
    public User(String fullName, String email, String phone, String address, String semester, String section, String course, String username, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.semester = semester;
        this.section = section;
        this.course = course;
        this.username = username;
        this.password = password;
        this.role = role;
    }

//  signup constructor
    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    
}
