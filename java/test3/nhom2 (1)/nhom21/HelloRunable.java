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
public class HelloRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("Bat dau Hello runable");
        int index=1;
        for (int i = 0; i < 10; i++) {
            System.out.println("trong hello runable "+index++);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e);
            }
            
        }
        System.out.println("Ket thuc Hello runable");
    }
    
}
