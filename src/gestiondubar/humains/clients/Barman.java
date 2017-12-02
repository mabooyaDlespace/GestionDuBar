/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.Caisse;
import gestiondubar.decore.bars.BoissonEtQuantite;
import gestiondubar.decore.bars.Stock;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.exceptions.BarmanException;
import gestiondubar.humains.clients.interfaces.GererStock;
import gestiondubar.humains.clients.interfaces.Servir;
import gestiondubar.humains.clients.interfaces.encapsulations.GererLeStockDuBar;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirClient;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirException;
import java.util.ArrayList;

/**
 * <strong>Le barman a obligatoirement une patronne sinon il est chomeur (peut
 * etre lui-même)</strong>.
 * <br> Il implément l'interface Servir et GererStock (voir See Also)
 *
 * @see Servir
 * @see GererStock
 * @see gestiondubar.humains.clients.AbstractClient
 * @see Barman#donnerLaMonnaieAuxResponsables(gestiondubar.humains.Humain)
 * <br> donnerLaMonnaieAuxResponsables
 * @see Barman#estPresentDansLeStock(gestiondubar.decore.Boisson)
 * estPresentDansLeStock
 * @see Barman#existeDansLeStock(gestiondubar.decore.Boisson) existeDansLeStock
 * @see #getBoissonEtQuantite(gestiondubar.decore.Boisson) <br>GETTER
 * :getBoissonEtQuantite
 * @see #getCaisseDuBar() getCaisseDuBar
 * @see #getMonnaieDuBar() getMonnaieDuBar
 * @see #getPatronne() getPatronne
 * @see #getQuantiteDeLaBoisson(gestiondubar.decore.Boisson)
 * getQuantiteDeLaBoisson
 * @see #setCaisseDuBar(gestiondubar.decore.Caisse) <br>SETTER: setCaisseDuBar
 * @see #setMonnaieDuBar(java.lang.Integer) setMonnaieDuBar
 * @see #setPatronne(gestiondubar.humains.clients.Patronne) setPatronne
 * @see #setQuantiteDeLaBoisson(gestiondubar.decore.Boisson, java.lang.Integer)
 * setQuantiteDeLaBoisson
 * @author ISEN
 */
public class Barman extends AbstractClient implements Servir, GererStock {

    private Patronne patronne;
    private Caisse caisseDuBar;
    private Stock stock;
    private Servir servirDesClients = new ServirClient();
    private GererStock gererLeStockDuBar;
    public static ArrayList<String> listeDesMethodesDesMenu = new ArrayList<>();

    static {
        listeDesMethodesDesMenu.addAll(AbstractClient.listeDesMethodesDesMenu);
        listeDesMethodesDesMenu.add("donnerLaMonnaieAuxResponsables");
        listeDesMethodesDesMenu.add("getCaisseDuBar");
        listeDesMethodesDesMenu.add("getMonnaieDuBar");
        listeDesMethodesDesMenu.add("getQuantiteDeLaBoisson");
        listeDesMethodesDesMenu.add("setMonnaieDuBar");
        listeDesMethodesDesMenu.add("setQuantiteDeLaBoisson");
        



    }

    /**
     *
     * @param prenom
     * @param patronne
     * @throws AbstractClientException
     */
    public Barman(String prenom, Patronne patronne) throws AbstractClientException {
        super(prenom);
        super.setSexe(Sexe.MR);
        this.patronne = patronne;
        this.patronne.setBarman(this);
        caisseDuBar = patronne.getBar().getCaisseDuBar(this);// on controle l'existance du barman avec this
        stock = patronne.getBar().getStock(this);
        gererLeStockDuBar = new GererLeStockDuBar(this, stock);

    }

    /**
     * Retourn la référance de la patronne.
     *
     * @see Barman
     * @return
     */
    public Patronne getPatronne() {
        return patronne;
    }

    /**
     * Retourn la référence de l'instance de la caisse
     *
     * @return
     */
    public Caisse getCaisseDuBar() {
        return caisseDuBar;
    }

    /**
     * Permet de modifier la référence de ma patronne
     *
     * @param patronne
     */
    public void setPatronne(Patronne patronne) throws BarmanException {
        if (patronne instanceof Patronne) {
            this.patronne = patronne;

        } else {
            throw new BarmanException("La patronne ne peut pas Set to null");
        }
    }

