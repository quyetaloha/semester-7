/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.UsersDAO;
import DTO.usersDTO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import orm.Users;

/**
 *
 * @author AdamKyle
 */
public class ProcessThread extends Thread{
    private Socket socket ;
    usersDTO userDTO;

    public usersDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(usersDTO userDTO) {
        this.userDTO = userDTO;
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream dis = null;
        ObjectOutputStream dos = null;
        UsersDAO userDao = new UsersDAO();
        try {
            dis = new ObjectInputStream(socket.getInputStream());
            dos = new ObjectOutputStream(socket.getOutputStream());
            while (socket.isConnected()) {
                int functionId = dis.readInt();
                if(functionId == 1){
                    List<Users> result = userDao.selectFriends(userDTO.getUserId());
                    if(result == null){
                        result = new ArrayList<Users>();
                    }
                    dos.writeObject(result); 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ProcessThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ProcessThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
