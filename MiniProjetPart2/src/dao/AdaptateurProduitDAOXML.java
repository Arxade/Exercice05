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
public class AdaptateurProduitDAOXML implements I_ProduitDAO{

    private ProduitDAOXML produitDAO_XML;
    static private AdaptateurProduitDAOXML instanceDAO;
    
    protected AdaptateurProduitDAOXML()
    {
        this.connect();
    }
    
    static public AdaptateurProduitDAOXML getInstance()
    {
        if(instanceDAO == null)
        {
            instanceDAO = new AdaptateurProduitDAOXML();
        }
        return instanceDAO;
    }
    
    @Override
    public boolean connect() {
        try
        {
            System.out.println("Connexion à la BDD");
            produitDAO_XML = new ProduitDAOXML();
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
    public ArrayList<I_Produit> readAll() {
        return (ArrayList) produitDAO_XML.lireTous();
    }

    @Override
    public Produit read(String nomProduit) {
        return (Produit) produitDAO_XML.lire(nomProduit);
    }


    @Override
    public boolean update(Produit produit) {
        return produitDAO_XML.maj(produit);
    }

    @Override
    public boolean delete(Produit produit) {
        return produitDAO_XML.supprimer(produit);
    }
    
    
    
    
    
}
