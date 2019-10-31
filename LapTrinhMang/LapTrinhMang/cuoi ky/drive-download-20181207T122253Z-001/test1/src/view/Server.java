/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.IRegistration;
import control.RegisterImpl;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet Nguyen
 */
public class Server implements Serializable{
    public static void main(String[] args) {
        try {
            //IRegistration rei = new RegisterImpl();
            
            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind("Server", new RegisterImpl());
            System.out.println("Server running...");
            
            
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
