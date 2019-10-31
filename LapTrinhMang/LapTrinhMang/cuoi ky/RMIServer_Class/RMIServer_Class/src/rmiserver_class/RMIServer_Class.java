/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver_class;

import control.IRegistration;
import control.Registration;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import view.ClientList;

/**
 *
 * @author ntkhanh
 */
public class RMIServer_Class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, IOException {
        // TODO code application logic here
        
//        ServerSocket myServer=new ServerSocket(1299);
//        Socket clientSocket = myServer.accept();
//        DataInputStream in=new DataInputStream(clientSocket.getInputStream());
//        
//            DataOutputStream ou=new DataOutputStream(clientSocket.getOutputStream());
//        System.out.println(in.readUTF());
//        ou.writeUTF("string server gui");
        ClientList view  = new ClientList();
        IRegistration reg = new Registration(view);
    }
    
}
