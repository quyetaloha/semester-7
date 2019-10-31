package connect_server.model;


import control.ClientControl;
import connect_server.view.User;

import javax.swing.*;

public class ClientView extends JFrame implements ActionListener{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    public ClientView(){
        super("TCP Login MVC");
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin = new JButton("Login");
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Username:"));
        content.add(txtUsername);
        content.add(new JLabel("Password:"));
        content.add(txtPassword);
        content.add(btnLogin);
        this.setContentPane(content);
        this.pack();
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            System.exit(0);
            }
        });
        }

        public void actionPerformed(ActionEvent e) {
        }
//        public User getUser(){
//            User model = new User(txtUsername.getText(),
//            txtPassword.getText());
//            return model;
//        }
        public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
        }
        public void addLoginListener(ActionListener log) {
        btnLogin.addActionListener(log);
        }
}
