
package w4;


public class Employee {
    //Code,name,sex,salary,bonus,income
    private String code;
    private String name;
    private boolean sex;
    private double salary;
    private double bonus;
    private double income;

    public Employee() {
    }

    public Employee(String code, String name, boolean sex, 
            double salary, double bonus) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.bonus = bonus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getIncome() {
        return salary+bonus;
    }

    
    public Object[] toObject(){
        return new Object[]{
          code,name,sex,salary,bonus,(salary+bonus)  
        };
    }    
}
