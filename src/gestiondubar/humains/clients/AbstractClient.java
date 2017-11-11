/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.humains.Humain;
import gestiondubar.decore.Boisson;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.Servir;

/**
 * Classe dont herite Barman, Client , Patronne ,Serveur et qui possèdes les
 * fonction suivantes.
 *
 * @see AbstractClient#boire(gestiondubar.decore.Boisson) boire
 * @see AbstractClient#commanderBoisson(gestiondubar.decore.Boisson,
 * gestiondubar.humains.Humain) commander
 * @see AbstractClient#offrirUnVerre(gestiondubar.humains.Humain,
 * gestiondubar.humains.Humain) offrirUnVerre
 * @see AbstractClient#getDegreAlccolemie() getDegreAlccolemie
 * @see AbstractClient#payer(gestiondubar.humains.Humain, java.lang.Integer)
 * payer
 * @see AbstractClient#sePresenterA(gestiondubar.humains.Humain) sePresenterA
 * @see AbstractClient#setDegreAlccolemie(java.lang.Integer) setDegreAlccolemie
 * @see AbstractClient#toString() toString
 * @see Barman Classe-Barman
 * @see Client Classe-Client
 * @see Patronne Classe-Patronne
 * @see Serveur Classe-Serveur
 * @author ISEN
 */
public abstract class AbstractClient extends Humain {

    Boisson boissonFavorite = Boisson.EAU;

    Integer degreAlccolemie = 0;

    /**
     * Ce constructeur est commun à toutes les classes clients
     *
     * @param prenom
     * @throws AbstractClientException
     */
    public AbstractClient(String prenom) throws AbstractClientException {
        super(prenom);
    }

    /**
     * Renvoit le degre d'alcolemie en Integer
     *
     * @see AbstractClient
     * @return
     */
    public Integer getDegreAlccolemie() {
        return degreAlccolemie;
    }

    /**
     * Permet de modifier le degré d'alcolemie
     *
     * @see AbstractClient
     * @param degreAlccolemie
     * @throws AbstractClientException
     */
    public void setDegreAlccolemie(Integer degreAlccolemie) throws AbstractClientException {
        if (degreAlccolemie instanceof Integer && degreAlccolemie.compareTo(0) > -1) {
            this.degreAlccolemie = degreAlccolemie;
        } else {
            throw new AbstractClientException("Degrealcolemie ne peut pas etre inférieur à 0");
        }
    }

    /**
     * Modifie le degre d'alcool en fonction de la boisson
     *
     * @see Boisson
     * @see AbstractClient#getDegreAlccolemie() getDegreAlccolemie
     * @see AbstractClient#setDegreAlccolemie(java.lang.Integer)
     * setDegreAlccolemie
     * @param boisson 
     * @throws AbstractClientException
     */
    @Override
    public void boire(Boisson boisson) throws AbstractClientException {
        if (boisson instanceof Boisson) {
            this.setDegreAlccolemie(this.getDegreAlccolemie() + boisson.getPointsAlcool());
        } else {
            throw new AbstractClientException("Le parametre boisson doit être une instance de Boisson");
        }
    }

    /**
     * Retire le montant du prix , du portemonnaie l'instance et le place dans 
     * "monnaieDuBar" du personnel.
     * 
     * @param humain le personel qu'on va payer (serveur barman)
     * @param prix le montant que l'on va donner
     * @throws AbstractClientException
     * @see Barman
     * @see Serveur
     */
    @Override
    public void payer(Humain humain, Integer prix) throws AbstractClientException {

        if (humain instanceof Serveur) {
            Serveur personnel = (Serveur) humain;
            if (prix instanceof Integer) {

                personnel.setMonnaieDuBar(personnel.getMonnaieDuBar() + prix);
                super.setPorteMonnaie(super.getPorteMonnaie() - prix);
            } else {
                throw new AbstractClientException("Le prix doit être non null");

            }
        } else if (humain instanceof Barman) {
            Barman personnel = (Barman) humain;
            if (prix instanceof Integer) {

                personnel.setMonnaieDuBar(personnel.getMonnaieDuBar() + prix);
                super.setPorteMonnaie(super.getPorteMonnaie() - prix);
            } else {
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
     * @param boisson ce quon veut commander
     * @param humain le personnel à qui on le commande
     * @return
     */
    public Boisson commanderBoisson(Boisson boisson, Humain humain) {
        if ((humain instanceof Servir
                || humain instanceof Servir) && boisson instanceof Boisson) {

            Integer prix = boisson.getPrix();
            try {
                this.payer(humain, prix);
            } catch (AbstractClientException ex) {
                //  Logger.getLogger(AbstractClient.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            //this.boire(boisson);
            return boisson;
        }

        return null;
    }

    /**
     *
     * @return une description du client
     */
    @Override
    public String toString() {
        return super.toString() + " BOI" + this.boissonFavorite + " DEG:" + this.degreAlccolemie; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param humain la personne à qui on vut se présenter
     * @param 
     * @return
     */
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

    /**
     *
     * @param humainChanceux
     * @param personnelServant
     * @throws AbstractClientException
     */
    @Override
    public void offrirUnVerre(Humain humainChanceux, Humain personnelServant) throws AbstractClientException {
        AbstractClient chanceux = (AbstractClient) humainChanceux;
        Boisson b = this.commanderBoisson(chanceux.boissonFavorite, personnelServant);
        if (b != null) {
            chanceux.boire(b);
        }
    }

}
