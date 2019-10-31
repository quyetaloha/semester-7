
package view;

import controller.IOFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BanDoc;
import model.BangQuanLy;
import model.Sach;


public class Main extends javax.swing.JFrame {
    enum State {
        normal,
        themBandoc,
        suaBandoc,
        themSach,
        suaSach,
        themQL,
        suaQL,
    }
    private State state;
    private ArrayList<Sach> listsach = new ArrayList<>();
    private ArrayList<BanDoc> listbandoc = new ArrayList<>();
    private ArrayList<BangQuanLy> qlmuon = new ArrayList<>();
    DefaultTableModel tm1,tm2,tm3;
    public Main() {
        initComponents();
        tm1=(DefaultTableModel)jTable1.getModel();
        tm2=(DefaultTableModel)jTable2.getModel();
        tm3=(DefaultTableModel)jTable3.getModel();
        changeState(State.normal);
        IOFile.readFile(listsach,"sach.dat");
        IOFile.readFile(listbandoc,"BanDoc.dat");
        IOFile.readFile(qlmuon,"qlmuon.dat");
        hienthiBandoc();
        hienthiSach();
        hienthiQLmuon();
        refresh2Ma();
        
    }
    
    private void changeState(State state){
        this.state = state;
        if(state == State.normal){
            btcn1.setEnabled(false);
            btbq1.setEnabled(false);
            btcn2.setEnabled(false);
            btbq2.setEnabled(false);
            btcn3.setEnabled(false);
            btbq3.setEnabled(false);
            btthem1.setEnabled(true);
            btsua1.setEnabled(true);
            btxoa1.setEnabled(true);
            btluu1.setEnabled(true);
            btthem2.setEnabled(true);
            btsua2.setEnabled(true);
            btxoa2.setEnabled(true);
            btluu2.setEnabled(true);
            btthem3.setEnabled(true);
            btsua3.setEnabled(true);
            btxoa3.setEnabled(true);
            btluu3.setEnabled(true);
        }
        else if((state == State.themBandoc)||
                (state == State.suaBandoc)){
            btthem1.setEnabled(false);
            btsua1.setEnabled(false);
            btxoa1.setEnabled(false);
            btluu1.setEnabled(false);
            btcn1.setEnabled(true);
            btbq1.setEnabled(true);
        }
        else if((state == State.themSach)||
                (state == State.suaSach)){
            btthem2.setEnabled(false);
            btsua2.setEnabled(false);
            btxoa2.setEnabled(false);
            btluu2.setEnabled(false);
            btcn2.setEnabled(true);
            btbq2.setEnabled(true);
        }
        else if((state == State.themQL)||
                (state == State.suaQL)){
            btthem3.setEnabled(false);
            btsua3.setEnabled(false);
            btxoa3.setEnabled(false);
            btluu3.setEnabled(false);
            btcn3.setEnabled(true);
            btbq3.setEnabled(true);
        }
    }
    private void hienthiSach(){
        tm2.setRowCount(0);
        for(Sach i : listsach){
            tm2.addRow(i.toObject());
        }
    }
    private void hienthiBandoc(){
        tm1.setRowCount(0);
        for(BanDoc i : listbandoc){
            tm1.addRow(i.toObject());
        }
    }
    private void hienthiQLmuon(){
        tm3.setRowCount(0);
        for(BangQuanLy i : qlmuon){
            tm3.addRow(i.toObject());
        }
    }
    private void refresh2Ma(){
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        for(BanDoc i : listbandoc){
            jComboBox1.addItem(Integer.toString(i.getMa()));
        }
        for(Sach i : listsach){
            jComboBox2.addItem(Integer.toString(i.getMa()));
        }        
    }
    private BanDoc timBandoc(int ma){
        for(int i=0;i<listbandoc.size();i++)
            if(listbandoc.get(i).getMa()==ma)
                return listbandoc.get(i);
        return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btthem1 = new javax.swing.JButton();
        btsua1 = new javax.swing.JButton();
        btxoa1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        btcn1 = new javax.swing.JButton();
        btbq1 = new javax.swing.JButton();
        btluu1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btthem2 = new javax.swing.JButton();
        btsua2 = new javax.swing.JButton();
        btxoa2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        combocn = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        btcn2 = new javax.swing.JButton();
        btbq2 = new javax.swing.JButton();
        btluu2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btthem3 = new javax.swing.JButton();
        btsua3 = new javax.swing.JButton();
        btxoa3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        btcn3 = new javax.swing.JButton();
        btbq3 = new javax.swing.JButton();
        btluu3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bạn đọc", "Họ và tên", "Địa chỉ", "Số điện thoại"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btthem1.setText("Thêm mới");
        btthem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthem1ActionPerformed(evt);
            }
        });

        btsua1.setText("Sửa");
        btsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsua1ActionPerformed(evt);
            }
        });

        btxoa1.setText("Xóa");
        btxoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoa1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã bạn đọc");

        jLabel2.setText("Họ và tên");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Số điện thoại");

        jTextField1.setEditable(false);

        btcn1.setText("Cập nhật");
        btcn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcn1ActionPerformed(evt);
            }
        });

        btbq1.setText("Bỏ qua");
        btbq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbq1ActionPerformed(evt);
            }
        });

        btluu1.setText("Lưu");
        btluu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btluu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btbq1)
                                .addComponent(btcn1))
                            .addGap(30, 30, 30)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btthem1)
                        .addGap(27, 27, 27)
                        .addComponent(btsua1)
                        .addGap(28, 28, 28)
                        .addComponent(btxoa1)
                        .addGap(31, 31, 31)
                        .addComponent(btluu1)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthem1)
                    .addComponent(btsua1)
                    .addComponent(btxoa1)
                    .addComponent(btluu1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btcn1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btbq1)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Bạn Đọc", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Chuyên ngành", "Năm xuất bản", "Số lượng"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btthem2.setText("Thêm mới");
        btthem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthem2ActionPerformed(evt);
            }
        });

        btsua2.setText("Sửa");
        btsua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsua2ActionPerformed(evt);
            }
        });

        btxoa2.setText("Xóa ");
        btxoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoa2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã sách");

        jLabel6.setText("Tên sách");

        jLabel7.setText("Tác giả");

        jLabel8.setText("Chuyên ngành");

        jLabel9.setText("Năm xuất bản");

        jLabel10.setText("Số lượng");

        jTextField5.setEditable(false);

        combocn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa hoc tu nhien", "Van hoc - Nghe thuat", "Dien tu vien thong", "Cong nghe thong tin" }));
        combocn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocnActionPerformed(evt);
            }
        });

        btcn2.setText("Cập nhật");
        btcn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcn2ActionPerformed(evt);
            }
        });

        btbq2.setText("Bỏ qua");
        btbq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbq2ActionPerformed(evt);
            }
        });

        btluu2.setText("Lưu");
        btluu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btluu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btthem2)
                                .addGap(27, 27, 27)
                                .addComponent(btsua2)
                                .addGap(47, 47, 47)
                                .addComponent(btxoa2)
                                .addGap(37, 37, 37)
                                .addComponent(btluu2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(combocn, 0, 186, Short.MAX_VALUE)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btcn2)
                            .addComponent(btbq2))
                        .addContainerGap(257, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthem2)
                    .addComponent(btsua2)
                    .addComponent(btxoa2)
                    .addComponent(btluu2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btcn2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btbq2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(combocn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sách", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bạn đọc", "Tên bạn đọc", "Mã sách", "Tên sách", "Số lượng", "Tình trạng"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        btthem3.setText("Thêm mới");
        btthem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthem3ActionPerformed(evt);
            }
        });

        btsua3.setText("Sửa ");
        btsua3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsua3ActionPerformed(evt);
            }
        });

        btxoa3.setText("Xóa ");
        btxoa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoa3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã bạn đọc");

        jLabel12.setText("Mã sách");

        jLabel13.setText("Số lượng");

        jLabel14.setText("Tình trạng");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btcn3.setText("Cập nhật");
        btcn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcn3ActionPerformed(evt);
            }
        });

        btbq3.setText("Bỏ qua");
        btbq3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbq3ActionPerformed(evt);
            }
        });

        btluu3.setText("Lưu");
        btluu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btluu3ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), null), "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Tên bạn đọc");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Số lượng");

        jButton1.setText("Sắp xếp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel15.setText("Tên bạn đọc");

        jButton2.setText("Tìm kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btthem3)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btsua3)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addGap(95, 95, 95)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btxoa3)
                                .addGap(58, 58, 58)
                                .addComponent(btluu3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btbq3)
                                    .addComponent(btcn3))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btthem3)
                                .addComponent(btsua3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btxoa3)
                                .addComponent(btluu3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btcn3)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btbq3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("QL mượn", jPanel3);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jButton3.setText("Tong so luong sach theo ma");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton3)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(359, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thêm", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btthem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthem1ActionPerformed
        changeState(State.themBandoc);
        int ma = listbandoc.size()+10000;
        while(true){
            if(timBandoc(ma)==null){
               jTextField1.setText(ma+"");
               break;               
            }
            ma++;
        }
    }//GEN-LAST:event_btthem1ActionPerformed
    private void xoaBandoc(){
        int check = jTable1.getSelectedRow();
        if(check < 0 || check > jTable1.getRowCount()||(jTable1.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon ban doc de xoa!");
        } else {           
            listbandoc.remove(check);
            hienthiBandoc();                   
        }
    }
    private BanDoc newBandoc(){
        BanDoc bd = null;
        try{
            String ten = jTextField2.getText(),
                   diachi = jTextField3.getText();
            long sdt = Long.parseLong(jTextField4.getText());
            if(ten.equals("") || diachi.equals("")){
                JOptionPane.showMessageDialog(this,"khong bo trong!");
            } else if(sdt < 0 ){
                JOptionPane.showMessageDialog(this,"Dien thoai phai la so!");
            }else {
                int ma = Integer.parseInt(jTextField1.getText());
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
    //
    private void suaBandoc(){
        int check = jTable1.getSelectedRow();        
            BanDoc bd = newBandoc();
            listbandoc.set(check, bd);
            hienthiBandoc();           
    }
    private Sach timSach(int ma){
        for(int i=0;i<listsach.size();i++)
            if(listsach.get(i).getMa()==ma)
                return listsach.get(i);
        return null;
    }
    private void xoaSach(){
        int check = jTable2.getSelectedRow();
        if(check < 0 || check > jTable2.getRowCount()||(jTable2.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon sach de xoa!");
        } else {           
            listsach.remove(check);
            hienthiSach();                   
        }
    }
    private Sach newSach(){
        Sach s = null;
        try{
            String ten = jTextField6.getText(),
                   tacgia = jTextField7.getText() ;
            String cnganh=combocn.getSelectedItem().toString();
            int namxb = Integer.parseInt(jTextField8.getText());
            int sluong = Integer.parseInt(jTextField9.getText());
            if(ten.equals("") || tacgia.equals("")){
                JOptionPane.showMessageDialog(this,"khong bo trong!");
            } else if((namxb < 0) || (sluong<0) ){
                JOptionPane.showMessageDialog(this,"nam xuat ban va so luong phai la so!");
            }else {
                int ma = Integer.parseInt(jTextField5.getText());
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
        int check = jTable2.getSelectedRow();        
            Sach s = newSach();
            listsach.set(check, s);
            hienthiSach();           
    }
    private void xoaQLmuon(){
        int check = jTable3.getSelectedRow();
        if(check < 0 || check > jTable3.getRowCount()||(jTable3.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon dong de xoa!");
        } else {
                qlmuon.remove(check);                
                hienthiQLmuon();            
            }        
    }
    private boolean isQLmuon(int mabd, int mas){
        for(BangQuanLy i:qlmuon){
            if((i.getMaBanDoc()==mabd)&&(i.getMaSach()==mas))
                return true;
        }
        return false;
    }
    private BangQuanLy newQLmuon(){
        BangQuanLy bql = null;
        int mabd=0, mas=0;
        try{ 
            mabd = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            mas = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            System.out.println(jComboBox1.getSelectedIndex());
            if(isQLmuon(mabd, mas)){
                JOptionPane.showMessageDialog(this,"Da ton tai 2 ma!");
                return null;
            }
            int num = Integer.parseInt(jTextField10.getText());
            if(num < 0){
                JOptionPane.showMessageDialog(this,"so luong la so nguyen duong!");                
            } else if(num > 3){
                JOptionPane.showMessageDialog(this,"khong duoc muon qua 3 cuon sach!");
            } else {
                String ttrang="";
                ttrang=jTextField11.getText();
                
                bql = new BangQuanLy(timBandoc(mabd),timSach(mas), num, ttrang);
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(this,"nhap sai kieu du lieu!");
        }
        return bql;
    }
    private void themQLmuon(){
        BangQuanLy bql = newQLmuon();
        if(bql != null){
            qlmuon.add(bql);
            hienthiQLmuon();           
        }        
    }

    private void suaQLmuon(){
        int check = jTable3.getSelectedRow();        
            BangQuanLy bql = newQLmuon();
            if(bql == null){
                return ;
            } else {
                qlmuon.set(check, bql);
                hienthiQLmuon();              
            }
    }
    private void btsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsua1ActionPerformed
        if(jTable1.getSelectedRow() >= 0){
                changeState(State.suaBandoc);
            } else{
                JOptionPane.showMessageDialog(this,"Chon ban doc de sua!");
            }
    }//GEN-LAST:event_btsua1ActionPerformed

    private void btxoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoa1ActionPerformed
        xoaBandoc();
        refresh2Ma();
    }//GEN-LAST:event_btxoa1ActionPerformed

    private void btcn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcn1ActionPerformed
        if(state==State.themBandoc)
           themBandoc();
        else if(state==State.suaBandoc)
            suaBandoc();
        refresh2Ma();
        changeState(State.normal);
    }//GEN-LAST:event_btcn1ActionPerformed

    private void btbq3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbq3ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btbq3ActionPerformed

    private void btluu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btluu3ActionPerformed
        IOFile.writeFile(qlmuon, "qlmuon.dat");
    }//GEN-LAST:event_btluu3ActionPerformed

    private void btluu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btluu1ActionPerformed
        IOFile.writeFile(listbandoc, "BanDoc.dat");
    }//GEN-LAST:event_btluu1ActionPerformed

    private void btluu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btluu2ActionPerformed
        IOFile.writeFile(listsach, "Sach.dat");
    }//GEN-LAST:event_btluu2ActionPerformed

    private void btthem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthem2ActionPerformed
        changeState(State.themSach);
        int ma = listsach.size()+10000;
        while(true){
            if(timSach(ma)==null){
               jTextField5.setText(ma+"");
               break;               
            }
            ma++;
        }
    }//GEN-LAST:event_btthem2ActionPerformed

    private void btsua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsua2ActionPerformed
        if(jTable2.getSelectedRow() >= 0){
                changeState(State.suaSach);
        }else{
                JOptionPane.showMessageDialog(this,"Chon sach de sua!");
            }
    }//GEN-LAST:event_btsua2ActionPerformed

    private void btxoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoa2ActionPerformed
        xoaSach();
        refresh2Ma();
    }//GEN-LAST:event_btxoa2ActionPerformed

    private void btcn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcn2ActionPerformed
        if(state==State.themSach)
           themSach();
        else if(state==State.suaSach)
            suaSach();
        changeState(State.normal);
        refresh2Ma();
    }//GEN-LAST:event_btcn2ActionPerformed

    private void btbq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbq1ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btbq1ActionPerformed

    private void btbq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbq2ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btbq2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int check = jTable1.getSelectedRow();
        jTextField1.setText(tm1.getValueAt(check, 0).toString());
        jTextField2.setText(tm1.getValueAt(check, 1).toString());
        jTextField3.setText(tm1.getValueAt(check, 2).toString());
        jTextField4.setText(tm1.getValueAt(check, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int check = jTable2.getSelectedRow();
        jTextField5.setText(tm2.getValueAt(check, 0).toString());
        jTextField6.setText(tm2.getValueAt(check, 1).toString());
        jTextField7.setText(tm2.getValueAt(check, 2).toString());
        combocn.setSelectedItem(tm2.getValueAt(check, 3).toString());
        jTextField8.setText(tm2.getValueAt(check, 4).toString());
        jTextField9.setText(tm2.getValueAt(check, 5).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void btthem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthem3ActionPerformed
        changeState(State.themQL);
    }//GEN-LAST:event_btthem3ActionPerformed

    private void btsua3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsua3ActionPerformed
        if(jTable3.getSelectedRow() >= 0){
                changeState(State.suaQL);
            } else{
                JOptionPane.showMessageDialog(this,"Chon dong de sua!");
            }
    }//GEN-LAST:event_btsua3ActionPerformed

    private void btxoa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoa3ActionPerformed
        xoaQLmuon();
    }//GEN-LAST:event_btxoa3ActionPerformed

    private void btcn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcn3ActionPerformed
        if(state==State.themQL)
           themQLmuon();
        else if(state==State.suaQL)
            suaQLmuon();
        changeState(State.normal);
    }//GEN-LAST:event_btcn3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int check = jTable3.getSelectedRow();
        jComboBox1.setSelectedItem(tm3.getValueAt(check, 0).toString());
        jComboBox2.setSelectedItem(tm3.getValueAt(check, 2).toString());
        jTextField10.setText(tm3.getValueAt(check, 4).toString());
        jTextField11.setText(tm3.getValueAt(check, 5).toString());
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            Collections.sort(qlmuon,new Comparator<BangQuanLy>(){
                @Override
                public int compare(BangQuanLy o1, BangQuanLy o2) {
                    return o1.getTenBanDoc().compareToIgnoreCase(o2.getTenBanDoc());
                }
                
            });
        }else{
            Collections.sort(qlmuon,new Comparator<BangQuanLy>() {
                @Override
                public int compare(BangQuanLy o1, BangQuanLy o2) {
                    return o2.getSoLuong()-o1.getSoLuong();
                }
            });
        }
        tm3.setRowCount(0);
        for(BangQuanLy b:qlmuon)
            tm3.addRow(b.toObject());
    }//GEN-LAST:event_jButton1ActionPerformed

    private HashSet<Integer> nhomDocGia(){
        HashSet<Integer> ll=new HashSet<>();
        for (int i = 0; i < qlmuon.size(); i++) {
            ll.add(qlmuon.get(i).getMaBanDoc());
        }
        return ll;
    }
    private String docgiaVaSoluong(){
        String re="";
        HashSet<Integer> nam=nhomDocGia();
        Iterator i=nam.iterator();
        int n;
        String ten="";
        while(i.hasNext()) {
            int sum=0;
            n=Integer.parseInt(i.next().toString());
            for (int j = 0; j < qlmuon.size(); j++) { 
               if((qlmuon.get(j).getMaBanDoc())==n){
                   sum+=qlmuon.get(j).getSoLuong();
                   ten=qlmuon.get(j).getTenBanDoc();
               }
        }
            re+=n+"\t"+ten+"\t"+sum+"\n";
        }
        return re;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<BangQuanLy> ll=new ArrayList<>();
        String ten=jTextField12.getText();
        for (int i = 0; i < qlmuon.size(); i++) {
            if(qlmuon.get(i).getTenBanDoc().indexOf(ten)>=0)
                ll.add(qlmuon.get(i));
        }
        tm3.setRowCount(0);
        for(BangQuanLy i:ll)
            tm3.addRow(i.toObject());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextArea1.setText("Ma DG\tten DG\tSo luong\n");
        jTextArea1.append(docgiaVaSoluong());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void combocnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combocnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbq1;
    private javax.swing.JButton btbq2;
    private javax.swing.JButton btbq3;
    private javax.swing.JButton btcn1;
    private javax.swing.JButton btcn2;
    private javax.swing.JButton btcn3;
    private javax.swing.JButton btluu1;
    private javax.swing.JButton btluu2;
    private javax.swing.JButton btluu3;
    private javax.swing.JButton btsua1;
    private javax.swing.JButton btsua2;
    private javax.swing.JButton btsua3;
    private javax.swing.JButton btthem1;
    private javax.swing.JButton btthem2;
    private javax.swing.JButton btthem3;
    private javax.swing.JButton btxoa1;
    private javax.swing.JButton btxoa2;
    private javax.swing.JButton btxoa3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combocn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
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
