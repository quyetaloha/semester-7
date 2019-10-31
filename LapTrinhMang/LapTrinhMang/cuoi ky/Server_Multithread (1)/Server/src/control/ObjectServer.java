/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.Student;

/**
 *
 * @author ntkhanh
 */
public class ObjectServer extends Thread {

    Server mainServerThread;
    // Khai bao server socket, luong vao-ra, va doi tuong socket
    ServerSocket myServer = null;
    Student input;

    public ObjectServer(ServerSocket ss) {
        this.myServer = ss;
    }

    public void updateView(Student student) {
        this.mainServerThread.updateView(student);

    }

    synchronized public void updateAnswerList(Answer answer) {
        this.mainServerThread.updateAnswerList(answer);

    }

    public Answer getAnswer(Student student) {
        return this.mainServerThread.getAnswer(student);

    }

    public void addStudent(Student s) {
        this.mainServerThread.addStudent(s);

    }

    public ObjectServer(Server main) {
        this.mainServerThread = main;

    }

    public void listening() throws IOException {
        // Xu li du lieu nhan duoc va tra ve
        while (true) {
            try {
                Socket clientSocket = myServer.accept();

                ObjectClientThread clientThread = new ObjectClientThread(clientSocket, this);
                clientThread.start();

            } catch (SocketException so) {
                System.out.println(" ------- Loi client ------- ");
                so.printStackTrace();
            }
        }
    }

    // Mo mot server socket
    public void openServer() {
        try {
            myServer = new ServerSocket(10001);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        this.openServer();
        try {
            this.listening();
        } catch (IOException ex) {
            Logger.getLogger(ObjectServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
