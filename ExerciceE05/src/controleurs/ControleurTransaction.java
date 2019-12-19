/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;
import classes.Catalogue;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
 *
 * @author diazt
 */
public class ControleurTransaction extends Controleur{

    Catalogue cat = getCatalogue();
    
    void enregistrerAchat(String nomProduit , int qteAchete , Component laFenetre)
    {
        boolean achete = cat.acheterStock(nomProduit, qteAchete);
        
        if(!achete)
        {
            JOptionPane.showMessageDialog(laFenetre, "Achat impossible");
        }
    }
    
    void enregistrerVente(String nomProduit , int qteVendu , Component laFenetre)
    {
        boolean vendu = cat.acheterStock(nomProduit, qteVendu);
        
        if(!vendu)
        {
            JOptionPane.showMessageDialog(laFenetre, "Achat impossible");
        }
    }
    
}
