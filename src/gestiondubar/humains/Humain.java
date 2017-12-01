/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public abstract class Humain {

    private final String prenom;
    protected String surnom = "";
    protected Integer porteMonnaie = 0;
    protected Integer coteDePopularite = 0;
    protected String crisignificatif = "";
    protected String sexe = "";
    public static ArrayList<String> listeDesMethodesDesMenu = new ArrayList<>();

    static {
        listeDesMethodesDesMenu.add("getPrenom");
        listeDesMethodesDesMenu.add("getSurnom");
        listeDesMethodesDesMenu.add("getCoteDePopularite");
        listeDesMethodesDesMenu.add("getCriSignificatif");
        listeDesMethodesDesMenu.add("getSexe");
        listeDesMethodesDesMenu.add("getPorteMonnaie");
        listeDesMethodesDesMenu.add("setSurnom");
        listeDesMethodesDesMenu.add("setCoteDePopularite");
        listeDesMethodesDesMenu.add("setCriSignificatif");
        listeDesMethodesDesMenu.add("setSexe");
        listeDesMethodesDesMenu.add("toString");
        listeDesMethodesDesMenu.add("setPorteMonnaie");
        listeDesMethodesDesMenu.add("CoteDePopularite");
    }

    /**
     * initie avec un prenom
     *
     * @param prenom
     * @throws gestiondubar.humains.clients.exceptions.AbstractClientException
     */
    public Humain(String prenom) throws AbstractClientException {
        if (prenom instanceof String) {
            this.prenom = prenom;
        } else {
            throw new AbstractClientException("Le prénom ne peut pas être vide");
        }
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
    public Integer getCoteDePopularite() {
        return coteDePopularite;
    }

    /**
     * Get the value of crisignificatif
     *
     * @return the value of crisignificatif
     */
    public String getCriSignificatif() {
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
     * @return 
     */
    public String setSurnom(String surnom) {
        this.surnom = surnom;
        return "Le surnom de "+this.prenom+" est maintenant" +this.surnom;
    }

    /**
     * Set the value of porteMonnaie
     *
     * @param porteMonnaie new value of porteMonnaie
     */
    public String setPorteMonnaie(Integer porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
        return "Le porte monnaie de "+ this.prenom +" vaut "+this.porteMonnaie;
    }

    /**
     * Set the value of coteDePopularite
     *
     * @param coteDePopularite new value of coteDePopularite
     */
    public String setCoteDePopularite(Integer coteDePopularite) {
        this.coteDePopularite = coteDePopularite;
        return "La cote de popularité de " +this.prenom+" vaut "+this.coteDePopularite;
    }

    /**
     * Set the value of crisignificatif
     *
     * @param crisignificatif new value of crisignificatif
     */
    public String setCriSignificatif(String crisignificatif) {
        this.crisignificatif = crisignificatif;
        return "Le cri significatif de "+this.prenom+" est "+this.crisignificatif;
    }

    /**
     * Set the value of sexe
     *
     * @param sexe new value of sexe
     */
    public String setSexe(String sexe) {
        this.sexe = sexe;
        return "Le sexe de "+this.prenom+ " est "+this.sexe;
    }

    @Override
    public String toString() {
        return "CLA:" + this.getClass().getSimpleName() + " NAM:" + this.prenom + " " + this.surnom + " ARG:" + this.porteMonnaie + " SEXE:" + this.sexe + " " + coteDePopularite + " " + crisignificatif + " ";
    }

    public abstract void boire(Boisson boisson) throws AbstractClientException;

    public abstract void payer(Humain humain, Integer prix) throws AbstractClientException;

    public abstract String sePresenterA(Humain humain) throws AbstractClientException;

    public abstract String offrirUnVerre(Humain humain, Humain serv) throws AbstractClientException;
}
