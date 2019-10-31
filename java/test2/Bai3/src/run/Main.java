
package run;

import controller.ListVehicle;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        ListVehicle a=new ListVehicle();        
        Scanner in=new Scanner(System.in);        
        while(true){    
            System.out.print("\n 1. input a Car");
            System.out.print("\n 2. input a Motor");
            System.out.print("\n 3. input a Truck");
            System.out.print("\n 4. output a list of Vehicles");
            System.out.print("\n 5. Search by manufacturer");
            System.out.print("\n 6. Search by manufacturer ()");
            System.out.print("\n 7. Search by cost (greater than)");
            System.out.print("\n 8. Search by cost (from to)");
            System.out.print("\n 9. Sort by manufacturer");
            System.out.print("\n 10. Sort by type of engine");
            //stream()
            System.out.print("\n 11. group Sum of cost");
            System.out.print("\n 12. Counting by Manufacture");
            System.out.print("\n 13. group Average of cost");
            System.out.print("\n 14. max in a list");
            System.out.print("\n 15. min in a list");
            System.out.print("\n 16. max in each group");
            System.out.print("\n 17. min in each group");
            System.out.print("\n 0. Exit");
            System.out.print("\n Your choice(0->10): ");
            int choice;
            choice=in.nextInt();
            switch(choice){
                case 1:a.inputCar();
                       break;
                case 2:a.inputMotor();
                       break;
                case 3:a.inputTruck();
                       break;
                case 4:a.output();
                       break;
                case 5:String manufacturer;
                       System.out.println("enter Manufacturer for searching:");
                       manufacturer=in.nextLine();
                       a.getByManufacturer(manufacturer);
                       break;
                case 6:
                       System.out.println("enter Manufacturer for searching:");
                       manufacturer=in.nextLine();
                       a.getByManufacturerA(manufacturer);
                       break;
                case 7:double cost;
                       System.out.println("enter cost for searching:");
                       cost=in.nextDouble();
                       a.getByCostGreater(cost);
                       break;
                case 8:double from,to;
                       System.out.println("enter cost from:");
                       from=in.nextDouble();
                       System.out.println("enter cost to:");
                       to=in.nextDouble();
                       a.getByCostFrom(from,to);
                       break;
                case 9:a.output();
                       a.sortByManufacture();
                       System.out.println("a sorted List by manufacturer");
                       a.output();
                       break;
                case 10:a.output();
                       a.sortByTypeofEngine();
                       System.out.println("a sorted List by type of engine");
                       a.output();
                       break;
                case 11:a.sum();
                        break;
                case 12:a.count();
                        break;
                case 13:a.average();
                        break;
                case 14:a.max();
                        break; 
                case 15:a.min();
                        break;
                case 16:a.maxGroup();
                        break;
                case 17:a.minGroup();
                        break;        
                case 0: System.out.println("Bye!!!!");
                        System.exit(0);
                       break;
                default:System.out.println("only to choose (0->10)");                    
            }
        }
    }
}
