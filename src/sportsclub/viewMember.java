/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclub;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;*/
/**
 *
 * @author Login N&NCreations
 */
public class viewMember extends javax.swing.JInternalFrame {

    String id = null;
    int search=1;
    DefaultTableModel dt =new DefaultTableModel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
private int findAge(String a){
    String dob[] = a.split("-") ;
    int year = Integer.parseInt(dob[0]);
    int month = Integer.parseInt(dob[1]);
    int day = Integer.parseInt(dob[2]);
    
    LocalDate selectedDate = LocalDate.of(year,month,day);
    LocalDate currentDate = LocalDate.now();
    int resultYear = Period.between(selectedDate, currentDate).getYears();
    
    return resultYear;
}


/*private void createColumn(){
    dt = (DefaultTableModel) member_list.getModel();
    dt.addColumn("id");
    dt.addColumn("Name");
    dt.addColumn("phone");
    dt.addColumn("DOB");
    dt.addColumn("BloodGroup");
    dt.addColumn("Catagory");
}*/
public ArrayList<MemberList> loadData(){
    ArrayList<MemberList> al=null;
    al=new ArrayList<MemberList>();
    try{
        DBConnection c=new DBConnection();
        Connection con=c.newDBConnection();
        System.out.println("Connection Established");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from members");
        MemberList list;
        
        
        while(rs.next()){
            list =new MemberList(rs.getString(1),rs.getString("name"),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            al.add(list);
            
            
            
        }
    }
    catch(Exception e){
            System.out.println("Error in Retrive Data : "+e);
        }
    return al;
}
public void fillTable(){
    ArrayList<MemberList> al=loadData();
    dt = (DefaultTableModel) member_list.getModel();
    dt.setRowCount(0);
    Object[] row = new Object[7];
        int j=1;
    for (int i = 0; i <al.size(); i++) {
        row[0]=j;
        row[1]=al.get(i).getId();
        row[2]=al.get(i).getName();
        row[3]=al.get(i).getPhone();
        row[4]=findAge(al.get(i).getDob());
        row[5]=al.get(i).getBg();
        row[6]=al.get(i).getCtgry();
        j++;
        dt.addRow(row);
        
    }
    
}


        
    /**
     * Creates new form viewMember
     */
    public viewMember() {
        initComponents();
        fillTable();
        
    }
    
    public void showItemToFields(int index){
        /*tf_search.setText(loadData().get(index).getName());
        tf_phn.setText(loadData().get(index).getPhone());
        cmb_bg.setSelectedItem(loadData().get(index).getBg());
        id = loadData().get(index).getId();*/
        id=member_list.getModel().getValueAt(index, 1).toString();
    
    try {
        
        DBConnection c=new DBConnection();
        Connection con=c.newDBConnection();
        System.out.println("Connection Established for cataegory");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from members where id='"+id+"'");
        if(rs.next()){
            Date dob=null;
            dob=new SimpleDateFormat("yyyy-MM-dd").parse((String) rs.getString(4));
            dc_dob.setDate(dob);
            tf_search.setText(rs.getString(2));
            tf_phn.setText(rs.getString(3));
            cmb_bg.setSelectedItem((rs.getString(5)));
            String sports=(rs.getString(6));
            if(sports.contains("Foot")){
                cb_fb.setSelected(true);
            }
            else
                cb_fb.setSelected(false);
            
            if(sports.contains("Cric")){
                cb_ckt.setSelected(true);
            }
            else
                cb_ckt.setSelected(false);
            
            if(sports.contains("Voll")){
                cb_vb.setSelected(true);
            }
            else
                cb_vb.setSelected(false);
            
        }
        
        
        
        
        
    } catch (Exception e) {
        System.out.println("Error at showItemToFields method...");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        member_list = new javax.swing.JTable();
        tf_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_phn = new javax.swing.JTextField();
        cmb_bg = new javax.swing.JComboBox();
        dc_dob = new com.toedter.calendar.JDateChooser();
        cb_fb = new javax.swing.JCheckBox();
        cb_ckt = new javax.swing.JCheckBox();
        cb_vb = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        member_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.NO", "ID", "Name", "Phone", "Age", "BloodGroup", "Catagories"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        member_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                member_listMouseClicked(evt);
            }
        });
        member_list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                member_listKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(member_list);
        if (member_list.getColumnModel().getColumnCount() > 0) {
            member_list.getColumnModel().getColumn(0).setResizable(false);
            member_list.getColumnModel().getColumn(0).setPreferredWidth(5);
            member_list.getColumnModel().getColumn(1).setResizable(false);
            member_list.getColumnModel().getColumn(1).setPreferredWidth(5);
            member_list.getColumnModel().getColumn(2).setResizable(false);
            member_list.getColumnModel().getColumn(2).setPreferredWidth(125);
            member_list.getColumnModel().getColumn(3).setResizable(false);
            member_list.getColumnModel().getColumn(3).setPreferredWidth(60);
            member_list.getColumnModel().getColumn(4).setResizable(false);
            member_list.getColumnModel().getColumn(4).setPreferredWidth(50);
            member_list.getColumnModel().getColumn(5).setResizable(false);
            member_list.getColumnModel().getColumn(5).setPreferredWidth(50);
            member_list.getColumnModel().getColumn(6).setResizable(false);
            member_list.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("type the name you want to search");

        cmb_bg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-" }));

        dc_dob.setDateFormatString("dd/MM/yyyy");

        cb_fb.setText("FootBall");
        cb_fb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_fbActionPerformed(evt);
            }
        });

        cb_ckt.setText("Cricket");
        cb_ckt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cktActionPerformed(evt);
            }
        });

        cb_vb.setText("VolleyBall");
        cb_vb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vbActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_update)
                .addGap(18, 18, 18)
                .addComponent(bt_delete)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_fb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cb_ckt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(cb_vb, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_phn)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(tf_search))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmb_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(34, 34, 34)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dc_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 177, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tf_phn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dc_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_fb)
                            .addComponent(cb_ckt)
                            .addComponent(cb_vb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
        /*DBConnection c=new DBConnection();
        Connection con=c.newDBConnection();
        String report = "D:\\N&N\\SportsClub\\SportsClub-master\\src\\sportsclub\\members.jrxml";
        try{
            JasperDesign jd = JRXmlLoader.load(report);
            JRDesignQuery newquery = new JRDesignQuery();
            String name= lbl_search.getText();
            newquery.setText("select * from members where name='"+name+"'");
            jd.setQuery(newquery);
            JasperReport jp = JasperCompileManager.compileReport(jd);
            System.out.println("Compiled...");
            JasperPrint jprint = JasperFillManager.fillReport(jp,null,con);
            JasperViewer.viewReport(jprint,false);
        }catch(Exception e){
            
        }*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        if(search==1){
            ArrayList<MemberList> al=null;
            al=new ArrayList<MemberList>();
            String sr=tf_search.getText().toString();
            try{
                DBConnection c=new DBConnection();
                Connection con=c.newDBConnection();
                System.out.println("Connection Established");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from members where name like '%"+sr+"%'");
                MemberList list;
        
                while(rs.next()){
                    list =new MemberList(rs.getString(1),rs.getString("name"),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                    al.add(list);
                }
                dt = (DefaultTableModel) member_list.getModel();
                dt.setRowCount(0);
                Object[] row = new Object[7];
                int j=1;
                for (int i = 0; i <al.size(); i++) {
                    row[0]=j;
                    row[1]=al.get(i).getId();
                    row[2]=al.get(i).getName();
                    row[3]=al.get(i).getPhone();
                    row[4]=findAge(al.get(i).getDob());
                    row[5]=al.get(i).getBg();
                    row[6]=al.get(i).getCtgry();
                    j++;
                    dt.addRow(row);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            //fillTable();
        }
        
    }//GEN-LAST:event_tf_searchKeyReleased

    
    public void filltable(int a){
        String sql="select * from members";
        if(a%2==0){
            if(a%3==0){
                if(a%5==0)
                    sql="select * from members where sports like '%FootBall,Cricket,VolleyBall%'";
                else
                   sql="select * from members where sports like '%FootBall,Cricket%'"; 
            }
            else
                sql="select * from members where sports like '%FootBall%'";
        }
        else if(a%3==0){
                if(a%5==0)
                    sql="select * from members where sports like '%Cricket,VolleyBall%'";
                else
                   sql="select * from members where sports like '%Cricket%'"; 
            }
        
        else if(a%5==0){
            sql="select * from members where sports like '%VolleyBall%'";
        }
        
        ArrayList<MemberList> al=null;
        al=new ArrayList<MemberList>();
        
        try{
            DBConnection c=new DBConnection();
            Connection con=c.newDBConnection();
            System.out.println("Connection Established");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            MemberList list;
        
            
            while(rs.next()){
                list =new MemberList(rs.getString(1),rs.getString("name"),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                al.add(list);
            }
            dt = (DefaultTableModel) member_list.getModel();
            dt.setRowCount(0);
            Object[] row = new Object[7];
            int j=1;
            for (int i = 0; i <al.size(); i++) {
                row[0]=j;
                row[1]=al.get(i).getId();
                row[2]=al.get(i).getName();
                row[3]=al.get(i).getPhone();
                row[4]=findAge(al.get(i).getDob());
                row[5]=al.get(i).getBg();
                row[6]=al.get(i).getCtgry();
                j++;
                dt.addRow(row);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    private void member_listKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_member_listKeyPressed
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_member_listKeyPressed

    private void member_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_member_listMouseClicked
        // TODO add your handling code here:
        int ind = member_list.getSelectedRow();
        showItemToFields(ind);
        search = 0;
    }//GEN-LAST:event_member_listMouseClicked

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        // TODO add your handling code for Update:
        
        if((tf_search.getText().trim().isEmpty()) || (tf_phn.getText().trim().isEmpty()) ){
            JOptionPane.showMessageDialog(null,"all fields are recquired...");
        }
        else{
                
                    try{
                        DBConnection c=new DBConnection();
                        try (Connection con = c.newDBConnection()) {
                        System.out.println("connection established");
                        String date = sdf.format(dc_dob.getDate());
                        String qry ="update members set name=?, phone=?, dob=?, bg=?, sports=?  where id=?" ;
                        PreparedStatement stmt=con.prepareStatement(qry);
                        System.out.println("statement created");
                        stmt.setString(1, tf_search.getText()) ;
                        stmt.setString(2, tf_phn.getText()) ;
                        stmt.setString(3, date) ;
                        stmt.setString(4, (String) cmb_bg.getSelectedItem()) ;
                        String sports=null;
                        if(cb_fb.isSelected()){
                            if(sports==null)
                                sports="FootBall";
                            else
                                sports=sports+"FootBall";}
                        if(cb_ckt.isSelected()){
                            if(sports==null)
                                sports="Cricket";
                            else
                            sports=sports+",Cricket";}
                        if(cb_vb.isSelected()){
                            if(sports==null)
                                sports="VolleyBall";
                            else
                            sports=sports+",VolleyBall";}
                        stmt.setString(5, sports) ;
                        stmt.setString(6, id);
                        System.out.println("statement created");
                        int res=stmt.executeUpdate();
                        if(res>=1){
                            JOptionPane.showMessageDialog(null, "MemberDetail Updated Successfully...");
                            try{
                                
                                
                                String sql="select * from admin where active=1";
                                PreparedStatement un=con.prepareStatement(sql);
                                ResultSet rs= un.executeQuery(sql);
                                String uname="";
                                if(rs.next()){
                                    uname=rs.getString(3);
                                }
                                PreparedStatement pst=con.prepareStatement("insert into history values(?,?,?,?)");
                                pst.setString(1, uname) ;
                                pst.setString(2, tf_search.getText()) ;
                                Date today =new Date();
                                pst.setString(3, sdf.format(today)) ;
                                pst.setString(4, "Update") ;
                                System.out.println("statement created");
                                int history=pst.executeUpdate();
                                con.close();
                                //this.setVisible(false);
                            }
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null,e);
                        }
                            //tf_name.setText("");
                            //dt_chsr.setDate("");
                            fillTable();
                            id=null;
                            search = 1;
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Something went Wrong...");
                        con.close();
                        id = null;
                        //this.setVisible(false);
                        }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,e);
                }
            }
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        // TODO add your handling code for Delete:
        if(id==null){
            System.out.println("Select a member first...");
        }else{
            int opt = JOptionPane.showConfirmDialog(null, "Do you really want to Delete", "Delete", JOptionPane.YES_NO_OPTION);
            if(opt==0){
            try{
                String qry = "delete from members where id=?";
                DBConnection c=new DBConnection();
                Connection con = c.newDBConnection();
                PreparedStatement ps = con.prepareStatement(qry);
                ps.setString(1, id);
                //JOptionPane.showConfirmDialog(rootPane, closable);
                int res=ps.executeUpdate();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, "Member Deleted Successfully...");
                    try{
                                
                                
                                String sql="select * from admin where active=1";
                                PreparedStatement un=con.prepareStatement(sql);
                                ResultSet rs= un.executeQuery(sql);
                                String uname="";
                                if(rs.next()){
                                    uname=rs.getString(3);
                                }
                                PreparedStatement pst=con.prepareStatement("insert into history values(?,?,?,?)");
                                pst.setString(1, uname) ;
                                pst.setString(2, tf_search.getText()) ;
                                Date today =new Date();
                                pst.setString(3, sdf.format(today)) ;
                                pst.setString(4, "Added") ;
                                System.out.println("statement created");
                                int history=pst.executeUpdate();
                                con.close();
                                //this.setVisible(false);
                            }
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null,e);
                        }
                    fillTable();
                    id=null;
                    search = 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Member Deletetion Failed...");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "somthin...");
            }
        }
        }
        
    }//GEN-LAST:event_bt_deleteActionPerformed

    int a=1;
    private void cb_fbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_fbActionPerformed
        
        if(search==1){
            if(cb_fb.isSelected())
                a=a*2;
            else
                a=a/2;
            filltable(a);
        }
        
    }//GEN-LAST:event_cb_fbActionPerformed

    private void cb_cktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cktActionPerformed
        
        if(search==1){
            if(cb_ckt.isSelected())
                a=a*3;
            else
                a=a/3;
            filltable(a);
        }
    }//GEN-LAST:event_cb_cktActionPerformed

    private void cb_vbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vbActionPerformed
        
        if(search==1){
            if(cb_vb.isSelected())
                a=a*5;
            else
                a=a/5;
            filltable(a);
        }
    }//GEN-LAST:event_cb_vbActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        search=1;
        tf_search.setText("");
        tf_phn.setText("");
        cmb_bg.setSelectedIndex(0);
        cb_ckt.setSelected(false);
        cb_fb.setSelected(false);
        cb_vb.setSelected(false);
        dc_dob.setDate(null);
        fillTable();
    }//GEN-LAST:event_jButton3ActionPerformed

public void setVisitor(){
    jPanel1.setVisible(false);
}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_update;
    private javax.swing.JCheckBox cb_ckt;
    private javax.swing.JCheckBox cb_fb;
    private javax.swing.JCheckBox cb_vb;
    private javax.swing.JComboBox cmb_bg;
    private com.toedter.calendar.JDateChooser dc_dob;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable member_list;
    private javax.swing.JTextField tf_phn;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
