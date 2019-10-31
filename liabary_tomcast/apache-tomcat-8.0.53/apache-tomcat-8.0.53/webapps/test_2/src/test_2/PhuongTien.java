package test_2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoang Quyet
 */
public class PhuongTien {
    String ten,nsx,gia;
    
    public PhuongTien(){
        
    }
    public PhuongTien(String ten, String nsx, String gia) {
        this.ten = ten;
        this.nsx = nsx;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public String getNsx() {
        return nsx;
    }

    public String getGia() {
        return gia;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "PhuongTien{" + "ten=" + ten + ", nsx=" + nsx + ", gia=" + gia ;
    }
    
}
