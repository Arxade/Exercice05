package dao;

import classes.Produit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diazt
 */
public class ProduitDAO {
    
    Connexion co;
    private Connection connect = null;
    private Statement st = null;
    
    public ProduitDAO(Connexion connexion)
    {
        try {
            co = connexion;
            connect = co.connection;
            st = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(Produit produit)
    {
        String requete = "INSERT INTO PRODUITS VALUES (?,?,?,?)";
    }
    
    public void delete(Produit produit)
    {
        try {
            String requete = "DELETE FROM PRODUITS WHERE NOMPRODUIT = " + produit.getNom();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            System.out.println("Erreur suppression" + ex);
        }
    }
    
    public void updateNom(Produit produit , String nouveauNom)
    {
        String requete = "UPDATE PRODUITS SET NOMPRODUIT = ? WHERE NOMPRODUIT = " + produit.getNom();
    }
    
    public void updatePrixHT(Produit produit , String nouveauPrix)
    {
        String requete = "UPDATE PRODUITS SET PRIXHTPRODUIT = ? WHERE NOMPRODUIT = " + produit.getNom();
    }
}
