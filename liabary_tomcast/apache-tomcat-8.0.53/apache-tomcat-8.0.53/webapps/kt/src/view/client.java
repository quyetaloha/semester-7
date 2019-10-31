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
import model.SinhVien;

/**
 *
 * @author Hoang Quyet
 */
public class client {
    public static void main(String[] args) {
        try {
            int port=9999;
            Socket clientSocket = new Socket("localhost", port);
            SinhVien sv = new SinhVien();
            sv.setTen("quyet");
            sv.setMasv(1234);
            sv.setdTA(1f);
            sv.setdTin(1.2f);
            sv.setdToan(5f);
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(sv);
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            try {
                boolean result = (boolean) ois.readObject();
                if(result){
                    System.out.println("pass");
                }else{
                    System.out.println("no pass");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
