/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DTO.usersDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import orm.Users;
import DAO.UsersDAO;
import java.io.ObjectOutputStream;
import java.net.SocketException;

/**
 *
 * @author AdamKyle
 */
public class Server1 {

    public static void main(String[] args) throws ClassNotFoundException {
        List<usersDTO> listUsersLogin= new ArrayList<usersDTO>();
        UsersDAO usersDAO = new UsersDAO();
        try {
            int port = 10000;
            ServerSocket serverSocket = new ServerSocket(port);
            ObjectInputStream ois;
            ObjectOutputStream oos;
            while(true){
                Socket clientSocket = serverSocket.accept();
                ois = new ObjectInputStream(clientSocket.getInputStream());
                oos = new ObjectOutputStream(clientSocket.getOutputStream());
                usersDTO userLogin =(usersDTO) ois.readObject();
                Users user = usersDAO.checkLogin(userLogin.getUserName(), userLogin.getPassWord());
                userLogin.setClientSocket(clientSocket);
                listUsersLogin.add(userLogin);
                System.out.println(userLogin.getClientSocket().getInetAddress()+":"+userLogin.getClientSocket().getPort()+" "+userLogin.getUserName() + " connected");
                // gui lai thong tin user cho client
                oos.writeObject(user);
                // gui lai list friend
                //List<Users> listFriend = usersDAO.selectFriends(user.getUserId());
                //oos.writeObject(listFriend);
                //tao thread rieng de xu li cho moi client
                ThreadTest a = new ThreadTest();
                a.setUser(user);
                a.setClientSocket(clientSocket);
                a.run();
            }
        } catch (SocketException ex){
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void white() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
