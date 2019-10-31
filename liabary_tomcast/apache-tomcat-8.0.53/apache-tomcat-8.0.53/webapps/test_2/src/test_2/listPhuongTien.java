/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hoang Quyet
 */
public class listPhuongTien {
    ArrayList<PhuongTien> ptien=new ArrayList<>();

    public listPhuongTien() {
    }
    public void nhapOto(){
        String ten,nsx,gia,maluc;
        System.out.print("ten:");
        Scanner sc=new Scanner(System.in);
        ten=sc.nextLine();
        do{
            System.out.print("nsx:");
            nsx=sc.nextLine();
            
        }while(!nsx.matches("[A-Za-z]{3,5}[0-9]{3,5}"));
        System.out.print("gia:");
        gia=sc.nextLine();
        System.out.print("maluc:");
        maluc=sc.nextLine();
        Oto oto=new Oto(ten, nsx, gia, maluc);
        ptien.add(oto);
    }
    public void nhapXeMay(){
        String ten,nsx,gia,dongco;
        Scanner sc=new Scanner(System.in);
        ten=sc.nextLine();
        do{
            nsx=sc.nextLine();
            
        }while(!nsx.matches("[A-Za-z]{3,5}[0-9]{3,5}"));
        gia=sc.nextLine();
        dongco=sc.nextLine();
        XeMay xemay=new XeMay(ten, nsx, gia, dongco);
        ptien.add(xemay);
    }
    public void hienthi(){
        System.out.println("Xe may:");
        for(PhuongTien p:ptien){
            if(p instanceof XeMay){
                System.out.println(p.toString());
            }
        }
        System.out.println("Oto:");
        for(PhuongTien p:ptien){
            if(p instanceof Oto){
                System.out.println(p.toString());
            }
        }
    }
    public  void xoa(){
        String s="abc";
        for(PhuongTien p:ptien){
            
                if(p instanceof XeMay){
                    ptien.(p);
                }
                
            
        }
    }
}
