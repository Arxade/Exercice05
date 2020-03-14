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

    protected ProduitDAOFactory() {

    }

    public static I_ProduitDAO createProduitDAO(String typeBDD) {
        switch (typeBDD) {
            case "Relationnel":
                return ProduitDAORel.getInstance();
            case "XML":
                return AdaptateurProduitDAOXML.getInstance();
            default:
                return null;
        }
    }

}
