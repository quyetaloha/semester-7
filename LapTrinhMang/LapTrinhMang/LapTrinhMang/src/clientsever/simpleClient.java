/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsever;

/**
 *
 * @author lamvi
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class simpleClient {
    public static void main(String[] args) {
        //dia chi may chu
        final String serverHost="localhost";
        
        Socket socketofclient=null;
        BufferedReader is =null;
        BufferedWriter os=null;
        try {
            //gui yue cau toi server dang lang nghe
            socketofclient = new Socket(serverHost, 9999);
            //tao dau ra client
            os = new BufferedWriter(new OutputStreamWriter(socketofclient.getOutputStream()));
            //dau vao
            is = new BufferedReader(new InputStreamReader(socketofclient.getInputStream()));
            
        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("loi ");
        }
        try {
            //ghi du lieu dau ra
            String response=null;
            os.write("say hello \n");
            os.flush();
            System.out.println("654");
            response=is.readLine();
            System.out.println(response+"465");
            os.write("say hello \n");
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(simpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
