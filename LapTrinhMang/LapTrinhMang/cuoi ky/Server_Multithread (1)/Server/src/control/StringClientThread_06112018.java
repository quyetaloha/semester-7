/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.ExamCode;
import model.StringExam;
import model.Student;

/**
 *
 * @author ntkhanh
 */
public class StringClientThread_06112018 extends Thread {

    Socket clientSocket;
    StringServer serverControl;
    DataInputStream is;
    DataOutputStream os;
    ObjectOutputStream objectStream;
    StringExam stringExam;

    Answer answer = null;
    Student student = null;

    public StringClientThread_06112018(Socket s, StringServer serverControl) {
        this.clientSocket = s;
        this.serverControl = serverControl;

        this.answer = new Answer();

        stringExam = new StringExam();
        //stringExam.stringGenerate(new Random().nextInt(4) + 1);

        //stringExam.stringGenerate(new Random().nextInt(2) + 1);
    }

    private void initiateStudentAnswer() throws IOException {
        //get Student information

        this.student = new Student(is.readUTF(), is.readUTF(), this.clientSocket.getInetAddress().getHostAddress(), is.readInt());

        this.answer = this.serverControl.getAnswer(student);

        if (this.answer == null) {
            System.out.println("Answer is null");
            this.answer = new Answer(student);
        } else {
            this.answer.setStudent(student);
        }
    }

    private void checkResponse() throws IOException {
        //get response
        switch (this.stringExam.getCode()) {
            case ExamCode.NUMCHAROFSTRING:
                this.stringExam.setNumericAnswer(is.readInt());
                System.out.println("Ket qua nhan duoc la :" + this.stringExam.getNumericAnswer());
                System.out.println("Ket qua dung  la :" + this.stringExam.getStringOrg().length());
                this.answer.updateAnswer(0, this.stringExam.getNumericAnswer(),
                        this.stringExam.isRightAnswer());

                break;
            case ExamCode.REVERSESTRING:
                this.stringExam.setStringAnswer(is.readUTF());
                System.out.println("Ket qua nhan duoc la :" + this.stringExam.getStringAnswer());
                System.out.println("xau goc la :" + this.stringExam.getStringOrg());
                System.out.println("Dap an: " + this.stringExam.isRightAnswer());
                this.answer.updateAnswer(1, this.stringExam.getStringAnswer(),
                        this.stringExam.isRightAnswer());

                break;
            case ExamCode.UNIQUECHARACTER:
                this.stringExam.setNumericAnswer(is.readInt());
                this.stringExam.setStringAnswer(is.readUTF());
                System.out.println("So ky tu duy nhat nhan duoc la :" + this.stringExam.getNumericAnswer());
                System.out.println("Xau moi là :" + this.stringExam.getStringAnswer());
                System.out.println("xau goc la :" + this.stringExam.getStringOrg());
                this.answer.updateAnswer(0, this.stringExam.getStringAnswer(),
                        this.stringExam.isRightAnswer());
                System.out.println(this.stringExam.getNumericAnswer());
                break;

            case ExamCode.UPPERLOWER:
                this.stringExam.setStringAnswer(is.readUTF());
                System.out.println(this.stringExam.getStringAnswer());
                break;
            case ExamCode.STRING2NUMERIC:
                this.stringExam.setNumericAnswer(is.readInt());
                System.out.println(this.stringExam.getNumericAnswer());
                break;
            case ExamCode.NORMALIZATION:
                this.stringExam.setStringAnswer(is.readUTF());
                System.out.println("Xau chuan hoa la :" + this.stringExam.getStringAnswer());
                System.out.println("xau goc la :" + this.stringExam.getStringOrg());
                this.answer.updateAnswer(0, this.stringExam.getStringAnswer(),
                        this.stringExam.isRightAnswer());
                break;
            case ExamCode.REVERSEWORDINSTRING:
                this.stringExam.setNumericAnswer(is.readInt());
                this.stringExam.setStringAnswer(is.readUTF());
                
                System.out.println("xau goc la :" + this.stringExam.getStringOrg());
                System.out.println("Xau có từ đảo ngược :" + this.stringExam.getStringAnswer());
                System.out.println("Số từ là :" + this.stringExam.getNumericAnswer());
                
                this.answer.updateAnswer(0, this.stringExam.getStringAnswer(),
                        this.stringExam.isRightAnswer());
                
                break;
        }
    }

