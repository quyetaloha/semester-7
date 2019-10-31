
package validate;

import java.util.ArrayList;
import java.util.Scanner;


public class ListNoException {
    private ArrayList<Student> list;

    public ListNoException() {
       list=new ArrayList<>();
    }
    private boolean isStudent(String id){      
        for(Student s:list){
            if(s.getId().equalsIgnoreCase(id)){
                return true;                
            }
        }
        return false;
    }
    public boolean addStudent(){         
        Student s;
        Scanner in=new Scanner(System.in);
        String id,first,last,dob;              
        while(true){
            System.out.print("Code (B15DCCN123): ");
            id = in.nextLine();
            if(id.matches("^[Bb]{1}\\d{2}[A-Za-z]{4}\\d{3}$"))
                break;
        }
        if(isStudent(id))
            return false;
        System.out.print("First name: ");
        first = in.nextLine();
        System.out.print("Last name: ");
        last = in.nextLine();                
        while(true){
            System.out.print("Date of birth (dd-mm-yyyy): ");
            dob = in.nextLine();
            if(dob.matches("\\d{2}-\\d{2}-\\d{4}"))
                break;        
        }                            
        s=new Student(id, first, last, dob);
        return list.add(s);
    }
    public void out(){
        System.out.println("  ID   Full name  Date of birth");
        for(Student s:list)
            System.out.println(s.toString());
    }
}
