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
     

    
//    public boolean estPresentDansLeStock(Boisson ceQueJeCherche) {
//        if (stock.isEmpty()) {
//
//            return false;
//        }
//        for (BoissonEtQuantite bETqt : this.stock) {
//            if (bETqt instanceof BoissonEtQuantite
//                    && bETqt.getBoisson().getClass().getSimpleName().equals(ceQueJeCherche.getClass().getSimpleName())
//                    && bETqt.getQuantite() > 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean existeDansLeStock(Boisson ceQueJeCherche) {
//        if (stock.isEmpty()) {
//
//            return false;
//        }
//        for (BoissonEtQuantite bETqt : this.stock) {
//            if (bETqt instanceof BoissonEtQuantite
//                    && bETqt.getBoisson().getClass().getSimpleName().equals(ceQueJeCherche.getClass().getSimpleName())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private BoissonEtQuantite getBoissonEtQuantite(Boisson ceQueJeCherche) {
//        if (existeDansLeStock(ceQueJeCherche)) {
//            for (BoissonEtQuantite bETqt : this.stock) {
//                if (bETqt instanceof BoissonEtQuantite
//                        && bETqt.getBoisson().getClass().getSimpleName().equals(ceQueJeCherche.getClass().getSimpleName())) {
//                    return bETqt;
//                }
//            }
//        }
//        return null;
//    }
//
//    public void setQuantite(Boisson ceQueJeMets, Integer quantite) throws StockException {
//        if (quantite.compareTo(0) > -1) {
//            if (this.existeDansLeStock(ceQueJeMets)) {
//                BoissonEtQuantite temp = this.getBoissonEtQuantite(ceQueJeMets);
//                temp.setQuantite(quantite);
//            } else {
//                try {
//                    stock.add(new BoissonEtQuantite(ceQueJeMets, quantite));
//                } catch (StockException e) {
//                    System.out.println(" Boisson n'a pas été ajoutée");
//                    System.out.println(e.getMessage());
//                }
//            }
//        } else {
//            throw new StockException("La quantité doit etre >= zero");
//        }
//    }
//
//    public Integer getQuantiteDe(Boisson boisson) {
//        if (existeDansLeStock(boisson)) {
//            BoissonEtQuantite temp = getBoissonEtQuantite(boisson);
//            return temp.getQuantite();
//        }
//        return 0;
//    }

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
