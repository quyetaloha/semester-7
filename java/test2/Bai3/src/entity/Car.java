
package entity;
import java.util.Date;

public class Car extends Vehicle implements GiaDemo {
    private String typeofEngine;
    private int seats;
    public Car(){
      super();
    }
    public double getGia(){
        int cy=(new Date()).getYear();
        if(getYear()>=cy-2)
            return getGia();
        else
            return getGia()*0.9;
    } 
    public Car(String manufacturer, int year,
            double cost, String color, 
            String typeofEngine, int seats){
        super(manufacturer, year, cost,color);
        this.typeofEngine=typeofEngine;
        this.seats=seats;
        
    }

    public String getTypeofEngine() {
        return typeofEngine;
    }

    public void setTypeofEngine(String typeofEngine) {
        this.typeofEngine = typeofEngine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
    public String toString(){
       return super.toString()+"\t"+typeofEngine+"\t"+seats;        
    }
}
