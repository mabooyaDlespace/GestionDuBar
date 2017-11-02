/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.*;
import gestiondubar.humains.clients.interfaces.Servir;
import gestiondubar.humains.clients.interfaces.barmanetserveur.ServirClient;
/**
 *
 * @author ISEN
 */
public class Serveur extends AbstractClient implements Servir{
    Patronne patronne=null;
    private Servir servirDesClients= new ServirClient();

  
    public Serveur(String prenom,Patronne patronne){
        super(prenom);
        this.patronne=patronne;
    }
    
    public int donnerMonnaieAuBarman(){
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+" MON:"+this.getMonnaieDuBar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getMonnaieDuBar() {
        return this.servirDesClients.getMonnaieDuBar();
    }

    @Override
    public void setMonnaieDuBar(Integer monnaieDubar) {
        this.servirDesClients.setMonnaieDuBar(monnaieDubar);
    }

    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) {
        this.servirDesClients.donnerLaMonnaieAuxResponsables(humain);
    }
    
}
