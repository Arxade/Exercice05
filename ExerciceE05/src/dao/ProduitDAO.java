package dao;

import classes.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class ProduitDAO extends Connexion {

    public ProduitDAO() {
        this.connect();
    }

    public boolean create(Produit produit) {
        String requete = "INSERT INTO PRODUITS (idProduit, nomProduit, prixHTProduit, QteStockProduit) "
                + "VALUES (seqProduits.nextval,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, produit.getNom());
            preparedStatement.setBigDecimal(2, produit.getPrixDecimal());
            preparedStatement.setInt(3, produit.getQuantite());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur insertion de produit : " + ex);
            return false;
        }
    }

    public boolean delete(String nomProduit) {
        String requete = "DELETE FROM PRODUITS WHERE NOMPRODUIT = ? ";
        try {
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, nomProduit);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur suppression de produit : " + ex);
            return false;
        }
    }

    public ArrayList<I_Produit> readAll() {
        ResultSet rs = null;
        ArrayList<I_Produit> lesProduits = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String requete = "SELECT * FROM PRODUITS";
            rs = statement.executeQuery(requete);
            while (rs.next())
            {
                I_Produit leProduit = new Produit(rs.getString("NOMPRODUIT"), rs.getDouble("PRIXHTPRODUIT"), rs.getInt("QTESTOCKPRODUIT"));
                lesProduits.add(leProduit);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur read : " + ex);
        }
        System.out.println(lesProduits);
        return lesProduits;
    }

    public Produit read(String nomProduit) {
        ResultSet rs = null;
        Produit produit = null;
        try {
            statement = connection.createStatement();
            String requete = "SELECT * FROM PRODUITS WHERE NOMPRODUIT = '" + nomProduit + "'";
            rs = statement.executeQuery(requete);
            rs.next();
            produit = new Produit(rs.getString("NOMPRODUIT"), rs.getDouble("PRIXHTPRODUIT"), rs.getInt("QTESTOCKPRODUIT"));
        } catch (SQLException ex) {
            System.out.println("Erreur read : " + ex);
        }
        return produit;
    }
    
    public void updateStock(String nomProduit, int nouveauStock) {
        try {
            String requete = "UPDATE PRODUITS SET QTESTOCKPRODUIT = ? WHERE NOMPRODUIT = ? ";
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, nouveauStock);
            preparedStatement.setString(2, nomProduit);
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
