/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

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
            String maSV = "B15DCCN644";
            String hovaten = "Nguyen Minh Viet";
            String ip = "192.168.1.1";
            String mes = "Toi la client";
            Student s = new Student(maSV, hovaten, ip, mes);
            ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(client.getInputStream());
            os.writeObject(s);
            
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
