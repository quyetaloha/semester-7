/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;

/**
 *
 * @author Hoang Quyet
 */
public class server {
    public static void main(String[] args) throws ClassNotFoundException {
        int port=9999;
        try{
            ServerSocket serverSocket=new ServerSocket(port);
            while(true){System.out.println("aa");Socket clientSocket = serverSocket.accept();
//                DataOutputStream os=new DataOutputStream(clientSocket.getOutputStream());
  //              DataInputStream in= new DataInputStream(clientSocket.getInputStream());
                
                    
                    //                DataOutputStream os=new DataOutputStream(clientSocket.getOutputStream());
//                DataInputStream in= new DataInputStream(clientSocket.getInputStream());
 //                   ObjectOutputStream os=new ObjectOutputStream(clientSocket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
//                    System.out.println("aa");
                    Student s=(Student) in.readObject();
//
//                    System.out.println(s.getTen());
                    System.out.println(s.getTen());
                    in.close();clientSocket.close();
                
                    serverSocket.close();
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
}