    /**
     * Permet de modifier la référence de la Caisse
     *
     * @param caisseDuBar
     */
    public void setCaisseDuBar(Caisse caisseDuBar) throws BarmanException {
        if (caisseDuBar instanceof Caisse) {
            this.caisseDuBar = caisseDuBar;
        } else {
            throw new BarmanException("La Caisse ne peut pas Set to null");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t" + " MON:" + this.getMonnaieDuBar();
    }

    // INTERFACE Servir=========================================================
    /**
     * Voir celle de ServirClient pour descrption
     *
     * @return
     * @see
     * gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#getMonnaieDuBar()
     * ServirClient.getMonnaieDuBar
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     */
    @Override
    public Integer getMonnaieDuBar() {
        return this.servirDesClients.getMonnaieDuBar();
    }

    /**
     * Voir celle de ServirClient pour descrption
     *
     * @param monnaieDubar
     * @see
     * gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#setMonnaieDuBar(java.lang.Integer)
     * ServirClient.setMonnaieDuBar(int)
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     */
    @Override
    public void setMonnaieDuBar(Integer monnaieDubar) {
        this.servirDesClients.setMonnaieDuBar(monnaieDubar);
    }

    /**
     * Voir celle de ServirClient pour descrption.
     *
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see
     * gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#donnerLaMonnaieAuxResponsables(gestiondubar.humains.Humain)
     * donnerLaMonnaieAuxResponsables
     * @see Servir
     * @param humain
     */
    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) throws ServirException {
        this.servirDesClients.donnerLaMonnaieAuxResponsables(humain);

    }
    // INTERFACE GererStock=====================================================

    /**
     * Voir celle de GererLeStockDuBar pour description.
     *
     * @see GererLeStockDuBar#estPresentDansLeStock(gestiondubar.decore.Boisson)
     * GererLeStockDuBar.estPresentDansLeStock
     * @see GererLeStockDuBar
     * @param ceQueJeCherche
     * @return
     */
    @Override
    public boolean estPresentDansLeStock(Boisson ceQueJeCherche) {
        return this.gererLeStockDuBar.estPresentDansLeStock(ceQueJeCherche);
    }

    /**
     * Voir celle de GererLeStockDuBar pour description.
     *
     * @see GererLeStockDuBar#existeDansLeStock(gestiondubar.decore.Boisson)
     * @see GererLeStockDuBar
     * @param ceQueJeCherche
     * @return
     */
    @Override
    public boolean existeDansLeStock(Boisson ceQueJeCherche) {
        return this.gererLeStockDuBar.existeDansLeStock(ceQueJeCherche);
    }

    /**
     * Voir celle de GererLeStockDuBar pour description.
     *
     * @see
     * GererLeStockDuBar#getQuantiteDeLaBoisson(gestiondubar.decore.Boisson)
     * @see GererLeStockDuBar
     * @param ceQueJeCherche
     * @return
     */
    @Override
    public BoissonEtQuantite getBoissonEtQuantite(Boisson ceQueJeCherche) {
        return this.gererLeStockDuBar.getBoissonEtQuantite(ceQueJeCherche);
    }

    /**
     * Voir celle de GererLeStockDuBar pour description.
     *
     * @see GererLeStockDuBar#setQuantite(gestiondubar.decore.Boisson,
     * java.lang.Integer)
     * @see GererLeStockDuBar
     * @param ceQueJeMets
     * @param quantite
     * @throws StockException
     */
    @Override
    public void setQuantiteDeLaBoisson(Boisson ceQueJeMets, Integer quantite) throws StockException {
        this.gererLeStockDuBar.setQuantiteDeLaBoisson(ceQueJeMets, quantite);
    }

    /**
     * Voir celle de GererLeStockDuBar pour description.
     *
     * @see
     * GererLeStockDuBar#getQuantiteDeLaBoisson(gestiondubar.decore.Boisson)
     * @see GererLeStockDuBar
     * @param boisson
     * @return
     */
    @Override
    public Integer getQuantiteDeLaBoisson(Boisson boisson) {
        return this.gererLeStockDuBar.getQuantiteDeLaBoisson(boisson);
    }

}
