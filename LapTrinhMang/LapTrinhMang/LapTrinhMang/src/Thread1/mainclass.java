/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread1;

/**
 *
 * @author lamvi
 */
public class mainclass {
    public static void main(String[] args) {
        helloClass obj1 = new helloClass();
        Thread a = new Thread(obj1);
        a.start();
        for(int i=1;i<1000;i++){
            System.out.println("main "+i);
        }
        
    }
}
