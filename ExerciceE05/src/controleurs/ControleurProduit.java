/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;
import classes.Catalogue;

/**
 *
 * @author diazt
 */
public class ControleurProduit extends Controleur{
    
    private Catalogue cat = getCatalogue();
        
    public void createProduit(String nom, double prix, int qteStock){
        cat.addProduit(nom, prix, qteStock);
    }
    
    public void removeProduit(String nom){
        cat.removeProduit(nom);
    }
    
    public String[] getNomsProduits(){
        return cat.getNomProduits();
    }
}
