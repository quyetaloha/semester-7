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
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class simpleSever {
    public static void main(String[] args) {
        ServerSocket listener = null;
        String line=null;
        BufferedReader is = null;
        BufferedWriter os = null;
        Socket socketOfserver=null;
        int port1=9999;
        try {           
            // mo m ot seversocket tai cong 9999
            // khong the chon cong <1023 neu khong la nguio dung dac quyen
            
            listener = new ServerSocket(port1);
        } catch (IOException ex) {
            Logger.getLogger(simpleSever.class.getName()).log(Level.SEVERE, null, ex);
        }
        //chap nhan ket noi tu client
        //dong thoi nhan duoc doi tuong tu server
        try {
            socketOfserver =listener.accept();
        } catch (IOException ex) {
            Logger.getLogger(simpleSever.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("accept a client, port: "+port1);
        try {
            //mo luong vao ra tren socket tai server
            is = new BufferedReader(new InputStreamReader(socketOfserver.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfserver.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(simpleSever.class.getName()).log(Level.SEVERE, null, ex);
        }
        //nhan duoc yeu cau tu client thi gui lai
        while(true){
            System.out.println("3");
            try {
                //doc du lieu toi server tu clien t gui toi
                line = is.readLine();
                System.out.println("clien: "+line);
                //gui tra lai client
                os.write("reply client");
                //day du lieu di
                os.flush();
                //ket thuc
                if(line=="exit1"){
                    os.write("ok");
                    os.newLine();
                    os.flush();
                    break;
                }
                System.out.println("6465");
            } catch (IOException ex) {
                Logger.getLogger(simpleSever.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
