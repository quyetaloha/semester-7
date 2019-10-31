
package morelist;

import vehiclesystem.list.*;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        ListDocument d=new ListDocument();        
        Scanner in=new Scanner(System.in);        
        while(true){    
            System.out.print("\n 1. input a Book");
            System.out.print("\n 2. input a Magazine");
            System.out.print("\n 3. input a Newspaper");
            System.out.print("\n 4. output a list of Documents");
            System.out.print("\n 5. Delete a Document");
            System.out.print("\n 6. Edit a Document");
            
            System.out.print("\n 0. Exit");
            System.out.print("\n Your choice(0->6): ");
            int choice;
            choice=in.nextInt();
            switch(choice){
                case 1:d.inputBook();
                       break;
                case 2:d.inputMagazine();
                       break;
                case 3:d.inputNewspaper();
                       break;
                case 4:d.output();
                       break;
                case 5:if(!d.delete())
                           System.out.println("can't find a document");
                       else
                           System.out.println("delete Successfully!!");
                       break;
                case 6:
                       if(!d.editDocument())
                           System.out.println("can't find a document");
                       else
                           System.out.println("Successful!!");
                       break;
                    
                case 0: System.out.println("Bye!!!!");
                        System.exit(0);
                       break;
                default:System.out.println("only to choose (0->4)");                    
            }
        }
    }
}
