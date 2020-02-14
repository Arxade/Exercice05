/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.I_Produit;
import classes.Produit;
import classes.ProduitFactory;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class AdaptateurProduitDAO_XML implements I_ProduitDAO{

    ProduitDAO_XML produitDAO_XML;
    
    
    public AdaptateurProduitDAO_XML()
    {
        this.connect();
    }
    
    @Override
    public boolean connect() {
        try
        {
            produitDAO_XML = new ProduitDAO_XML();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean create(Produit produit) {
        return produitDAO_XML.creer(produit);
    }

    @Override
    public boolean delete(String nomProduit) {
        I_Produit p = new Produit(nomProduit, 0, 0);
        return produitDAO_XML.supprimer(p);
    }

    @Override
    public ArrayList<I_Produit> readAll() {
        return (ArrayList) produitDAO_XML.lireTous();
    }

    @Override
    public Produit read(String nomProduit) {
        return (Produit) produitDAO_XML.lire(nomProduit);
    }

    @Override
    public void updateStock(String nomProduit, int nouveauStock) {
        I_Produit p = ProduitFactory.createProduit(nomProduit, 0, nouveauStock);
        produitDAO_XML.maj(p);
    }

    @Override
    public void update(Produit produit) {
        produitDAO_XML.maj(produit);
    }
    
    
    
}
