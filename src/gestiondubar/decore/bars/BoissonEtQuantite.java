/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore.bars;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;

/**
 *
 * @author ISEN
 */
public class BoissonEtQuantite {

    Boisson boisson;
    int quantite;

    public BoissonEtQuantite(Boisson boisson, Integer quantite) throws StockException {
        if (boisson instanceof Boisson && quantite.compareTo(0) > -1) {
            this.boisson = boisson;
            this.quantite = quantite;
        } else {
            throw new StockException("boisson is not an instance or Quantité is >0");
        }
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public void setBoisson(Boisson boisson) throws StockException {
        if (boisson instanceof Boisson) {
            this.boisson = boisson;
        } else {

        }
        throw new StockException(" Param boisson is not an instance of Boisson");
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) throws StockException {
        if (quantite.compareTo(0) > -1) {
            this.quantite = quantite;
        } else {
            throw new StockException(" quantite has to be positiv or zero ");
        }
    }

}
