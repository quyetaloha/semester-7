
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
import model.Reader;
import model.BorrowingTable;
import model.Book;


public class Main extends javax.swing.JFrame {
    enum State {
        normal,
        addReader,
        editReader,
        addBook,
        editBook,
        addBorrow,
        editBorrow,
    }
    private State state;
    private ArrayList<Book> listbook = new ArrayList<>();
    private ArrayList<Reader> listreader = new ArrayList<>();
    private ArrayList<BorrowingTable> listborrow = new ArrayList<>();
    DefaultTableModel tm1,tm2,tm3;
    public Main() {
        initComponents();
        tm1=(DefaultTableModel)jTable1.getModel();
        tm2=(DefaultTableModel)jTable2.getModel();
        tm3=(DefaultTableModel)jTable3.getModel();
        changeState(State.normal);
        IOFile.readFile(listbook,"book.dat");
        IOFile.readFile(listreader,"reader.dat");
        IOFile.readFile(listborrow,"borrowing.dat");
        displayReader();
        displayBook();
        displayBorrowTable();
        refresh2Code();
        
    }
    
    private void changeState(State state){
        this.state = state;
        if(state == State.normal){
            btupdate1.setEnabled(false);
            btcancel1.setEnabled(false);
            btupdate2.setEnabled(false);
            btcancel2.setEnabled(false);
            btupdate3.setEnabled(false);
            btcancel3.setEnabled(false);
            btadd1.setEnabled(true);
            btedit1.setEnabled(true);
            btremove1.setEnabled(true);
            btsave1.setEnabled(true);
            btadd2.setEnabled(true);
            btedit2.setEnabled(true);
            btremove2.setEnabled(true);
            btsave2.setEnabled(true);
            btadd3.setEnabled(true);
            btedit3.setEnabled(true);
            btremove3.setEnabled(true);
            btsave3.setEnabled(true);
        }
        else if((state == State.addReader)||(state == State.editReader)){
            btadd1.setEnabled(false);
            btedit1.setEnabled(false);
            btremove1.setEnabled(false);
            btsave1.setEnabled(false);
            btupdate1.setEnabled(true);
            btcancel1.setEnabled(true);
        }
        else if((state == State.addBook)||(state == State.editBook)){
            btadd2.setEnabled(false);
            btedit2.setEnabled(false);
            btremove2.setEnabled(false);
            btsave2.setEnabled(false);
            btupdate2.setEnabled(true);
            btcancel2.setEnabled(true);
        }
        else if((state == State.addBorrow)||(state == State.editBorrow)){
            btadd3.setEnabled(false);
            btedit3.setEnabled(false);
            btremove3.setEnabled(false);
            btsave3.setEnabled(false);
            btupdate3.setEnabled(true);
            btcancel3.setEnabled(true);
        }
    }
    private void displayBook(){
        tm2.setRowCount(0);
        for(Book i : listbook){
            tm2.addRow(i.toObject());
        }
    }
    private void displayReader(){
        tm1.setRowCount(0);
        for(Reader i : listreader){
            tm1.addRow(i.toObject());
        }
    }
    private void displayBorrowTable(){
        tm3.setRowCount(0);
        for(BorrowingTable i : listborrow){
            tm3.addRow(i.toObject());
        }
    }
    private void refresh2Code(){
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        for(Reader i : listreader){
            jComboBox1.addItem(Integer.toString(i.getCode()));
        }
        for(Book i : listbook){
            jComboBox2.addItem(Integer.toString(i.getCode()));
        }        
    }
    private Reader searchReader(int code){
        for(int i=0;i<listreader.size();i++)
            if(listreader.get(i).getCode()==code)
                return listreader.get(i);
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
        btadd1 = new javax.swing.JButton();
        btedit1 = new javax.swing.JButton();
        btremove1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        btupdate1 = new javax.swing.JButton();
        btcancel1 = new javax.swing.JButton();
        btsave1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btadd2 = new javax.swing.JButton();
        btedit2 = new javax.swing.JButton();
        btremove2 = new javax.swing.JButton();
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
        btupdate2 = new javax.swing.JButton();
        btcancel2 = new javax.swing.JButton();
        btsave2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btadd3 = new javax.swing.JButton();
        btedit3 = new javax.swing.JButton();
        btremove3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        btupdate3 = new javax.swing.JButton();
        btcancel3 = new javax.swing.JButton();
        btsave3 = new javax.swing.JButton();
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
                "Reader code", "Full name", "Address", "Phone number"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btadd1.setText("Add new");
        btadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btadd1ActionPerformed(evt);
            }
        });

        btedit1.setText("Edit");
        btedit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btedit1ActionPerformed(evt);
            }
        });

        btremove1.setText("Remove");
        btremove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btremove1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Reader code");

        jLabel2.setText("Full name");

        jLabel3.setText("Address");

        jLabel4.setText("Phone number");

        jTextField1.setEditable(false);

        btupdate1.setText("Update");
        btupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdate1ActionPerformed(evt);
            }
        });

        btcancel1.setText("Cancel");
        btcancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancel1ActionPerformed(evt);
            }
        });

        btsave1.setText("Save to file");
        btsave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsave1ActionPerformed(evt);
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
                                .addComponent(btcancel1)
                                .addComponent(btupdate1))
                            .addGap(30, 30, 30)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btadd1)
                        .addGap(27, 27, 27)
                        .addComponent(btedit1)
                        .addGap(28, 28, 28)
                        .addComponent(btremove1)
                        .addGap(31, 31, 31)
                        .addComponent(btsave1)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btadd1)
                    .addComponent(btedit1)
                    .addComponent(btremove1)
                    .addComponent(btsave1))
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
                        .addComponent(btupdate1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btcancel1)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Reader", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book code", "Book title", "Author", "Book field", "published year", "Numbers"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btadd2.setText("Add new");
        btadd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btadd2ActionPerformed(evt);
            }
        });

        btedit2.setText("Edit");
        btedit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btedit2ActionPerformed(evt);
            }
        });

        btremove2.setText("Remove");
        btremove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btremove2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Book code");

        jLabel6.setText("Book title");

        jLabel7.setText("Author");

        jLabel8.setText("Book field");

        jLabel9.setText("Pulished year");

        jLabel10.setText("Numbers");

        jTextField5.setEditable(false);

        combocn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural Sciences", "literary arts", "Electronics and Telecommunication", "computer science" }));

        btupdate2.setText("Update");
        btupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdate2ActionPerformed(evt);
            }
        });

        btcancel2.setText("Cancel");
        btcancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancel2ActionPerformed(evt);
            }
        });

        btsave2.setText("Save to file");
        btsave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsave2ActionPerformed(evt);
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
                                .addComponent(btadd2)
                                .addGap(27, 27, 27)
                                .addComponent(btedit2)
                                .addGap(47, 47, 47)
                                .addComponent(btremove2)
                                .addGap(37, 37, 37)
                                .addComponent(btsave2)
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
                            .addComponent(btupdate2)
                            .addComponent(btcancel2))
                        .addContainerGap(272, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btadd2)
                    .addComponent(btedit2)
                    .addComponent(btremove2)
                    .addComponent(btsave2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btupdate2)))
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
                        .addComponent(btcancel2)))
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

        jTabbedPane1.addTab("Book", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reader code", "Reader name", "Book code", "Book title", "nums", "Status"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        btadd3.setText("Add new");
        btadd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btadd3ActionPerformed(evt);
            }
        });

        btedit3.setText("Edit");
        btedit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btedit3ActionPerformed(evt);
            }
        });

        btremove3.setText("Remove");
        btremove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btremove3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Reader code");

        jLabel12.setText("Book code");

        jLabel13.setText("Number");

        jLabel14.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btupdate3.setText("Update");
        btupdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdate3ActionPerformed(evt);
            }
        });

        btcancel3.setText("Cancel");
        btcancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancel3ActionPerformed(evt);
            }
        });

        btsave3.setText("Save to file");
        btsave3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsave3ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), null), "Sorting", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 0, 255))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Reader name");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Numbers");

        jButton1.setText("Sort");
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

        jLabel15.setText("Reader name");

        jButton2.setText("Search");
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
                                    .addComponent(btadd3)
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
                                    .addComponent(btedit3)))
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
                                .addComponent(btremove3)
                                .addGap(58, 58, 58)
                                .addComponent(btsave3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btcancel3)
                                    .addComponent(btupdate3))))))
                .addContainerGap(56, Short.MAX_VALUE))
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
                                .addComponent(btadd3)
                                .addComponent(btedit3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btremove3)
                                .addComponent(btsave3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btupdate3)
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
                                .addComponent(btcancel3)))
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

        jTabbedPane1.addTab("Borrowing Book", jPanel3);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jButton3.setText("Sum of Books by Book code");
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
                .addContainerGap(189, Short.MAX_VALUE))
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

        jTabbedPane1.addTab("More", jPanel4);

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

    private void btadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btadd1ActionPerformed
        changeState(State.addReader);
        int code = listreader.size()+10000;
        while(true){
            if(searchReader(code)==null){
               jTextField1.setText(code+"");
               break;               
            }
            code++;
        }
    }//GEN-LAST:event_btadd1ActionPerformed
    private void removeReader(){
        int check = jTable1.getSelectedRow();
        if(check < 0 || check > jTable1.getRowCount()||(jTable1.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"Select reader to remove!");
        } else {           
            listreader.remove(check);
            displayReader();                   
        }
    }
    private Reader newReader(){
        Reader r = null;
        try{
            String name = jTextField2.getText(),
                   address = jTextField3.getText();
            long phone = Long.parseLong(jTextField4.getText());
            if(name.equals("") || address.equals("")){
                JOptionPane.showMessageDialog(this,"not blank!");
            } else if(phone < 0 ){
                JOptionPane.showMessageDialog(this,"phone is number!");
            }else {
                int code = Integer.parseInt(jTextField1.getText());
                r = new Reader(code,name, address, phone);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Dien thoai phai la so!");
        }
        return r;
    }
    private void addReader(){
        Reader r = newReader();
        if(r != null){
            listreader.add(r);
            displayReader();
        }
    }
    
    private void editReader(){
        int check = jTable1.getSelectedRow();        
            Reader r = newReader();
            listreader.set(check, r);
            displayReader();           
    }
    private Book searchBook(int code){
        for(int i=0;i<listbook.size();i++)
            if(listbook.get(i).getCode()==code)
                return listbook.get(i);
        return null;
    }
    private void removeBook(){
        int check = jTable2.getSelectedRow();
        if(check < 0 || check > jTable2.getRowCount()||(jTable2.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"Select book to remove!");
        } else {           
            listbook.remove(check);
            displayBook();                   
        }
    }
    private Book newBook(){
        Book b = null;
        try{
            String title = jTextField6.getText(),
                   author = jTextField7.getText() ;
            String field=combocn.getSelectedItem().toString();
            int year = Integer.parseInt(jTextField8.getText());
            int number = Integer.parseInt(jTextField9.getText());
            if(title.equals("") || author.equals("")){
                JOptionPane.showMessageDialog(this,"not blank!");
            } else if((year < 0) || (number<0) ){
                JOptionPane.showMessageDialog(this,"Published year and Numbers are the number!");
            }else {
                int code = Integer.parseInt(jTextField5.getText());
                b = new Book(code, title, author, field, year, number);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Published year and Numbers are the number!");
        }
        return b;
    }
    private void addBook(){
        Book b = newBook();
        if(b != null){
            listbook.add(b);
            displayBook();
        }
    }
    
    private void editBook(){
        int check = jTable2.getSelectedRow();        
            Book b = newBook();
            listbook.set(check, b);
            displayBook();           
    }
    private void removeBorrowing(){
        int check = jTable3.getSelectedRow();
        if(check < 0 || check > jTable3.getRowCount()||(jTable3.getRowCount()==0)){
            JOptionPane.showMessageDialog(this,"hay chon dong de xoa!");
        } else {
                listborrow.remove(check);                
                displayBorrowTable();            
            }        
    }
    private boolean isBorrowing(int readercode, int bookcode){
        for(BorrowingTable i:listborrow){
            if((i.getCodeBook()==readercode)&&(i.getCodeBook()==bookcode))
                return true;
        }
        return false;
    }
    private BorrowingTable newBorrowing(){
        BorrowingTable br = null;
        int readercode=0, bookcode=0;
        try{ 
            readercode = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            bookcode = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            System.out.println(jComboBox1.getSelectedIndex());
            if(isBorrowing(readercode, bookcode)){
                JOptionPane.showMessageDialog(this,"2 codes have exsited!");
                return null;
            }
            int num = Integer.parseInt(jTextField10.getText());
            if(num < 0){
                JOptionPane.showMessageDialog(this,"number is non negative integer!");                
            } else if(num > 3){
                JOptionPane.showMessageDialog(this,"not allowed to borrow greater than 3 books!");
            } else {
                String status="";
                status=jTextField11.getText();
                
                br = new BorrowingTable(searchReader(readercode),
                        searchBook(bookcode),num, status);
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(this,"input invalid data!");
        }
        return br;
    }
    private void addBorrowing(){
        BorrowingTable br = newBorrowing();
        if(br != null){
            listborrow.add(br);
            displayBorrowTable();           
        }        
    }

    private void editBorrowing(){
        int check = jTable3.getSelectedRow();        
            BorrowingTable br = newBorrowing();
            if(br == null){
                return ;
            } else {
                listborrow.set(check, br);
                displayBorrowTable();              
            }
    }
    private void btedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btedit1ActionPerformed
        if(jTable1.getSelectedRow() >= 0){
                changeState(State.editReader);
            } else{
                JOptionPane.showMessageDialog(this,"Select a reader for edit!");
            }
    }//GEN-LAST:event_btedit1ActionPerformed

    private void btremove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btremove1ActionPerformed
        removeReader();
        refresh2Code();
    }//GEN-LAST:event_btremove1ActionPerformed

    private void btupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdate1ActionPerformed
        if(state==State.addReader)
           addReader();
        else if(state==State.editReader)
            editReader();
        refresh2Code();
        changeState(State.normal);
    }//GEN-LAST:event_btupdate1ActionPerformed

    private void btcancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancel3ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btcancel3ActionPerformed

    private void btsave3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsave3ActionPerformed
        IOFile.writeFile(listborrow, "borrowing.dat");
    }//GEN-LAST:event_btsave3ActionPerformed

    private void btsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsave1ActionPerformed
        IOFile.writeFile(listreader, "reader.dat");
    }//GEN-LAST:event_btsave1ActionPerformed

    private void btsave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsave2ActionPerformed
        IOFile.writeFile(listbook, "book.dat");
    }//GEN-LAST:event_btsave2ActionPerformed

    private void btadd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btadd2ActionPerformed
        changeState(State.addBook);
        int code = listbook.size()+10000;
        while(true){
            if(searchBook(code)==null){
               jTextField5.setText(code+"");
               break;               
            }
            code++;
        }
    }//GEN-LAST:event_btadd2ActionPerformed

    private void btedit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btedit2ActionPerformed
        if(jTable2.getSelectedRow() >= 0){
                changeState(State.editBook);
            } else{
                JOptionPane.showMessageDialog(this,"Select a book to edit!");
            }
    }//GEN-LAST:event_btedit2ActionPerformed

    private void btremove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btremove2ActionPerformed
        removeBook();
        refresh2Code();
    }//GEN-LAST:event_btremove2ActionPerformed

    private void btupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdate2ActionPerformed
        if(state==State.addBook)
           addBook();
        else if(state==State.editBook)
            editBook();
        changeState(State.normal);
        refresh2Code();
    }//GEN-LAST:event_btupdate2ActionPerformed

    private void btcancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancel1ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btcancel1ActionPerformed

    private void btcancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancel2ActionPerformed
        changeState(State.normal);
    }//GEN-LAST:event_btcancel2ActionPerformed

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

    private void btadd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btadd3ActionPerformed
        changeState(State.addBorrow);
    }//GEN-LAST:event_btadd3ActionPerformed

    private void btedit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btedit3ActionPerformed
        if(jTable3.getSelectedRow() >= 0){
                changeState(State.editBorrow);
            } else{
                JOptionPane.showMessageDialog(this,"Select a line to remove!");
            }
    }//GEN-LAST:event_btedit3ActionPerformed

    private void btremove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btremove3ActionPerformed
        removeBorrowing();
    }//GEN-LAST:event_btremove3ActionPerformed

    private void btupdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdate3ActionPerformed
        if(state==State.addBorrow)
           addBorrowing();
        else if(state==State.editBorrow)
            editBorrowing();
        changeState(State.normal);
    }//GEN-LAST:event_btupdate3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int check = jTable3.getSelectedRow();
        jComboBox1.setSelectedItem(tm3.getValueAt(check, 0).toString());
        jComboBox2.setSelectedItem(tm3.getValueAt(check, 2).toString());
        jTextField10.setText(tm3.getValueAt(check, 4).toString());
        jTextField11.setText(tm3.getValueAt(check, 5).toString());
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            Collections.sort(listborrow,new Comparator<BorrowingTable>(){
                @Override
                public int compare(BorrowingTable o1, BorrowingTable o2) {
                    return o1.getNameReader().compareToIgnoreCase(
                            o2.getNameReader());
                }
                
            });
        }else{
            Collections.sort(listborrow,new Comparator<BorrowingTable>() {
                @Override
                public int compare(BorrowingTable o1, BorrowingTable o2) {
                    return o2.getNums()-o1.getNums();
                }
            });
        }
        tm3.setRowCount(0);
        for(BorrowingTable b:listborrow)
            tm3.addRow(b.toObject());
    }//GEN-LAST:event_jButton1ActionPerformed

    private HashSet<Integer> groupReader(){
        HashSet<Integer> ll=new HashSet<>();
        for (int i = 0; i < listborrow.size(); i++) {
            ll.add(listborrow.get(i).getCodeReader());
        }
        return ll;
    }
    private String readerAndNumber(){
        String re="";
        HashSet<Integer> year=groupReader();
        Iterator i=year.iterator();
        int n;
        String name="";
        while(i.hasNext()) {
            int sum=0;
            n=Integer.parseInt(i.next().toString());
            for (int j = 0; j < listborrow.size(); j++) { 
               if((listborrow.get(j).getCodeReader())==n){
                   sum+=listborrow.get(j).getNums();
                   name=listborrow.get(j).getNameReader();
               }
        }
            re+=n+"\t"+name+"\t"+sum+"\n";
        }
        return re;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<BorrowingTable> ll=new ArrayList<>();
        String name=jTextField12.getText();
        for (int i = 0; i < listborrow.size(); i++) {
            if(listborrow.get(i).getNameReader().indexOf(name)>=0)
                ll.add(listborrow.get(i));
        }
        tm3.setRowCount(0);
        for(BorrowingTable i:ll)
            tm3.addRow(i.toObject());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextArea1.setText("Reader code\tReader name\tnumbers\n");
        jTextArea1.append(readerAndNumber());
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton btadd1;
    private javax.swing.JButton btadd2;
    private javax.swing.JButton btadd3;
    private javax.swing.JButton btcancel1;
    private javax.swing.JButton btcancel2;
    private javax.swing.JButton btcancel3;
    private javax.swing.JButton btedit1;
    private javax.swing.JButton btedit2;
    private javax.swing.JButton btedit3;
    private javax.swing.JButton btremove1;
    private javax.swing.JButton btremove2;
    private javax.swing.JButton btremove3;
    private javax.swing.JButton btsave1;
    private javax.swing.JButton btsave2;
    private javax.swing.JButton btsave3;
    private javax.swing.JButton btupdate1;
    private javax.swing.JButton btupdate2;
    private javax.swing.JButton btupdate3;
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
