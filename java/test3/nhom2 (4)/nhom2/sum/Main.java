package nhom2.sum;



import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();
        OutputThread t1=new OutputThread(v);
        InputThread t2=new InputThread(v, t1);
        t2.start();
        t1.start();
        
    }
    
}
