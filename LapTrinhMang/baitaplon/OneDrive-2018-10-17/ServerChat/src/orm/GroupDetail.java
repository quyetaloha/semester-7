/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

/**
 *
 * @author AdamKyle
 */
public class GroupDetail {
    private int GroupId;
    private int ToUserId;

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int GroupId) {
        this.GroupId = GroupId;
    }

    public int getToUserId() {
        return ToUserId;
    }

    public void setToUserId(int ToUserId) {
        this.ToUserId = ToUserId;
    }
}
