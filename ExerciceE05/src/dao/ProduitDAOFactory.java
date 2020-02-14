/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Alexandre
 */
public class ProduitDAOFactory {
    protected ProduitDAOFactory(){
    
    }

    public static I_ProduitDAO createProduitDAOXML() {
        return new AdaptateurProduitDAO_XML();
    }
    
    public static I_ProduitDAO createProduitDAORelationnel() {
        return new ProduitDAORel();
    }
}
