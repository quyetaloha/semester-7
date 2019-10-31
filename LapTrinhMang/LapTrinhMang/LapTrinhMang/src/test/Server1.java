/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class Server1 {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            int port = 10000;
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("connected");
                ThreadTest a = new ThreadTest();
                a.setClientSocket(clientSocket);
                a.run();
//                 ThreadSocket a = new ThreadSocket();
//                 a.setClientSocket(clientSocket);
//                 a.run();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void white() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
