/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import model.Student;
import view.ClientList;

/**
 *
 * @author ntkhanh
 */
public class Server {

    // Khai bao server socket, luong vao-ra, va doi tuong socket
    ServerSocket myServer = null;
    Student input;

    ClientList view;
    ArrayList<Student> svList;

    public Server(ClientList v) {
        this.svList = new ArrayList<Student>();
        this.view = v;
        this.view.setVisible(true);
    }

    // Mo mot server socket
    public void openServer() {
        try {
            myServer = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addStudent(Student s){
        if (this.svList == null) {
            this.svList = new ArrayList<Student>();
        }
        this.svList.add(s);
         view.addNewRow(s);
    }
    // Chap nhan ket noi va xu li du lieu
    public void listening() throws IOException {
        //try {
        // Xu li du lieu nhan duoc va tra ve
        while (true) {
            try {
                Socket clientSocket = myServer.accept();

                ClientThread clientThread = new ClientThread(clientSocket,this);
                clientThread.start();
                
            } catch (SocketException so) {
                System.out.println(" ------- Loi client ------- ");
                so.printStackTrace();
            } 
        }
    }

    public void close() {
        try {
            myServer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
