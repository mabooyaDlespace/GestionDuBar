/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients.interfaces.encapsulations;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.BoissonEtQuantite;
import gestiondubar.decore.bars.Stock;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.interfaces.GererStock;
import java.util.LinkedList;

/**
 *
 * @author ISEN
 */
public class GererLeStockDuBar implements GererStock {
        private Stock stockDuBar;
        private LinkedList<BoissonEtQuantite> stock;
        private String nomAdministrateur;

    public GererLeStockDuBar( Barman barman,Stock stock ) {
        
        this.stockDuBar=stock;
        this.stock=this.stockDuBar.getStockDeBoissonEtQuantite(barman);
    }

    
     @Override
    public boolean estPresentDansLeStock(Boisson ceQueJeCherche) {
        if (getStock().isEmpty()) {

            return false;
        }
        for (BoissonEtQuantite bETqt : this.getStock()) {
            if (bETqt instanceof BoissonEtQuantite
                    && bETqt.getBoisson().getClass().getSimpleName().equals(ceQueJeCherche.getClass().getSimpleName())
                    && bETqt.getQuantite() > 0) {
                return true;
            }
        }
        return false;
    }

     @Override
    public boolean existeDansLeStock(Boisson ceQueJeCherche) {
        if (getStock().isEmpty()) {

            return false;
        }
        for (BoissonEtQuantite bETqt : this.getStock()) {
            if (bETqt instanceof BoissonEtQuantite
                    && bETqt.getBoisson().getClass().getSimpleName().equals(ceQueJeCherche.getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public BoissonEtQuantite getBoissonEtQuantite(Boisson ceQueJeCherche) {
        if (existeDansLeStock(ceQueJeCherche)) {
            for (BoissonEtQuantite bETqt : this.getStock()) {
                if (bETqt instanceof BoissonEtQuantite
                        && bETqt.getBoisson().getClass().getSimpleName().equals(ceQueJeCherche.getClass().getSimpleName())) {
                    return bETqt;
                }
            }
        }
        return null;
    }

    public void setQuantite(Boisson ceQueJeMets, Integer quantite) throws StockException {
        if (quantite.compareTo(0) > -1) {
            if (this.existeDansLeStock(ceQueJeMets)) {
                BoissonEtQuantite temp = this.getBoissonEtQuantite(ceQueJeMets);
                temp.setQuantite(quantite);
            } else {
                try {
                    getStock().add(new BoissonEtQuantite(ceQueJeMets, quantite));
                } catch (StockException e) {
                    System.out.println(" Boisson n'a pas été ajoutée");
                    System.out.println(e.getMessage());
                }
            }
        } else {
            throw new StockException("La quantité doit etre >= zero");
        }
    }

    public Integer getQuantiteDeLaBoisson(Boisson boisson) {
        if (existeDansLeStock(boisson)) {
            BoissonEtQuantite temp = getBoissonEtQuantite(boisson);
            return temp.getQuantite();
        }
        return 0;
    }

    /**
     * @return the stock
     */
    public LinkedList<BoissonEtQuantite> getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(LinkedList<BoissonEtQuantite> stock) {
        this.stock = stock;
    }

    /**
     * @return the nomAdministrateur
     */
    public String getNomAdministrateur() {
        return nomAdministrateur;
    }

    /**
     * @param nomAdministrateur the nomAdministrateur to set
     */
    public void setNomAdministrateur(String nomAdministrateur) {
        this.nomAdministrateur = nomAdministrateur;
    }

}
