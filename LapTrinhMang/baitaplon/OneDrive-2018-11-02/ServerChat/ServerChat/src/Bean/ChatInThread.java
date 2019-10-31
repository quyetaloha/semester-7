/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.UsersDAO;
import Lib.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import orm.Message;
import orm.MessageData;
import orm.Users;

/**
 *
 * @author AdamKyle
 */
public class ChatInThread extends Thread{
    private Socket socket ;
    Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    private String nameObject;

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }
    @Override
    public void run() {
        ObjectInputStream dis = null;
        UsersDAO usersDAO = new UsersDAO();
        ObjectOutputStream oos;
        try {
            this.setName("server chat in thread");
            dis = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            MessageData messReceive;
            List<Users> listFriend;
            List<Message> listMess;
            while(true){
                messReceive = (MessageData) dis.readObject();
                System.out.println("server da nhan messdata");
                if(messReceive.getFuntion() == StringUtility.FUNCTION_CLIENT_GET_LIST_FRIENDS){
                    listFriend = usersDAO.selectFriends(user.getUserId());
                    oos.writeObject(listFriend);
                    System.out.println("server gui tra list friend:"+listFriend.size());
                    continue;
                }
                if(messReceive.getFuntion() == StringUtility.FUNCTION_CLIENT_SENT_MESS){
                    // luu vao db de chuyen cho dua kia
                    boolean result;
                    result = usersDAO.updateMess(user.getUserId(), messReceive.getUserIdReceive(), messReceive.getContent());
                    if(result){
                        System.out.println("luu mess thanh cong");
                    } else{
                        System.out.println("luu mess that bai");
                    }
                }
                if(messReceive.getFuntion() == StringUtility.FUNCTION_CLIENT_GET_MESS_BY_USERID){
                    listMess = usersDAO.selectMessagesFromToUserId(user.getUserId(), messReceive.getUserIdReceive());
                    oos.writeObject(listMess);
                    System.out.println("server gui tra list friend:"+listMess.size());
                    continue;
                }
                System.out.println(messReceive.getFuntion()+" "+messReceive.getContent());
            }
        } catch(SocketException ex){
            System.out.println(user.getFirstName() +" "+ user.getLastName() + " disconnect");
        }
        catch (IOException ex) {
            Logger.getLogger(ChatInThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ChatInThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
