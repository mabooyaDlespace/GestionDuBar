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
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <b> Est une intance qui implmente la classe GererStock et permet de gerer un
 * Instance de la classe Stock . </b><br>
 * Elle permet de Stocker le corps des fonctions, elle n'est utilisé que par
 * barman. <br>
 *
 * @see Barman
 * @see Stock
 * @see #estPresentDansLeStock(gestiondubar.decore.Boisson)
 * <br>estPresentDansLeStock
 * @see #existeDansLeStock(gestiondubar.decore.Boisson) existeDansLeStock
 * @see #getBoissonEtQuantite(gestiondubar.decore.Boisson)
 * <br>getBoissonEtQuantite
 * @see #getNomAdministrateur() getNomAdministrateur
 * @see #getQuantiteDeLaBoisson(gestiondubar.decore.Boisson)
 * getQuantiteDeLaBoisson
 * @see #getStock() getStock
 * @see #setNomAdministrateur(java.lang.String) <br>setNomAdministrateur
 * @see #setQuantiteDeLaBoisson(gestiondubar.decore.Boisson, java.lang.Integer)
 * setQuantiteDeLaBoisson
 * @see #setStock(java.util.LinkedList) setStock
 * @author ISEN
 */
public class GererLeStockDuBar implements GererStock {

    private LinkedList<BoissonEtQuantite> stock;
    private String nomAdministrateur;
    public static ArrayList<String> listeDesMethodesDesMenus = new ArrayList<>();

    static {
        listeDesMethodesDesMenus.add("estPresentDansLeStock");
        listeDesMethodesDesMenus.add("setQuantiteDeLaBoisson");
        listeDesMethodesDesMenus.add("getQuantiteDeLaBoisson");
        listeDesMethodesDesMenus.add("afficherLeContenuDuStock");
    }

    /**
     * <b> Constructeur pour cette classe </b> .
     * <br> Est généralement implémenté lors de la création du Barman,
     * <br> on par du principe qu'un barman qui n'a pas de stock ou de caisse
     * est un client comme un autre
     * <br> Le stock contient la liste des boissons
     * <br> Le stock est une entité non autonome. Elle nécéssite un barman pour
     * etre exploité
     *
     * @param barman
     * @param stock
     */
    public GererLeStockDuBar(Barman barman, Stock stock) {
        this.stock = stock.getStockDeBoissonEtQuantite(barman);
    }

    /**
     *
     * Permet de verifier si une boisson est présente dans le stock.
     * <br> Même chose que existe sauf que en plus de vérifier si elle est sur
     * la carte,on regarde si la qt n'est pas nulle.
     *
     * @param ceQueJeCherche
     * @return true if stock !=empty && et qt >0
     */
    @Override
    public boolean estPresentDansLeStock(Boisson ceQueJeCherche) {
        if (getStock().isEmpty() || !(ceQueJeCherche instanceof Boisson)) {

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

    /**
     * Permet de vérifier si une boisson est sur la carte (Si ya une instance
     * BoissonEtQuantite)
     *
     * @param ceQueJeCherche
     * @return
     */
    @Override
    public boolean existeDansLeStock(Boisson ceQueJeCherche) {
        if (getStock().isEmpty() || !(ceQueJeCherche instanceof Boisson)) {

            return false;
        }
        for (BoissonEtQuantite bETqt : this.getStock()) {
            if (bETqt instanceof BoissonEtQuantite
                    && bETqt.getBoisson().equals(ceQueJeCherche)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie la reference du couple boisson et quantité
     *
     * @param ceQueJeCherche
     * @return
     */
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
/**
     * Revoie le contenue du stock
     *
     * @return
     */
    @Override
    public String afficherLeContenuDuStock()  {
        String str = "Contenu du Stock:";
        if (this.stock instanceof LinkedList && !(this.stock.isEmpty()) ) {
            for (BoissonEtQuantite betq : this.stock) {
                str += "\n" + betq.getBoisson().toString() + " QUANTITE:" + betq.getQuantite();
            }
            return str;
        }
        return "Il est vide...";
    }
    /**
     * Permet de modifier la quantiter de la boisson et rajoute une instance si
     * n'existe pas dans stock
     *
     * @param ceQueJeMets
     * @param quantite doit etre positive
     * @throws StockException
     */
    @Override
    public void setQuantiteDeLaBoisson(Boisson ceQueJeMets, Integer quantite) throws StockException {
        if (quantite instanceof Integer && quantite.compareTo(0) > -1) {
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

    /**
     * Renvoie la quantité de la boisson
     *
     * @param boisson
     * @return
     */
    @Override
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
