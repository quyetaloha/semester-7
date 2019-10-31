/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class ChatOutThread extends Thread{
    Socket socket ;
    private String nameObject;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            this.setName("server chat out thread");
            ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
            while(true){
                System.out.println("server dung gui");
                suspend();
                dos.writeUTF(message);
                System.out.println("server da gui");
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatOutThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
