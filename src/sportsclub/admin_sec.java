/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclub;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author N&NCreations
 */
public class admin_sec extends javax.swing.JFrame {

    /**
     * Creates new form admin_sec
     */
    public admin_sec() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        visitor_history = new javax.swing.JMenuItem();
        history = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        vm = new javax.swing.JMenuItem();
        anm = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        FootBall = new javax.swing.JMenuItem();
        Crik = new javax.swing.JMenuItem();
        vob = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Desktop.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Desktop)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        jMenu3.setText("File");

        visitor_history.setText("VisitorHistory");
        visitor_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitor_historyActionPerformed(evt);
            }
        });
        jMenu3.add(visitor_history);

        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        jMenu3.add(history);

        jMenuItem4.setText("Logout");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Member");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        vm.setText("ViewMembers");
        vm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmActionPerformed(evt);
            }
        });
        jMenu1.add(vm);

        anm.setText("AddNewMember");
        anm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anmActionPerformed(evt);
            }
        });
        jMenu1.add(anm);

        jMenuItem3.setText("ViewMemberSuggetions");
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("AppliedMembers");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Category");

        FootBall.setText("FootBall");
        FootBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FootBallActionPerformed(evt);
            }
        });
        jMenu2.add(FootBall);

        Crik.setText("Cricket");
        Crik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrikActionPerformed(evt);
            }
        });
        jMenu2.add(Crik);

        vob.setText("VolleyBall");
        vob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vobActionPerformed(evt);
            }
        });
        jMenu2.add(vob);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void anmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anmActionPerformed
        newMember nm = new newMember();
        Desktop.add(nm);
        nm.setAV("AddNewMember");
        nm.setVisible(true);
    }//GEN-LAST:event_anmActionPerformed

    private void vmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vmActionPerformed
        viewMember vm = new viewMember();
        Desktop.add(vm);
        vm.setVisible(true);
    }//GEN-LAST:event_vmActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        try{
            DBConnection c=new DBConnection();
            Connection con=c.newDBConnection();
            System.out.println("Connection Established");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate("update admin set active=0  where active=1");
            if(rs>=1){
                JOptionPane.showMessageDialog(null, "Logout Successful...");
                mainWindow mw=new mainWindow();
                mw.setVisible(true);
                this.dispose();
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void FootBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FootBallActionPerformed
        category ct=new category();
        Desktop.add(ct);
        String cat =FootBall.getText();
        ct.setData(cat);
        ct.setVisible(true);
    }//GEN-LAST:event_FootBallActionPerformed

    private void CrikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrikActionPerformed
        category ct=new category();
        Desktop.add(ct);
        String cat =Crik.getText();
        ct.setData(cat);
        ct.setVisible(true);
    }//GEN-LAST:event_CrikActionPerformed

    private void vobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vobActionPerformed
        category ct=new category();
        Desktop.add(ct);
        String cat =vob.getText();
        ct.setData(cat);
        ct.setVisible(true);
    }//GEN-LAST:event_vobActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        
        history ht = new history();
        Desktop.add(ht);
        ht.setVisible(true);
        
    }//GEN-LAST:event_historyActionPerformed

    private void visitor_historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitor_historyActionPerformed
        
        visitor_history vh = new visitor_history();
        Desktop.add(vh);
        vh.setVisible(true);
        
        
    }//GEN-LAST:event_visitor_historyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_sec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Crik;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem FootBall;
    private javax.swing.JMenuItem anm;
    private javax.swing.JMenuItem history;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem visitor_history;
    private javax.swing.JMenuItem vm;
    private javax.swing.JMenuItem vob;
    // End of variables declaration//GEN-END:variables
}
