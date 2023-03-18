/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author lenovo
 */
public class Student {
    private user user;
    private String semester;
    private String matrix_no;
            
    public Student(user user) {
        this.user = user;
    }

    public Student() {
    }

    public Student(user user, String semester, String matrix_no) {
        this.user = user;
        this.semester = semester;
        this.matrix_no = matrix_no;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getMatrix_no() {
        return matrix_no;
    }

    public void setMatrix_no(String matrix_no) {
        this.matrix_no = matrix_no;
    }
    
    
    
    
}
