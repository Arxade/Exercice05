/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classes.Catalogue;
import dao.I_ProduitDAO;
import dao.ProduitDAOFactory;
import dao.ProduitDAORel;

/**
 *
 * @author Alexandre
 */
public class Controleur {
    
    private static Catalogue catalogue = new Catalogue();
    
    public Catalogue getCatalogue()
    {
        I_ProduitDAO dao = ProduitDAOFactory.createProduitDAOXML();
        catalogue.clear();
        catalogue.addProduits(dao.readAll());
        return catalogue;
    }
    
}
