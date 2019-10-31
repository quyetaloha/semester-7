/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DTO.usersDTO;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import orm.Users;

/**
 *
 * @author AdamKyle
 */
public class ThreadTest extends Thread{
    private Socket clientSocket;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    Users user;
    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        try{
            this.setName("server thread test");
            ChatInThread cit = new ChatInThread();
            cit.setSocket(clientSocket);
            cit.setUser(user);
            cit.setNameObject(user.getLastName());
            cit.start();
//            ChatOutThread cot = new ChatOutThread();
//            cot.setSocket(clientSocket);
//            cot.start();
        } catch(Exception ex){
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
