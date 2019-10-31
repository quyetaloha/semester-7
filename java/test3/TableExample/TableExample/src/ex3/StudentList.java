
package ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class StudentList {
    ArrayList<Student> list;
    public StudentList(){
        list = new ArrayList<>();
    }
    public boolean isStudent(String rollno){       
        for(Student i:list)
            if(i.getRollno().equalsIgnoreCase(rollno))
                return true;                                    
        return false;
    }
    public boolean addStudent(Student s){
        return list.add(s);
    }

    public ArrayList<Student> getAllStudent(){
        return list;
    }
    public void setStudent(int pos,Student s){
        list.set(pos, s);
    }
    public void delStudent(String rollno){
        Student s=searchByRollno(rollno);
        list.remove(s);
    }
    public Student searchByRollno(String rollno){        
        for(Student i:list){
            if(i.getRollno().equalsIgnoreCase(rollno))
                return i;
        }
        return null;        
    }
    public ArrayList<Student> searchByName(String name){
        ArrayList<Student> l=new ArrayList<>();
        int k=0;
        for(Student i:list){
            if(i.getName().indexOf(name)>=0){
                l.add(i);
                k++;
            }
        }
        if(k==0)
            return null;
        else
            return l;
    }
    public void sortByRollno(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {                
                return ((s1.getRollno()).
                        compareTo((s2.getRollno())));                
            }                          
        });
    }
    public void sortByTs(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {                
                return ((s1.getTs()).compareTo((s2.getTs())));                 
            }                          
        });
    }
}
