/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;

/**
 *
 * @author Hoang Quyet
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket client=new Socket("192.168.79.103", 9999);
  //          DataOutputStream os=new DataOutputStream(client.getOutputStream());
            DataInputStream in= new DataInputStream(client.getInputStream());
                ObjectOutputStream os=new ObjectOutputStream(client.getOutputStream());
  //               ObjectInputStream in = new ObjectInputStream(client.getInputStream());
           
            Student st=new Student("B15DCCN446", "Hoang Xuan Quyet", "D15DCCN06");
            os.writeObject(st);
//            os.writeUTF("huhu");
            System.out.println("successfully");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
