/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class ChatInThread extends Thread{
    private Socket socket ;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    private String nameObject;

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }
    @Override
    public void run() {
        ObjectInputStream dis = null;
        try {
            this.setName("client chat in thread");
            dis = new ObjectInputStream(socket.getInputStream());
            while(true){
                System.out.println("client dang cho nhan");
                System.out.println(nameObject+": "+dis.readUTF());
                System.out.println("client da nhan");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChatInThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ChatInThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
