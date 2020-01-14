package dao;

import classes.Produit;

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
    public ProduitDAO(Connexion con)
    {
        co = con;
    }
    
    public void insert(Produit produit)
    {
        String requete = "INSERT INTO PRODUITS VALUES (?,?,?,?)";
    }
    
    public void delete(Produit produit)
    {
        String requete = "DELETE FROM PRODUITS WHERE NOMPRODUIT = " + produit.getNom();
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
