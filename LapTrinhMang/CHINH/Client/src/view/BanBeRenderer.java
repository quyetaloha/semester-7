package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.Nguoi;

public class BanBeRenderer extends javax.swing.JPanel implements ListCellRenderer<Nguoi> {

    public BanBeRenderer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameBanBeLablel = new javax.swing.JLabel();
        tinhTrangLabel = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 102), new java.awt.Color(255, 153, 0)));
        setMaximumSize(new java.awt.Dimension(260, 60));
        setMinimumSize(new java.awt.Dimension(260, 60));
        setPreferredSize(new java.awt.Dimension(260, 60));

        nameBanBeLablel.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        nameBanBeLablel.setForeground(new java.awt.Color(51, 51, 255));
        nameBanBeLablel.setText("name");
        nameBanBeLablel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 204), new java.awt.Color(255, 255, 153)));
        nameBanBeLablel.setMaximumSize(new java.awt.Dimension(30, 25));
        nameBanBeLablel.setMinimumSize(new java.awt.Dimension(30, 25));
        nameBanBeLablel.setPreferredSize(new java.awt.Dimension(30, 25));

        avatar.setAlignmentY(0.0F);
        avatar.setMaximumSize(new java.awt.Dimension(45, 45));
        avatar.setMinimumSize(new java.awt.Dimension(45, 45));
        avatar.setPreferredSize(new java.awt.Dimension(45, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameBanBeLablel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tinhTrangLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tinhTrangLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameBanBeLablel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel nameBanBeLablel;
    private javax.swing.JLabel tinhTrangLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends Nguoi> list, Nguoi nguoi, int index, boolean isSelected, boolean cellHasFocus) {
        String avata="";
        if(nguoi.getAvata().equals("nguoiSoi1.png")){
            avata="nguoiSoi.png";
        }else if(nguoi.getAvata().equals("nguoiSat1.png")){
            avata="nguoiSat.png";
        }else if(nguoi.getAvata().equals("luky1.png")){
            avata="luky.png";
        }else{
            avata="cap.png";
        }
        avatar.setIcon(new ImageIcon(getClass().getResource("/img/"+avata)));
        nameBanBeLablel.setText(nguoi.getName());
        if (nguoi.getTinhTrang() == 0) {
            tinhTrangLabel.setText("Off");
        } else {
            tinhTrangLabel.setText("On");
        }
        nameBanBeLablel.setOpaque(true);
        tinhTrangLabel.setOpaque(true);
        avatar.setOpaque(true);
        if (isSelected) {
            avatar.setBackground(Color.decode("#ffcf60"));
            nameBanBeLablel.setBackground(Color.decode("#ffcf60"));
            tinhTrangLabel.setBackground(Color.decode("#ffcf60"));
            setBackground(Color.decode("#ffcf60"));
        } else {
            avatar.setBackground(Color.decode("#ffe2a0"));
            nameBanBeLablel.setBackground(Color.decode("#ffc549"));
            tinhTrangLabel.setBackground(Color.decode("#ffe2a0"));
            setBackground(Color.decode("#ffe2a0"));
        }
        return this;
    }
}
