/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class ClientParent extends Client {

    public Patronne patronne;
    ArrayList<Enfant> enfants;
    public static ArrayList<String> listeDesMethodesDesMenu = new ArrayList<>();

    static {
        listeDesMethodesDesMenu.addAll(Client.listeDesMethodesDesMenu);
    }

    public ClientParent(String prenom, Patronne patronne) throws AbstractClientException {
        super(prenom);
        this.patronne = patronne;
    }

    public String ajouterUnEnfant(Enfant e) {
        enfants.add(e);
        return this.prenom + " est un parent de " + e.getPrenom();
    }

    public String retirerLesEnfants() {
        enfants.removeAll(enfants);
        return this.prenom + " ne s'ocuppe plus de ses enfants ";
    }

    @Override
    public void boire(Boisson boisson) throws AbstractClientException {
        if (boisson instanceof Boisson) {
            if (this.getDegreAlccolemie() > 7) {
                super.boire(boisson);
            } else {
                retirerLesEnfants();
                super.boire(boisson);
            }
        } else {
            throw new AbstractClientException("Le parametre boisson doit être une instance de Boisson");
        }
        //To change body of generated methods, choose Tools | Templates.
    }

}
