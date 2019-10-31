/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Viet Nguyen
 */
public class server {
    public static void main(String[] args) {
         try {
            
            System.out.println("Start server");
            ServerSocket server = new ServerSocket(9999);
            Socket client = server.accept();
            System.out.println("Server Running...");
            
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
             System.out.println("a");
            Student student = (Student) ois.readObject();
             System.out.println("b");
            if(student!=null){
                System.out.println("Lay thoong tin client \n");
                System.out.println(student.toString());
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
   
