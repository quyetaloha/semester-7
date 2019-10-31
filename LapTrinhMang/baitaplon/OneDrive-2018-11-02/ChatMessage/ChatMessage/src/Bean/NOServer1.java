/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DTO.usersDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class NOServer1 {
    public NOServer1() {
        
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        List<usersDTO> listUsersLogin= new ArrayList<usersDTO>();
        try {
            int port = 10000;
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                usersDTO userLogin =(usersDTO) ois.readObject();
                userLogin.setClientSocket(clientSocket);
                listUsersLogin.add(userLogin);
                System.out.println(userLogin.getClientSocket().getInetAddress()+":"+userLogin.getClientSocket().getPort()+" "+userLogin.getUserName() + " connected");
                ThreadTest a = new ThreadTest();
                a.setClientSocket(clientSocket);
                a.run();
//                 ThreadSocket a = new ThreadSocket();
//                 a.setClientSocket(clientSocket);
//                 a.run();
            }
        } catch (IOException ex) {
            Logger.getLogger(NOServer1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void white() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
