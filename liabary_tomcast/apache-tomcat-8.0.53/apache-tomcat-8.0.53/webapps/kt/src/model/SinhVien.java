/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Hoang Quyet
 */
public class SinhVien implements Serializable{
    String ten;
    Float dTA;
    Float dToan;
    Float dTin;
    int masv;

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getdTA() {
        return dTA;
    }

    public void setdTA(Float dTA) {
        this.dTA = dTA;
    }

    public Float getdToan() {
        return dToan;
    }

    public void setdToan(Float dToan) {
        this.dToan = dToan;
    }

    public Float getdTin() {
        return dTin;
    }

    public void setdTin(Float dTin) {
        this.dTin = dTin;
    }
}
