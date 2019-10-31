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
public abstract class AbstractDemo {
    private int x;
    private String name;
    public AbstractDemo(String name){
        this.name=name;
    }
    public int getX(){
        return x;        
    }
    public void setX(int x){
        this.x=x;        
    }
    public abstract void m6();
    public abstract void m7();
}
