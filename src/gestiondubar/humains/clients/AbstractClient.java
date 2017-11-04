/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.humains.Humain;
import gestiondubar.decore.Boisson;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISEN
 */
public abstract class AbstractClient extends Humain {

    Boisson boissonFavorite = Boisson.EAU;

    Integer degreAlccolemie = 0;

    public AbstractClient(String prenom) {
        super(prenom);
    }

    public Integer getDegreAlccolemie() {
        return degreAlccolemie;
    }

    public void setDegreAlccolemie(Integer degreAlccolemie) throws AbstractClientException {
        if (degreAlccolemie instanceof Integer && degreAlccolemie.compareTo(0) > -1) {
            this.degreAlccolemie = degreAlccolemie;
        } else {
            throw new AbstractClientException("Degrealcolemie ne peut pas etre inférieur à 0");
        }
    }

    @Override
    public void boire(Boisson boisson) throws AbstractClientException {
        if (boisson instanceof Boisson) {
            this.setDegreAlccolemie(this.getDegreAlccolemie() + boisson.getPointsAlcool());
        } else {
            throw new AbstractClientException("Le parametre boisson doit être une instance de Boisson");
        }
    }

    @Override
    public void payer(Humain humain, Integer prix) throws AbstractClientException {
        if (humain instanceof Serveur
                || humain instanceof Barman){
             if( prix instanceof Integer) {
            Serveur serveur = (Serveur) humain;
            serveur.setMonnaieDuBar(serveur.getMonnaieDuBar() + prix);
            super.setPorteMonnaie(super.getPorteMonnaie() - prix);
             }else{
                    throw new AbstractClientException("Le prix doit être non null");
            
                    }
        } else {
            throw new AbstractClientException("Le parametre humain doit etre un barman ou un serveur");
            
        }
    }

    /**
     * L'instance commande une boisson à un membre du personnel et la paye avec
     * son argent.
     *
     * @param boisson
     * @param humain
     * @return
     */
    public Boisson commanderBoisson(Boisson boisson, Humain humain) {
        if ((humain instanceof Serveur
                || humain instanceof Barman)&& boisson instanceof Boisson) {
            Serveur serveur = (Serveur) humain;
            Integer prix = boisson.getPrix();
            try {
                this.payer(serveur, prix);
            } catch (AbstractClientException ex) {
                //  Logger.getLogger(AbstractClient.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            //this.boire(boisson);
            return boisson;
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " BOI" + this.boissonFavorite + " DEG:" + this.degreAlccolemie; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sePresenterA(Humain humain) {

        String str = this.getPrenom() + " dit ";
        Integer DEG = this.degreAlccolemie;
        if (DEG.equals(0)) {
            return str + "salut";
        } else if (DEG > 1 && DEG < 9) {
            return str + "salut c'est cool";
        } else {
            return str + "ch'suis pas bourré dabord";
        }
    }

    @Override
    public void offrirUnVerre(Humain humainChanceux, Humain personnelServant) throws AbstractClientException {
        AbstractClient chanceux = (AbstractClient) humainChanceux;
        Boisson b = this.commanderBoisson(chanceux.boissonFavorite, personnelServant);
        if (b != null) {
            chanceux.boire(b);
        }
    }

}
