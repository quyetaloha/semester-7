/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Answer;
import model.Student;

/**
 *
 * @author Viet Nguyen
 */
public class RegisterImpl extends UnicastRemoteObject implements IRegistration{
    Student s = new Student();
    Answer a = new Answer();
    
    public RegisterImpl() throws RemoteException{
        super();
    }
    
    
    
    @Override
    public Student register(Student s) throws RemoteException{        
        s.setStrExamCode1("Toi La Server");
        s.setStrExamCode2("");
        s.setNumericCode3(20);
        s.setNumericCode4(5);
        int []mang = {1,2,3,4,5,6,7,8,9};
        s.setNumbericExam(mang);
        s.setIsAlreadyRegistration(true);
        
        return s;
    }
    
        
        int bcnn = BCNN(20,5);
        int ucln = UCLN(20,5);
        String str = "Toi La Server";
        
    @Override
    public Answer answer(Answer a) throws RemoteException{
        if(a.getMaxNumericAnswer()==9){
            a.setIsMaxNumericAnswerRiht(true);
        }else a.setIsMaxNumericAnswerRiht(false);
        
        
        if(a.getBcnnNumericAnswer()==bcnn){
            a.setIsBSCNNNumericAnswerRiht(true);
        }else a.setIsBSCNNNumericAnswerRiht(false);
        
        
        
        if(a.getUclnNumericAnswer()==ucln){
            a.setIsUSCLNNumericAnswerRiht(true);
        }else a.setIsUSCLNNumericAnswerRiht(false);
        
        a.setIsAlreadyRegistration(true);
        
        
        String strx = ReverseString(str);
        String reverseString = a.getReverseStringAnswer();
        
        if(reverseString.equals(strx)){
            a.setIsReverseStringAnswerRiht(true);
        }else a.setIsUSCLNNumericAnswerRiht(false);
        
        return a;
    }
    
    public static int UCLN(int a, int b){
       if(b==0) return a;
       return UCLN(b, a%b);
   }
   public static int BCNN(int a, int b){
       return (a*b)/UCLN(a,b);
   }
   public static String ReverseString(String str){
       StringBuilder str1 = new StringBuilder(str);
       String str2 = str1.reverse().toString();
       return str2;
       
       
   }

}
