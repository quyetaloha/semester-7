/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacedemo;

/**
 *
 * @author ADMIN
 */
public class Sub extends Person
        implements Demo1, Demo{
    public Sub(String name){
        super(name);
    }
    @Override
    public void m1() {
        System.out.println("M 1");
    }

    @Override
    public int m2() {
        return 20;
    }
    public void m3(){
        System.out.println("M 3");
    }
    public void m4(){
        System.out.println("M 4");
    }
    
}
