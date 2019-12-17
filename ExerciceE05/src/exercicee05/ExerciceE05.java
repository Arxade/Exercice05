/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicee05;

import interfaces.FenetrePrincipale;
import classes.*;

/**
 *
 * @author diazt
 */
public class ExerciceE05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FenetrePrincipale fenetre = new FenetrePrincipale();
        Produit mars = new Produit("        mars   ", 10, 15);
        Produit mars2 = new Produit("     mars   ", 10, 15);
        System.out.println(mars.getNom().equals(mars2.getNom()));

    }

}
