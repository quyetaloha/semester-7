/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Lib.StringUtility;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import orm.Message;
import orm.MessageData;
import orm.Users;

/**
 *
 * @author AdamKyle
 */
public class AddGroupFrm extends javax.swing.JFrame {

    /**
     * Creates new form AddGroupFrm
     */
    private List<Users> listFriends= new ArrayList<>();
    private List<Users> listMembers= new ArrayList<>();
    private Users userMember;
    public List<Users> getListFriends() {
        return listFriends;
    }

    public void setListFriends(List<Users> listFriends) {
        this.listFriends = listFriends;
    }
    public AddGroupFrm() {
        
        initComponents();
        Users a=new Users();
        a.setFirstName("quân");
        Users b=new Users();
        b.setFirstName("Phượng");
        Users c=new Users();
        c.setFirstName("Chim");
        Users d=new Users();
        d.setFirstName("Hơi to");
        Users e=new Users();
        e.setFirstName("Quá to");
        listFriends.add(a);
        listFriends.add(b);
        listFriends.add(c);
        listFriends.add(d);
        listFriends.add(e);
        init();
    }
    void init(){
        
        
            updateListFriends();
        clickList();
        
        
    }
     private void updateListFriends(){
        if(listFriends == null || listFriends.size() <= 0) return;
        
        DefaultTableModel dtm = (DefaultTableModel) jTable_listFriends.getModel();
       
      //  dtm.getDataVector().removeAllElements();
        
        for(Users userFriend : listFriends){
            
            dtm.addRow(userFriend.toObjectListFriend());
        }
    }
    
    
    private void clickList(){
        jTable_listFriends.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                
                if(e.getClickCount() >=2){
                    int k=jTable_listFriends.getSelectedRow();
                    Users userMembe = listFriends.get(k);
                    listMembers.add(userMembe);
                    //updateListMembers();
                    
                    DefaultTableModel dtm1 = (DefaultTableModel) jTable_listMembers.getModel();
                    
                    dtm1.addRow(userMembe.toObjectListFriend());
                    //xoa row trong listfriends
                    DefaultTableModel dtm = (DefaultTableModel) jTable_listFriends.getModel();
                    
                    dtm.removeRow(k);
                    listFriends.remove(userMembe);
                    //jTable_listFriends.hide();
                }
            }
            
        });
        jTable_listMembers.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                
                if(e.getClickCount() >=2){
                    int k=jTable_listMembers.getSelectedRow();
                    userMember = listMembers.get(k);
                    listFriends.add(userMember);
                    //updateListMembers();
                    
                    DefaultTableModel dtm1 = (DefaultTableModel) jTable_listFriends.getModel();
                    
                    dtm1.addRow(userMember.toObjectListFriend());
                    //xoa row trong listfriends
                    DefaultTableModel dtm = (DefaultTableModel) jTable_listMembers.getModel();
                    
                    dtm.removeRow(k);
                    listMembers.remove(userMember);
                    //jTable_listFriends.hide();
                }
            }
            
        });
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listFriends = new javax.swing.JTable();
        jLabel_userName = new javax.swing.JLabel();
        jLabel_userName1 = new javax.swing.JLabel();
        jTextField_name_group = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_listMembers = new javax.swing.JTable();
        jButton_creat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_listFriends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "List Friends"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_listFriends.setRowHeight(60);
        jScrollPane1.setViewportView(jTable_listFriends);

        jLabel_userName.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_userName.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel_userName.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_userName.setText("Suggested");

        jLabel_userName1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_userName1.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel_userName1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_userName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_userName1.setText("Name group");

        jTextField_name_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_name_groupActionPerformed(evt);
            }
        });

        jTable_listMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Members"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_listMembers.setRowHeight(60);
        jScrollPane2.setViewportView(jTable_listMembers);

        jButton_creat.setText("Creat");
        jButton_creat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_creatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel_userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_userName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_name_group)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton_creat)
                        .addContainerGap(80, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_userName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_name_group, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_creat)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_name_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_name_groupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_name_groupActionPerformed

    private void jButton_creatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_creatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_creatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddGroupFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGroupFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGroupFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGroupFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGroupFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_creat;
    private javax.swing.JLabel jLabel_userName;
    private javax.swing.JLabel jLabel_userName1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_listFriends;
    private javax.swing.JTable jTable_listMembers;
    private javax.swing.JTextField jTextField_name_group;
    // End of variables declaration//GEN-END:variables
}
