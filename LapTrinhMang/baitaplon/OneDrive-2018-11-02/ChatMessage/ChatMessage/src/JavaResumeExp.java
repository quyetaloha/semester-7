
import java.util.Scanner;

public class JavaResumeExp extends Thread  
{    
    public void run()  
    {    while(true){
        System.out.println("sfasjdhfbasdfdsfasdf"); 
        this.suspend();
    } 
    }    
    public static void main(String args[])  
    {        
        JavaResumeExp t2=new JavaResumeExp ();    
        t2.start();  
        while(true){
            String a = new Scanner(System.in).next();
            if(a.equalsIgnoreCase("e")){
                t2.resume();
            }
        }
    }    
}  