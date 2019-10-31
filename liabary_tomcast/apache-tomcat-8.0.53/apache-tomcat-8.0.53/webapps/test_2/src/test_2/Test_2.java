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
public class Test_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PhuongTien pt[]=new PhuongTien[5];
        System.out.println(pt.toString());
        listPhuongTien a=new listPhuongTien();
        a.nhapOto();
        a.nhapXeMay();
        a.hienthi();
        a.xoa();
        a.hienthi();
    }
    
}
