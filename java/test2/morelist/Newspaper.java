
package morelist;


public class Newspaper extends Document{
   //Release date
    private String date;
    public Newspaper(){
        super();
    }

    public Newspaper(String code, String publisher, int circulation,
            String date) {
        super(code, publisher, circulation);
        this.date = date;        
    }    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String toString(){
        return super.toString()+"\t"+date;
    }
    
}
