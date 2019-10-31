
import Bean.NOServer1;
import Bean.ThreadTest;
import DTO.usersDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
public class server {
    public static void main(String[] args) {
        try {
            int port = 10000;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("accept");
            ObjectInputStream userLogin = new ObjectInputStream(clientSocket.getInputStream());
            usersDTO user = (usersDTO) userLogin.readObject();
            System.out.println(user.getUserName() + "connected");
        } catch(SocketException ex){
            Logger.getLogger(NOServer1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(NOServer1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
