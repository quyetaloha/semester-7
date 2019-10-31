/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import java.io.Serializable;

/**
 *
 * @author AdamKyle
 */
public class MessageData implements Serializable{
    private String content;
    private short funtion;
    private int userIdReceive;

    public int getUserIdReceive() {
        return userIdReceive;
    }

    public void setUserIdReceive(int userIdReceive) {
        this.userIdReceive = userIdReceive;
    }
    public short getFuntion() {
        return funtion;
    }

    public void setFuntion(short funtion) {
        this.funtion = funtion;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
