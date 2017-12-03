/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.clients.AttributSpecial;
import gestiondubar.humains.clients.Sexe;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISEN
 */
public abstract class Humain {

    private final String prenom;
    protected String surnom = null;
    protected Integer porteMonnaie = 0;
    protected Integer coteDePopularite = 0;
    protected String crisignificatif = null;
    public Sexe sexe;// = Sexe.MR;
    protected AttributSpecial attributSpecial;
    public static final Integer SOBRE = 0;
    public static final Integer JOYEUX = 5;
    public static final Integer BOURRE = 7;
    public static final Integer DOITVOMIR = 12;

    public static ArrayList<String> listeDesMethodesDesMenus = new ArrayList<>();

    static {
        listeDesMethodesDesMenus.add("getPrenom");
        listeDesMethodesDesMenus.add("getSurnom");
        listeDesMethodesDesMenus.add("getCoteDePopularite");
        listeDesMethodesDesMenus.add("getCriSignificatif");
        listeDesMethodesDesMenus.add("getSexe");
        listeDesMethodesDesMenus.add("getPorteMonnaie");
        listeDesMethodesDesMenus.add("setSurnom");
        listeDesMethodesDesMenus.add("setCoteDePopularite");
        listeDesMethodesDesMenus.add("setCriSignificatif");
        listeDesMethodesDesMenus.add("setSexe");
        listeDesMethodesDesMenus.add("setAttributSpecial");
        listeDesMethodesDesMenus.add("toString");
        listeDesMethodesDesMenus.add("setPorteMonnaie");
        listeDesMethodesDesMenus.add("setPorteMonnaie");
        listeDesMethodesDesMenus.add("setPorteMonnaie");
        listeDesMethodesDesMenus.add("setPorteMonnaie");
        
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
    public Sexe getSexe() {
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
        return "Le surnom de " + this.prenom + " est maintenant" + this.surnom;
    }

    /**
     * Set the value of porteMonnaie
     *
     * @param porteMonnaie new value of porteMonnaie
     */
    public String setPorteMonnaie(Integer porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
        return "Le porte monnaie de " + this.prenom + " vaut " + this.porteMonnaie;
    }

    /**
     * Set the value of coteDePopularite
     *
     * @param coteDePopularite new value of coteDePopularite
     */
    public String setCoteDePopularite(Integer coteDePopularite) {
        this.coteDePopularite = coteDePopularite;
        return "La cote de popularité de " + this.prenom + " vaut " + this.coteDePopularite;
    }

    /**
     * Set the value of crisignificatif
     *
     * @param crisignificatif new value of crisignificatif
     */
    public String setCriSignificatif(String crisignificatif) {
        this.crisignificatif = crisignificatif;
        return "Le cri significatif de " + this.prenom + " est " + this.crisignificatif;
    }

    /**
     * Set the value of sexe
     *
     * @param sexe new value of sexe
     * @return
     */
    public String setSexe(Sexe sexe) {
        if (!(this.getSexe() instanceof Sexe) && (sexe instanceof Sexe)) {
            this.sexe = sexe;
            return "Le sexe de " + this.prenom + " est " + this.sexe + " et son " + updateAttributSpecial();
        } else {
            return " Le sexe est déjà defini: " + this.sexe + " avec un" + " Attribut spécial est " + attributSpecial.toString();
        }
    }

    public String setAttributSpecial(AttributSpecial a) throws AbstractClientException {
        if (this.sexe instanceof Sexe) {
            attributSpecial = a;
            return " Attribut spécial: " + attributSpecial.toString();
        } else {
            throw new AbstractClientException("Set sexe avant de l'attribut");
        }
    }

    protected String updateAttributSpecial() {
        try {
            attributSpecial = AttributSpecial.AutoChoisirUnAttribut(this);
            return " Attribut spécial: " + attributSpecial.toString();
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public String toString() {
        return "CLA:" + this.getClass().getSimpleName() + " NOM:" + this.prenom + " SURNOM:" + this.surnom + " ARGENT:" + this.porteMonnaie + " SEXE:" + this.sexe + " ATTRIBUT:" + this.attributSpecial + " COTEPOP:" + coteDePopularite + " CRISIGNI:" + crisignificatif + " ";
    }

    public abstract void boire(Boisson boisson) throws AbstractClientException;
//
//    public abstract void payer(Humain humain, Integer prix) throws AbstractClientException;

    public abstract String sePresenterA(Humain humain) throws AbstractClientException;

//    public abstract String offrirUnVerre(Humain humain, Humain serv) throws AbstractClientException;
}
