
package demo;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {        
        Scanner in=new Scanner(System.in);        
        while(true){
    
            System.out.print("\n 1. Case 1");
            System.out.print("\n 2. Case 2");
            System.out.print("\n 3. Case 3");            
            System.out.print("\n 0. Exit");
            System.out.print("\n Your choice(0->3): ");
            int choice;
            choice=in.nextInt();
            switch(choice){
                case 1: System.out.println("Case 1");
                        break;
                case 2:System.out.println("Case 2");
                       break;
                case 3:System.out.println("Case 3");
                       break;                
                case 0: System.out.println("Bye!!!!");
                        System.exit(0);
                       break;
                default:System.out.println("only to choose (0->4)");                    
            }
        }
    }
}
