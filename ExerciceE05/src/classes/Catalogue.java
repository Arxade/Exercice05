/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diazt
 */
public class Catalogue implements I_Catalogue {

    private ArrayList<I_Produit> ensembleProduits;

    public Catalogue() {
        ensembleProduits = new ArrayList<I_Produit>();
    }

    @Override
    public String toString() {
        return "Catalogue{" + "ensembleProduits=" + ensembleProduits + '}';
    }

    @Override
    public boolean addProduit(I_Produit produit) {
        boolean ajoute = true;
                if (produit == null || produit.getPrixUnitaireHT() <= 0 || produit.getQuantite() <= 0) {
            ajoute = false;
        }
        for (I_Produit p : ensembleProduits) {
            if (p.getNom() == produit.getNom()) {
                ajoute = false;
            }
        }
        if (ajoute) {
            ensembleProduits.add(produit);
        }
        return ajoute;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        boolean ajoute = true;
        if  (prix <= 0 || qte <= 0){
            ajoute = false;
        }
        
        for (I_Produit p : ensembleProduits) {
            if (p.getNom() == nom) {
                ajoute = false;
            }
        }
        if (ajoute) {
            Produit produit = new Produit(nom, prix, qte);
            ensembleProduits.add(produit);
        }
        return ajoute;
    }

    @Override
    public int addProduits(List<I_Produit> liste) {
        int i = 0;
        if (liste != null) {
            for (I_Produit prod : liste) {
                if (prod.getPrixUnitaireHT() > 0 && prod.getQuantite() >= 0) {
                    ensembleProduits.add(prod);
                    i++;
                }

            }
        }
        return i;
    }

    @Override
    public boolean removeProduit(String nom) {
        boolean remove = false;
        I_Produit produitAEfface = null;
        for (I_Produit prod : ensembleProduits) {
            if (prod.getNom() == nom) {
                remove = true;
                produitAEfface = prod;
            }
        }

        if (remove) {
            ensembleProduits.remove(produitAEfface);
        }

        return remove;
    }

    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        I_Produit produitAchete = null;
        int index = 0;
        int i = 0;
        boolean achete = false;
        for (I_Produit prod : ensembleProduits) {
            if (prod.getNom() == nomProduit) {
                produitAchete = prod;
                produitAchete.ajouter(qteAchetee);
                achete = true;
                index = i;
            }
            i++;

        }
        return achete;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        I_Produit produitVendu = null;
        boolean vendu = false;
        for (I_Produit prod : ensembleProduits) {
            if (prod.getNom() == nomProduit) {
                produitVendu = prod;
                return produitVendu.enlever(qteVendue);
            }

        }
        return vendu;
    }

    @Override
    public String[] getNomProduits() {
        String[] lesNoms = new String[ensembleProduits.size()];
        int i = 0;
        for (I_Produit produit : ensembleProduits) {
            lesNoms[i] = produit.getNom();
            i++;
        }

        return lesNoms;
    }

    @Override
    public double getMontantTotalTTC() {
        double total = 0;
        for (I_Produit produit : ensembleProduits) {
            total = total + produit.getPrixStockTTC();
        }

        return total;
    }

    @Override
    public void clear() {
        ensembleProduits.removeAll(ensembleProduits);
    }

}
