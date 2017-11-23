/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients.interfaces;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.BoissonEtQuantite;
import gestiondubar.decore.bars.exceptions.StockException;

/**
 * @see gestiondubar.humains.clients.interfaces.encapsulations.GererLeStockDuBar
 * @author ISEN
 */
public interface GererStock {
    public boolean estPresentDansLeStock(Boisson ceQueJeCherche);
     public boolean existeDansLeStock(Boisson ceQueJeCherche);
     public BoissonEtQuantite getBoissonEtQuantite(Boisson ceQueJeCherche);
     public void setQuantiteDeLaBoisson(Boisson ceQueJeMets, Integer quantite) throws StockException ;
     public Integer getQuantiteDeLaBoisson(Boisson boisson);
}
