
package morelist;


public class Document {
    //code, publisher and circulation (tổng số phát hành)
    private String code;
    private String publisher;
    private int circulation;

    public Document() {
    }

    public Document(String code, String publisher, 
            int circulation) {
        this.code = code;
        this.publisher = publisher;
        this.circulation = circulation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }
    public String toString(){
        return code+"\t"+publisher+"\t"+circulation;
    }
    
    
    
}
