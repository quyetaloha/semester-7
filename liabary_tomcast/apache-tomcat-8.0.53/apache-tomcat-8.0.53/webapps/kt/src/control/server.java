/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SinhVien;

/**
 *
 * @author Hoang Quyet
 */
public class server {
    public static void main(String[] args) {
        
            try {
                int port =9999;
                ServerSocket server = new ServerSocket(port);
                while(true){
                Socket client = server.accept();
                
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
                
                    
                    SinhVien sv = (SinhVien) ois.readObject();
                    float dtb = (sv.getdTA()+ sv.getdTin()+ sv.getdToan())*1f/3;
                    boolean result;
                    if(dtb>5){
                        result = true;
                    } else{
                       result = false;
                    }
                    
                    oos.writeObject(result);
                    System.out.println("end server");
                }
            } catch (IOException ex) {
                Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
}
