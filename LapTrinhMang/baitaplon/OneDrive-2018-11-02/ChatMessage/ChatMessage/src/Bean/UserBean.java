/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import orm.Users;
import com.mysql.jdbc.Connection;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AdamKyle
 */
public class UserBean {
    public Users checkLogin(String user, String pass){
        try {
            StringBuilder query = new StringBuilder();
            query.append("select * from users ul ");
            query.append("where ul.username = '"+user+"' ");
            query.append("and ul.password = '"+pass+"' ");
            query.append("limit 1");
            PreparedStatement ps = null;
            ps = baseBean.con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            Users result = null ;
            if(rs.next()){
                result = new Users();
                result.setUserId(rs.getInt("UsersId"));
                result.setUserName(rs.getString("UserName"));
                result.setPassWord(rs.getString("PassWord"));
                result.setState(rs.getInt("State"));
                result.setFirstName(rs.getString("FirstName"));
                result.setLastName(rs.getString("LastName"));
                result.setEmail(rs.getString("Email"));
                result.setAddress(rs.getString("Address"));
            }
            ps.close();
            if(result != null){
                return result;
            }
        } catch (SQLException ex) { 
            System.out.println(ex);
        }
        return null;
    }
    public Socket getSocketToServer(String localhost, int port){
        try {
            Socket clientSocket = new Socket(localhost, port);
            System.out.println("get socket success: "+localhost+":"+port);
            return clientSocket;
        } catch (Exception e) {
        }
        return null;
    }
    public List<Users> selectFriends(int userId){
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ul.* from users ul,friendList fl ");
            query.append("where fl.userId = '"+userId+"' ");
            query.append("and ul.usersId = fl.userFriendId ");
            PreparedStatement ps = null;
            ps = baseBean.con.prepareStatement(query.toString());
            List<Users> listFriends = new ArrayList<Users>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Users userFriend = new Users();
                userFriend.setUserId(rs.getInt("UsersId"));
                userFriend.setUserName(rs.getString("UserName"));
                userFriend.setPassWord(rs.getString("PassWord"));
                userFriend.setState(rs.getInt("State"));
                userFriend.setFirstName(rs.getString("FirstName"));
                userFriend.setLastName(rs.getString("LastName"));
                userFriend.setEmail(rs.getString("Email"));
                userFriend.setAddress(rs.getString("Address"));
                listFriends.add(userFriend);
            }
            ps.close();
            System.out.println("select friends size = "+listFriends.size());
            return listFriends;
        } catch (SQLException ex) {
            
        }
        return new ArrayList<>();
    }
}
