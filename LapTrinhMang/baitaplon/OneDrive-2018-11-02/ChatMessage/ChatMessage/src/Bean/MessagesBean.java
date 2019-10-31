/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import orm.Message;
import orm.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AdamKyle
 */
public class MessagesBean {

    public MessagesBean() {
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
}
