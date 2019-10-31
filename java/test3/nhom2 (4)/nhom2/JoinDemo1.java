
package nhom2;


public class JoinDemo1 {
    public static void main(String[] args) {
        FF12 t1=new FF12("Thread 1");
        FF12 t2=new FF12("Thread 2");
        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            
        }
        t2.start();
    }
}
class FF12 extends Thread{
    public FF12(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){
                
            }
        }
    }
}
