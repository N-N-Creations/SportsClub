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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Faris
 */
public class events extends javax.swing.JInternalFrame {

    DefaultTableModel dt = new DefaultTableModel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DBConnection c = new DBConnection();
    int add = 1;
    String id = null;

    public events() {
        initComponents();
        fillTable();
        bt_cancel.setVisible(false);
    }

    public void fillTable() {
        ArrayList<MemberList> al = loadData();
        dt = (DefaultTableModel) event_list.getModel();
        dt.setRowCount(0);
        Object[] row = new Object[6];
        int j = 1;
        for (int i = 0; i < al.size(); i++) {
            row[0] = j;
            row[1] = al.get(i).getId();
            row[2] = al.get(i).getName();
            row[3] = al.get(i).getCtgry();
            row[4] = al.get(i).getDate();
            row[5] = al.get(i).getLastDate();
            j++;
            dt.addRow(row);

        }

    }

    public ArrayList<MemberList> loadData() {
        ArrayList<MemberList> al = null;
        al = new ArrayList<MemberList>();
        try {

            System.out.println("Connection Established");
            Connection con = c.newDBConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from event");
            MemberList list;
            while (rs.next()) {
                list = new MemberList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                al.add(list);
            }

        } catch (Exception e) {
            System.out.println("Error in Retrive Data : " + e);

        }
        return al;
    }

    public void showItemToFields(int index) throws ParseException {
        id = event_list.getModel().getValueAt(index, 1).toString();
        tf_name.setText(event_list.getModel().getValueAt(index, 2).toString());
        dc_date.setDate(sdf.parse(event_list.getModel().getValueAt(index, 4).toString()));
        dc_ldate.setDate(sdf.parse(event_list.getModel().getValueAt(index, 5).toString()));
        String sports = event_list.getModel().getValueAt(index, 3).toString();
        if (sports.contains("Cri")) {
            cmb_ctry.setSelectedIndex(0);
        } else if (sports.contains("Foot")) {
            cmb_ctry.setSelectedIndex(1);
        } else if (sports.contains("Voll")) {
            cmb_ctry.setSelectedIndex(2);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        event_list = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bt_add_edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bt_cancel = new javax.swing.JButton();
        dc_date = new com.toedter.calendar.JDateChooser();
        dc_ldate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_ctry = new javax.swing.JComboBox();
        bt_delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Events");

        event_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.NO", "Event_id", "Name", "Catagory", "Date", "LastDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        event_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                event_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(event_list);
        if (event_list.getColumnModel().getColumnCount() > 0) {
            event_list.getColumnModel().getColumn(0).setResizable(false);
            event_list.getColumnModel().getColumn(0).setPreferredWidth(5);
            event_list.getColumnModel().getColumn(1).setResizable(false);
            event_list.getColumnModel().getColumn(1).setPreferredWidth(5);
            event_list.getColumnModel().getColumn(2).setResizable(false);
            event_list.getColumnModel().getColumn(2).setPreferredWidth(20);
            event_list.getColumnModel().getColumn(3).setResizable(false);
            event_list.getColumnModel().getColumn(3).setPreferredWidth(20);
            event_list.getColumnModel().getColumn(4).setResizable(false);
            event_list.getColumnModel().getColumn(4).setPreferredWidth(25);
            event_list.getColumnModel().getColumn(5).setResizable(false);
            event_list.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        bt_add_edit.setText("Add");
        bt_add_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_editActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add / Edit / Delete an Event");

        bt_cancel.setText("Cancel");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Date");

        jLabel5.setText("LastDate");

        cmb_ctry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cricket", "FootBall", "VolleyBall" }));

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Category");

        jLabel6.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(bt_cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_add_edit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc_date, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(dc_ldate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_ctry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_name))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmb_ctry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(dc_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5))
                    .addComponent(dc_ldate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_add_edit)
                    .addComponent(bt_delete)
                    .addComponent(bt_cancel))
                .addContainerGap())
        );

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_add_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add_editActionPerformed

        String sql = null, result = null;
        if (add == 0) {

            sql = "update event set name=?,category=?,date=?,lastdate=? where event_id=?";
            result = "Updated";
        } else if (add == 1) {

            sql = "insert into event(name,category,date,lastdate,event_id) values(?,?,?,?,?)";
            result = "Added";
        }

        try {
            Connection con = c.newDBConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tf_name.getText());
            stmt.setString(2, (String) cmb_ctry.getSelectedItem());
            stmt.setString(3, sdf.format(dc_date.getDate()));
            stmt.setString(4, sdf.format(dc_ldate.getDate()));
            if (add == 1) {
                stmt.setString(5, idget());
            } else if (add == 0) {
                stmt.setString(5, id);
            }

            int rs = stmt.executeUpdate();
            if (rs >= 1) {
                JOptionPane.showMessageDialog(null, "Event " + result + " Successfully...");
                fillTable();
            }

        } catch (Exception e) {
        }
        fillTable();


    }//GEN-LAST:event_bt_add_editActionPerformed

    private String idget() {
        int newid = 0;
        try {
            Connection con = c.newDBConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select event_id from event");
            while (rs.next()) {
                String id[] = rs.getString(1).split("-");
                newid = Integer.parseInt(id[1]);;
            }
            if (newid == 0) {
                newid = 1;
            } else {
                newid++;
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return "E-" + newid;
    }

    private void event_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_listMouseClicked
        add = 0;
        bt_add_edit.setText("Edit");
        cmb_ctry.setEnabled(false);
        tf_name.setEnabled(false);
        bt_cancel.setVisible(true);
        int ind = event_list.getSelectedRow();
        try {
            showItemToFields(ind);
        } catch (ParseException ex) {
            Logger.getLogger(events.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_event_listMouseClicked

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        bt_add_edit.setText("Add");
        cmb_ctry.setSelectedIndex(0);
        dc_date.setDate(null);
        dc_ldate.setDate(null);
        bt_cancel.setVisible(false);
        tf_name.setText("");
        tf_name.setEnabled(true);
        cmb_ctry.setEnabled(true);
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        if (add == 0) {
            String qry = "delete from event where event_id=?";
            try {
                Connection con = c.newDBConnection();
                PreparedStatement stmt = con.prepareStatement(qry);
                stmt.setString(1, id);
                int res = stmt.executeUpdate();
                if (res >= 1) {
                    JOptionPane.showMessageDialog(null, "Event Deleted Successfully...");
                    fillTable();
                }

            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select an Event First...");
        }
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add_edit;
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_delete;
    private javax.swing.JComboBox cmb_ctry;
    private com.toedter.calendar.JDateChooser dc_date;
    private com.toedter.calendar.JDateChooser dc_ldate;
    private javax.swing.JTable event_list;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables
}
