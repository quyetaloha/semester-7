/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.io.Serializable;


public class BanDoc implements Serializable{
    private String maBD;
    private String tenBD;
    private String diachi;
    private String dienthoai;   
    private String khoa;
    
    public BanDoc(){        
    }

    public BanDoc(String maBD) {
        this.maBD = maBD;
    }

    public BanDoc(String maBD, String tenBD, 
            String diachi, String dienthoai,String khoa) {
        this.maBD = maBD;
        this.tenBD = tenBD;
        this.diachi = diachi;
        this.dienthoai = dienthoai;   
        this.khoa=khoa;
       
    }
    
    public String getMaBD() {
        return maBD;
    }

    public void setMaBD(String maBD) {
        this.maBD = maBD;
    }

    public String getTenBD() {
        return tenBD;
    }

    public void setTenBD(String tenBD) {
        this.tenBD = tenBD;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    Object[] toObject(){
        return new Object[]{maBD,tenBD,
            diachi,dienthoai,khoa};
    }
}
