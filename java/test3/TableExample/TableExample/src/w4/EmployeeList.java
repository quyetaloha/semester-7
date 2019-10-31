
package w4;

import java.util.ArrayList;


public class EmployeeList {
    private ArrayList<Employee> list;
    public EmployeeList(){
        list=new ArrayList<Employee>();
    } 
    public boolean add(Employee e){
        return list.add(e);
    }
    public void delete(int index){
        list.remove(index);
    }
    public ArrayList<Employee> getAllEmployee(){
        return list;
    }
    public ArrayList<Employee> searchByCode(String code){
        ArrayList<Employee> t=new ArrayList<>();
        for(Employee i:list)
            if(i.getCode().indexOf(code)>=0)
                t.add(i);
        return t;
    }
    
}
