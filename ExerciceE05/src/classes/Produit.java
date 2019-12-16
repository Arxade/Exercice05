/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.lang.Math;

/**
 *
 * @author diazt
 */
public class Produit implements I_Produit {

    private int quantiteStock;
    private String nom;
    private double prixUnitaireHT;
    static private double tauxTVA = 0.2;

    public Produit() {

    }

    public Produit(String nom, double prixUnitaireHT, int quantiteStock) {
        this.quantiteStock = quantiteStock;
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    public void setPrixUnitaireHT(double prixUnitaireHT) {
        this.prixUnitaireHT = prixUnitaireHT;
    }

    public static double getTauxTVA() {
        return tauxTVA;
    }

    public static void setTauxTVA(double tauxTVA) {
        Produit.tauxTVA = tauxTVA;
    }

    @Override
    public String toString() {
        return "Nom du produit : " + nom + "\nPrix HT : " + prixUnitaireHT + "€" + "\nStock : " + quantiteStock;
    }

    @Override
    public boolean ajouter(int qteAchetee) {
        quantiteStock = quantiteStock + qteAchetee;
        return true;
    }

    @Override
    public boolean enlever(int qteVendue) {
        if (quantiteStock - qteVendue >= 0) {
            quantiteStock = quantiteStock - qteVendue;
            return true;
        } else {
            System.out.println("Stock épuisé ou insuffisant");
                    return false;

        }

    }

    @Override
    public int getQuantite() {
        return quantiteStock;
    }

    @Override
    public double getPrixUnitaireTTC() {
       double res = prixUnitaireHT * (1 + tauxTVA) ;
       return Math.round( res * 100 ) / 100;
    }

    @Override
    public double getPrixStockTTC() {
       double res = (prixUnitaireHT *  quantiteStock) * (1 + tauxTVA) ;
       return Math.round( res * 100 ) / 100;
    }

}
