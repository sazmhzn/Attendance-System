/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class College {
    private Subject subject;
    private Course course;
    private Semester semester;
    private Section section;
    private Student student;

    public College() {
    }

    public College(Course course, Semester semester, Section section) {
        this.course = course;
        this.semester = semester;
        this.section = section;
    }

    public College(Subject subject, Course course, Semester semester, Section section, Student student) {
        this.subject = subject;
        this.course = course;
        this.semester = semester;
        this.section = section;
        this.student = student;
    }

    
    
    
    
    public College(Subject subject) {
        this.subject = subject;
    }

    public College(Course course) {
        this.course = course;
    }

    public College(Semester semester) {
        this.semester = semester;
    }

    public College(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
