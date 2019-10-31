
package demo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {        
        Tool t=new Tool();
        int[] a=new int[100];
        while(true){
            System.out.println("1. Nhap day so");
            System.out.println("2. Tong");
            System.out.println("3. Trung Binh");
            System.out.println("4. Day tang dan");
            System.out.println("5. Lon nhat va be nhat");
            System.out.println("0. Exit");
            System.out.print("Your choce (0->5):");
            int c;                    
            int n;
            Scanner in=new Scanner(System.in);
            c=in.nextInt();
            switch(c){
                case 0:System.out.println("Bye!!!");
                       System.exit(0);
                       break;
                case 1:System.out.print("n=");
                       n=in.nextInt();                       
                       System.out.print("Nhap day so:");
                       for(int i=0;i<n;i++)
                           a[i]=in.nextInt();
                       break;
                case 2:System.out.println(" Tong:"+t.tong(a));
                       break;
                case 3:System.out.println(" Trung binh:"+t.trungbinh(a));
                       break;
                case 4:System.out.println(t.sapxep(a));
                       break;
                case 5:System.out.println(t.maxmin(a));
                       break;    
                default:System.out.println("Have to choose (0->4)");
                      break;
            }
        }                        
    }
}
