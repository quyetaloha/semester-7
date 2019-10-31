
package nhom2;


public class ExDemo {
    public static void main(String[] args) {
        NoneDemo t1=new NoneDemo();
        DeamonDemo t2=new DeamonDemo();
        t1.start();
        t2.setDaemon(true);
        t2.start();
        
    }
}
class NoneDemo extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("None: "+i);
            try{
                Thread.sleep(400);
            }catch(InterruptedException e){
                
            }
        }
    }
}
class DeamonDemo extends Thread{
    public void run(){
        int i=0;
        while(true) {
            System.out.println("Deamon: "+(i++));
            try{
                Thread.sleep(400);
            }catch(InterruptedException e){
                
            }
        }
    }
}