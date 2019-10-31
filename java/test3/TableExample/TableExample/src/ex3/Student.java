
package ex3;

import java.text.DecimalFormat;

public class Student {
    private String rollno;
    private String name;
    private int age;
    private String sex;
    private double ws,pe,fe;
    private String ts;

    public Student() {
    }

    public Student(String rollno, String name, 
            int age, String sex, double ws, 
            double pe, double fe) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.ws = ws;
        this.pe = pe;
        this.fe = fe;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getWs() {
        return ws;
    }

    public void setWs(double ws) {
        this.ws = ws;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public String getTs() {
        return ts;
    }

    public void setTs() {       
        DecimalFormat f=new DecimalFormat("#.##");
        this.ts = f.format(0.3*getWs()+0.3*getPe()+0.4*getFe());
    }
    Object[] toObject1(){
        return new Object[]{
        rollno,name,age,sex,ws,pe,fe
        };
    }
    Object[] toObject2(){
        return new Object[]{
        rollno,name,age,sex,ts
        };
    }
}
