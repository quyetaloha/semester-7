package model;

import java.io.Serializable;
import java.net.Socket;

public class Nguoi implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idNguoiDung;
    private String name;
    private String loaiHang;
    private int xepHang;
    private int soTranThang;
    private int soTranThua;
    private int diem;
    private String avata;
    private int tinhTrang;//1 ON 0 la OFF
    private int role;//1 chu phong 0 la nguoi choi vao phong
    private String ipAddress;
    private int port;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public int getXepHang() {
        return xepHang;
    }

    public void setXepHang(int xepHang) {
        this.xepHang = xepHang;
    }

    public int getSoTranThang() {
        return soTranThang;
    }

    public void setSoTranThang(int soTranThang) {
        this.soTranThang = soTranThang;
    }

    public int getSoTranThua() {
        return soTranThua;
    }

    public void setSoTranThua(int soTranThua) {
        this.soTranThua = soTranThua;
    }

}
