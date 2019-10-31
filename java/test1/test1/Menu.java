
package test1;

import java.util.Scanner;

public class Menu {
       public static void main(String[] args) {
          Tool t=new Tool();
          double a=1,b=1,c=1;
           while(true){
               System.out.println("1. input a,b,c");
               System.out.println("2. Quadratic Equation Solver");
               System.out.println("3. sin(a)");
               System.out.println("4. Case 4");
               System.out.println("0. Exit");
               System.out.print("Your choice (0=>4):");
               int cc;
               Scanner in=new Scanner(System.in);
               cc=in.nextInt();
               switch(cc){
                   case 0: System.out.println("Bye!!!!");
                          System.exit(0);
                          break;
                   case 1:System.out.print("a=");
                          a=in.nextDouble();
                          System.out.print("b=");
                          b=in.nextDouble();
                          System.out.print("c=");
                          c=in.nextDouble();
                          break;
                   case 2: t.sovleEquation(a, b, c);
                          break;
                   case 3:System.out.println("Sin("+Math.PI/2+")= "+t.calculatorSin(Math.PI/2)); 
                          System.out.println("Sin("+a+")="+t.calculatorSin(a));
                          break;
                   case 4: System.out.println("case 4");
                          break;
                   default:System.out.println("have to select (0-4)");
                           break;
               }
           }
    }
}
