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
import model.Student;

/**
 *
 * @author ntkhanh
 */
public class NumericClientThread_06112018 extends Thread {

    Socket clientSocket;
    NumericServer serverControl;
    DataInputStream is;
    DataOutputStream os;
    ObjectOutputStream ooS;

    int numOperator = 0;
    int operatorCode = -1;
    int insertNumeric = 0;

    String operatorType = null;

    int[] intAnswers = null;
    long[] longAnswers = null;

    Answer answer = null;
    Student student = null;

    int intAnswer = 0;
    long longAnswer = 0;

    public NumericClientThread_06112018(Socket s, NumericServer serverControl) {
        this.clientSocket = s;
        this.serverControl = serverControl;

        this.answer = new Answer();

    }

    private void initiateStudentAnswer() throws IOException {
        this.student = new Student(is.readUTF(), is.readUTF(),
                this.clientSocket.getInetAddress().getHostAddress(), is.readInt());

        this.answer = this.serverControl.getAnswer(student);

        if (this.answer == null) {
            System.out.println("Answer is null");
            this.answer = new Answer(student);
        } else {
            this.answer.setStudent(student);
        }
    }

    private void checkResponse(int code) throws IOException {

        //get response
        switch (code) {//1 USCLN, 2 BSCNN, 3 sx mang
            case 1://USCLN
                //update
                int uscln = is.readInt();
                if (this.BSCNN(intAnswers[0], intAnswers[1]) == uscln) {
                    System.out.println("Ket qua: " + uscln + " Dung");
                    this.answer.updateAnswer(3, uscln, true);
                } else {
                    System.err.println("Ket qua: " + uscln + " Sai");
                    this.answer.updateAnswer(3, uscln, false);
                }
                break;
            case 2: //BSCNN
                //update
                int bscnn = is.readInt();
                if (this.USCLN(intAnswers[0], intAnswers[1]) == bscnn) {
                    System.out.println("Ket qua: " + bscnn + " Dung");
                    this.answer.updateAnswer(4, bscnn, true);
                } else {
                    System.err.println("Ket qua: " + bscnn + " Sai");
                    this.answer.updateAnswer(4, bscnn, false);
                }
                break;
            case 3: //Sort array
                boolean isRight = true;
                this.sortASC(intAnswers);
                int results[] = this.insert(intAnswers, insertNumeric);

                if (this.operatorCode == 1) //tang dan
                {

                    for (int i = 0; i < results.length; i++) {
                        if (is.readInt() != results[i]) {
                            isRight = false;
                            break;
                        }

                    }
                } else {//giam dan
                    for (int i = results.length - 1; i >= 0; i--) {
                        if (is.readInt() != results[i]) {
                            isRight = false;
                            break;
                        }

                    }

                }
                //update
                if (isRight) {
                    this.answer.updateAnswer(2, -1, true);
                } else {
                    this.answer.updateAnswer(2, -1, false);
                }

                break;
        }
        //update view
        this.serverControl.updateAnswerList(answer);
        this.serverControl.updateView(student);
    }

    private void sendQuestion(int numOperator) throws IOException {

        //send operator
        this.intAnswers = new int[numOperator];
        for (int i = 0; i < numOperator; i++) {
            int tmp = new Random().nextInt(100) + 100;
            os.writeInt(tmp);
            this.intAnswers[i] = tmp;
        }
    }

    @Override
    public void run() {
        try {
            super.run();

            is = new DataInputStream(clientSocket.getInputStream());
            os = new DataOutputStream(clientSocket.getOutputStream());
            ooS = new ObjectOutputStream(clientSocket.getOutputStream());

            initiateStudentAnswer();

            this.numOperator = new Random().nextInt(10) + 10;
            //gửi mảng 
            os.writeInt(this.numOperator);
            sendQuestion(this.numOperator);
            //số nguyên để chèn
            this.insertNumeric = new Random().nextInt(100) + 100;
            os.writeInt(this.insertNumeric);

            //gui operator code: 1 tang dan ; 2 giam dan
            this.operatorCode = new Random().nextInt(2) + 1;
            os.writeInt(this.operatorCode);

            checkResponse(3);

            sendQuestion(2);
            checkResponse(operatorCode);

            sendQuestion(2);
            checkResponse((operatorCode == 1 ? 2 : 1));

            //return answer
            ooS.writeObject(this.answer);

        } catch (SocketException so) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            so.printStackTrace();
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } finally {
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(NumericClientThread_06112018.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Tìm ước số chung lớn nhất (USCLN)
     *
     * @param a: số nguyên dương
     * @param b: số nguyên dương
     * @return USCLN của a và b
     */
    private int USCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return USCLN(b, a % b);
    }

    /**
     * Tìm ước số chung lớn nhất (USCLN)
     *
     * @param a: số nguyên dương
     * @param b: số nguyên dương
     * @return USCLN của a và b
     */
    private long longUSCLN(long a, long b) {
        if (b == 0) {
            return a;
        }
        return longUSCLN(b, a % b);
    }

    /**
     * Tìm bội số chung nhỏ nhất (BSCNN)
     *
     * @param a: số nguyên dương
     * @param b: số nguyên dương
     * @return BSCNN của a và b
     */
    private int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }

    /**
     * Tìm bội số chung nhỏ nhất (BSCNN)
     *
     * @param a: số nguyên dương
     * @param b: số nguyên dương
     * @return BSCNN của a và b
     */
    private long longBSCNN(long a, long b) {
        return (a * b) / longBSCNN(a, b);
    }

    /**
     * sắp xếp mảng số nguyên theo thứ tự tăng dần
     *
     * @param arr: mảng các số nguyên
     */
    private void sortASC(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * sắp xếp mảng số nguyên theo thứ tự tăng dần
     *
     * @param arr: mảng các số nguyên
     */
    private void sortLongASC(long[] arr) {
        long temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * sắp xếp mảng số nguyên theo thứ tự tăng dần
     *
     * @param arr: mảng các số nguyên
     */
    private void sortDES(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * sắp xếp mảng số nguyên theo thứ tự tăng dần
     *
     * @param arr: mảng các số nguyên
     */
    private void sortLongDES(long[] arr) {
        long temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * sắp xếp mảng số nguyên theo thứ tự tăng dần
     *
     * @param arr: mảng các số nguyên
     */
    private boolean compare(Object[] arr, Object[] arr1) {

        if (arr == null || arr1 == null || arr.length != arr1.length) {
            return false;
        } else {
            for (int i = 0; i < arr.length; i++) {
                Object o1 = arr[i];
                Object o2 = arr1[i];
                if (o1 != o2) {
                    return false;
                }

            }
            return true;
        }

    }

    /**
     * chèn phần tử vào mảng số nguyên tăng dần sau khi chèn mảng vẫn duy trì
     * thứ tự tăng dần
     *
     * @param arr: mảng số nguyên tăng dần
     * @param k: phần tử chèn vào mảng arr
     */
    private int[] insert(int[] arr, int k) {
        int arrIndex = arr.length - 1;
        int tempIndex = arr.length;
        int[] tempArr = new int[tempIndex + 1];
        boolean inserted = false;

        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && arr[arrIndex] > k) {
                tempArr[i] = arr[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = k;
                    inserted = true;
                } else {
                    tempArr[i] = arr[arrIndex--];
                }
            }
        }
        return tempArr;
    }

}
