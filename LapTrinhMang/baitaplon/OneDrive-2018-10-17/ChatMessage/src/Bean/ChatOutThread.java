/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import orm.MessageData;

/**
 *
 * @author AdamKyle
 */
public class ChatOutThread extends Thread{
    Socket socket ;
    private String nameObject;
    private MessageData message;

    public MessageData getMessage() {
        return message;
    }

    public void setMessage(MessageData message) {
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
            this.setName("client chat out thread");
            ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
            //Scanner input = new Scanner(System.in);
            while(true){
                System.out.println("client ngung gui");
                suspend();
                System.out.println("client da gui");
                dos.writeObject(message);
                //dos.writeUTF(message);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatOutThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
