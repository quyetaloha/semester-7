package nhom2;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Demo extends JFrame implements ActionListener{
    JTextField bt;
    JButton tinh;
    JLabel kqua;
    public Demo(){
        setTitle("Demo");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,2));
        JLabel nn=new JLabel("Ban kinh:");
        Font f=new Font("Calibri",Font.BOLD,26);
        nn.setFont(f);
        nn.setForeground(Color.BLUE);
        add(nn);
        bt=new JTextField();
        add(bt);
        tinh=new JButton("Tinh");
        add(tinh);
        kqua=new JLabel();
        tinh.setFont(f);
        add(kqua);
        tinh.addActionListener(this);
        kqua.setFont(f);
   }
    public static void main(String[] args) {
        Demo m=new Demo();
        m.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tinh){
            String rr=bt.getText();
            double r=Double.parseDouble(rr);
            double s=Math.PI*r*r;
            DecimalFormat df=new DecimalFormat("##.##");
            kqua.setText("Dien tich:"+df.format(s));
        }
    }
}
