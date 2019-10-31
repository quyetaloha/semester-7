
import com.sun.corba.se.impl.io.IIOPInputStream;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main1 extends javax.swing.JFrame {

    enum State {
        normal,
        themSach,
        suaSach,
    }
    List<Sach> listsach;
    private State state;
    DefaultTableModel tm1;
    String path;
    public Main1() {
        initComponents();
        listsach=new ArrayList<>();
        tm1=(DefaultTableModel)jTable1.getModel();
        path="sach.dat";
        changeState(state.normal);
        readFile();
        hienthiSach();
    }
    private void hienthiSach(){
        tm1.setRowCount(0);
        for(Sach i : listsach){
            tm1.addRow(i.toObject());
        }
    }
    private Sach timSach(int ma){
        for(int i=0;i<listsach.size();i++)
            if(listsach.get(i).getMa()==ma)
                return listsach.get(i);
        return null;
    }
    private Sach newSach(){
        Sach s = null;
        try{
            String ten = jTextField2.getText(),
                   tacgia = jTextField3.getText() ;
            String cnganh=jComboBox1.getSelectedItem().toString();
            int namxb = Integer.parseInt(jTextField4.getText());
            int sluong = Integer.parseInt(jTextField5.getText());
            if(ten.equals("") || tacgia.equals("")){
                JOptionPane.showMessageDialog(this,"khong bo trong!");
            } else if((namxb < 0) || (sluong<0) ){
                JOptionPane.showMessageDialog(this,"nam xuat ban va so luong phai la so!");
            }else {
                int ma = Integer.parseInt(jTextField1.getText());
                s = new Sach(ma,ten, tacgia, cnganh, namxb, sluong);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"nam xuat ban va so luong phai la so!");
        }
        return s;
    }
    private void themSach(){
        Sach s = newSach();
        if(s != null){
            listsach.add(s);
            hienthiSach();
        }
    }
    
    private void suaSach(){
        int check = jTable1.getSelectedRow();        
            Sach s = newSach();
            listsach.set(check, s);
            hienthiSach();           
    }
    private void xoaSach(){
        int check = jTable1.getSelectedRow();
        if(check < 0 || check > jTable1.getRowCount()||
                (jTable1.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon sach de xoa!");
        } else {           
            listsach.remove(check);
            hienthiSach();                   
        }
    }
    private void readFile(){
        try{
            ObjectInputStream fin=new ObjectInputStream(new FileInputStream(path));
            listsach=(List<Sach>)fin.readObject();
            fin.close();
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    private void writeFile(){
        try{
            ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(path));
            fout.writeObject(listsach);
            fout.close();
        }catch(IOException e){
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btthem1 = new javax.swing.JButton();
        btsua1 = new javax.swing.JButton();
        btxoa1 = new javax.swing.JButton();
        btluu1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        btcn1 = new javax.swing.JButton();
        btbq1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma", "Ten", "Tac gia", "chuyen nganh", "nam", "so luong"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btthem1.setText("Them moi");
        btthem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthem1ActionPerformed(evt);
            }
        });

        btsua1.setText("Sua");
        btsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsua1ActionPerformed(evt);
            }
        });

        btxoa1.setText("xoa");
        btxoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoa1ActionPerformed(evt);
            }
        });

        btluu1.setText("Luu");
        btluu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btluu1ActionPerformed(evt);
            }
        });

        jLabel1.setText("ma");

        jLabel2.setText("ten");

        jLabel3.setText("tac gia");

        jLabel4.setText("chuyen nganh");

        jLabel5.setText("nam");

        jTextField1.setEditable(false);

        jTextField2.setText("nhay mua");

        jTextField3.setText("Ho tung Khanh");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa hoc tu nhien", "Van hoc - Nghe thuat", "Dien tu vien thong", "Cong nghe thong tin" }));

        jTextField4.setText("2015");

        jTextField5.setText("200");

        btcn1.setText("Cap nhat");
        btcn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcn1ActionPerformed(evt);
            }
        });

        btbq1.setText("Bo qua");
        btbq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbq1ActionPerformed(evt);
            }
        });

        jLabel6.setText("so lung");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btthem1)
                                .addGap(32, 32, 32)
                                .addComponent(btsua1)
                                .addGap(55, 55, 55)
                                .addComponent(btxoa1)
                                .addGap(43, 43, 43)
                                .addComponent(btluu1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btcn1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btbq1)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btthem1)
                            .addComponent(btsua1)
                            .addComponent(btxoa1)
                            .addComponent(btluu1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btcn1)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btbq1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sach", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btthem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthem1ActionPerformed
        changeState(State.themSach);
        int ma = listsach.size()+10000;
        while(true){
            if(timSach(ma)==null){
               jTextField1.setText(ma+"");
               break;               
            }
            ma++;
        }
    }//GEN-LAST:event_btthem1ActionPerformed

    private void btcn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcn1ActionPerformed
        if(state==State.themSach)
           themSach();
        else if(state==State.suaSach)
            suaSach();
        changeState(State.normal);
    }//GEN-LAST:event_btcn1ActionPerformed

    private void btbq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbq1ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btbq1ActionPerformed

    private void btluu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btluu1ActionPerformed
        writeFile();
    }//GEN-LAST:event_btluu1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int check = jTable1.getSelectedRow();
        jTextField1.setText(tm1.getValueAt(check, 0).toString());
        jTextField2.setText(tm1.getValueAt(check, 1).toString());
        jTextField3.setText(tm1.getValueAt(check, 2).toString());
        jComboBox1.setSelectedItem(tm1.getValueAt(check, 3).toString());
        jTextField4.setText(tm1.getValueAt(check, 4).toString());
        jTextField5.setText(tm1.getValueAt(check, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsua1ActionPerformed
        if(jTable1.getSelectedRow() >= 0){
                changeState(State.suaSach);
        }else{
                JOptionPane.showMessageDialog(this,"Chon sach de sua!");
            }
    }//GEN-LAST:event_btsua1ActionPerformed

    private void btxoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoa1ActionPerformed
        xoaSach();
    }//GEN-LAST:event_btxoa1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main1().setVisible(true);
            }
        });
    }
    private void changeState(State state){
        this.state = state;
        if(state == State.normal){
            btcn1.setEnabled(false);
            btbq1.setEnabled(false);
            btthem1.setEnabled(true);
            btsua1.setEnabled(true);
            btxoa1.setEnabled(true);
            btluu1.setEnabled(true);
        }
        else if((state == State.themSach)||
                (state == State.suaSach)){
            btthem1.setEnabled(false);
            btsua1.setEnabled(false);
            btxoa1.setEnabled(false);
            btluu1.setEnabled(false);
            btcn1.setEnabled(true);
            btbq1.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbq1;
    private javax.swing.JButton btcn1;
    private javax.swing.JButton btluu1;
    private javax.swing.JButton btsua1;
    private javax.swing.JButton btthem1;
    private javax.swing.JButton btxoa1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
