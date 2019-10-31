
package entity;


public class Motor extends Vehicle{
    private double power;
    
    public Motor(){
        super();
    }
    public Motor(String manufacturer, int year,
            double cost, String color, double power){
        super(manufacturer, year, cost, color);
        this.power=power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
    public String toString(){
        return super.toString()+"\t"+power;
    }                
}
