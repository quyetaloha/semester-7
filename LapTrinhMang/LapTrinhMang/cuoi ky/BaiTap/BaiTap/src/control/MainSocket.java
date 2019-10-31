package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.Student;

public class MainSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.170.44.100", 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            //lam tuong tu nhan va gui du lieu rmi
            Student student = new Student("B15DCCN072", "Luong Van Chinh", "10.170.44.43", 4);
            oos.writeObject(student);

            //Nhan du lieu tu server qua doi tuong student
            Student s = (Student) ois.readObject();
            String str1 = s.getStrExamCode1(), str2 = s.getStrExamCode2();
            int numeric3 = s.getNumericCode3(), numeric4 = s.getNumericCode4();
            int[] numericExam = s.getNumericExam();

            //Thuc hien yeu cau va gui ket qua ve cho server thong qua Answer
            Answer answer = new Answer();
            ThucThi thucThi = new ThucThi();
            answer.setStudent(s);
            answer.setReverseStringAnswer(thucThi.daoXau(str1));
            answer.setNormalizationStringAnswer(thucThi.chuanHoa(str2));
            answer.setBcnnNumericAnswer(thucThi.BSCNN(numeric3, numeric4));
            answer.setUclnNumericAnswer(thucThi.USCLN(numeric3, numeric4));
            oos.writeObject(answer);
            
            //Nhan ket qua cuoi cung cai nay k quan trong
            Answer a = (Answer) ois.readObject();
            if (a.isIsAlreadyRegistration()) {
                System.out.println("Ket qua dung OK");
            };
            
            ois.close();
            oos.close();
            socket.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
