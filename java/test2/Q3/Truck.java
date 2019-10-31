
package Q3;


public class Truck extends Vehicle {
    private double load;
    public Truck(){
        super();
    }
    public Truck(String manufacturer, int year,
            double cost, String color, double load){
        super(manufacturer, year, cost, color);
        this.load=load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
    public String toString(){
        return super.toString()+"\t"+load;
    }
    
}
