/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.I_Produit;
import classes.Produit;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author diazt
 */
public interface I_ProduitDAO {

    public boolean connect();

    public boolean create(Produit produit);

    public boolean delete(String nomProduit);

    public ArrayList<I_Produit> readAll();

    public Produit read(String nomProduit);
    
    public void updateStock(String nomProduit, int nouveauStock);
}
