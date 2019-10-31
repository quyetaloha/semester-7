/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Hoang Quyet
 */
public class Student implements Serializable{
    private String mSV,ten,lop;

    public Student() {
    }

    public Student(String mSV, String ten, String lop) {
        this.mSV = mSV;
        this.ten = ten;
        this.lop = lop;
    }

    public void setmSV(String mSV) {
        this.mSV = mSV;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getmSV() {
        return mSV;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }
    
}
