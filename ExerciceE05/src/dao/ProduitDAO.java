package dao;

import classes.Produit;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
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
        String requete = "DELETE FROM PRODUITS WHERE NOMPRODUIT = " + nomProduit;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(requete);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur suppression de produit : " + ex);
            return false;
        }
    }

    public ResultSet readAll() {
        ResultSet resultat = null;
        try {
            statement = connection.createStatement();
            String requete = "SELECT * FROM PRODUITS";
            resultat = statement.executeQuery(requete);
        } catch (SQLException ex) {
            System.out.println("Erreur read : " + ex);
        }
        return resultat;
    }

    public Produit read(String nomProduit) {
        Produit produit = null;
        try {
            statement = connection.createStatement();
            String requete = "SELECT * FROM PRODUITS WHERE NOMPRODUIT = " + nomProduit;
            statement.executeQuery(requete);
        } catch (SQLException ex) {
            System.out.println("Erreur read : " + ex);
        }
        return produit;
    }

    public void updateNom(String ancienNom, String nouveauNom) {
        String requete = "UPDATE PRODUITS SET NOMPRODUIT = ? WHERE NOMPRODUIT = " + ancienNom;
    }

    public void updatePrixHT(String nomProduit, BigDecimal ancienPrix, BigDecimal nouveauPrix) {
        String requete = "UPDATE PRODUITS SET PRIXHTPRODUIT = ? WHERE NOMPRODUIT = " +nomProduit;
    }
    
    public void updateStock(String nomProduit, int ancienStock, int nouveauStock) {
        String requete = "UPDATE PRODUITS SET PRIXHTPRODUIT = ? WHERE NOMPRODUIT = " + nomProduit;
    }
}
