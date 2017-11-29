/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 */
package gestiondubar.humains.clients.interfaces.encapsulations;

import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.interfaces.Servir;

/**
 * Est une classe qui permet de gere la monnaie du bar que les individus possèdent
 * @see #getMonnaieDuBar() getMonnaieDuBar() 
 * @see #setMonnaieDuBar(java.lang.Integer) setMonnaieDuBar()
 * @see #donnerLaMonnaieAuxResponsables(gestiondubar.humains.Humain) donnerLaMonnaieAuxResponsables()
 * @author ISEN
 */
public class ServirClient implements Servir {

    Integer monnaieDuBar = 0;

    /**
     * Permet de connaitre le montant de la monnaie du bar que le personnel a sur lui
     * @return 
     */
    @Override
    public Integer getMonnaieDuBar() {
        return monnaieDuBar;
    }

    /**
     * Permet de modifier la monnaie du bar que le personnel à sur lui
     * @param monnaieDuBar montant qu'on veut attribuer : peut être négatif
     */
    @Override
    public void setMonnaieDuBar(Integer monnaieDuBar) {
        this.monnaieDuBar = monnaieDuBar;
    }
    /**
     * Permet de donner la monnaie du bar à un responsable qui l'ajoute à la casse du bar
     * et met la monnaie du bar des instance à zéro.
     * @param humain est un responsable
     * 
     * 
     */
    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) throws ServirException{
        if (humain instanceof Barman) {
            Barman barman = (Barman) humain;
            barman.getCaisseDuBar().setArgentDuBar(barman.getCaisseDuBar().getArgentDuBar() + this.monnaieDuBar);
            this.setMonnaieDuBar(0);
        }
        else throw new ServirException("doit être un Barman");
    }

}
