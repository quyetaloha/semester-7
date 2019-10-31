
package vehiclesystem;

import vehiclesystem.entity.Truck;
import vehiclesystem.entity.Car;
import vehiclesystem.entity.Motor;
import vehiclesystem.entity.Vehicle;
import java.util.Scanner;

public class ArrayVehicles {
    private Vehicle[] list;
    private int n;
    public ArrayVehicles(){
        n=0;
        list=new Vehicle[50];
    }
    public int getNumberofVehicle(){
        return n;
    }
    private Vehicle input(){        
        Vehicle v=null;
        String manufacturer;
        int year;
        double cost;
        String color;
        Scanner in=new Scanner(System.in);        
        System.out.print("Manufacturer:");
        manufacturer=in.nextLine();
        System.out.print("Manufacture year:");
        year=Integer.parseInt(in.nextLine());
        System.out.print("Cost:");
        cost=Double.parseDouble(in.nextLine());
        System.out.print("Color:");
        color=in.nextLine();
        v=new Vehicle(manufacturer, year, cost, color);        
        return v;
    }
    public void inputCar(){
        String typeofEngine;
        int seats;
        Vehicle v=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Type of engine:");
        typeofEngine=in.nextLine();
        System.out.print("Number of Seats:");
        seats=in.nextInt();
        list[n++]=new Car(v.getManufacturer(),
                v.getYear(),
                v.getCost(),v.getColor(), 
                typeofEngine, seats);        
    }
    public void inputMotor(){
        double power;
        Vehicle v=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Power:");
        power=in.nextDouble();        
        list[n++]=new Motor(v.getManufacturer(),v.getYear(),
                v.getCost(),v.getColor(), power);        
    }
    public void inputTruck(){
        double load;
        Vehicle v=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Load:");
        load=in.nextDouble();        
        list[n++]=new Truck(v.getManufacturer(),v.getYear(),
                v.getCost(),v.getColor(), load);        
    }
    public int getNumberofCar(){
        int count=0;
        for(int i=0;i<n;i++)
          if(list[i] instanceof Car)
              count++;
        return count;
    }
    public int getNumberofMotor(){
        int count=0;
        for(int i=0;i<n;i++)
          if(list[i] instanceof Motor)
              count++;
        return count;
    }
    public int getNumberofTruck(){
        int count=0;
        for(int i=0;i<n;i++)
          if(list[i] instanceof Truck)
              count++;
        return count;
    }
    public void output(){
      if(getNumberofCar()>0){
        System.out.println("List of Cars");
        System.out.println("Manufacturer  Year   Cost    Color TypeofEngine NumberofSeats");
        for(int i=0;i<n;i++){
            if(list[i] instanceof Car)
            System.out.println(list[i].toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of cars:"+getNumberofCar());
      }
      if(getNumberofMotor()>0){
        System.out.println("List of Motors");
        System.out.println("Manufacturer  Year   Cost    Color Power");
        for(int i=0;i<n;i++){
            if(list[i] instanceof Motor)
            System.out.println(list[i].toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of motors:"+getNumberofMotor());
      }
      if(getNumberofTruck()>0){
        System.out.println("List of Trucks");
        System.out.println("Manufacturer  Year   Cost    Color Load");
        for(int i=0;i<n;i++){
            if(list[i] instanceof Truck)
            System.out.println(list[i].toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of trucks:"+getNumberofTruck());
      }  
    }
}
