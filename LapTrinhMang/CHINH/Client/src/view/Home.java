package view;

import controller.ClientControl;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.Nguoi;
import model.NguoiDung;
import model.Phong;
import controller.Key;
import static controller.Key.UPDATE_P_ND;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame implements Key, Runnable {

    private NguoiDung nguoiDung;
    private Phong phong;
    private ClientControl c;
    private DefaultListModel<Phong> modelPHONG;
    private DefaultListModel<Nguoi> modelBANBE;
    private DefaultListModel<Nguoi> modelTOP_SERVER;

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public Home(NguoiDung nguoiDung) {
        //tao icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.jpeg")));
        this.setTitle("Game Caro (" + nguoiDung.getName() + ")");
        //tao cac doi tuong can thiet
        this.nguoiDung = nguoiDung;

        c = new ClientControl(nguoiDung);
        //set danh sach phong da tao
        modelPHONG = new DefaultListModel<>();
        setListPhongTT();
        //set danh sach ban be
        modelBANBE = new DefaultListModel<>();
        setListBanBe();
        //set danh sach TOP
        modelTOP_SERVER = new DefaultListModel<>();
        setDsTopServer();
        //init
        initComponents();
        ssButton.setVisible(false);
        dangXuatNd(this);
        dangXuatNd(this.playGame);
        //set thong tin nguoi dung
        avatarNguoiDungLabel.setIcon(new ImageIcon(getClass().getResource("/img/" + nguoiDung.getAvata())));
        listPhong.setCellRenderer(new PhongRenderer());
        listTopServer.setCellRenderer(new TopRenderer());
        listFriends.setCellRenderer(new BanBeRenderer());
        nameNguoiDung.setText(nguoiDung.getName());
        diemNguoiDungLabel.setText("Điểm: " + String.valueOf(nguoiDung.getDiem()));
        tienNguoiDungLabel.setText(String.valueOf(nguoiDung.getTien()));
        ssButton.setVisible(false);
        moiButton.setVisible(false);
        listFriends.setComponentPopupMenu(popupMenuFriends);
        listTopServer.setComponentPopupMenu(popupMenuTopServer);

        Thread myThread = new Thread(this);
        myThread.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playGame = new javax.swing.JFrame();
        nguoiChoi1 = new javax.swing.JPanel();
        avatarNguoiChoi1 = new javax.swing.JLabel();
        tenNguoiChoi1 = new javax.swing.JLabel();
        hangNguoiChoi1 = new javax.swing.JLabel();
        nguoiChoi2 = new javax.swing.JPanel();
        avatarNguoiChoi2 = new javax.swing.JLabel();
        tenNguoiChoi2 = new javax.swing.JLabel();
        hangNguoiChoi2 = new javax.swing.JLabel();
        screen = new javax.swing.JPanel();
        mucTien = new javax.swing.JLabel();
        idPhong = new javax.swing.JLabel();
        roiPhongButton = new javax.swing.JButton();
        themBanBeButton = new javax.swing.JButton();
        moiBanBeButton = new javax.swing.JButton();
        ssButton = new javax.swing.JButton();
        thongTinNguoiDung = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        avatarInf = new javax.swing.JButton();
        idInf = new javax.swing.JLabel();
        nameInf = new javax.swing.JLabel();
        loaiHangInf = new javax.swing.JLabel();
        xepHangInf = new javax.swing.JLabel();
        diemInfo = new javax.swing.JLabel();
        danhSachBanBe = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        listFriends = new javax.swing.JList<>();
        moiButton = new javax.swing.JButton();
        danhSachTopServer = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTopServer = new javax.swing.JList<>();
        popupMenuTopServer = new javax.swing.JPopupMenu();
        xemThongTinTop = new javax.swing.JMenuItem();
        popupMenuFriends = new javax.swing.JPopupMenu();
        xemThongTinBB = new javax.swing.JMenuItem();
        xoaBB = new javax.swing.JMenuItem();
        refreshBB = new javax.swing.JMenuItem();
        ntBB = new javax.swing.JMenuItem();
        showAvatar = new javax.swing.JFrame();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        taoPhong = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        screenPlay = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        diemNguoiDungLabel = new javax.swing.JLabel();
        tienNguoiDungLabel = new javax.swing.JLabel();
        nameNguoiDung = new javax.swing.JLabel();
        avatarNguoiDungLabel = new javax.swing.JLabel();
        layertop = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        topButton = new javax.swing.JToggleButton();
        settingButton = new javax.swing.JToggleButton();
        thongTinButton = new javax.swing.JToggleButton();
        listFriendButton = new javax.swing.JToggleButton();
        jButton5 = new javax.swing.JButton();
        backgroundl = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPhong = new javax.swing.JList<>();
        taoPhongButton = new javax.swing.JButton();
        vaoPhongButton = new javax.swing.JButton();
        backgroundright = new javax.swing.JLabel();

        playGame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        playGame.setTitle("Cờ caro");
        playGame.setLocation(new java.awt.Point(100, 50));
        playGame.setMinimumSize(new java.awt.Dimension(1090, 570));
        playGame.setResizable(false);

        nguoiChoi1.setBackground(new java.awt.Color(51, 0, 255));

        tenNguoiChoi1.setText("Tên: ");

        hangNguoiChoi1.setText("Loại hang: ");

        javax.swing.GroupLayout nguoiChoi1Layout = new javax.swing.GroupLayout(nguoiChoi1);
        nguoiChoi1.setLayout(nguoiChoi1Layout);
        nguoiChoi1Layout.setHorizontalGroup(
            nguoiChoi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiChoi1Layout.createSequentialGroup()
                .addGroup(nguoiChoi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nguoiChoi1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(nguoiChoi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hangNguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenNguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(nguoiChoi1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(avatarNguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        nguoiChoi1Layout.setVerticalGroup(
            nguoiChoi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiChoi1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(avatarNguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(tenNguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hangNguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nguoiChoi2.setBackground(new java.awt.Color(51, 51, 255));

        tenNguoiChoi2.setText("Tên:");

        hangNguoiChoi2.setText("Loại hạng: ");

        javax.swing.GroupLayout nguoiChoi2Layout = new javax.swing.GroupLayout(nguoiChoi2);
        nguoiChoi2.setLayout(nguoiChoi2Layout);
        nguoiChoi2Layout.setHorizontalGroup(
            nguoiChoi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiChoi2Layout.createSequentialGroup()
                .addGroup(nguoiChoi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nguoiChoi2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(avatarNguoiChoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nguoiChoi2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(nguoiChoi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hangNguoiChoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tenNguoiChoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        nguoiChoi2Layout.setVerticalGroup(
            nguoiChoi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiChoi2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(avatarNguoiChoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(tenNguoiChoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hangNguoiChoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mucTien.setText("Mức tiền: ");

        idPhong.setText("ID Phòng: ");

        roiPhongButton.setText("Rời phòng");
        roiPhongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roiPhongButtonActionPerformed(evt);
            }
        });

        themBanBeButton.setText("Thêm bạn");
        themBanBeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBanBeButtonActionPerformed(evt);
            }
        });

        moiBanBeButton.setText("Mời bạn");
        moiBanBeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moiBanBeButtonActionPerformed(evt);
            }
        });

        ssButton.setText("Bắt đầu");
        ssButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout screenLayout = new javax.swing.GroupLayout(screen);
        screen.setLayout(screenLayout);
        screenLayout.setHorizontalGroup(
            screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(screenLayout.createSequentialGroup()
                        .addComponent(moiBanBeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(themBanBeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(screenLayout.createSequentialGroup()
                        .addGroup(screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(mucTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(155, 155, 155)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(roiPhongButton)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ssButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        screenLayout.setVerticalGroup(
            screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(idPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(mucTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(ssButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roiPhongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themBanBeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moiBanBeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout playGameLayout = new javax.swing.GroupLayout(playGame.getContentPane());
        playGame.getContentPane().setLayout(playGameLayout);
        playGameLayout.setHorizontalGroup(
            playGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playGameLayout.createSequentialGroup()
                .addComponent(nguoiChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nguoiChoi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        playGameLayout.setVerticalGroup(
            playGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nguoiChoi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nguoiChoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        thongTinNguoiDung.setBackground(new java.awt.Color(102, 255, 102));
        thongTinNguoiDung.setLocation(new java.awt.Point(122, 220));
        thongTinNguoiDung.setMinimumSize(new java.awt.Dimension(260, 400));
        thongTinNguoiDung.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        avatarInf.setPreferredSize(new java.awt.Dimension(80, 80));
        avatarInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatarInfActionPerformed(evt);
            }
        });

        idInf.setText("ID");

        nameInf.setText("Name");

        loaiHangInf.setText("Loai Hang");

        xepHangInf.setText("Xep hang");

        diemInfo.setText("Diem");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idInf)
                    .addComponent(nameInf)
                    .addComponent(loaiHangInf)
                    .addComponent(xepHangInf)
                    .addComponent(diemInfo))
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(avatarInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(idInf)
                .addGap(18, 18, 18)
                .addComponent(nameInf)
                .addGap(18, 18, 18)
                .addComponent(loaiHangInf)
                .addGap(18, 18, 18)
                .addComponent(xepHangInf)
                .addGap(18, 18, 18)
                .addComponent(diemInfo)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(avatarInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(309, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout thongTinNguoiDungLayout = new javax.swing.GroupLayout(thongTinNguoiDung.getContentPane());
        thongTinNguoiDung.getContentPane().setLayout(thongTinNguoiDungLayout);
        thongTinNguoiDungLayout.setHorizontalGroup(
            thongTinNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        thongTinNguoiDungLayout.setVerticalGroup(
            thongTinNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        danhSachBanBe.setTitle("Bạn bè");
        danhSachBanBe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        danhSachBanBe.setFocusableWindowState(false);
        danhSachBanBe.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/friends.png")));
        danhSachBanBe.setLocation(new java.awt.Point(122, 220));
        danhSachBanBe.setMinimumSize(new java.awt.Dimension(260, 400));
        danhSachBanBe.setResizable(false);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listFriends.setModel(modelBANBE);
        listFriends.setAlignmentX(1.0F);
        listFriends.setAlignmentY(1.0F);
        jScrollPane3.setViewportView(listFriends);

        moiButton.setText("Mời");
        moiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout danhSachBanBeLayout = new javax.swing.GroupLayout(danhSachBanBe.getContentPane());
        danhSachBanBe.getContentPane().setLayout(danhSachBanBeLayout);
        danhSachBanBeLayout.setHorizontalGroup(
            danhSachBanBeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, danhSachBanBeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        danhSachBanBeLayout.setVerticalGroup(
            danhSachBanBeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, danhSachBanBeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        danhSachTopServer.setTitle("Top");
        danhSachTopServer.setFocusableWindowState(false);
        danhSachTopServer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/top.png")));
        danhSachTopServer.setLocation(new java.awt.Point(122, 220));
        danhSachTopServer.setMinimumSize(new java.awt.Dimension(260, 400));
        danhSachTopServer.setResizable(false);
        danhSachTopServer.setType(java.awt.Window.Type.UTILITY);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listTopServer.setModel(modelTOP_SERVER);
        jScrollPane2.setViewportView(listTopServer);

        javax.swing.GroupLayout danhSachTopServerLayout = new javax.swing.GroupLayout(danhSachTopServer.getContentPane());
        danhSachTopServer.getContentPane().setLayout(danhSachTopServerLayout);
        danhSachTopServerLayout.setHorizontalGroup(
            danhSachTopServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        danhSachTopServerLayout.setVerticalGroup(
            danhSachTopServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        xemThongTinTop.setText("Xem thông tin");
        xemThongTinTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemThongTinTopActionPerformed(evt);
            }
        });
        popupMenuTopServer.add(xemThongTinTop);

        xemThongTinBB.setText("Xem thông tin");
        xemThongTinBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemThongTinBBActionPerformed(evt);
            }
        });
        popupMenuFriends.add(xemThongTinBB);

        xoaBB.setText("Xóa");
        xoaBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaBBActionPerformed(evt);
            }
        });
        popupMenuFriends.add(xoaBB);

        refreshBB.setText("Refresh");
        refreshBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBBActionPerformed(evt);
            }
        });
        popupMenuFriends.add(refreshBB);

        ntBB.setText("Nhắn tin");
        ntBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntBBActionPerformed(evt);
            }
        });
        popupMenuFriends.add(ntBB);

        showAvatar.setTitle("Avatar");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);

        buttonGroup1.add(jRadioButton4);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nguoiSoi1.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nguoiSat1.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cap1.png"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/luky1.png"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 60));

        jButton1.setText("Chọn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showAvatarLayout = new javax.swing.GroupLayout(showAvatar.getContentPane());
        showAvatar.getContentPane().setLayout(showAvatarLayout);
        showAvatarLayout.setHorizontalGroup(
            showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAvatarLayout.createSequentialGroup()
                .addGroup(showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showAvatarLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jRadioButton1)
                        .addGap(48, 48, 48)
                        .addGroup(showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showAvatarLayout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(55, 55, 55)
                                .addComponent(jRadioButton3)
                                .addGap(62, 62, 62)
                                .addComponent(jRadioButton4))
                            .addGroup(showAvatarLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(showAvatarLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        showAvatarLayout.setVerticalGroup(
            showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAvatarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(showAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        taoPhong.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        taoPhong.setTitle("Cờ caro");
        taoPhong.setLocation(new java.awt.Point(100, 50));
        taoPhong.setMinimumSize(new java.awt.Dimension(400, 300));
        taoPhong.setResizable(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Tạo phòng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Mức tiền:");

        jButton2.setText("Tạo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setSelected(true);
        jRadioButton5.setText("100");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("200");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("500");

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("1000");

        javax.swing.GroupLayout taoPhongLayout = new javax.swing.GroupLayout(taoPhong.getContentPane());
        taoPhong.getContentPane().setLayout(taoPhongLayout);
        taoPhongLayout.setHorizontalGroup(
            taoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taoPhongLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(taoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taoPhongLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taoPhongLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton8)
                        .addGap(54, 54, 54))))
            .addComponent(jSeparator1)
            .addGroup(taoPhongLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        taoPhongLayout.setVerticalGroup(
            taoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taoPhongLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(taoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout screenPlayLayout = new javax.swing.GroupLayout(screenPlay.getContentPane());
        screenPlay.getContentPane().setLayout(screenPlayLayout);
        screenPlayLayout.setHorizontalGroup(
            screenPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPlayLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        screenPlayLayout.setVerticalGroup(
            screenPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(100, 50));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diemNguoiDungLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        diemNguoiDungLabel.setForeground(new java.awt.Color(255, 102, 102));
        diemNguoiDungLabel.setText("diem");
        getContentPane().add(diemNguoiDungLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 42, 60, -1));

        tienNguoiDungLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tienNguoiDungLabel.setForeground(new java.awt.Color(255, 102, 102));
        tienNguoiDungLabel.setText("tien");
        getContentPane().add(tienNguoiDungLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 42, 50, -1));

        nameNguoiDung.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nameNguoiDung.setForeground(new java.awt.Color(255, 102, 102));
        nameNguoiDung.setText("Name");
        getContentPane().add(nameNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 74, 150, 20));

        avatarNguoiDungLabel.setMaximumSize(new java.awt.Dimension(56, 60));
        avatarNguoiDungLabel.setPreferredSize(new java.awt.Dimension(56, 60));
        getContentPane().add(avatarNguoiDungLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 42, -1, -1));

        layertop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/layertop_1.png"))); // NOI18N
        layertop.setOpaque(true);
        getContentPane().add(layertop, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 265, 93));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        backButton.setToolTipText("Đăng xuất");
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 40, 40));

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoi.png"))); // NOI18N
        jToggleButton4.setToolTipText("Hỏi đáp?");
        jToggleButton4.setContentAreaFilled(false);
        getContentPane().add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 40, 40));

        topButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/top.png"))); // NOI18N
        topButton.setToolTipText("Top server");
        topButton.setContentAreaFilled(false);
        topButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topButtonActionPerformed(evt);
            }
        });
        getContentPane().add(topButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 40, 40));

        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/setting.png"))); // NOI18N
        settingButton.setToolTipText("Cài đặt");
        settingButton.setContentAreaFilled(false);
        getContentPane().add(settingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 40, 40));

        thongTinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/infor.png"))); // NOI18N
        thongTinButton.setToolTipText("Thông tin");
        thongTinButton.setContentAreaFilled(false);
        thongTinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongTinButtonActionPerformed(evt);
            }
        });
        getContentPane().add(thongTinButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 40, 40));

        listFriendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/friends.png"))); // NOI18N
        listFriendButton.setToolTipText("Danh sách bạn bè");
        listFriendButton.setContentAreaFilled(false);
        listFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listFriendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(listFriendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 40, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/game1.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 40, 40));

        backgroundl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgroundfeft.png"))); // NOI18N
        backgroundl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        backgroundl.setPreferredSize(new java.awt.Dimension(300, 600));
        getContentPane().add(backgroundl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 570));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        searchButton.setToolTipText("Tìm kiếm");
        searchButton.setContentAreaFilled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 18, 40, 40));

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh2.png"))); // NOI18N
        refreshButton.setToolTipText("Refresh");
        refreshButton.setContentAreaFilled(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 40, 40));

        searchTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        getContentPane().add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 200, 35));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        listPhong.setModel(modelPHONG);
        listPhong.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPhong.setMaximumSize(new java.awt.Dimension(660, 999999999));
        listPhong.setMinimumSize(new java.awt.Dimension(660, 400));
        jScrollPane1.setViewportView(listPhong);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 660, 400));

        taoPhongButton.setText("Tạo phòng");
        taoPhongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taoPhongButtonActionPerformed(evt);
            }
        });
        getContentPane().add(taoPhongButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, 120, 30));

        vaoPhongButton.setText("Vào Phòng");
        vaoPhongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaoPhongButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vaoPhongButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 90, 30));

        backgroundright.setBackground(new java.awt.Color(255, 255, 255));
        backgroundright.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgroundright.png"))); // NOI18N
        backgroundright.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(backgroundright, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void dangXuatNd(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (getPhong() != null) {
                    c.xoaNguoiChoiKhoiDanhSachPhong(getPhong());
                }
                c.dangXuat();
                System.exit(0);
            }
        });
    }

    private void setListPhongTT() {
        ArrayList<Phong> obj = c.getListPhong();
        if (obj != null) {
            for (Phong phong : obj) {
                modelPHONG.addElement(phong);
            }
        }
    }

    private void setListBanBe() {
        ArrayList<Nguoi> obj = c.getDanhSachBanBe();
        if (obj != null) {
            nguoiDung.setDsBanBe(obj);
            for (Nguoi nguoi : obj) {
                modelBANBE.addElement(nguoi);
            }
        }

    }

    private void setDsTopServer() {
        ArrayList<Nguoi> obj = c.getDanhSachTopServer();
        if (obj != null) {
            for (Nguoi nguoi : obj) {
                modelTOP_SERVER.addElement(nguoi);
            }
        }
    }

    private void setThongTinNguoi(Nguoi ng) {
        avatarInf.setIcon(new ImageIcon(getClass().getResource("/img/" + ng.getAvata())));
        idInf.setText("ID:  " + String.valueOf(ng.getIdNguoiDung()));
        nameInf.setText("Name:  " + ng.getName());
        loaiHangInf.setText("Loại hạng:  " + ng.getLoaiHang());
        xepHangInf.setText("Xếp hạng:  " + ng.getXepHang());
        diemInfo.setText("Điểm:  " + ng.getDiem());
    }

    private void loadThongTinPhong(Phong p) {
        mucTien.setText(String.valueOf(p.getSoLuongTienCuoc()));
        idPhong.setText(String.valueOf(p.getIdPhong()));
        ArrayList<Nguoi> dsNguoiChoiTrongPhong = p.getDsNguoiChoi();
        if (dsNguoiChoiTrongPhong.size() == 1) {
            Nguoi nguoi1 = dsNguoiChoiTrongPhong.get(0);
            avatarNguoiChoi1.setIcon(new ImageIcon(getClass().getResource("/img/" + nguoi1.getAvata())));
            tenNguoiChoi1.setText("Tên:  " + nguoi1.getName());
            hangNguoiChoi1.setText("Loại hạng:  " + nguoi1.getLoaiHang());
            avatarNguoiChoi2.setIcon(new ImageIcon());
            tenNguoiChoi2.setText("Tên:  ");
            hangNguoiChoi2.setText("Loại hạng:  ");
            if (nguoi1.getRole() == 1 && nguoiDung.getIdNguoiDung() == nguoi1.getIdNguoiDung()) {
                ssButton.setVisible(true);
            }

        } else if (dsNguoiChoiTrongPhong.size() == 2) {
            Nguoi nguoi1 = dsNguoiChoiTrongPhong.get(0);
            avatarNguoiChoi1.setIcon(new ImageIcon(getClass().getResource("/img/" + nguoi1.getAvata())));
            tenNguoiChoi1.setText("Tên:  " + nguoi1.getName());
            hangNguoiChoi1.setText("Loại hạng:  " + nguoi1.getLoaiHang());

            Nguoi nguoi2 = dsNguoiChoiTrongPhong.get(1);
            avatarNguoiChoi2.setIcon(new ImageIcon(getClass().getResource("/img/" + nguoi2.getAvata())));
            tenNguoiChoi2.setText("Tên:  " + nguoi2.getName());
            hangNguoiChoi2.setText("Loại hạng:  " + nguoi2.getLoaiHang());

            if (nguoiDung.getIdNguoiDung() == nguoi1.getIdNguoiDung() && nguoi1.getRole() == 1) {
                ssButton.setVisible(true);
            } else if (nguoiDung.getIdNguoiDung() == nguoi2.getIdNguoiDung() && nguoi2.getRole() == 1) {
                ssButton.setVisible(true);
            } else {
                ssButton.setVisible(false);
            }
        }
    }

    private void listFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listFriendButtonActionPerformed
        this.danhSachBanBe.setVisible(true);
    }//GEN-LAST:event_listFriendButtonActionPerformed

    private void thongTinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongTinButtonActionPerformed
        setThongTinNguoi(nguoiDung);
        this.thongTinNguoiDung.setVisible(true);

    }//GEN-LAST:event_thongTinButtonActionPerformed

    private void vaoPhongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaoPhongButtonActionPerformed
        int row = listPhong.getSelectedIndex();
        if (row != -1) {
            Phong phong = listPhong.getSelectedValue();
            if (phong.getDsNguoiChoi().size() == 2) {
                JOptionPane.showMessageDialog(this, "Phòng đã đầy!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (getNguoiDung().getTien() < phong.getSoLuongTienCuoc()) {
                JOptionPane.showMessageDialog(this, "Không đủ tiền để tham gia phòng, phòng đầy", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                nguoiDung.setRole(0);
                c.vaoPhong(phong.getIdPhong());
                phong = c.getDuLieuPhong(phong.getIdPhong());
                setPhong(phong);
                loadThongTinPhong(phong);
                this.playGame.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_vaoPhongButtonActionPerformed
    private void topButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topButtonActionPerformed
        this.danhSachTopServer.setVisible(true);
    }//GEN-LAST:event_topButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        c.dangXuat();
        Login l = new Login();
        l.setVisible(true);
        l.setThongTin(nguoiDung.getUsername());
        this.setVisible(false);

    }//GEN-LAST:event_backButtonActionPerformed

    private void avatarInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatarInfActionPerformed
        this.showAvatar.setVisible(true);
    }//GEN-LAST:event_avatarInfActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //khi nguoi dung muon thay doi Avatar
        if (jRadioButton1.isSelected()) {
            nguoiDung.setAvata("nguoiSoi1.png");
        } else if (jRadioButton2.isSelected()) {
            nguoiDung.setAvata("nguoiSat1.png");
        } else if (jRadioButton3.isSelected()) {
            nguoiDung.setAvata("cap1.png");
        } else if (jRadioButton4.isSelected()) {
            nguoiDung.setAvata("luky1.png");
        }
        c.updateNguoiDung();
        modelBANBE.removeAllElements();
        setListBanBe();
        modelTOP_SERVER.removeAllElements();
        setDsTopServer();
        avatarNguoiDungLabel.setIcon(new ImageIcon(getClass().getResource("/img/" + getNguoiDung().getAvata())));
        diemInfo.setText("Điểm:  " + getNguoiDung().getDiem());
        loaiHangInf.setText("Loại hạng:  " + getNguoiDung().getLoaiHang());
        xepHangInf.setText("Xếp hạng:  " + getNguoiDung().getXepHang());
        avatarInf.setIcon(new ImageIcon(getClass().getResource("/img/" + getNguoiDung().getAvata())));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //tim kiem phong theo ma phong
        int maP = Integer.valueOf(searchTextField.getText());
        if (maP != 0 && c.timKiemPhong(maP) != null) {
            modelPHONG.removeAllElements();
            modelPHONG.addElement(c.timKiemPhong(maP));
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy", "Thống báo", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void taoPhongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taoPhongButtonActionPerformed
        taoPhong.setVisible(true);
    }//GEN-LAST:event_taoPhongButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //khi nguoi dung tao phong, thi su kien duoc thuc hien
        int giaTien;
        if (jRadioButton5.isSelected()) {
            giaTien = 100;
        } else if (jRadioButton6.isSelected()) {
            giaTien = 200;
        } else if (jRadioButton7.isSelected()) {
            giaTien = 500;
        } else {
            giaTien = 1000;
        }
        Phong phong = c.taoPhong(giaTien);
        setPhong(phong);
        if (phong != null) {
            taoPhong.setVisible(false);
            loadThongTinPhong(getPhong());
            this.playGame.setVisible(true);
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(this, "Servr quá tải", "Thống báo", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void roiPhongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roiPhongButtonActionPerformed
        c.xoaNguoiChoiKhoiDanhSachPhong(getPhong());
        modelPHONG.removeAllElements();
        setListPhongTT();
        this.playGame.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_roiPhongButtonActionPerformed

    private void xemThongTinTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemThongTinTopActionPerformed
        int row = listTopServer.getSelectedIndex();
        if (row != -1) {
            Nguoi topServer = listTopServer.getSelectedValue();
            setThongTinNguoi(topServer);
            this.thongTinNguoiDung.setVisible(true);
        }

    }//GEN-LAST:event_xemThongTinTopActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        //Refresh lai danh sach phong dang co
        modelPHONG.removeAllElements();
        setListPhongTT();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void xemThongTinBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemThongTinBBActionPerformed
        int row = listFriends.getSelectedIndex();
        if (row != -1) {
            Nguoi topServer = listFriends.getSelectedValue();
            setThongTinNguoi(topServer);
            this.thongTinNguoiDung.setVisible(true);
        }
    }//GEN-LAST:event_xemThongTinBBActionPerformed

    private void refreshBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBBActionPerformed
        modelBANBE.removeAllElements();
        setListBanBe();
    }//GEN-LAST:event_refreshBBActionPerformed

    private void xoaBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaBBActionPerformed
        int row = listFriends.getSelectedIndex();
        if (row != -1) {
            Nguoi bbCanXoa = listFriends.getSelectedValue();
            c.xoaBanBe(getNguoiDung().getIdNguoiDung(), bbCanXoa.getIdNguoiDung());
        }
    }//GEN-LAST:event_xoaBBActionPerformed

    private void ntBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntBBActionPerformed
        //goi ra 1 cai jframe chat vs ban ve
    }//GEN-LAST:event_ntBBActionPerformed

    private void moiBanBeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moiBanBeButtonActionPerformed
        Phong phong = c.getDuLieuPhong(getPhong().getIdPhong());
        if (phong.getDsNguoiChoi().size() == 2) {
            JOptionPane.showMessageDialog(this, "Phòng đã đầy không thể mời", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            moiButton.setVisible(true);
            this.danhSachBanBe.setVisible(true);
        }
    }//GEN-LAST:event_moiBanBeButtonActionPerformed

    private void moiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moiButtonActionPerformed
        int row = listFriends.getSelectedIndex();
        if (row != -1) {
            Nguoi banBe = listFriends.getSelectedValue();
            if (banBe.getTinhTrang() == 0) {
                JOptionPane.showMessageDialog(this, "Mời cái cc. Có online đâu mà mời!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Phong p = c.moiBanBeChoiGame(banBe.getIdNguoiDung(), getPhong().getIdPhong());
                if (p != null) {
                    setPhong(p);
                    loadThongTinPhong(getPhong());
                    this.playGame.setVisible(false);
                    this.playGame.setVisible(true);
                    System.out.println("Bạn bè đồng ý vào phòng");
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn bè từ chối lời mời", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_moiButtonActionPerformed

    private void themBanBeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBanBeButtonActionPerformed
        // Thêm người dùng vào danh sách bạn bè
        Nguoi banMuonThem = null;
        ArrayList<Nguoi> dsNguoi = getPhong().getDsNguoiChoi();
        for (Nguoi nguoi : dsNguoi) {
            if (nguoi.getIdNguoiDung() != getNguoiDung().getIdNguoiDung()) {
                banMuonThem = nguoi;
                break;
            }
        }
        if (banMuonThem != null) {
            if (c.themBanBe(banMuonThem.getIdNguoiDung())) {
                JOptionPane.showMessageDialog(this, "Thêm bạn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                modelBANBE.removeAllElements();
                setListBanBe();
            } else {
                JOptionPane.showMessageDialog(this, "Người chơi không đồng y thêm bạn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }


    }//GEN-LAST:event_themBanBeButtonActionPerformed

    private void ssButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssButtonActionPerformed
        //neu chu phong an nut San sang thì thực hiện load vào game
        if (getPhong().getDsNguoiChoi().size() == 2) {
            ChoiGame choiGame = new ChoiGame(getPhong(), getNguoiDung());
            choiGame.setVisible(true);
            //tao luong gui den client yeu cau vao choiGame
            for (Nguoi nguoi : getPhong().getDsNguoiChoi()) {
                if (nguoi.getIdNguoiDung() != nguoiDung.getIdNguoiDung()) {
                    try {
                        Socket sk = new Socket(nguoi.getIpAddress(), 21656);
                        ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
                        oos.writeObject("SanSang");
                        System.out.println((String)ois.readObject());
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }


    }//GEN-LAST:event_ssButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avatarInf;
    private javax.swing.JLabel avatarNguoiChoi1;
    private javax.swing.JLabel avatarNguoiChoi2;
    private javax.swing.JLabel avatarNguoiDungLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundl;
    private javax.swing.JLabel backgroundright;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFrame danhSachBanBe;
    private javax.swing.JFrame danhSachTopServer;
    private javax.swing.JLabel diemInfo;
    private javax.swing.JLabel diemNguoiDungLabel;
    private javax.swing.JLabel hangNguoiChoi1;
    private javax.swing.JLabel hangNguoiChoi2;
    private javax.swing.JLabel idInf;
    private javax.swing.JLabel idPhong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JLabel layertop;
    private javax.swing.JToggleButton listFriendButton;
    private javax.swing.JList<Nguoi> listFriends;
    private javax.swing.JList<Phong> listPhong;
    private javax.swing.JList<Nguoi> listTopServer;
    private javax.swing.JLabel loaiHangInf;
    private javax.swing.JButton moiBanBeButton;
    private javax.swing.JButton moiButton;
    private javax.swing.JLabel mucTien;
    private javax.swing.JLabel nameInf;
    private javax.swing.JLabel nameNguoiDung;
    private javax.swing.JPanel nguoiChoi1;
    private javax.swing.JPanel nguoiChoi2;
    private javax.swing.JMenuItem ntBB;
    private javax.swing.JFrame playGame;
    private javax.swing.JPopupMenu popupMenuFriends;
    private javax.swing.JPopupMenu popupMenuTopServer;
    private javax.swing.JMenuItem refreshBB;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton roiPhongButton;
    private javax.swing.JPanel screen;
    private javax.swing.JFrame screenPlay;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JToggleButton settingButton;
    private javax.swing.JFrame showAvatar;
    private javax.swing.JButton ssButton;
    private javax.swing.JFrame taoPhong;
    private javax.swing.JButton taoPhongButton;
    private javax.swing.JLabel tenNguoiChoi1;
    private javax.swing.JLabel tenNguoiChoi2;
    private javax.swing.JButton themBanBeButton;
    private javax.swing.JToggleButton thongTinButton;
    private javax.swing.JFrame thongTinNguoiDung;
    private javax.swing.JLabel tienNguoiDungLabel;
    private javax.swing.JToggleButton topButton;
    private javax.swing.JButton vaoPhongButton;
    private javax.swing.JMenuItem xemThongTinBB;
    private javax.swing.JMenuItem xemThongTinTop;
    private javax.swing.JLabel xepHangInf;
    private javax.swing.JMenuItem xoaBB;
    // End of variables declaration//GEN-END:variables
    @Override
    public void run() {
        ServerSocket getToServer = null;
        try {
            getToServer = new ServerSocket(21656);
            while (true) {
                Socket socketToServer = getToServer.accept();
                System.out.println(socketToServer);
                ObjectInputStream ois = new ObjectInputStream(socketToServer.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socketToServer.getOutputStream());
                String nhan = (String) ois.readObject();
                if (nhan.equals(UPDATE_P_ND)) {
                    //phong co su thay doi
                    Phong p = (Phong) ois.readObject();
                    setPhong(p);
                    loadThongTinPhong(p);
                    playGame.setVisible(false);
                    playGame.setVisible(true);
                }
                if (nhan.equals("XOA")) {
                    Phong p = (Phong) ois.readObject();
                    setPhong(p);
                    loadThongTinPhong(p);
                    playGame.setVisible(false);
                    playGame.setVisible(true);
                }
                if (nhan.equals("CHOI_CUNG_K")) {
                    String gui;

                    int idP = (int) ois.readObject();
                    NguoiDung banBe = (NguoiDung) ois.readObject();

                    int confirm = JOptionPane.showConfirmDialog(this, banBe.getName() + " mời chơi cùng?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        oos.writeObject(true);
                        gui = "Client đồng ý chơi cùng";
                        System.out.println("Đồng ý chơi cùng,..");
                        oos.writeObject(gui);
                        Phong p = (Phong) ois.readObject();
                        setPhong(p);
                        loadThongTinPhong(getPhong());
                        this.playGame.setVisible(true);
                        this.setVisible(false);
                    } else {
                        oos.writeObject(false);
                        gui = "Client k đồng ý chơi cùng";
                        System.out.println("Đồng ý chơi cùng,..");
                        oos.writeObject(gui);
                    }
                }
                if (nhan.equals("THEM_BAN_BE")) {
                    NguoiDung nd = (NguoiDung) ois.readObject();
                    int confirm = JOptionPane.showConfirmDialog(this, nd.getName() + " gửi lời mời thêm bạn!", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        oos.writeObject(1);
                        System.out.println("Đồng ý kết bạn!");
                    } else {
                        oos.writeObject(0);
                        System.out.println("Từ chối kết bạn!");
                    }
                }
                if(nhan.equals("SanSang")){
                    oos.writeObject("Vào game OK");
                    ChoiGame choiGame = new ChoiGame(getPhong(), getNguoiDung());
                    choiGame.setVisible(true);
                    socketToServer.close();
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
