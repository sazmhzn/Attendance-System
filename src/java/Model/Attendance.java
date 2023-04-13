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
public class Attendance {
    private int att_id;
    private String date;
    private boolean status;
    private int sub_id;
    private String[] stu_id;
    private int teac_id;
    

    public Attendance() {
    }

    public Attendance(int att_id, String date, boolean status, int sub_id, String[] stu_id, int teac_id) {
        this.att_id = att_id;
        this.date = date;
        this.status = status;
        this.sub_id = sub_id;
        this.stu_id = stu_id;
        this.teac_id = teac_id;
    }
    
    

    public Attendance(boolean status) {
        this.status = status;
    }
    

    public int getAtt_id() {
        return att_id;
    }

    public void setAtt_id(int att_id) {
        this.att_id = att_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String[] getStu_id() {
        return stu_id;
    }

    public void setStu_id(String[] stu_id) {
        this.stu_id = stu_id;
    }

    public int getTeac_id() {
        return teac_id;
    }

    public void setTeac_id(int teac_id) {
        this.teac_id = teac_id;
    }
    
    
}