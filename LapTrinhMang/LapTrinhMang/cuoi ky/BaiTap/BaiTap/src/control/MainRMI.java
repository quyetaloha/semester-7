package control;

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

public class MainRMI {
    public static void main(String[] args) {
        try {
            
            Registry registry=LocateRegistry.getRegistry(1099);
            IRegistration i = (IRegistration) Naming.lookup("Server");
            //gui du lieu de submit
            Student student = new Student("B15DCCN072", "Luong Van Chinh", "10.170.44.43", 4);
            //lay du lieu tra ve qua doi tuong student
            Student s = i.register(student);
            System.out.println(s.toString());
            String str1 = s.getStrExamCode1(),str2 = s.getStrExamCode2();
            int numeric3 = s.getNumericCode3(), numeric4 = s.getNumericCode4();
            int[] numericExam = s.getNumericExam();
            //thuc hien yeu cau bai
            Answer answer = new Answer();
            ThucThi thucThi = new ThucThi();
            answer.setStudent(s);
            answer.setReverseStringAnswer(thucThi.daoXau(str1));
            answer.setNormalizationStringAnswer(thucThi.chuanHoa(str2));
            answer.setBcnnNumericAnswer(thucThi.BSCNN(numeric3, numeric4));
            answer.setUclnNumericAnswer(thucThi.USCLN(numeric3, numeric4));
            //gui di
            Answer a = i.answer(answer);
            //ok xong
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MainRMI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
