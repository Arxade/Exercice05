/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author diazt
 */
public class Catalogue implements I_Catalogue {

    private List<I_Produit> ensembleProduits;
    
    @Override
    public boolean addProduit(I_Produit produit) {
        boolean ajoute=true;
        for(I_Produit p: ensembleProduits)
        {
            if(p.getNom() == produit.getNom())
            {
                ajoute=false;
            }
        }
        if(ajoute)
        {
            ensembleProduits.add(produit);
        }
        return ajoute;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        boolean ajoute=true;
        for(I_Produit p: ensembleProduits)
        {
            if(p.getNom() == nom)
            {
                ajoute=false;
            }
        }
        if(ajoute)
        {
            Produit produit = new Produit(qte, nom ,prix);
            ensembleProduits.add(produit);
        }
        return ajoute;
    }

    @Override
    public int addProduits(List<I_Produit> l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeProduit(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getNomProduits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMontantTotalTTC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
