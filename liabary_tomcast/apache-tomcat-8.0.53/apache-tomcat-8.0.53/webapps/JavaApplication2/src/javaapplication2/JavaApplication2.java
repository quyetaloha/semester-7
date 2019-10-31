/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Hoang Quyet
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket serversoc = new ServerSocket(4000);
        Socket  clientsoc = serversoc.accept();
        System.out.println("ok");
        while(true){
            System.out.println("dfd");
            ObjectInputStream ois = new ObjectInputStream(clientsoc.getInputStream());
            System.out.println(ois);
            if(ois.toString().equalsIgnoreCase("exit")) break;
            Scanner s = new Scanner(System.in);
            ObjectOutputStream oos =new ObjectOutputStream(clientsoc.getOutputStream());
            oos.writeObject(s);
        }
        return;
//        Socket socket;
//        String host="localhost";
//        String host1="192.168.0.1";
//        socket = new Socket(host, 4000); 
//        System.out.println("connect ok");
    }
    
}
