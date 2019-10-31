
package Q3;


public class Vehicle {
    //manufacturer, manufacture year, cost, color.
    private  String manufacturer;
    private int year;
    private double cost;    
    private String color;
    
    public Vehicle() {
        
    }

    public Vehicle(String manufacturer, int year, double cost, String color) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.cost = cost;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public static double getCostA(){
        return 1000;
    }    
    public String toString(){
        return manufacturer+"\t"+year+"\t"+cost+"\t"+color;
    }
    
}
