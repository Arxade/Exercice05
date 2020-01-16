/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author diazt
 */
public class ProduitFactory {
    
    public static I_Produit createProduit()
    {
        return new Produit();
    }
}
