
import Bean.ChatInThread;
import Bean.ChatOutThread;
import Bean.Client;
import DTO.usersDTO;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AdamKyle
 */
public class client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 10000);
            System.out.println("connected");
            usersDTO user = new usersDTO();
            user.setUserName("manh");
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(user);
            oos.close();
            System.out.println("sent");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