    @Override
    public void run() {
        try {
            super.run();

            is = new DataInputStream(clientSocket.getInputStream());
            os = new DataOutputStream(clientSocket.getOutputStream());
            objectStream = new ObjectOutputStream(clientSocket.getOutputStream());

            initiateStudentAnswer();

            int code = (Integer.valueOf(this.student.getMaSV().charAt(this.student.getMaSV().length() - 1))
                    + Integer.valueOf(this.student.getMaSV().charAt(this.student.getMaSV().length() - 2))
                    + Integer.valueOf(this.student.getMaSV().charAt(this.student.getMaSV().length() - 2))) % 2;

            os.writeInt(code);

            if (code == 0) {
                //Code 1: Chuan hoa xau
                stringExam.stringGenerate(ExamCode.REVERSEWORDINSTRING);
                os.writeUTF(this.stringExam.getStringOrg());
                this.checkResponse();

                //Code2: counting number of sub-string in string
                StringBuilder subStringBuilder = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    int character = (int) (Math.random() * ExamCode.ALPHA_STRING.length());
                    subStringBuilder.append(ExamCode.ALPHA_STRING.charAt(character));
                }
                System.out.println("Sub-String: " + subStringBuilder.toString());
                

                StringBuilder longStringBuilder = new StringBuilder();
                for (int i = 0; i < new Random().nextInt(10) + 10; i++) {
                    int character = (int) (Math.random() * ExamCode.ALPHA_STRING.length());
                    longStringBuilder.append(subStringBuilder.toString());
                    longStringBuilder.append(ExamCode.ALPHA_STRING.charAt(character));
                }
                System.out.println("Long String: " + longStringBuilder.toString());
               
                os.writeUTF(longStringBuilder.toString());
                os.writeUTF(subStringBuilder.toString());
                
                //get counting answer
                int countRespond = is.readInt();
                this.answer.updateAnswer(1, countRespond,
                        countRespond == this.stringExam.countSubstring(subStringBuilder.toString(), longStringBuilder.toString()));

            } else {

                //Code2: counting number of sub-string in string
                StringBuilder subStringBuilder = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    int character = (int) (Math.random() * ExamCode.ALPHA_STRING.length());
                    subStringBuilder.append(ExamCode.ALPHA_STRING.charAt(character));
                }
                System.out.println("Sub-String: " + subStringBuilder.toString());
                

                StringBuilder longStringBuilder = new StringBuilder();
                for (int i = 0; i < new Random().nextInt(10) + 10; i++) {
                    int character = (int) (Math.random() * ExamCode.ALPHA_STRING.length());
                    longStringBuilder.append(subStringBuilder.toString());
                    longStringBuilder.append(ExamCode.ALPHA_STRING.charAt(character));
                }
                System.out.println("Long String: " + longStringBuilder.toString());
               
                os.writeUTF(longStringBuilder.toString());
                os.writeUTF(subStringBuilder.toString());
                
                //get counting answer
                int countRespond = is.readInt();
                this.answer.updateAnswer(1, countRespond,
                        countRespond == this.stringExam.countSubstring(subStringBuilder.toString(), longStringBuilder.toString()));

                //Code 1: calculate the number of special character
                stringExam.stringGenerate(ExamCode.REVERSEWORDINSTRING);
                os.writeUTF(this.stringExam.getStringOrg());
                this.checkResponse();
            }

            //update view
            this.serverControl.updateAnswerList(answer);
            this.serverControl.updateView(student);

            //return answer
            objectStream.writeObject(this.answer);
        } catch (SocketException so) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            so.printStackTrace();
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException e) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            e.printStackTrace();
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e2) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            e2.printStackTrace();
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } finally {
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
