/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients.interfaces.encapsulations;

import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.interfaces.Servir;

/**
 *
 * @author ISEN
 */
public class ServirClient implements Servir {

    Integer monnaieDuBar = 0;
//zjfnjefqsfq
    @Override
    public Integer getMonnaieDuBar() {
        return monnaieDuBar;
    }

    @Override
    public void setMonnaieDuBar(Integer monnaieDuBar) {
        this.monnaieDuBar = monnaieDuBar;
    }
    /**
     * Permet de donner la monnaie du bar à un responsable qui l'ajoute à la casse du bar
     * @param humain 
     */
    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) {
        if (humain instanceof Barman) {
            Barman barman = (Barman) humain;
            barman.getCaisseDuBar().setArgentDuBar(barman.getCaisseDuBar().getArgentDuBar() + this.monnaieDuBar);
        }
    }

}
