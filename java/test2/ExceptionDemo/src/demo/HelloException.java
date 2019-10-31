/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author ADMIN
 */
public class HelloException {
    public static void main(String[] args) {
      System.out.println("Two");
     // The division is ok
      int value = 10 / 2;      
      System.out.println("One");
      // divide by zero
      // error encountered in here
      try{
      value = 10 / 0;
      }catch(ArithmeticException e){
          System.out.println(e);
      }
       //this line is not executed
      System.out.println("Let's go!");
  }
    
}
