
package test1;


public class Tool {
   public void sovleEquation(double a, double b, double c){
       String ms="";
       if(a==0){
           ms="X="+Double.toString(-c/b);    
       }
       else{
           double dt=b*b-4*a*c;
           if(dt<0)
               ms="imaginary";
           else if(dt==0)
               ms="x1=x2="+Double.toString(-b/(2*a));
           else{
               ms="x1 = "+Double.toString(((-b+Math.sqrt(dt))/(2*a)))+
                       " x2="+ Double.toString(((-b-Math.sqrt(dt))/(2*a)));
           }
           
       }
       System.out.println(ms);
           
   }
   public double calculatorSin(double a){
       double t=a;
       int i=2;
       double gt=(a*a*a)/(2*3);
       int d=-1;
       while(gt>0.00000001){
           t += d*gt;
           d=-d;
           gt *=((a*a)/((2*i)*(2*i+1)));
           i++;
       }
       
       return t;
   }    
}
