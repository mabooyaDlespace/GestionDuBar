/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISEN
 */
public class Enfant extends Humain {

    ClientParent parent;
    public static ArrayList<String> listeDesMethodesDesMenus = new ArrayList<>();

    static {
        listeDesMethodesDesMenus.addAll(Humain.listeDesMethodesDesMenus);
        listeDesMethodesDesMenus.add("boire");

    }

    public Enfant(String prenom, ClientParent parent) throws AbstractClientException {
        super(prenom);
        this.parent = parent;
    }

    @Override
    public String boire(Boisson boisson) throws AbstractClientException {
        if (!(boisson instanceof Boisson) || boisson.isAvecAlcool()) {
            throw new AbstractClientException("Votre enfant essaie de se souler");
        } else {
            try {
                parent.commanderBoisson(boisson, parent.patronne.getBarman());
                return this.getPrenom() + " a bu " + boisson.getNom() + "offert par son père";
            } catch (StockException ex) {
                throw new AbstractClientException("La commende n'a pas pu etre effectué car"+ex.getMessage(), ex);
            }
        }
    }

    @Override
    public String sePresenterA(Humain humain) throws AbstractClientException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
