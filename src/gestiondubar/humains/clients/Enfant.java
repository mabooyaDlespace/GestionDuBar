/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;

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

    public Enfant( String prenom,ClientParent parent) throws AbstractClientException {
        super(prenom);
        this.parent = parent;
    }

   

    @Override
    public void boire(Boisson boisson) throws AbstractClientException {
        parent.offrirUnVerre(this, parent.patronne);
    }

    @Override
    public String sePresenterA(Humain humain) throws AbstractClientException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
