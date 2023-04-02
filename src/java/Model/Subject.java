/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Subject {
    private int subject_id;
    private String subject_name;
    private String subject_code;
    private Teacher teacher;

    public Subject() {
    }

    public Subject(int subject_id, String subject_name, String subject_code) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_code = subject_code;
    }

    public Subject(String subject_name, String subject_code, Teacher teacher) {
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.teacher = teacher;
    }
    
    public Subject(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
}
