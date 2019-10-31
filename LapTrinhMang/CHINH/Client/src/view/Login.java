package view;

import controller.Key;
import controller.ClientControl;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import model.NguoiDung;

public class Login extends javax.swing.JFrame implements Key {

    public Login() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.jpeg")));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        dangnhapButton = new javax.swing.JButton();
        dangkyButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game cờ caro");
        setBackground(new java.awt.Color(51, 204, 255));
        setLocation(new java.awt.Point(400, 20));
        setPreferredSize(new java.awt.Dimension(505, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 234, 147), 5, true), "Đăng nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Cambria Math", 3, 18), new java.awt.Color(255, 51, 255))); // NOI18N
        login.setOpaque(false);
        login.setPreferredSize(new java.awt.Dimension(350, 200));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Tên đăng nhập:");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel3.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Mật khẩu:");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 20));

        usernameTextField.setMaximumSize(new java.awt.Dimension(120, 20));
        usernameTextField.setPreferredSize(new java.awt.Dimension(70, 30));

        passwordTextField.setPreferredSize(new java.awt.Dimension(70, 30));

        dangnhapButton.setBackground(new java.awt.Color(255, 255, 255));
        dangnhapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dangnhap.png"))); // NOI18N
        dangnhapButton.setContentAreaFilled(false);
        dangnhapButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dangky.png"))); // NOI18N
        dangnhapButton.setPreferredSize(new java.awt.Dimension(100, 48));
        dangnhapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangnhapButtonActionPerformed(evt);
            }
        });

        dangkyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dangky.png"))); // NOI18N
        dangkyButton.setBorderPainted(false);
        dangkyButton.setContentAreaFilled(false);
        dangkyButton.setPreferredSize(new java.awt.Dimension(100, 48));
        dangkyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangkyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(dangnhapButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dangkyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dangnhapButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dangkyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        getContentPane().add(login);
        login.setBounds(80, 360, 350, 200);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 600);

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dangnhapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangnhapButtonActionPerformed
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();
        if (username.length() == 0 || password.length() == 0) {
            JOptionPane.showMessageDialog(this, "Ban chua nhap username, password", "Thong bao", JOptionPane.ERROR_MESSAGE);
        } else {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setUsername(username);
            nguoiDung.setPassword(password);
            ClientControl loginControl = new ClientControl(nguoiDung);
            NguoiDung object = loginControl.checkLoginNguoiDung();
            if (object != null) {
                System.out.println("Login thành công chuyển sang giao diện HOME.");
                Home home = new Home(object);
                this.dispose();
                home.setVisible(true);
            } else {
                System.out.println("Login không thành công");
                JOptionPane.showMessageDialog(this, "Đăng nhập không thành công! Mời kiểm tra lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_dangnhapButtonActionPerformed
    private void dangkyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangkyButtonActionPerformed
        DangKy dangKy = new DangKy();
        dangKy.setVisible(true);
    }//GEN-LAST:event_dangkyButtonActionPerformed
    public void setThongTin(String u) {
        usernameTextField.setText(u);
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dangkyButton;
    private javax.swing.JButton dangnhapButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
