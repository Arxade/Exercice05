/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;
import classes.Catalogue;
import classes.Produit;
import dao.I_ProduitDAO;
import dao.ProduitDAOFactory;
import dao.ProduitDAORel;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
 *
 * @author diazt
 */
public class ControleurTransaction extends Controleur{

    Catalogue cat = getCatalogue();
    
    public void enregistrerAchat(String nomProduit , int qteAchete , Component laFenetre)
    {
        boolean achete = cat.acheterStock(nomProduit, qteAchete);
        
        if(!achete)
        {
            JOptionPane.showMessageDialog(laFenetre, "Achat impossible");
        }
        else
        {
            JOptionPane.showMessageDialog(laFenetre, "Produit acheté");
            I_ProduitDAO dao = ProduitDAOFactory.createProduitDAO();
            Produit produit = dao.read(nomProduit);
            int nouveauStock = produit.getQuantite() + qteAchete;
            dao.updateStock(nomProduit, nouveauStock);
        }
    }
    
    public void enregistrerVente(String nomProduit , int qteVendu , Component laFenetre)
    {
        boolean vendu = cat.vendreStock(nomProduit, qteVendu);
        
        if(!vendu)
        {
            JOptionPane.showMessageDialog(laFenetre, "Vente impossible");
        }
        else
        {
            JOptionPane.showMessageDialog(laFenetre, "Produit vendu");
            I_ProduitDAO dao = ProduitDAOFactory.createProduitDAO();
            Produit produit = dao.read(nomProduit);
            int nouveauStock = produit.getQuantite() - qteVendu;
            dao.updateStock(nomProduit, nouveauStock);
        }
    }
    
}
