/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class ThreadTest extends Thread{
    private Socket clientSocket;

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        System.out.println("thread run"+ clientSocket.getLocalAddress()+" " +clientSocket.getPort());
        ChatInThread cit = new ChatInThread();
        cit.setSocket(clientSocket);
        cit.setNameObject("client");
        cit.start();
        ChatOutThread cot = new ChatOutThread();
        cot.setSocket(clientSocket);
        cot.start();
    //ObjectInputStream ois  = new ObjectInputStream(clientSocket.getInputStream());
        //BufferedReader ois = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
//            while(true){
//                System.out.println("while");
//                System.out.println(dis.readUTF());
//            }
    }
    
}
