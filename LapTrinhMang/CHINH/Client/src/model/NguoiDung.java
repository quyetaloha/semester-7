package model;

import java.io.Serializable;
import java.util.ArrayList;

public class NguoiDung extends Nguoi implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int tien;
    private ArrayList<Nguoi> dsBanBe;

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public ArrayList<Nguoi> getDsBanBe() {
        return dsBanBe;
    }

    public void setDsBanBe(ArrayList<Nguoi> dsBanBe) {
        this.dsBanBe = dsBanBe;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTinhTrang(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
