/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Connect;
import Bean.baseBean;
import Lib.StringUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import orm.Message;
import orm.Users;

/**
 *
 * @author AdamKyle
 */
public class UsersDAO {
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
    public List<Users> selectFriends(int userId){
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ul.* from users ul,friendList fl ");
            query.append("where (fl.userId = '"+userId+"' and ul.usersId = fl.userFriendId )");
            query.append("or (fl.userFriendId = '"+userId+"' and ul.usersId = fl.userId )");
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
    public List<Message> selectMessagesFromToUserId(int fromUserId, int toUserId){
        try {
            StringBuilder query = new StringBuilder();
            query.append("select m.* from messages m ");
            query.append("where (m.fromUserId = "+fromUserId+" and m.toUserId = "+toUserId+") ");
            query.append("or (m.fromUserId = "+toUserId+" and m.toUserId = "+fromUserId+") ");
            query.append("and m.groupId = -1 ");
            query.append("order by m.createdDate DESC ");
            PreparedStatement ps = null;
            ps = baseBean.con.prepareStatement(query.toString());
            List<Message> listMessages = new ArrayList<Message>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Message mess = new Message();
                mess.setMessagesId(rs.getInt("messagesId"));
                mess.setFromUserId(rs.getInt("fromUserId"));
                mess.setToUserId(rs.getInt("toUserId"));
                mess.setContnet(rs.getString("content"));
                mess.setCreatedDate(rs.getDate("createdDate"));
                mess.setGroupId(rs.getInt("groupId"));
                listMessages.add(mess);
            }
            ps.close();
            System.out.println("select mess size "+fromUserId+" to "+ toUserId+" = "+listMessages.size());
            return listMessages;
        } catch (SQLException ex) {
            
        }
        return new ArrayList<>();
    }
    public boolean updateMess(int toUser, int fromuser, String mess){
        try {
            StringBuilder query = new StringBuilder();
            //INSERT INTO `messenger`.`messages` (`fromUserId`, `toUserId`, `content`, `createdDate`, `groupId`) VALUES ('1', '4', 'asdfs', 'date', '-1');
            query.append("INSERT INTO messages ");
            query.append("(`fromUserId`, `toUserId`, `content`, `createdDate`, `groupId`)");
            query.append("VALUES ('"+toUser+"', '"+fromuser+"', '"+mess+"', '"+StringUtility.currentDateTime()+"', '-1')");
            Statement statement = baseBean.con.createStatement();
            statement.executeUpdate(query.toString());
            statement.close();
            return true;
        } catch (SQLException ex) {
            
        }
        return false;
    }
    public boolean addUser(){
        return false;
    }
}
