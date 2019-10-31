
package model;


import java.io.Serializable;

public class BangQuanLy implements Serializable{
    private BanDoc banDoc;
    private Sach sach;    
    private int soLuong;
    private String tinhtrang;

    public BangQuanLy(BanDoc banDoc, Sach sach, int soLuong,
            String tinhtrang) {        
        this.banDoc = banDoc;
        this.sach = sach;
        this.soLuong = soLuong;
        this.tinhtrang=tinhtrang;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMaSach(){
        return sach.getMa();
    }
    
    public int getMaBanDoc(){
        return banDoc.getMa();
    }
    
    public String getTenSach(){
        return sach.getTen();
    }
    
    public String getTenBanDoc(){
        return banDoc.getTen();
    }
    
    public Object[] toObject() {
        return new Object[]{getMaBanDoc(),getTenBanDoc(),
            getMaSach(),getTenSach(),soLuong, tinhtrang};
    }
    
}
