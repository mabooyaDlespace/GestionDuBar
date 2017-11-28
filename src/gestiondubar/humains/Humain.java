/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.clients.exceptions.AbstractClientException;

/**
 *
 * @author ISEN
 */
public abstract class Humain {

    private final String prenom;
    protected String surnom ="";
    protected Integer porteMonnaie = 0;
    protected String coteDePopularite = "0";
    protected String crisignificatif = "";
    protected String sexe = "";

    /**
     * initie avec un prenom
     * @param prenom 
     * @throws gestiondubar.humains.clients.exceptions.AbstractClientException 
     */
    public Humain(String prenom) throws AbstractClientException {
       if(prenom instanceof String) this.prenom=prenom;
       else throw new  AbstractClientException("Le prénom ne peut pas être vide");
    }

    

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Get the value of surnom
     *
     * @return the value of surnom
     */
    public String getSurnom() {
        return surnom;
    }

    /**
     * Get the value of porteMonnaie
     *
     * @return the value of porteMonnaie
     */
    public Integer getPorteMonnaie() {
        return porteMonnaie;
    }

    /**
     * Get the value of coteDePopularite
     *
     * @return the value of coteDePopularite
     */
    public String getCoteDePopularite() {
        return coteDePopularite;
    }
       /**
     * Get the value of crisignificatif
     *
     * @return the value of crisignificatif
     */
    public String getCrisignificatif() {
        return crisignificatif;
    }
   
   /**
     * Get the value of sexe
     *
     * @return the value of sexe
     */
    public String getSexe() {
        return sexe;
    }
//SETTER========================================================================
    /**
     * Set the value of surnom
     *
     * @param surnom new value of surnom
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    /**
     * Set the value of porteMonnaie
     *
     * @param porteMonnaie new value of porteMonnaie
     */
    public void setPorteMonnaie(Integer porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
    }

    /**
     * Set the value of coteDePopularite
     *
     * @param coteDePopularite new value of coteDePopularite
     */
    public void setCoteDePopularite(String coteDePopularite) {
        this.coteDePopularite = coteDePopularite;
    }

   
 

    /**
     * Set the value of crisignificatif
     *
     * @param crisignificatif new value of crisignificatif
     */
    public void setCrisignificatif(String crisignificatif) {
        this.crisignificatif = crisignificatif;
    }

    
    /**
     * Set the value of sexe
     *
     * @param sexe new value of sexe
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString(){
        return "CLA:"+this.getClass().getSimpleName()+" NAM:"+this.prenom+" "+this.surnom+" ARG:"+this.porteMonnaie+" SEXE:"+this.sexe+" "+coteDePopularite+" "+crisignificatif+" ";
    }
    public abstract void boire(Boisson boisson)throws AbstractClientException ;
    public abstract void payer(Humain humain, Integer prix) throws AbstractClientException;
    public abstract String sePresenterA(Humain humain)throws AbstractClientException;
    public abstract void offrirUnVerre(Humain humain, Humain serv)throws AbstractClientException ;
}
