/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

/**
 *
 * @author Hoang Quyet
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
 
 
public class Exaample extends JFrame {
 
    JTextField field;
    JButton button;
 
    public Exaample() {
 
        setTitle("Drag And Drop Example");
 
        setLayout(null);
 
        button = new JButton("Button");
        button.setBounds(200, 50, 90, 25);
 
        field = new JTextField();
        field.setBounds(30, 50, 150, 25);
 
        add(button);
        add(field);
 
        field.setDragEnabled(true);
        button.setTransferHandler(new TransferHandler("text"));
 
        setSize(330, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new Exaample();
    }
}
