//lớp này dùng để định dạng lại các phần tử tring JList
package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import model.Phong;

public class PhongRenderer extends javax.swing.JPanel implements ListCellRenderer<Phong>{
    public PhongRenderer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLabel = new javax.swing.JLabel();
        soPhongLabel = new javax.swing.JLabel();
        soNguoiTrongPhong = new javax.swing.JLabel();
        tienCuocLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 153, 0)));
        setPreferredSize(new java.awt.Dimension(600, 122));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        add(iconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 260, 100));

        soPhongLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        soPhongLabel.setForeground(new java.awt.Color(255, 102, 102));
        soPhongLabel.setText("soPhong");
        soPhongLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        soPhongLabel.setAutoscrolls(true);
        soPhongLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        soPhongLabel.setMaximumSize(new java.awt.Dimension(150, 20));
        soPhongLabel.setMinimumSize(new java.awt.Dimension(150, 20));
        soPhongLabel.setPreferredSize(new java.awt.Dimension(150, 20));
        add(soPhongLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 150, 25));

        soNguoiTrongPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        soNguoiTrongPhong.setForeground(new java.awt.Color(255, 102, 102));
        soNguoiTrongPhong.setText("SoNguoiTrongPhong");
        soNguoiTrongPhong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        soNguoiTrongPhong.setMaximumSize(new java.awt.Dimension(150, 20));
        soNguoiTrongPhong.setMinimumSize(new java.awt.Dimension(150, 20));
        soNguoiTrongPhong.setPreferredSize(new java.awt.Dimension(150, 20));
        add(soNguoiTrongPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 150, 25));

        tienCuocLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tienCuocLabel.setForeground(new java.awt.Color(255, 102, 102));
        tienCuocLabel.setText("tienCuoc");
        tienCuocLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        tienCuocLabel.setMaximumSize(new java.awt.Dimension(150, 20));
        tienCuocLabel.setMinimumSize(new java.awt.Dimension(150, 20));
        tienCuocLabel.setPreferredSize(new java.awt.Dimension(150, 20));
        add(tienCuocLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 150, 25));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel soNguoiTrongPhong;
    private javax.swing.JLabel soPhongLabel;
    private javax.swing.JLabel tienCuocLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends Phong> list, Phong phong, int index, boolean isSelected, boolean cellHasFocus) {
        soNguoiTrongPhong.setText("  Số người chơi:  "+String.valueOf(phong.getSoLuongNguoiChoi())+"/2");
        soPhongLabel.setText("  Phòng:  "+String.valueOf(phong.getIdPhong()));
        tienCuocLabel.setText("  Tiền cược: "+String.valueOf(phong.getSoLuongTienCuoc()));
        iconLabel.setIcon(new ImageIcon(getClass().getResource("/img/avataPhong.png")));
        
        soNguoiTrongPhong.setOpaque(true);
        soPhongLabel.setOpaque(true);
        tienCuocLabel.setOpaque(true);
        iconLabel.setOpaque(true);
        
        if(isSelected){
            soNguoiTrongPhong.setBackground(Color.decode("#ffcf60"));
            soPhongLabel.setBackground(Color.decode("#ffcf60"));
            tienCuocLabel.setBackground(Color.decode("#ffcf60"));
            iconLabel.setBackground(Color.decode("#ffcf60"));
            setBackground(Color.decode("#ffcf60"));
        }else{
            soNguoiTrongPhong.setBackground(Color.decode("#ffe2a0"));
            soPhongLabel.setBackground(Color.decode("#ffe2a0"));
            tienCuocLabel.setBackground(Color.decode("#ffe2a0"));
            iconLabel.setBackground(Color.decode("#ffe2a0"));
            setBackground(Color.decode("#ffe2a0"));
        }
        return this;

    }
}
