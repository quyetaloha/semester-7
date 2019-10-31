/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ntkhanh
 */
public class Student implements Serializable{
       
       static final long serialVersionUID = 1L;
       
       private String maSV;
       private String hovaten;
       private String IP;
       private String message;

    public String getMessage() {
        return message;
    }

    public Student(String maSV, String hovaten, String IP, String message) {
        this.maSV = maSV;
        this.hovaten = hovaten;
        this.IP = IP;
        this.message = message;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public String getIP() {
        return IP;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
       
}
