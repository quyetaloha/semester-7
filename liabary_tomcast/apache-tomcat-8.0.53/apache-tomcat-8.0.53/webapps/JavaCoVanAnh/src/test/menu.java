/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author Hoang Quyet
 */
public class menu {
    public static void main(String[] args) {
        Tool t=new Tool();
        double a=1,b=1,c=1;
        while(true){
            System.out.println("1. nhap a,b,c");
            System.out.println("2. giai phuong trinh bac 2");
            System.out.println("3. sin(a)");
            System.out.println("4. Case 4");
            System.out.println("0. exit");
            System.out.println("Your choice (0->4) : ");
            int cc;
            Scanner in = new Scanner(System.in);
            cc=in.nextInt();
            switch(cc){
                case 0: System.out.println("Bye!!");
                        System.exit(0);
                        break;
                case 1: System.out.println("a=");
                        a=in.nextDouble();
                        System.out.println("b=");
                        b=in.nextDouble();
                        System.out.println("c=");
                        c=in.nextDouble();
                        break;
                case 2: t.giaipt(a, b, c);
                        break;
                case 3:
                        System.out.println("sin("+Math.PI/2+")="+t.tinhSin(Math.PI/2));
                        System.out.println("sin("+a+")="+t.tinhSin(a));
                        break;
                case 4:
                        System.out.println("case 4");
                        break;
                default: System.out.println("have to select 0->4");
                        break;
                        
            }
        }
    }
}
