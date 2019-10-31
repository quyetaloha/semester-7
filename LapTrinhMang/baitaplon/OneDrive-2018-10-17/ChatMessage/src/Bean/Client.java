/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 10000);
            System.out.println("connected");
//            Scanner input = new Scanner(System.in);
//            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
//            while(true){
//                String s = input.nextLine();
//                dos.writeUTF(s);
//                if(s.equals("q")) break;
//            }
            ChatInThread cit = new ChatInThread();
            cit.setSocket(clientSocket);
            cit.setNameObject("server");
            cit.start();
            ChatOutThread cot = new ChatOutThread();
            cot.setSocket(clientSocket);
             cot.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
