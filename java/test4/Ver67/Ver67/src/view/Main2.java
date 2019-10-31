
package view;


import entity.BanDoc;
import entity.Sach;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class Main2 extends javax.swing.JFrame {

    enum State {
        normal,
        themSach,
        suaSach,
        themBandoc,
        suaBandoc,
    }
    List<Sach> listsach;
    List<BanDoc> listbandoc;
    private State state;
    DefaultTableModel tm1,tm2;
    String path1,path2;
    public Main2() {
        initComponents();
        listsach=new ArrayList<>();
        listbandoc=new ArrayList<>();
        tm1=(DefaultTableModel)jTable1.getModel();
        tm2=(DefaultTableModel)jTable2.getModel();
        path1="sach.dat";
        path2="bandoc.dat";
        changeState(state.normal);
        readFile();
        readFile1();
        hienthiSach();
        hienthiBandoc();
    }
    private void hienthiSach(){
        tm1.setRowCount(0);
        for(Sach i : listsach){
            tm1.addRow(i.toObject());
        }
    }
    private void hienthiBandoc(){
        tm2.setRowCount(0);
        for(BanDoc i : listbandoc){
            tm2.addRow(i.toObject());
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
        if(check < 0 || check > jTable1.getRowCount()||(jTable1.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon sach de xoa!");
        } else {           
            listsach.remove(check);
            hienthiSach();                   
        }
    }
    private BanDoc timBandoc(int ma){
        for(int i=0;i<listbandoc.size();i++)
            if(listbandoc.get(i).getMa()==ma)
                return listbandoc.get(i);
        return null;
    }
    private void xoaBandoc(){
        int check = jTable2.getSelectedRow();
        if(check < 0 || check > jTable2.getRowCount()||(jTable2.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon ban doc de xoa!");
        } else {           
            listbandoc.remove(check);
            hienthiBandoc();                   
        }
    }
    private BanDoc newBandoc(){
        BanDoc bd = null;
        try{
            String ten = jTextField7.getText(),
                   diachi = jTextField8.getText();
            long sdt = Long.parseLong(jTextField9.getText());
            if(ten.equals("") || diachi.equals("")){
                JOptionPane.showMessageDialog(this,"khong bo trong!");
            } else if(sdt < 0 ){
                JOptionPane.showMessageDialog(this,"Dien thoai phai la so!");
            }else {
                int ma = Integer.parseInt(jTextField6.getText());
                bd = new BanDoc(ma, ten, diachi, sdt);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Dien thoai phai la so!");
        }
        return bd;
    }
    private void themBandoc(){
        BanDoc bd = newBandoc();
        if(bd != null){
            listbandoc.add(bd);
            hienthiBandoc();
        }
    }
    
    private void suaBandoc(){
        int check = jTable2.getSelectedRow();        
            BanDoc bd = newBandoc();
            listbandoc.set(check, bd);
            hienthiBandoc();           
    }
    private void readFile(){
        try{
            ObjectInputStream fin=new ObjectInputStream(new FileInputStream(path1));
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
            ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(path1));
            fout.writeObject(listsach);
            fout.close();
        }catch(IOException e){
            
        }
    }
    private void readFile1(){
        try{
            ObjectInputStream fin=new ObjectInputStream(new FileInputStream(path2));
            listbandoc=(List<BanDoc>)fin.readObject();
            fin.close();
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    private void writeFile1(){
        try{
            ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(path2));
            fout.writeObject(listbandoc);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btthem2 = new javax.swing.JButton();
        btsua2 = new javax.swing.JButton();
        btxoa2 = new javax.swing.JButton();
        btluu2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        btcn2 = new javax.swing.JButton();
        btbq2 = new javax.swing.JButton();

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

        jLabel1.setText("Ma");

        jLabel2.setText("Ten");

        jLabel3.setText("Tac gia");

        jLabel4.setText("Chuyen nganh");

        jLabel5.setText("Nam");

        jTextField1.setEditable(false);

        jTextField2.setText("nhay mua");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

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

        jButton1.setText("Sap xep theo ten");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("sap xep giam dan so luong");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("So luong");

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
                            .addComponent(jLabel10))
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
                                .addComponent(btbq1)))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btcn1)
                            .addComponent(jButton1))
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(jLabel10)))
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sach", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma", "ten", "dia chi", "dien thoai"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btthem2.setText("Them moi");
        btthem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthem2ActionPerformed(evt);
            }
        });

        btsua2.setText("Sua");
        btsua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsua2ActionPerformed(evt);
            }
        });

        btxoa2.setText("Xoa");
        btxoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoa2ActionPerformed(evt);
            }
        });

        btluu2.setText("Luu");
        btluu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btluu2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Ma");

        jLabel7.setText("Ten");

        jLabel8.setText("Dia chi");

        jLabel9.setText("jLabel9");

        jTextField6.setEditable(false);

        jTextField7.setText("Tran An An");

        jTextField8.setText("So 5 duong lang");

        jTextField9.setText("0912765443");

        btcn2.setText("Cap nhat");
        btcn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcn2ActionPerformed(evt);
            }
        });

        btbq2.setText("Bo qua");
        btbq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbq2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jTextField9))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btcn2)
                            .addComponent(btbq2))
                        .addGap(119, 119, 119))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btthem2)
                        .addGap(18, 18, 18)
                        .addComponent(btsua2)
                        .addGap(37, 37, 37)
                        .addComponent(btxoa2)
                        .addGap(45, 45, 45)
                        .addComponent(btluu2)))
                .addGap(155, 155, 155))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btthem2)
                            .addComponent(btsua2)
                            .addComponent(btxoa2)
                            .addComponent(btluu2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btcn2)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btbq2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ban Doc", jPanel2);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
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

    private void btthem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthem2ActionPerformed
        changeState(State.themBandoc);
        int ma = listbandoc.size()+10000;
        while(true){
            if(timBandoc(ma)==null){
               jTextField6.setText(ma+"");
               break;               
            }
            ma++;
        }
    }//GEN-LAST:event_btthem2ActionPerformed

    private void btcn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcn2ActionPerformed
        if(state==State.themBandoc)
           themBandoc();
        else if(state==State.suaBandoc)
            suaBandoc();
        changeState(State.normal);
    }//GEN-LAST:event_btcn2ActionPerformed

    private void btbq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbq2ActionPerformed
        changeState(state.normal);
    }//GEN-LAST:event_btbq2ActionPerformed

    private void btsua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsua2ActionPerformed
        if(jTable2.getSelectedRow() >= 0){
                changeState(State.suaBandoc);
        }else{
                JOptionPane.showMessageDialog(this,"Chon ban doc de sua!");
            }
    }//GEN-LAST:event_btsua2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int check = jTable2.getSelectedRow();
        jTextField6.setText(tm2.getValueAt(check, 0).toString());
        jTextField7.setText(tm2.getValueAt(check, 1).toString());
        jTextField8.setText(tm2.getValueAt(check, 2).toString());
        jTextField9.setText(tm2.getValueAt(check, 3).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void btxoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoa2ActionPerformed
        xoaBandoc();
    }//GEN-LAST:event_btxoa2ActionPerformed

    private void btluu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btluu2ActionPerformed
        writeFile1();
    }//GEN-LAST:event_btluu2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Collections.sort(listsach, new Comparator<Sach>(){
            @Override
            public int compare(Sach o1, Sach o2) {
                return o1.getTen().compareToIgnoreCase(
                        o2.getTen());
            }
            
        });
        hienthiSach();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Collections.sort(listsach, new Comparator<Sach>(){
            @Override
            public int compare(Sach o1, Sach o2) {
                return o2.getSoLuong()-o1.getSoLuong();
            }
            
        });
        hienthiSach();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
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
            
            btcn2.setEnabled(false);
            btbq2.setEnabled(false);
            btthem2.setEnabled(true);
            btsua2.setEnabled(true);
            btxoa2.setEnabled(true);
            btluu2.setEnabled(true);
        }
        else if((state == State.themSach)||(state == State.suaSach)){
            btthem1.setEnabled(false);
            btsua1.setEnabled(false);
            btxoa1.setEnabled(false);
            btluu1.setEnabled(false);
            btcn1.setEnabled(true);
            btbq1.setEnabled(true);
        }else if((state == State.themBandoc)||
                (state == State.suaBandoc)){
            btthem2.setEnabled(false);
            btsua2.setEnabled(false);
            btxoa2.setEnabled(false);
            btluu2.setEnabled(false);
            btcn2.setEnabled(true);
            btbq2.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbq1;
    private javax.swing.JButton btbq2;
    private javax.swing.JButton btcn1;
    private javax.swing.JButton btcn2;
    private javax.swing.JButton btluu1;
    private javax.swing.JButton btluu2;
    private javax.swing.JButton btsua1;
    private javax.swing.JButton btsua2;
    private javax.swing.JButton btthem1;
    private javax.swing.JButton btthem2;
    private javax.swing.JButton btxoa1;
    private javax.swing.JButton btxoa2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
