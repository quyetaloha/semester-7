
package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {        
        
        while(true){
            System.out.println("1. Nhap day so");
            System.out.println("2. Tong");
            System.out.println("3. Trung Binh");
            System.out.println("4. Day tang dan");
            System.out.println("5. Lon nhat va be nhat");
            System.out.println("0. Exit");
            System.out.print("Your choce (0->5):");
            int c;
            Scanner in=new Scanner(System.in);
            c=in.nextInt();
            switch(c){
                case 0:System.out.println("Bye!!!");
                       System.exit(0);
                       break;
                case 1:System.out.println(" case 1");
                       break;
                case 2:System.out.println(" case 2");
                       break;
                case 3:System.out.println(" case 3");
                       break;
                case 4:System.out.println(" case 4");
                       break;    
                default:System.out.println("Have to choose (0->4)");
                      break;
            }
        }                        
    }
}
