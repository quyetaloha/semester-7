/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import orm.Message;
import java.util.List;

/**
 *
 * @author AdamKyle
 */
public interface messageDAO extends baseDAO{
    public List<Message> selectMessagesByFromUserId(int fromUserId);
}
