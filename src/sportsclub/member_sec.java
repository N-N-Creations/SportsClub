/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Faris
 */
public class member_sec extends javax.swing.JFrame {

    DefaultTableModel dt = new DefaultTableModel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String id = null;
    DBConnection c = new DBConnection();
    Connection con = c.newDBConnection();

    public member_sec() {
        initComponents();
        bt_apply.setVisible(false);

        fillTable_my();
        fillData();
        if (lbl_spitem.getText().contains("Foot")) {
            fillTable_new("FootBall");
        }
        if (lbl_spitem.getText().contains("Cri")) {
            fillTable_new("Cricket");
        }
        if (lbl_spitem.getText().contains("Voll")) {
            fillTable_new("VolleyBall");
        }

    }

    public void fillTable_my() {
        ArrayList<MemberList> al = loadData();
        dt = (DefaultTableModel) tbl_new_ev.getModel();
        dt.setRowCount(0);
        Object[] row = new Object[2];
        for (int i = 0; i < al.size(); i++) {
            row[0] = al.get(i).getCtgry();
            row[1] = al.get(i).getDate();
            dt.addRow(row);

        }

    }

    public ArrayList<MemberList> loadData() {
        ArrayList<MemberList> al = null;
        al = new ArrayList<MemberList>();
        try {

            PreparedStatement evid = con.prepareStatement("select event_id from members where id=?");
            evid.setString(1, lbl_id.getText());
            ResultSet res = evid.executeQuery();
            if (res.next()) {
                String ctry[] = res.getString(1).split(",");
                for (int i = 0; i < ctry.length; i++) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from event where category='" + ctry[i] + "'");
                    MemberList list;
                    while (rs.next()) {
                        list = new MemberList(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5));
                        al.add(list);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error in Retrive Data : " + e);

        }
        return al;
    }

    public void fillTable_new(String ctry) {
        ArrayList<MemberList> al = loadData(ctry);
        dt = (DefaultTableModel) tbl_new_ev.getModel();
        dt.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0] = al.get(i).getId();
            row[1] = al.get(i).getCtgry();
            row[2] = al.get(i).getDate();
            row[3] = al.get(i).getLastDate();
            dt.addRow(row);

        }

    }

    public ArrayList<MemberList> loadData(String ctry) {
        ArrayList<MemberList> al = null;
        al = new ArrayList<MemberList>();
        try {

            System.out.println("Connection Established");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from event where category='" + ctry + "'");
            MemberList list;
            while (rs.next()) {
                list = new MemberList(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5));
                al.add(list);
            }

        } catch (Exception e) {
            System.out.println("Error in Retrive Data : " + e);

        }
        return al;
    }

    public void fillData() {
        try {
            DBConnection c = new DBConnection();
            Connection con = c.newDBConnection();
            System.out.println("Connection Established");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from members where active=1");
            if (rs.next()) {
                lbl_id.setText(rs.getString(1));
                lbl_name.setText(rs.getString(2));
                lbl_pno.setText(rs.getString(3));
                lbl_dob.setText(rs.getString(4));
                lbl_bg.setText(rs.getString(5));
                lbl_spitem.setText(rs.getString(6));
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_name = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_spitem = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_pno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_bg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_dob = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_my_ev = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_new_ev = new javax.swing.JTable();
        bt_apply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_name.setFont(new java.awt.Font("Tahoma", 3, 28)); // NOI18N
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name.setText("MemberName");

        lbl_spitem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_spitem.setText("SportsItems");

        lbl_id.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_id.setText("ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("BloodGroup");

        lbl_pno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_pno.setText("PhoneNO");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("SportsItems");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("PhoneNO");

        lbl_bg.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_bg.setText("BloodGroup");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("DateOfBirth");

        lbl_dob.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_dob.setText("DateOfBirth");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_pno, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(lbl_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_spitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_id))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_pno))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_bg))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_dob))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_spitem))
                .addContainerGap())
        );

        tbl_my_ev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MyEvents", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_my_ev);
        if (tbl_my_ev.getColumnModel().getColumnCount() > 0) {
            tbl_my_ev.getColumnModel().getColumn(0).setResizable(false);
            tbl_my_ev.getColumnModel().getColumn(0).setPreferredWidth(65);
            tbl_my_ev.getColumnModel().getColumn(1).setResizable(false);
            tbl_my_ev.getColumnModel().getColumn(1).setPreferredWidth(15);
        }

        tbl_new_ev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NewEvents", "Date", "LastDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_new_ev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_new_evMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_new_ev);
        if (tbl_new_ev.getColumnModel().getColumnCount() > 0) {
            tbl_new_ev.getColumnModel().getColumn(0).setResizable(false);
            tbl_new_ev.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_new_ev.getColumnModel().getColumn(1).setResizable(false);
            tbl_new_ev.getColumnModel().getColumn(1).setPreferredWidth(65);
            tbl_new_ev.getColumnModel().getColumn(2).setResizable(false);
            tbl_new_ev.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_new_ev.getColumnModel().getColumn(3).setResizable(false);
            tbl_new_ev.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        bt_apply.setText("Apply");
        bt_apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_applyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_apply, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_apply)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_applyActionPerformed

        try {
            PreparedStatement stmt = con.prepareStatement("select event_id from members where id=?");
            stmt.setString(1, lbl_id.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String ev_id = rs.getString(1);
                if (ev_id.contains(id)) {
                    JOptionPane.showMessageDialog(null, "You Already Applied for this Event...");
                } else {

                    PreparedStatement updt = con.prepareStatement("update members set event_id=?  where id=?");
                    updt.setString(1, ev_id + "," + id);
                    updt.setString(2, lbl_id.getText());
                    int res = updt.executeUpdate();
                    if (res >= 1) {
                        JOptionPane.showMessageDialog(null, "Applied Successfully...");
                        fillTable_my();
                    }

                }

            }

        } catch (Exception e) {
        }
        bt_apply.setVisible(false);
    }//GEN-LAST:event_bt_applyActionPerformed

    private void tbl_new_evMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_new_evMouseClicked

        bt_apply.setVisible(true);
        int ind = tbl_new_ev.getSelectedRow();
        id = tbl_new_ev.getModel().getValueAt(ind, 0).toString();

    }//GEN-LAST:event_tbl_new_evMouseClicked

    /**
     * @paramlbl_idhe command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(member_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(member_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(member_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(member_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new member_sec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_apply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_dob;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_pno;
    private javax.swing.JLabel lbl_spitem;
    private javax.swing.JTable tbl_my_ev;
    private javax.swing.JTable tbl_new_ev;
    // End of variables declaration//GEN-END:variables
}
