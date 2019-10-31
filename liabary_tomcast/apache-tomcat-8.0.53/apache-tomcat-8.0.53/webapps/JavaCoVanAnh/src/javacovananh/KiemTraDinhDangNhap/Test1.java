/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacovananh.KiemTraDinhDangNhap;

import java.util.Scanner;


/**
 *
 * @author Hoang Quyet
 */
public class Test1 {
    
    public static void main(String[] args) {
        String s="^\\d{2}-\\D{3}$";
        String a="14-ata";
        System.out.println(a.matches(s));
        Scanner sc=new Scanner(System.in);
        StringBuilder f=new StringBuilder();
        f.append(sc.nextLine());
        a=f.toString();
        a=a.replaceAll("\\s+", " ");
        System.out.println(a);
        int d[][]=new int[5][3];
    }
}
