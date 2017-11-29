/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore.bars;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.clients.Barman;
import java.util.LinkedList;

/**
 *
 * @author ISEN
 */
public class Stock {
    private LinkedList<BoissonEtQuantite> stockDeBoissonEtQuantite;
    private String nomAdministrateur;
   
    public Stock( String nomAdministrateur) {
        this.stockDeBoissonEtQuantite = new LinkedList<BoissonEtQuantite>();
         this.nomAdministrateur=nomAdministrateur;
    }
     
    public LinkedList<BoissonEtQuantite> getStockDeBoissonEtQuantite() {
     return stockDeBoissonEtQuantite;
     
    }
    public LinkedList<BoissonEtQuantite> getStockDeBoissonEtQuantite(Barman barman) {
        if (barman instanceof Barman )return stockDeBoissonEtQuantite;
        return null;
    }

    public void setStockDeBoissonEtQuantite(LinkedList<BoissonEtQuantite> stockDeBoissonEtQuantite,Barman barman) {
        if (barman instanceof Barman )this.stockDeBoissonEtQuantite = stockDeBoissonEtQuantite;
    }

    public String getNomAdministrateur() {
        return nomAdministrateur;
    }

    public void setNomAdministrateur(String nomAdministrateur) {
        this.nomAdministrateur = nomAdministrateur;
    }

}
