package nhom2;

import nhom1.*;

public class SynMethod {    
    public static void print(String s){
        String name=Thread.currentThread().getName();
        System.out.println(name+" - "+s);
    }        
    public synchronized void takeaPen(){        
        print("Take a pen");        
        print("be writing");
        try{
            Thread.sleep(2000);            
        }catch(Exception e){
            e.fillInStackTrace();
        }
        print("finish writing!");
    }
                    
    public static void main(String[] agrs){
        final SynMethod bb=new SynMethod();
        Runnable runA = new Runnable(){
          public void run(){
              bb.takeaPen();
          }
        };
        Thread tA = new Thread(runA,"threadA");
        tA.start();
        try{
            Thread.sleep(200);            
        }catch(Exception e){
            e.fillInStackTrace();
        }
        Runnable runB = new Runnable(){
          public void run(){
              bb.takeaPen();
          }
        };
        Thread tB = new Thread(runB,"threadB");
        tB.start();
    }
}
//class runAB implements Runnable{
//    SynMethod bb=new SynMethod();
//        public void run(){
//            bb.takeaPen();
//        }      
//    }