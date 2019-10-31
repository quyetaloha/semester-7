
package Q3;



public class Car extends Vehicle{
    private String engine;
    private int numofsests;
    public Car(){
        
    }

    public Car( 
            String manufacturer, int year, 
            double cost, String color,String engine, int numofsests) {
        super(manufacturer, year, cost, color);
        this.engine = engine;
        this.numofsests = numofsests;
    }
    
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getNumofsests() {
        return numofsests;
    }

    public void setNumofsests(int numofsests) {
        this.numofsests = numofsests;
    }
    
    public String toString(){
        return super.toString()+"\t"+engine+"\t"+numofsests;
    }
}
