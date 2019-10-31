
package validate;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StudentList list=new StudentList();
        while(true){  
        System.out.println("1. input student");        
        System.out.println("2. output");
        System.out.println("0. Exit");
        System.out.print("\n your choice (0-2):");
        int c;
        Scanner in=new Scanner(System.in);
        c=in.nextInt();
        
        switch(c){
            case 0: System.out.println("Bye!!!!");
                    System.exit(0);
                    break;
            case 1: while(true){                        
                        if(!list.addStudent())
                            System.out.println("id existed!!!");
                        else
                            break;
                    }    
                    break;    
            case 2: list.out();
                    break;            
            default: System.out.println("only choose 0-2");            
        }
      }
    }
}
