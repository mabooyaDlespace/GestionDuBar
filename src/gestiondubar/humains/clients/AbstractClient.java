/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.humains.Humain;
import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.Servir;
import java.util.ArrayList;

/**
 * Classe dont herite Barman, Client , Patronne ,Serveur,ClientParent et qui
 * possède les fonction suivantes. Elle est la classe qui contient le corps de
 * plusieurs autres fonction autre que les getter et les setter.
 *
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
 * @see Barman <br>Classe-Barman
 * @see Client Classe-Client
 * @see Patronne Classe-Patronne
 * @see Serveur Classe-Serveur
 * @author ISEN
 */
public abstract class AbstractClient extends Humain {

    protected Boisson boissonFavorite = Boisson.EAU;
    protected Object AttributSpecial = null;
    protected Integer degreAlccolemie = 0;
    public static ArrayList<String> listeDesMethodesDesMenus = new ArrayList<>();

    static {
        listeDesMethodesDesMenus.addAll(Humain.listeDesMethodesDesMenus);
        listeDesMethodesDesMenus.add("commanderBoisson");
        listeDesMethodesDesMenus.add("sePresenterA");
        listeDesMethodesDesMenus.add("offrirUnVerre");
        listeDesMethodesDesMenus.add("demanderSiPresentDansLesStocks");

    }

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
     * <b>Modifie le degre d'alcool en fonction de la boisson.
     * </b> <br> Génnère une exception si boisson n'est pas une instance.
     *
     * @see Boisson
     * @see AbstractClient#getDegreAlccolemie() getDegreAlccolemie
     * @see AbstractClient#setDegreAlccolemie(java.lang.Integer)
     * setDegreAlccolemie
     * @param boisson
     * @throws AbstractClientException
     */
    @Override
    public String boire(Boisson boisson) throws AbstractClientException {
        if (boisson instanceof Boisson) {
            this.setDegreAlccolemie(this.getDegreAlccolemie() + boisson.getPointsAlcool());
            return this.getPrenom() + " a bu de/du" + boisson.getNom();
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
     * <b> L'instance commande une boisson à un membre du personnel et la paye
     * avec son argent.
     * </b> <br> génère une exception si humain n'est pas une instance
     *
     * @param boisson ce quon veut commander
     * @param humain le personnel à qui on le commande
     * @return null sil n'y en a plus dans le stock
     * @throws gestiondubar.humains.clients.exceptions.AbstractClientException
     */
    public Boisson commanderBoisson(Boisson boisson, Humain humain) throws AbstractClientException, StockException {

        if ((humain instanceof Servir
                || humain instanceof Servir)
                && boisson instanceof Boisson
                && this.demanderSiPresentDansLesStocks(humain, boisson, 1)) {

            Integer prix = boisson.getPrix();
            this.payer(humain, prix);//source exception
            //this.boire(boisson);
            if (humain instanceof Serveur) {
                Serveur s = (Serveur) humain;
                int i = s.getPatronne().getBarman().getQuantiteDeLaBoisson(boisson);
                s.getPatronne().getBarman().setQuantiteDeLaBoisson(boisson, i - 1);
            } else {
                Barman b = (Barman) humain;
                int i = b.getQuantiteDeLaBoisson(boisson);
                b.setQuantiteDeLaBoisson(boisson, i - 1);
            }
            return boisson;
        } else {
            if (!(boisson instanceof Boisson)) {
                throw new AbstractClientException("le parametre n'est pas une instance de boisson ");
            } else {
                throw new AbstractClientException("Le parametre humain n'est pas une instance de Personnel(Barman/Serveur)");
            }
        }

    }

    /**
     * On regarde s'il yen a au moins une On regarde sil y en a suffisament pour
     * le client
     *
     * @overload
     * @param humain
     * @param serveur Doit être une instance
     * @param boisson Doit etre une instance
     * @param quantite >=1
     * @return
     * @throws gestiondubar.humains.clients.exceptions.AbstractClientException
     */
    public boolean demanderSiPresentDansLesStocks(Humain humain, Boisson boisson, Integer quantite) throws AbstractClientException {
        if (humain instanceof Serveur) {
            Serveur serveur = (Serveur) humain;
            return this.demanderSiPresentDansLesStocksServeur(serveur, boisson, quantite);
        } else if ((humain instanceof Barman)) {
            Barman barman = (Barman) humain;
            return this.demanderSiPresentDansLesStocksBarman(barman, boisson, quantite);
        } else {
            throw new AbstractClientException(" n'est pas un membre du personnel ");
        }

    }

    /**
     * On regarde s'il yen a au moins une On regarde sil y en a suffisament pour
     * le client
     *
     * @param serveur Doit être une instance
     * @param boisson Doit etre une instance
     * @param quantite >=1
     * @return
     */
    public boolean demanderSiPresentDansLesStocksServeur(Serveur serveur, Boisson boisson, Integer quantite) throws AbstractClientException {
        if (serveur instanceof Serveur
                && boisson instanceof Boisson
                && quantite.compareTo(0) > 0 // si supérieur à zero
                && serveur.getPatronne().getBarman().estPresentDansLeStock(boisson) // on regarde s'il yen a au moins une
                && serveur.getPatronne().getBarman().getQuantiteDeLaBoisson(boisson).compareTo(quantite) > -1) // on regarde sil y en a suffisament pour le client
        {
            return true;
        } else {
            if (!(serveur instanceof Serveur)) {
                throw new AbstractClientException("Le parametre humain n'est pas une instance de Personnel");
            } else if (!(boisson instanceof Boisson)) {
                throw new AbstractClientException("le parametre n'est pas une instance de boisson ");
            } else {
                throw new AbstractClientException("N'est pas une instance de boisson ou quant inf à 1");
            }

        }
    }

    /**
     * On regarde s'il yen a au moins une On regarde sil y en a suffisament pour
     * le client
     *
     * @param serveur Doit être une instance
     * @param boisson Doit etre une instance
     * @param quantite >=1
     * @return
     */
    public boolean demanderSiPresentDansLesStocksBarman
        (Barman serveur, Boisson boisson, Integer quantite) throws AbstractClientException {
        if (serveur instanceof Barman
                && boisson instanceof Boisson
                && quantite.compareTo(0) > 0 // si supérieur à zero
                && serveur.estPresentDansLeStock(boisson) // on regarde s'il yen a au moins une
                && serveur.getQuantiteDeLaBoisson(boisson).compareTo(quantite) > -1) // on regarde sil y en a suffisament pour le client
        {
            return true;
        } else {
            if (!(serveur instanceof Barman)) {
                throw new AbstractClientException("Le parametre humain n'est pas une instance de Personnel");
            } else if (!(boisson instanceof Boisson)) {
                throw new AbstractClientException("le parametre n'est pas une instance de boisson ");
            } else {
                throw new AbstractClientException("N'est pas une instance de boisson ou quant inf à 1");
            }
        }
    }

    /**
     *
     * @return une description du client
     */
    @Override
    public String toString() {
        return super.toString() + "\n\t BOISSFAV:" + this.boissonFavorite.getNom() + " ALCOMEMIE:" + this.degreAlccolemie; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Dépend du degré d'alcolémie Renvoie prenom + phrase
     *
     * @param humain la personne à qui on veut se présenter
     *
     * @param
     * @return
     */
    @Override
    public String sePresenterA(Humain humain) throws AbstractClientException {
        if (humain instanceof Humain) {
            String str = this.getPrenom() + " dit ";
            Integer DEG = this.degreAlccolemie;
            if (DEG < Humain.JOYEUX) {
                return str + "salut";
            } else if (DEG >= Humain.JOYEUX && DEG < Humain.BOURRE) {
                return str + "salut c'est cool";
            } else {
                return str + "ch'suis pas bourré dabord";
            }
        } else {
            throw new AbstractClientException("humain est d'intance null ou pas humain");
        }
    }

    /**
     *
     * <b> Permet d'offire un verre à un a un chanceu </>. Génère une exception
     * si n'est pas une instance. instance commande la boisson favorite de du
     * chanceu et le chancieux la boit si possible
     *
     * @param humainChanceux instance issue d'abstractclient
     * @param personnelServant Une instane barman serveur
     * @throws AbstractClientException
     */
    public String offrirUnVerre(Humain humainChanceux, Humain personnelServant) throws AbstractClientException, StockException {

        if (humainChanceux instanceof Humain) {
            if (personnelServant instanceof Humain) {
                AbstractClient chanceux = (AbstractClient) humainChanceux;
                Boisson b = this.commanderBoisson(chanceux.boissonFavorite, personnelServant);
                if (b != null) {
                    chanceux.boire(b);
                    return "\n" + humainChanceux.getPrenom() + "a bu " + b.getNom() + " offert par " + this.getPrenom();

                } else {
                    throw new AbstractClientException("la boisson n'existe pas");
                }

            } else {
                throw new AbstractClientException("personnel n'est pas une instance");
            }

        } else {
            throw new AbstractClientException("humainChanceux n'est pas une instance");
        }
        //return null;
    }

}
