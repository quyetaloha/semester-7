/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Hoang Quyet
 */
public class client {
    
    public static Socket client1() throws IOException {
        Socket socket;
        String host="192.168.109";
        return socket = new Socket(host, 4000); 
        
    }
}
