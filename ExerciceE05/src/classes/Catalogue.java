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
        int i = 0;
        for(I_Produit prod:l)
        {
            ensembleProduits.add(prod);
            i++;
        }
        return i;
    }

    @Override
    public boolean removeProduit(String nom) {
        boolean remove = false;
        I_Produit produitAEfface = null;
        for(I_Produit prod: ensembleProduits)
        {
            if(prod.getNom() == nom)
            {
                remove = true;
                produitAEfface = prod;
            }
        }
        
        if(remove)
        {
            ensembleProduits.remove(produitAEfface);
        }
        
        return remove;
    }

    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        I_Produit produitAchete = null;
        int index = 0;
        int i = 0 ;
        boolean achete = false;
        for( I_Produit prod : ensembleProduits )
        {
            if(prod.getNom() == nomProduit)
            {
                produitAchete = prod;
                produitAchete.ajouter(qteAchetee) ;
                achete = true;
                index = i;
            }
            i++;
            
            if(achete)
            {
                ensembleProduits.set(index , produitAchete);
            }
        }
        return achete;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        I_Produit produitVendu = null;
        int index = 0;
        int i = 0 ;
        boolean vendu = false;
        for( I_Produit prod : ensembleProduits )
        {
            if(prod.getNom() == nomProduit)
            {
                produitVendu = prod;
                produitVendu.enlever(qteVendue) ;
                vendu = true;
                index = i;
            }
            i++;
            
            if(vendu)
            {
                ensembleProduits.set(index , produitVendu);
            }
        }
        return vendu;
    }

    @Override
    public String[] getNomProduits() {
        String[] lesNoms = new String[ensembleProduits.size()];
        int i =0;
        for( I_Produit produit : ensembleProduits )
        {
            lesNoms[i] = produit.getNom();
            i++;
        }
        
        return lesNoms ;
    }

    @Override
    public double getMontantTotalTTC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        ensembleProduits.removeAll(ensembleProduits);
    }
    
}
