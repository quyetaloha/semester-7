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
public class Oto extends PhuongTien implements InterfaceXeCo{
    private String maluc;
    public Oto(){
        super();
    }
    public String getMaluc() {
        return maluc;
    }

    public void setMaluc(String maluc) {
        this.maluc = maluc;
    }

    public Oto(String ten, String nsx, String gia,String maluc) {
        super(ten, nsx, gia);
        this.maluc=maluc;
    }
    @Override
    public int getgia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public String toString() {
        
        return "Oto{" +super.toString()+ "dongco=" + maluc + '}';
    }
}
