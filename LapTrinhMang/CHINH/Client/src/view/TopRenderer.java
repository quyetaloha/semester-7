package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.Nguoi;

public class TopRenderer extends javax.swing.JPanel implements ListCellRenderer<Nguoi> {

    public TopRenderer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avataTopLabel = new javax.swing.JLabel();
        nameTopLable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 102), new java.awt.Color(255, 153, 0)));
        setMaximumSize(new java.awt.Dimension(250, 60));
        setMinimumSize(new java.awt.Dimension(250, 60));
        setPreferredSize(new java.awt.Dimension(250, 60));

        avataTopLabel.setMaximumSize(new java.awt.Dimension(45, 45));
        avataTopLabel.setMinimumSize(new java.awt.Dimension(45, 45));
        avataTopLabel.setPreferredSize(new java.awt.Dimension(45, 45));

        nameTopLable.setBackground(new java.awt.Color(255, 255, 102));
        nameTopLable.setText("name");
        nameTopLable.setMaximumSize(new java.awt.Dimension(30, 25));
        nameTopLable.setMinimumSize(new java.awt.Dimension(30, 25));
        nameTopLable.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(avataTopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameTopLable, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTopLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avataTopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
        avataTopLabel.setIcon(new ImageIcon(getClass().getResource("/img/"+avata)));
        nameTopLable.setText(nguoi.getName());
        jLabel1.setText(String.valueOf(nguoi.getXepHang()));
        avataTopLabel.setOpaque(true);
        nameTopLable.setOpaque(true);

        if (isSelected) {
            avataTopLabel.setBackground(Color.decode("#ffcf60"));
            nameTopLable.setBackground(Color.decode("#ffcf60"));
            setBackground(Color.decode("#ffcf60"));
        } else {
            avataTopLabel.setBackground(Color.decode("#ffe2a0"));
            nameTopLable.setBackground(Color.decode("#ffe2a0"));
            setBackground(Color.decode("#ffe2a0"));
        }
        return this;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avataTopLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nameTopLable;
    // End of variables declaration//GEN-END:variables
}
