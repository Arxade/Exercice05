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
public class ControleurStock extends Controleur{
    
    private Catalogue cat = getCatalogue();
    
    public String getStock(){
        return cat.toString();
    }
    
        public String[] getNomsProduits(){
        return cat.getNomProduits();
    }
    
    
}
