/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdamKyle
 */
public class client2 {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 10000);
            System.out.println("connected");
            Scanner input = new Scanner(System.in);
            //ObjectOutputStream dos = new ObjectOutputStream(clientSocket.getOutputStream());
            //BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            while(true){
                String s = input.nextLine();
                dos.writeUTF(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
