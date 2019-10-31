/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
public class getListFriendThread extends Thread{
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
    List<Users> result;

    public List<Users> getResult() {
        return result;
    }

    public void setResult(List<Users> result) {
        this.result = result;
    }
    @Override
    public void run() {
        try {// chi khoi tao thread khi co yeu cau thuc hien ham tu client
            ObjectInputStream dis = null;
            ObjectOutputStream dos = null;
            dis = new ObjectInputStream(socket.getInputStream());
            dos = new ObjectOutputStream(socket.getOutputStream());
            dos.writeInt(1);
            result = (List<Users>) dis.readObject();
            if(result == null){
                result = new ArrayList<Users>();
            }
        } catch (IOException ex) {
            Logger.getLogger(getListFriendThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getListFriendThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
