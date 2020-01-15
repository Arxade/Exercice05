/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author diazt
 */
public class Connexion {
    
    protected Connection connection = null;
    protected DatabaseMetaData dbMetadata = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    
    public boolean connect(){
        try {
            String url = "jdbc:oracle:thin:@162.38.222.149:1521:iut";
            connection = DriverManager.getConnection(url, "diazt", "1107013536H");
            return true;
        }
        catch (HeadlessException | SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
            return false;
        } 
    }
}
