/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom2;

/**
 *
 * @author ADMIN
 */
import java.io.Serializable;
public class HoaDon implements Serializable{
    private String ma,ten,ngay;
    private double tien;

    public HoaDon() {
    }

    public HoaDon(String ma, String ten, String ngay, double tien) {
        this.ma = ma;
        this.ten = ten;
        this.ngay = ngay;
        this.tien = tien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }
    public Object[] toObject(){
        return new Object[]{
         ma,ten, ngay, tien
        };
    }
}
