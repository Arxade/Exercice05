/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.I_Produit;
import classes.Produit;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class AdaptateurProduitDAO_XML implements I_ProduitDAO{

    ProduitDAO_XML produitDAO_XML;
    
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
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<I_Produit> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produit read(String nomProduit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
