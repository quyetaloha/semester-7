package model;



import java.io.Serializable;

public class Student implements Serializable{
    public static long SerialVersionUID=-3126998878902358585L;
    private String maSV;
    private String hoVaTen;
    private String IP;
    private String mes;

    public Student(String maSV, String hoVaTen, String IP, String mes) {
        this.maSV = maSV;
        this.hoVaTen = hoVaTen;
        this.IP = IP;
        this.mes = mes;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getIP() {
        return IP;
    }

    public String getMes() {
        return mes;
    }
    
}