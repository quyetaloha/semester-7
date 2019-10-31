/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_2;

/**
 *
 * @author Hoang Quyet
 */
public class XeMay extends PhuongTien{
    private String dongco;

    @Override
    public String toString() {
        
        return "XeMay{" +super.toString()+ "dongco=" + dongco + '}';
    }

    public void setDongco(String dongco) {
        this.dongco = dongco;
    }

    public String getDongco() {
        return dongco;
    }

    public XeMay() {
        super();
    }

    public XeMay(String ten, String nsx, String gia,String dongco) {
        super(ten, nsx, gia);
        this.dongco=dongco;
    }
    
}
