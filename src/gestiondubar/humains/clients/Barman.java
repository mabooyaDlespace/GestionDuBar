/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Caisse;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.interfaces.Servir;
import gestiondubar.humains.clients.interfaces.barmanetserveur.ServirClient;

/**
 * Le barman a obligatoirement une patronne sinon il est chomeur: peut etre
 * luimeme
 *
 * @author ISEN
 */
public class Barman extends AbstractClient implements Servir {

    private Patronne patronne;
    private Caisse caisseDuBar;
    private Servir servirDesClients = new ServirClient();

    public Barman(String prenom, Patronne patronne) {
        super(prenom);
        this.patronne = patronne;
        caisseDuBar=patronne.getBar().getCaisseDuBar(this);

    }

    public Patronne getPatronne() {
        return patronne;
    }

    public Caisse getCaisseDuBar() {
        return caisseDuBar;
    }

    @Override
    public Integer getMonnaieDuBar() {
        return this.servirDesClients.getMonnaieDuBar();
    }

    public void setPatronne(Patronne patronne) {
        this.patronne = patronne;
    }

    public void setCaisseDuBar(Caisse caisseDuBar) {
        this.caisseDuBar = caisseDuBar;
    }

    @Override
    public void setMonnaieDuBar(Integer monnaieDubar) {
        this.servirDesClients.setMonnaieDuBar(monnaieDubar);
    }
    
     @Override
    public String toString() {
        return super.toString()+" MON:"+this.getMonnaieDuBar(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) {
        this.servirDesClients.donnerLaMonnaieAuxResponsables(humain);

    }
}
