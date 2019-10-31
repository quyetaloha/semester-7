
package morelist;


public class Magazine extends Document{
    //issue number, monthly release.
    private int number,monthly;
    public Magazine(){
        super();
    }

    public Magazine(String code, String publisher, int circulation,
            int number, int monthly) {
        super(code, publisher, circulation);
        this.number = number;
        this.monthly = monthly;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMonthly() {
        return monthly;
    }

    public void setMonthly(int monthly) {
        this.monthly = monthly;
    }
    public String toString(){
        return super.toString()+"\t"+number+"\t"+monthly;
    }
    
}
