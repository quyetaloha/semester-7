package view;

import controller.ClientControl;
import controller.Key;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Nguoi;
import model.NguoiDung;
import model.Phong;

public class ChoiGame extends javax.swing.JFrame implements Runnable, Key {

    private ClientControl c;
    private NguoiDung nguoiDung;
    private NguoiDung nguoiChoi;
    private Phong phongChuyenSang;
    JButton banCo[][];
    int giaTri[][];
    private int luotChoi;//thử để thành static

    public int getLuotChoi() {
        return luotChoi;
    }

    public void setLuotChoi(int luotChoi) {
        this.luotChoi = luotChoi;
    }

    public NguoiDung getNguoiChoi() {
        return nguoiChoi;
    }

    public void setNguoiChoi(NguoiDung nguoiChoi) {
        this.nguoiChoi = nguoiChoi;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public ChoiGame(Phong phong, NguoiDung nguoiDung) {
        c = new ClientControl(nguoiDung);
        this.nguoiDung = nguoiDung;
        phongChuyenSang = phong;
        banCo = new JButton[20][30];
        giaTri = new int[20][30];
        luotChoi = 0;
        /*
        - Khởi tạo thông tin người dùng load từ Home sang
         */
        setTitle("Game cờ caro");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.jpeg")));
        initComponents();

        for (Nguoi nguoi : phong.getDsNguoiChoi()) {
            if (nguoiDung.getIdNguoiDung() != nguoi.getIdNguoiDung()) {
                avatar2.setIcon(new ImageIcon(getClass().getResource("/img/" + nguoi.getAvata())));
                tenNguoi2.setText("Tên:  " + nguoi.getName());
                loaiHang2.setText("Loại hạng:  " + nguoi.getLoaiHang());
                if (nguoi.getRole() == 1) {
                    luotNguoiChoi.setText("Đến lượt " + nguoi.getName() + " đánh!");
                }
                setNguoiChoi((NguoiDung) nguoi);
            } else {
                avatar1.setIcon(new ImageIcon(getClass().getResource("/img/" + nguoi.getAvata())));
                tenNguoi1.setText("Tên:  " + nguoi.getName());
                loaiHang1.setText("Loại hạng:  " + nguoi.getLoaiHang());
                if (nguoi.getRole() == 1) {
                    luotNguoiChoi.setText("Đến lượt " + nguoi.getName() + " đánh!");
                }
                setNguoiDung((NguoiDung) nguoi);
            }

        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (phong != null) {
                    c.xoaNguoiChoiKhoiDanhSachPhong(phong);
                }
                c.dangXuat();
                System.exit(0);
            }

        });
        /*
        - Khởi tạo bàn cờ game caro với ma trận Button 20x30
        - Khởi tạo ma trận giá trị int[20][30] có giá trị 0
        - Bắt sự kiện người dùng bấm Button sẽ thay đổi giá trị 1 nếu người dùng là Người Dùng 1, 2 nếu người dùng
          là Người Dùng 2, đồng thời thay đổi Icon của Button[][] thành Iocn của người dùng
         */
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 30; j++) {
                giaTri[i][j] = 0;
                banCo[i][j] = new JButton();
                banCo[i][j].setBackground(Color.getColor("[255,255,102]"));
                banCo[i][j].setActionCommand(i + "," + j);
                banCo[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bamButton(e);
                    }
                });
                screenGame.add(banCo[i][j]);
            }
        }
        Thread thread = new Thread(this);
        thread.start();
        screenGame.setLayout(new GridLayout(20, 30));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        nguoiDung2 = new javax.swing.JPanel();
        avatar2 = new javax.swing.JLabel();
        tenNguoi2 = new javax.swing.JLabel();
        loaiHang2 = new javax.swing.JLabel();
        nguoiDung1 = new javax.swing.JPanel();
        avatar1 = new javax.swing.JLabel();
        tenNguoi1 = new javax.swing.JLabel();
        loaiHang1 = new javax.swing.JLabel();
        thongTin = new javax.swing.JPanel();
        luotNguoiChoi = new javax.swing.JLabel();
        thongBao = new javax.swing.JLabel();
        screenGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setLocation(new java.awt.Point(100, 50));
        setMaximumSize(new java.awt.Dimension(1090, 570));
        setMinimumSize(new java.awt.Dimension(1090, 570));
        setPreferredSize(new java.awt.Dimension(1090, 570));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        nguoiDung2.setBackground(new java.awt.Color(255, 153, 153));
        nguoiDung2.setPreferredSize(new java.awt.Dimension(150, 570));

        avatar2.setText("avatar2");

        tenNguoi2.setText("Tên:");

        loaiHang2.setText("Loại hạng:");

        javax.swing.GroupLayout nguoiDung2Layout = new javax.swing.GroupLayout(nguoiDung2);
        nguoiDung2.setLayout(nguoiDung2Layout);
        nguoiDung2Layout.setHorizontalGroup(
            nguoiDung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiDung2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(avatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nguoiDung2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nguoiDung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loaiHang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tenNguoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        nguoiDung2Layout.setVerticalGroup(
            nguoiDung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiDung2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(avatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(tenNguoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(loaiHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nguoiDung1.setBackground(new java.awt.Color(255, 153, 153));
        nguoiDung1.setPreferredSize(new java.awt.Dimension(150, 570));

        avatar1.setText("avatar1");

        tenNguoi1.setText("Tên:");

        loaiHang1.setText("Loại hạng:");

        javax.swing.GroupLayout nguoiDung1Layout = new javax.swing.GroupLayout(nguoiDung1);
        nguoiDung1.setLayout(nguoiDung1Layout);
        nguoiDung1Layout.setHorizontalGroup(
            nguoiDung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiDung1Layout.createSequentialGroup()
                .addGroup(nguoiDung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(nguoiDung1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(avatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nguoiDung1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tenNguoi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(nguoiDung1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loaiHang1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        nguoiDung1Layout.setVerticalGroup(
            nguoiDung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoiDung1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(avatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(tenNguoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(loaiHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        thongTin.setBackground(new java.awt.Color(204, 255, 255));

        luotNguoiChoi.setText("Lượt người chơi");

        thongBao.setText("Thông báo:");

        javax.swing.GroupLayout thongTinLayout = new javax.swing.GroupLayout(thongTin);
        thongTin.setLayout(thongTinLayout);
        thongTinLayout.setHorizontalGroup(
            thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongTinLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(luotNguoiChoi, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        thongTinLayout.setVerticalGroup(
            thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(luotNguoiChoi)
                    .addComponent(thongBao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        screenGame.setBackground(new java.awt.Color(255, 255, 102));
        screenGame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
        screenGame.setMaximumSize(new java.awt.Dimension(1000, 1000));
        screenGame.setMinimumSize(new java.awt.Dimension(750, 500));
        screenGame.setPreferredSize(new java.awt.Dimension(750, 500));

        javax.swing.GroupLayout screenGameLayout = new javax.swing.GroupLayout(screenGame);
        screenGame.setLayout(screenGameLayout);
        screenGameLayout.setHorizontalGroup(
            screenGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        screenGameLayout.setVerticalGroup(
            screenGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(nguoiDung1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(screenGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nguoiDung2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(thongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
            .addComponent(nguoiDung2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
            .addComponent(nguoiDung1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bamButton(ActionEvent evt) {
        String viTri[] = evt.getActionCommand().split(",");
        int i = Integer.valueOf(viTri[0]);
        int j = Integer.valueOf(viTri[1]);
        if (getLuotChoi() % 2 == 0 && nguoiDung.getRole() == 1) {
            while (giaTri[i][j] == 0) {
                luotNguoiChoi.setText("Đến lượt: " + nguoiDung.getName() + " đánh!");
                giaTri[i][j] = 1;
                banCo[i][j].setIcon(new ImageIcon(getClass().getResource("/img/cap.png")));
                setLuotChoi(getLuotChoi() + 1);
                guiLuotChoi(getLuotChoi(), getNguoiChoi(), i, j, giaTri[i][j]);
                if (kiemTraThangThua(i, j, giaTri[i][j])) {
                    guiThongTinSauTranDau(1, nguoiDung.getIdNguoiDung(), phongChuyenSang.getSoLuongTienCuoc());
                    guiThongTinThangDenNguoiChoiKhach(getNguoiChoi());
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn thắng cuộc", "Thông báo", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        //server.close();
                        this.dispose();
//                        Thread thread = new Thread(this);
//                        thread.stop();
                    }
                }
            }
        } else if (getLuotChoi() % 2 != 0 && nguoiDung.getRole() == 0) {
            while (giaTri[i][j] == 0) {
                luotNguoiChoi.setText("Đến lượt: " + nguoiDung.getName() + " đánh!");
                giaTri[i][j] = 2;
                banCo[i][j].setIcon(new ImageIcon(getClass().getResource("/img/nguoiSoi.png")));
                setLuotChoi(getLuotChoi() + 1);
                guiLuotChoi(getLuotChoi(), getNguoiChoi(), i, j, giaTri[i][j]);
                if (kiemTraThangThua(i, j, giaTri[i][j])) {
                    guiThongTinSauTranDau(1, nguoiDung.getIdNguoiDung(), phongChuyenSang.getSoLuongTienCuoc());
                    guiThongTinThangDenNguoiChoiKhach(getNguoiChoi());
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn thắng cuộc", "Thông báo", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        //server.close();
                        this.dispose();
//                        Thread thread = new Thread(this);
//                        thread.stop();
                    }
                }
            }
        }
    }

    public boolean kiemTraThangThua(int i, int j, int giaTri) {
        int soHang = 0;
        int soCot = 0;
        int soCheuTren = 0;
        int soCheoDuoi = 0;
        int tamI = i;
        int tamJ = j;
        //kiểm tra cột dọc
        while (i - 1 >= 0 && this.giaTri[i - 1][j] == giaTri) {
            soHang++;
            i--;
        }
        i = tamI;
        if (soHang == 4) {
            return true;
        }
        while (i + 1 <= 19 && this.giaTri[i + 1][j] == giaTri) {
            soHang++;
            i++;
        }
        i = tamI;
        if (soHang == 4) {
            return true;
        }
        //kiểm tra hàng ngang
        while (j - 1 >= 0 && this.giaTri[i][j - 1] == giaTri) {
            soCot++;
            j--;
        }
        j = tamJ;
        if (soCot == 4) {
            return true;
        }
        while (j + 1 <= 29 && this.giaTri[i][j + 1] == giaTri) {
            soCot++;
            j++;
        }
        j = tamJ;
        if (soCot == 4) {
            return true;
        }
        //kiểm tra đường chéo trên
        while (i - 1 >= 0 && j - 1 >= 0 && this.giaTri[i - 1][j - 1] == giaTri) {
            soCheuTren++;
            i--;
            j--;
        }
        i = tamI;
        j = tamJ;
        if (soCheuTren == 4) {
            return true;
        }
        while (i + 1 <= 19 && j + 1 <= 29 && this.giaTri[i + 1][j + 1] == giaTri) {
            soCheuTren++;
            i++;
            j++;
        }
        i = tamI;
        j = tamJ;
        if (soCheuTren == 4) {
            return true;
        }
        //kiểm tra đường chéo dưới
        while (i - 1 >= 0 && j + 1 <= 29 && this.giaTri[i - 1][j + 1] == giaTri) {
            soCheoDuoi++;
            i--;
            j++;
        }
        i = tamI;
        j = tamJ;
        if (soCheoDuoi == 4) {
            return true;
        }
        while (i + 1 <= 19 && j - 1 >= 0 && this.giaTri[i + 1][j - 1] == giaTri) {
            soCheoDuoi++;
            i++;
            j--;
        }
        i = tamI;
        j = tamJ;
        if (soCheoDuoi == 4) {
            return true;
        }
        return false;

    }

    private void guiThongTinSauTranDau(int kq, int idNguoiDung, int mucTien) {
        try {
            //gửi thông tin người dùng về server để cập nhật dữ liệu vào database
            //kq = 1 thì người dùng thắng, kq = 2 người dùng thua
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject("THONG_TIN_SAU_TD");
            os.writeObject(kq);
            os.writeObject(idNguoiDung);
            os.writeObject(mucTien);
            System.out.println((String) is.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ChoiGame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void guiThongTinThangDenNguoiChoiKhach(NguoiDung nguoiChoiKhach) {
        try {
            Socket socket = new Socket(nguoiChoiKhach.getIpAddress(), 1111);
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject("KETQUAGUIVE");
            os.writeObject(2);
            System.out.println((String) is.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ChoiGame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void guiLuotChoi(int luotChoi, NguoiDung nguoiDung, int i, int j, int giaTri) {
        //gửi lượt chơi đến Người chơi khách
        try {
            Socket socket = new Socket(nguoiDung.getIpAddress(), 1111);
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject("XDLUOTCHOI");
            os.writeObject(luotChoi);
            os.writeObject(i);
            os.writeObject(j);
            os.writeObject(giaTri);
            System.out.println((String) is.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ChoiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar1;
    private javax.swing.JLabel avatar2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel loaiHang1;
    private javax.swing.JLabel loaiHang2;
    private javax.swing.JLabel luotNguoiChoi;
    private javax.swing.JPanel nguoiDung1;
    private javax.swing.JPanel nguoiDung2;
    private javax.swing.JPanel screenGame;
    private javax.swing.JLabel tenNguoi1;
    private javax.swing.JLabel tenNguoi2;
    private javax.swing.JLabel thongBao;
    private javax.swing.JPanel thongTin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //lấy yêu cầu từ Client khác gửi tối
        ServerSocket server = null;
        try {
            server = new ServerSocket(1111);
            while (true) {
                Socket socket = server.accept();
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                String nhan = (String) is.readObject();
                if (nhan.equals("XDLUOTCHOI")) {
                    int lc = (int) is.readObject();
                    int i = (int) is.readObject();
                    int j = (int) is.readObject();
                    System.out.println("Nhận được lượt đánh từ Clien: " + socket.getInetAddress() + " tại vị trí: " + i + "," + j);
                    int giaTri = (int) is.readObject();
                    this.giaTri[i][j] = giaTri;
                    setLuotChoi(lc);
                    if (giaTri == 1) {
                        banCo[i][j].setIcon(new ImageIcon(getClass().getResource("/img/cap.png")));
                    } else {
                        banCo[i][j].setIcon(new ImageIcon(getClass().getResource("/img/nguoiSoi.png")));
                    }
                    String gui = "Nhân được OK";
                    os.writeObject(gui);

                } else if (nhan.equals("KETQUAGUIVE")) {
                    int kq = (int) is.readObject();
                    os.writeObject("OK Tao thua");
                    guiThongTinSauTranDau(kq, nguoiDung.getIdNguoiDung(), phongChuyenSang.getSoLuongTienCuoc());
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn thua cuộc", "Thông báo", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        server.close();
                        this.dispose();
//                        Thread thread = new Thread(this);
//                        thread.stop();
                    }
                    
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
//        finally {
//            if (server != null) {
//                try {
//                    server.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(ChoiGame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

}
