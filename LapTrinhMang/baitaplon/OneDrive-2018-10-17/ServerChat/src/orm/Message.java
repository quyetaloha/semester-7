/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AdamKyle
 */
// tin nhan ben trong 1 group
public class Message implements Serializable{
    private int messagesId;
    private int fromUserId;
    private int toUserId;
    private String contnet;
    private Date createdDate;
    private int groupId;

    public int getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(int messagesId) {
        this.messagesId = messagesId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public String getContnet() {
        return contnet;
    }

    public void setContnet(String contnet) {
        this.contnet = contnet;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public Object[] toObjectMess(){
        return new Object[]{contnet};
    }
}
