/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestiondubar.humains.clients;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.*;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.Servir;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirClient;
/**
 *
 * @author ISEN
 */
public class Serveur extends AbstractClient implements Servir{
    Patronne patronne=null;
    private Servir servirDesClients= new ServirClient();

  
    public Serveur(String prenom,Patronne patronne) throws AbstractClientException{
        super(prenom);
        this.patronne=patronne;
    }
    
  

    @Override
    public String toString() {
        return super.toString()+" MON:"+this.getMonnaieDuBar(); //To change body of generated methods, choose Tools | Templates.
    }

    // INTERFACE Servir=========================================================
     /**
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#getMonnaieDuBar()  ServirClient.getMonnaieDuBar
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     * 
     * 
     */ 
    @Override
    public Integer getMonnaieDuBar() {
        return this.servirDesClients.getMonnaieDuBar();
    }
     /**
     * 
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#setMonnaieDuBar(java.lang.Integer) ServirClient.setMonnaieDuBar(int)
     *  @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     * 
     * @param monnaieDuBar 
     */
    @Override
    public void setMonnaieDuBar(Integer monnaieDubar) {
        this.servirDesClients.setMonnaieDuBar(monnaieDubar);
    }
    
    /**
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#donnerLaMonnaieAuxResponsables(gestiondubar.humains.Humain) ServirClient.donnerLaMonnaieAuxResponsables(Humain) 
     *  @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     * 
     * @param unserveuroubarman 
     */
    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) {
        this.servirDesClients.donnerLaMonnaieAuxResponsables(humain);

    }
    
}
