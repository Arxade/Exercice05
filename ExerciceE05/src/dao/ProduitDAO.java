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
    
    public void insert(Produit produit)
    {
        String requete = "INSERT INTO PRODUITS VALUES (?,?,?,?)";
    }
    
    public void delete(Produit produit)
    {
        String requete = "DELETE FROM PRODUITS WHERE NOMPRODUIT = " + produit.getNom();
    }
    
    public void updateNom(Produit produit)
    {
        String requete = "UPDATE PRODUITS SET NOMPRODUIT = ? WHERE NOMPRODUIT = " + produit.getNom();
    }
}
