/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.IRegistration;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.Student;

/**
 *
 * @author Viet Nguyen
 */
public class Client implements Serializable{
    public static void main(String[] args) {
        
            try {
                Registry reg = LocateRegistry.getRegistry("localhost", 1099);
                IRegistration ir = (IRegistration) Naming.lookup("Server");
                Student s = new Student();
                s.setMaSV("B15DCCN644");
                s.setHovaten("Nguyen Minh Viet");
                s.setGroup(9);
                s.setIP("192.168.1.1");
                Student b = ir.register(s);
                System.out.println(b.toString());

                int [] mang = b.getNumbericExam();
                int max = mang[0];
                for(int i=1;i<mang.length;i++){
                   if(max<mang[i])
                       max = mang[i+1];
                    }

                StringBuilder str = new StringBuilder(b.getStrExamCode1());
                String reverseStr = str.reverse().toString();
                
                int x = b.getNumericCode3();
                int y = b.getNumericCode4();
                
                

                

                

                Answer a = new Answer();

                a.setStudent(b);
                a.setMaxNumericAnswer(max);
                a.setReverseStringAnswer(reverseStr);
                int ucln = UCLN(x,y);
                int bcnn = BCNN(x,y);
                a.setUclnNumericAnswer(ucln);
                a.setBcnnNumericAnswer(bcnn);

                Answer a1 = ir.answer(a);
                System.out.println(a1.toString());

                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
   public static int UCLN(int a, int b){
       if(b==0) return a;
       return UCLN(b, a%b);
   }
   public static int BCNN(int a, int b){
       return (a*b)/UCLN(a,b);
   }

            
}

