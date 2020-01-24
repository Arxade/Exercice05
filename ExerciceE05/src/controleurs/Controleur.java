/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classes.Catalogue;
import dao.ProduitDAORel;

/**
 *
 * @author Alexandre
 */
public class Controleur {
    
    private static Catalogue catalogue = new Catalogue();
    
    public Catalogue getCatalogue()
    {
        ProduitDAORel dao = new ProduitDAORel();
        catalogue.clear();
        catalogue.addProduits(dao.readAll());
        return catalogue;
    }
    
}
