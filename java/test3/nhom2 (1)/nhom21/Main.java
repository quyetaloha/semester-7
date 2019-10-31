/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom2;

/**
 *
 * @author ADMIN
 */
public class Main {
     public static void main(String[] args) {
         System.out.println("bat dau MAIN");
         for (int i = 0; i < 5; i++) {
             System.out.println("tron Main");
             try{
                 Thread.sleep(1000);
             }catch(InterruptedException e){
                 System.out.println(e);
             }
         }
         HelloThread t=new HelloThread();
         t.start();
         //implement Runable
         Thread r=new Thread(new HelloRunable());
         r.start();
         System.out.println("ket thuc Main");
    }
    
}
