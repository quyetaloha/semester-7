
package validate;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentList {
    private ArrayList<Student> list;

    public StudentList() {
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
    private void validateID(String id)
            throws ValidateException{
        if(!id.matches("^[Bb]{1}\\d{2}[A-Za-z]{4}\\d{3}$"))                          
            throw new ValidateException("ID \""+id+"\" "
                    + "not valid");
    }
    private void validateDob(String dob)
         throws ValidateException{
       if(!dob.matches("\\d{2}-\\d{2}-\\d{4}"))            
            throw new ValidateException("DOB \""+dob+
                    "\" not valid"); 
    }    
    public boolean addStudent(){         
        Student s;
        Scanner in=new Scanner(System.in);
        String id,first,last,dob;              
        while(true){
            System.out.print("ID (B15DCCN123): ");
            id = in.nextLine();
            try{
               validateID(id);
               break;
            }catch(ValidateException e){
               System.out.println(e.getMessage());
            }
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
            try{
               validateDob(dob);
               break;            
            }catch(ValidateException e){
               System.out.println(e.getMessage());
            }
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
