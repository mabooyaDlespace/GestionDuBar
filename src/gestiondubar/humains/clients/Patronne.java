/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Bar;
import gestiondubar.humains.clients.exceptions.AbstractClientException;

/**
 * La patronne n'a pas forcément de barman(peut etre un clone de lui) mais le
 * bar a obligatoirement un barman Le barman a obligatoirement une patronne. La
 * patronne a obligatoirement un bar sinon elle est chomeuse.
 *
 * @author ISEN
 */
public class Patronne extends AbstractClient {

    private Bar bar;
    private Barman barman;

    /**
     * Constructeur: Initie le nom, le bar , et le barman.
     *
     * @param nomDeLaPatronne
     * @see Bar
     */
    public Patronne(String nomDeLaPatronne) throws AbstractClientException {
        super(nomDeLaPatronne);
        bar = new Bar(nomDeLaPatronne);
//    this.nomDeLaPatronne=nomDeLaPatronne;
        this.barman = new Barman(nomDeLaPatronne, this);

    }

    public Bar getBar() {
        return bar;
    }

    public Barman getBarman() {
        return barman;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public void setBarman(Barman barman) {
        this.barman = barman;
    }

}
