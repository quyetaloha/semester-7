package view;

import controller.ClientControl;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import model.Nguoi;
import model.NguoiDung;
import controller.Key;

public class DangKy extends javax.swing.JFrame implements Key {

    public DangKy() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        nlPasswrodField = new javax.swing.JPasswordField();
        nameTextField = new javax.swing.JTextField();
        dangKyButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Đăng ký");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(480, 200));
        setMaximumSize(new java.awt.Dimension(350, 400));
        setMinimumSize(new java.awt.Dimension(350, 400));
        setPreferredSize(new java.awt.Dimension(350, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(350, 400));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng ký");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 9, 170, 55);

        jLabel6.setText("Tên đăng nhâp:");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 40));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(18, 77, 100, 40);

        jLabel7.setText("Mật khẩu:");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 40));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(18, 123, 100, 40);

        jLabel8.setText("Nhập lại mật khẩu:");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 40));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(18, 169, 100, 40);

        jLabel2.setText("Nickname:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 40));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(18, 217, 100, 40);

        usernameTextField.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(usernameTextField);
        usernameTextField.setBounds(136, 82, 150, 30);

        passwordField.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(passwordField);
        passwordField.setBounds(136, 128, 150, 30);

        nlPasswrodField.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(nlPasswrodField);
        nlPasswrodField.setBounds(136, 174, 150, 30);

        nameTextField.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(nameTextField);
        nameTextField.setBounds(136, 222, 150, 30);

        dangKyButton.setText("Đăng ký");
        dangKyButton.setPreferredSize(new java.awt.Dimension(120, 40));
        dangKyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangKyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(dangKyButton);
        dangKyButton.setBounds(111, 288, 120, 40);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LeftArrow (1).png"))); // NOI18N
        backButton.setText("Back");
        backButton.setPreferredSize(new java.awt.Dimension(40, 40));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(18, 16, 40, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LeftArrow (1).png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 340, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void dangKyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangKyButtonActionPerformed
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String nlpasswrod = nlPasswrodField.getText();
        String nickname = nameTextField.getText();
        if (username.length() == 0 || password.length() == 0 || nlpasswrod.length() == 0 || nickname.length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhập thiêu! Mời kiểm tra lại", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(nlpasswrod)) {
            JOptionPane.showMessageDialog(this, "Password không trùng nhau! Mời kiểm tra lại", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setUsername(username);
            nguoiDung.setPassword(password);
            nguoiDung.setName(nickname);
            ClientControl c = new ClientControl(nguoiDung);
            NguoiDung nd = c.dangKyControl();
            if (nd != null) {
                JOptionPane.showMessageDialog(this, "Đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Đăng ký tài khoản thanh công.");
            } else {
                JOptionPane.showMessageDialog(this, "Đăng ký k thành công. Ktra lại username", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Đăng ký tài khoản k thanh công.");
            }
        }
    }//GEN-LAST:event_dangKyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton dangKyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField nlPasswrodField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
