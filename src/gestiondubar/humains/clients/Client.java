/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;

/**
 *
 * @author ISEN
 */
public class Client extends AbstractClient {

    private Boisson boissonSecours = Boisson.EAU;

    public Client(String prenom) {
        super(prenom);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.boissonFavorite + " " + this.boissonSecours + " DEG:" + this.degreAlccolemie; //To change body of generated methods, choose Tools | Templates.
    }
}
