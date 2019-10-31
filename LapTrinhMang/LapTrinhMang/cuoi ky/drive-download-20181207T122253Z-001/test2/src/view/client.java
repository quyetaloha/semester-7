/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Viet Nguyen
 */
public class client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 9999);
            Student s = new Student();
            s.setMaSV("B15DCCN644");
            s.setHovaten("Nguyen Minh Viet");
            s.setGroup(9);
            s.setIp("192.168.1.1");
            
            ObjectInputStream is = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
            os.writeObject(s);
            System.out.println("Ghi object len server");
            System.out.println(s.toString());
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
