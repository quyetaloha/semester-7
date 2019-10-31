package nhom2.sum;



import java.util.Vector;


public class OutputThread extends Thread {
    Vector<Integer> v;
    public OutputThread(Vector<Integer> v){
        this.v=v;
    }
    public void run(){
        int x,y,z;
        while(true){
          synchronized(this){
           try{
              wait();
            x=v.remove(0);
            if(x==0)
                break;
            y=v.remove(0);
            z=x+y;
            System.out.println("Result: "+x+"+"+y+"="+z);
           }catch(InterruptedException e){
               System.out.println(e);
           }
        }
        }
    }
}
