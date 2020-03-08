/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclub;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DBConnection {
    public Connection newDBConnection()
    {Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsclub" ,"root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally{
        return con;
        }
    }

}