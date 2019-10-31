
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import entity.Car;
import entity.Motor;
import entity.Truck;
import entity.Vehicle;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class ListVehicle {
    ArrayList<Vehicle> list;
    public ListVehicle(){
        list=new ArrayList<Vehicle>();
        list.add(new Car("madaz1234",2017, 12,"Do","gggg", 7));
        list.add(new Car("madaz1234",2000, 2,"Do","gggg", 7));
        list.add(new Car("madaz1234",2014, 10,"xanh","gggg", 7));
        list.add(new Car("madaz1222",2015, 14,"Do","gggg", 7));
        list.add(new Motor("madaz1222",2016, 4, "xanh", 23));
    }    
    private Vehicle input(){        
        Vehicle v;
        String manufacturer;
        int year;
        double cost;
        String color;
        Scanner in=new Scanner(System.in); 
        while(true){
               System.out.println("manufacturer(Mazda2017): ");
               manufacturer = in.nextLine();
               if(manufacturer.matches("^[A-Za-z]+\\d{4}$"))
                  break;
            }        
        System.out.print("Manufacture year:");
        year=Integer.parseInt(in.nextLine());
        System.out.print("Cost:");
        cost=Double.parseDouble(in.nextLine());
        System.out.print("Color:");
        color=in.nextLine();
        v=new Vehicle(manufacturer, year, cost, color);        
        return v;
    }
    public boolean inputCar(){
        String typeofEngine;
        int seats;
        Vehicle v=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Type of engine:");
        typeofEngine=in.nextLine();
        String s="";
        while(true){
           System.out.print("Number of Seats:");
           s=in.nextLine();
           if(s.matches("\\d+"))
               break;
        }
        seats=Integer.parseInt(s);
        return list.add(new Car(v.getManufacturer(),
            v.getYear(),v.getCost(),v.getColor(), 
            typeofEngine, seats));
    }
    public boolean inputMotor(){
        double power;
        Vehicle v=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Power:");
        power=in.nextDouble();        
        return list.add(new Motor(v.getManufacturer(),v.getYear(),
                v.getCost(),v.getColor(), power));        
    }
    public boolean inputTruck(){
        double load;
        Vehicle v=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Load:");
        load=in.nextDouble();        
        return list.add(new Truck(v.getManufacturer(),v.getYear(),
                v.getCost(),v.getColor(), load));        
    }
    public int getNumberofCar(){
        int count=0;
        for(Vehicle i:list)
          if(i instanceof Car)
              count++;
        return count;
    }
    public int getNumberofMotor(){
        int count=0;
        for(Vehicle i:list)
          if(i instanceof Motor)
              count++;
        return count;
    }
    public int getNumberofTruck(){
        int count=0;
        for(Vehicle i:list)
          if(i instanceof Truck)
              count++;
        return count;
    }
    public void output(){
      if(getNumberofCar()>0){
        System.out.println("List of Cars");
        System.out.println("Manufacturer  Year   Cost    Color TypeofEngine NumberofSeats");
        for(Vehicle v:list){
            if(v instanceof Car)
            System.out.println(v.toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of cars:"+getNumberofCar());
      }  
      if(getNumberofMotor()>0){
        System.out.println("List of Motors");
        System.out.println("Manufacturer  Year   Cost    Color Power");
        for(Vehicle v:list){
            if(v instanceof Motor)
            System.out.println(v.toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of motors:"+getNumberofMotor());
      }
      if(getNumberofTruck()>0){
        System.out.println("List of Trucks");
        System.out.println("Manufacturer  Year   Cost    Color Load");
        for(Vehicle v:list){
            if(v instanceof Truck)
            System.out.println(v.toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of trucks:"+getNumberofTruck());
      }
    }
    public void getByManufacturer(String manufacturer){
        System.out.println("=====A list of Vehicles=========");
        System.out.println("Manufacture  Year   Cost Color");
        for (Vehicle v: list)
            if(v.getManufacturer().equalsIgnoreCase(manufacturer))
                System.out.println(v.toString());                 
        System.out.println("=====================================");
    }
    public void getByManufacturerA(String manufacturer){
        System.out.println("=====A list of Vehicles=========");
        System.out.println("Manufacture  Year   Cost Color");
        for (Vehicle v: list)
           // if(v.getManufacturer().contains(manufacturer))
            if(v.getManufacturer().indexOf(manufacturer)>=0)
                System.out.println(v.toString());                 
        System.out.println("=====================================");
    }
    public void getByCostGreater(double cost){
        System.out.println("=====A list of Vehicles=========");
        System.out.println("Manufacture  Year   Cost Color");
        for (Vehicle v: list)
            if(v.getCost()>=cost)
                System.out.println(v.toString());                 
        System.out.println("=====================================");
    }
    public void getByCostFrom(double from, double to){
        System.out.println("=====A list of Vehicles=========");
        System.out.println("Manufacture  Year   Cost Color");
        for (Vehicle v: list)
            if((v.getCost()>=from) && (v.getCost()<=to))
                System.out.println(v.toString());                 
        System.out.println("=====================================");
    }
    public void sortByManufacture(){
        Collections.sort(list, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {                
                return ((v1.getManufacturer().compareToIgnoreCase(v2.getManufacturer())));                
            }                          
        });
    }
    public void sortByTypeofEngine(){
        Collections.sort(list, new Comparator<Vehicle>(){
          public int compare(Vehicle v1, Vehicle v2){
              return (int)v1.getCost()-(int)v2.getCost();
          }
    });
    }
    private ArrayList<Integer> getAllYear(){
        ArrayList<Integer> t=new ArrayList<>();
        for(Vehicle i:list)
            if(!t.contains(i.getYear()))
                t.add(i.getYear());
        return t;
    }
    public void statisticByYear(){
        int i;
        ArrayList<Integer> t=getAllYear();
        Collections.sort(t);
        System.out.println("Statistic by year");
        System.out.println("Order Manufacture  Year   Cost Color");
        for(Integer k:t){
            i=0;
            for(Vehicle v:list)
                if(v.getYear()==k)
                    System.out.println((++i)+"  "+v.toString());
            System.out.println("Year: "+k+", Sum: "+i);
            System.out.println("------------------");
        }            
    }
    private ArrayList<String> getAllManufacturer(){
        ArrayList<String> t=new ArrayList<>();
        for(Vehicle i:list)
            if(!t.contains(i.getManufacturer()))
                t.add(i.getManufacturer());
        return t;
    }
    public void statisticByManufacturer(){
        int i;
        ArrayList<String> t=getAllManufacturer();
        System.out.println("Statistic by manufacturer");
        System.out.println("Order Manufacture  Year   Cost Color");
        for(String k:t){
            i=0;
            for(Vehicle v:list)
                if(k.contains(v.getManufacturer()))
                    System.out.println((++i)+"  "+v.toString());
            System.out.println("Manufacturer: "+k+", Sum: "+i);
            System.out.println("------------------");
        }
    }
    //group by Manufacturer and sum of cost
    public void sum(){
        Map<String, Double> sum = list.stream().collect(
        Collectors.groupingBy(Vehicle::getManufacturer, 
            Collectors.summingDouble(Vehicle::getCost)));
        System.out.println(sum); 
        }
    
    //group by Manufacturer and counting
    public void count(){
        Map<String, Long> counting = list.stream().collect(
          Collectors.groupingBy(Vehicle::getManufacturer, 
                  Collectors.counting()));
        System.out.println(counting);
        }
    //group by Manufacturer 
    public void average(){
        Map<String,Double> avg = list.stream().collect(
            Collectors.groupingBy(Vehicle::getManufacturer,
          Collectors.averagingDouble(Vehicle::getCost)));
        System.out.println(avg);
    }
    //max all of list
    public void max(){
        Optional<Vehicle> max = 
            list.stream()
            .collect(Collectors.maxBy(Comparator.
                    comparing(Vehicle::getCost)));
        System.out.println("Vehicle with max cost:"+            
             (max.isPresent()? max.get():"Not Applicable"));
    }
    //min all list
    public void min(){
        Optional<Vehicle> min = 
            list.stream()
            .collect(Collectors.minBy(Comparator.
                    comparing(Vehicle::getCost)));
        System.out.println("Vehicle with min cost:"+            
             (min.isPresent()? min.get():"Not Applicable"));
    }
    public void maxGroup(){
        Map<String, Vehicle> o =  
        list.stream().collect(
        Collectors.groupingBy(Vehicle::getManufacturer,
         Collectors.collectingAndThen(
         Collectors.reducing((Vehicle v1, Vehicle v2)
         -> v1.getCost()> v2.getCost()? v1 : v2),
          Optional::get)));
    
    System.out.println(o);
    }
    
    public void minGroup(){
        Map<String, Vehicle> o =  
        list.stream().collect(
        Collectors.groupingBy(Vehicle::getManufacturer,
         Collectors.collectingAndThen(
         Collectors.reducing((Vehicle v1, Vehicle v2)
         -> v1.getCost()< v2.getCost()? v1 : v2),
          Optional::get)));
    
    System.out.println(o);
    }
}
