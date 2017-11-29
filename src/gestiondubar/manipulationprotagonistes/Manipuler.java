/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.manipulationprotagonistes;

import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Serveur;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ISEN
 */
public class Manipuler {

    // ArrayListe<Humain> Protagoniste
    public Patronne patronne;
    public ArrayList<Humain> liste;

    public Manipuler(Patronne patronne) throws AbstractClientException {
        this.patronne = patronne;
        this.liste = this.updateListeDesProtagonistes(patronne);
    }

    private ArrayList<Humain> updateListeDesProtagonistes(Patronne patronne) throws AbstractClientException {
        if (patronne instanceof Patronne) {
            this.liste = new ArrayList<Humain>();
            this.liste.add(patronne);
            this.liste.add(patronne.getBarman());
            this.liste.addAll(patronne.getBar().serveurs);
            this.liste.addAll(patronne.getBar().clients);
            return liste;
        } else {
            throw new AbstractClientException("Patronne cant be null");
        }
    }

    public String afficherLesProtagonnistes() {
        Humain hum;
        String description = "";
        for (Iterator<Humain> it = this.liste.iterator(); it.hasNext();) {
            hum = it.next();
            description += "\n" + hum.toString();

        }
        return description.toString();
    }

    public void ajouterUnClient(Humain client) throws AbstractClientException {
        if (client instanceof Humain && !(client instanceof Barman) && !(client instanceof Serveur) && !(client instanceof Patronne)) {
            patronne.getBar().clients.add(client);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

    public void ajouterUnServeur(Serveur serveur) throws AbstractClientException {
        if (serveur instanceof Humain && (serveur instanceof Serveur)) {
            patronne.getBar().serveurs.add(serveur);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

    public void RemplacerLeBarmanConserverCaisseEtStock(String nomBarman) throws AbstractClientException, ServirException {
        if (nomBarman instanceof String) {
            patronne.getBarman().donnerLaMonnaieAuxResponsables(patronne.getBarman());
            Barman barman = new Barman(nomBarman, patronne);
            //patronne.setBarman(barman);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Il la string ne doit pas être vide");
        }

    }

    public void RemplacerLaPatronne() {

    }

    /*
     private 
     AutoClear
     updatelisteDesProtagonistes /maj
     trouverUnProtagoniste
     afficherLesPortagoniste
     changerPatronne  faiblesse sur les attributs propres
     changerBarman    faiblesse sur les attributs propres
     ajouterUnServeur /maj 
     retirerUnServeur /maj 
     ajouterunClient /maj
     retierUnclient  /maj 
     faireUnHumainparler
     faireUnHumainJouer
    
    
    
    
     */
}
