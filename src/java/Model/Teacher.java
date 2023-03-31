/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */

public class Teacher {
    private int acc_id;
    private User user;
    private Subject[] subject;
    
    public Teacher() {
    }

    public Teacher(User user) {
        this.user = user;
    }

    public Teacher(int acc_id, User user) {
        this.acc_id = acc_id;
        this.user = user;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject[] getSubjects() {
        return subject;
    }

    public void setSubjects(Subject[] subjects) {
        this.subject = subjects;
    }
}

