/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import model.Answer;
import model.ExamCode;
import model.Student;
import view.ClientList;

/**
 *
 * @author ntkhanh
 */
public class Registration extends UnicastRemoteObject 
        implements IRegistration, ActionListener {

    ArrayList<Student> studentLists;
    ArrayList<Answer> answerLists;
    ClientList view;

    public Registration(ClientList view) throws RemoteException {
        this.studentLists = new ArrayList<>();
        this.answerLists = new ArrayList<>();
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("Server", this);

        this.view = view;
        this.view.setVisible(true);
    }

    @Override
    synchronized public Student register(Student s) throws RemoteException {
        Iterator<Student> it = this.studentLists.iterator();
        if(s.getMaSV() == null)
            return null;
        while (it.hasNext()) {
            Student next = it.next();
            if (s.getMaSV().equalsIgnoreCase(next.getMaSV()) && s.getMaSV() != null) {
                return next;
            }
        }
        //dao xau
        s.setStrExamCode1(this.randomAlphaString(new Random().nextInt(10) + 10));
        //chua  hoa xau
        s.setStrExamCode2(this.randomAlphaSpaceString(new Random().nextInt(10) + 10));
        //so thu nhat
        s.setNumericCode3(new Random().nextInt(10) + 10);
        //so thu 2
        s.setNumericCode4(new Random().nextInt(10) + 10);
        //phan tu lon nhat cua mang
        s.setNumericExam(new int[]{new Random().nextInt(100), new Random().nextInt(100),
             new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100)});
        s.setIsAlreadyRegistration(true);
        if (s.getMaSV() != null) {
            this.studentLists.add(s);
            this.view.addNewRow(s);
        }
        return s;
    }

    @Override
    synchronized public Answer answer(Answer answer) throws RemoteException {

        answer.setIsMaxNumericAnswerRight(CheckAnswer.checkMaxNumericAnswer(answer.getStudent().
                getNumericExam(), answer.getMaxNumericAnswer()));
        
        //answer.checkMaxNumericAnswer();
        answer.setIsReverseStringAnswerRight(CheckAnswer.reverse(answer.getStudent().getStrExamCode1()).
                equals(answer.getStringAnswer()));
        //answer.checkReverseStringAnswer();
        answer.setIsBSCNNNumericAnswerRight(CheckAnswer.BSCNN(answer.getStudent().getNumericCode3(), 
                answer.getStudent().getNumericCode4())==answer.getBcnnNumericAnswer());
        //answer.checkBSNNNumericAnswer();
        //answer.checkNormalizationStringAnswer();
        answer.setIsNormalizationStringAnswerRight(CheckAnswer.chuanHoa(answer.getStudent().getStrExamCode2()).
                equals(answer.getNormalizationStringAnswer()));
        answer.setIsUSCLNNumericAnswerRight(CheckAnswer.USCLN(answer.getStudent().getNumericCode3(), 
                answer.getStudent().getNumericCode4())==answer.getUclnNumericAnswer());
        //answer.checkUCLNNumericAnswer();

        Iterator<Answer> it = this.answerLists.iterator();
        int index = 0;
        while (it.hasNext()) {
            Answer next = it.next();
            if (next.getStudent().getMaSV().equalsIgnoreCase(answer.getStudent().getMaSV())) {
                this.answerLists.set(index, answer);
                this.view.updateAnswerView(answer);
                return answer;
            }
            index++;
        }

        this.view.updateAnswerView(answer);
        this.answerLists.add(answer);
        return answer;
    }

    private String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ExamCode.ALPHA_STRING.length());
            builder.append(ExamCode.ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

    

   

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String randomAlphaSpaceString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            for (int i = 0; i < new Random().nextInt(7) + 1; i++) {
                int character = (int) (Math.random() * ExamCode.ALPHA_STRING.length());
                builder.append(ExamCode.ALPHA_STRING.charAt(character));
            }
            if (count != 0) {
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    @Override
    public int layport1(Student s) throws RemoteException {
        return 10001;
    }

    @Override
    public int layport2(Student s) throws RemoteException {
        return 10002;
    }
    
  

}
