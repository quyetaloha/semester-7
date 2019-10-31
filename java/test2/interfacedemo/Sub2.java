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
public class Sub2 extends AbstractDemo {
     
    public Sub2(String name){
        super(name);
    }
    @Override
    public void m6() {
        System.out.println("M 6");
    }

    @Override
    public void m7() {
        System.out.println("M 7");
    }
    
}
