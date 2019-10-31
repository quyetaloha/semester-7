/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Hoang Quyet
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        
        
        int portNumber=9999;
        try{
            ServerSocket serverSocket=new ServerSocket(portNumber);
            Socket clientSocket=serverSocket.accept();
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while((inputLine=in.readLine())!=null){
                out.println(inputLine);
            }
        }catch(IOException e){
            System.out.println("Exception caught when trying to listen on port "
                +portNumber+"or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
