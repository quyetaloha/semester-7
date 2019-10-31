
package validate;


public class Student {
    private String id;
    private String first;
    private String last;
    private String dob;
    public Student() {
    }
    public Student(String id, String first, 
            String last, String dob) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.dob = dob;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = this.first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String toString(){
        return id+"\t"+first+" "+last+"\t"+dob;
    }        
}
