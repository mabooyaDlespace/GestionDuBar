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
import gestiondubar.humains.clients.interfaces.GererStock;
import gestiondubar.humains.clients.interfaces.Servir;
import gestiondubar.humains.clients.interfaces.encapsulations.GererLeStockDuBar;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirClient;

/**
 * <strong>Le barman a obligatoirement une patronne sinon il est chomeur (peut
 * etre lui-même)</strong>.
 * <br> Il implément l'interface Servir et GererStock (voir See Also)
 *@see Servir
 *@see GererStock
 *@see gestiondubar.humains.clients.AbstractClient
 *@see Barman#donnerLaMonnaieAuxResponsables(gestiondubar.humains.Humain) donnerLaMonnaieAuxResponsables
 *@see Barman#estPresentDansLeStock(gestiondubar.decore.Boisson) estPresentDansLeStock
 *@see Barman#existeDansLeStock(gestiondubar.decore.Boisson) existeDansLeStock
 * @see #getBoissonEtQuantite(gestiondubar.decore.Boisson) getBoissonEtQuantite
 * @see #getCaisseDuBar() getCaisseDuBar
 * @see #getMonnaieDuBar() getMonnaieDuBar
 * @see #getPatronne() getPatronne
 * @see #getQuantiteDe(gestiondubar.decore.Boisson) getQuantiteDe
 * @see #setCaisseDuBar(gestiondubar.decore.Caisse) setCaisseDuBar
 * @see #setMonnaieDuBar(java.lang.Integer) setMonnaieDuBar
 * @see #setPatronne(gestiondubar.humains.clients.Patronne) setPatronne
 * @see #setQuantite(gestiondubar.decore.Boisson, java.lang.Integer) setQuantite
 * @author ISEN
 */
public class Barman extends AbstractClient implements Servir, GererStock {

    private Patronne patronne;
    private Caisse caisseDuBar;
    private Stock stock;
    private Servir servirDesClients = new ServirClient();
    private GererStock gererLeStockDuBar;

    public Barman(String prenom, Patronne patronne) throws AbstractClientException {
        super(prenom);
        this.patronne = patronne;
        caisseDuBar = patronne.getBar().getCaisseDuBar(this);// on controle l'existance du barman avec this
        stock = patronne.getBar().getStock(this);
        gererLeStockDuBar = new GererLeStockDuBar(this, stock);
    }

    public Patronne getPatronne() {
        return patronne;
    }

    public Caisse getCaisseDuBar() {
        return caisseDuBar;
    }

    public void setPatronne(Patronne patronne) {
        this.patronne = patronne;
    }

    public void setCaisseDuBar(Caisse caisseDuBar) {
        this.caisseDuBar = caisseDuBar;
    }

    @Override
    public String toString() {
        return super.toString() + " MON:" + this.getMonnaieDuBar();
    }

    // INTERFACE Servir=========================================================

    /**
     * @see
     * gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#getMonnaieDuBar()
     * ServirClient.getMonnaieDuBar
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     *
     * @param
     */
    @Override
    public Integer getMonnaieDuBar() {
        return this.servirDesClients.getMonnaieDuBar();
    }

    /**
     *
     * @see
     * gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#setMonnaieDuBar(java.lang.Integer)
     * ServirClient.setMonnaieDuBar(int)
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
     * @see Servir
     *
     * @param monnaieDuBar
     */
    @Override
    public void setMonnaieDuBar(Integer monnaieDubar) {
        this.servirDesClients.setMonnaieDuBar(monnaieDubar);
    }

    /**
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient 
     * @see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient#donnerLaMonnaieAuxResponsables(gestiondubar.humains.Humain) donnerLaMonnaieAuxResponsables
     * 
     * 
     
     * @see Servir
     *
     * @param humain 
     */
    @Override
    public void donnerLaMonnaieAuxResponsables(Humain humain) {
        this.servirDesClients.donnerLaMonnaieAuxResponsables(humain);

    }
    // INTERFACE GererStock=====================================================

    @Override
    public boolean estPresentDansLeStock(Boisson ceQueJeCherche) {
        return this.gererLeStockDuBar.estPresentDansLeStock(ceQueJeCherche);
    }

    @Override
    public boolean existeDansLeStock(Boisson ceQueJeCherche) {
        return this.gererLeStockDuBar.existeDansLeStock(ceQueJeCherche);
    }

    @Override
    public BoissonEtQuantite getBoissonEtQuantite(Boisson ceQueJeCherche) {
        return this.gererLeStockDuBar.getBoissonEtQuantite(ceQueJeCherche);
    }

    @Override
    public void setQuantite(Boisson ceQueJeMets, Integer quantite) throws StockException {
        this.gererLeStockDuBar.setQuantite(ceQueJeMets, quantite);
    }

    @Override
    public Integer getQuantiteDe(Boisson boisson) {
        return this.gererLeStockDuBar.getQuantiteDe(boisson);
    }

}
