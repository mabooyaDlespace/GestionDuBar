/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Client extends AbstractClient {
    
    public String prenom;
    private Boisson boissonSecours = Boisson.EAU;

    public Boisson getBoissonSecours() {
        return boissonSecours;
    }

    public void setBoissonSecours(Boisson boissonSecours) {
        this.boissonSecours = boissonSecours;
    }
      public static ArrayList<String> listeDesMethodesDesMenus = new ArrayList<>();

    static {
        listeDesMethodesDesMenus.addAll(AbstractClient.listeDesMethodesDesMenus);
        listeDesMethodesDesMenus.add("setBoissonSecours");
        listeDesMethodesDesMenus.add("getBoissonSecours");
    }
    public Client(String prenom) throws AbstractClientException {
        super(prenom);
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return super.toString() +"\n\t"+ "BOISSFAV2:" + this.boissonSecours.getNom() ;//+ " DEG:" + this.degreAlccolemie; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public  String sePresenterA(Humain humain) throws AbstractClientException{
        if (humain instanceof Humain) {
            String str = this.getPrenom() + " dit ";
            Integer DEG = this.degreAlccolemie;
            if (DEG<Humain.JOYEUX) {
                return str + "salut";
            } else if (DEG >= Humain.JOYEUX && DEG < Humain.BOURRE) {
                return str + "salut c'est cool "+this.saddresserA(humain);
            } else {
                return str + "ch'suis pas bourré dabord " + this.saddresserA(humain);
            }
        } else {
            throw new AbstractClientException("humain est d'intance null ou pas humain");
        }
    }
    
    private String saddresserA(Humain h){
        if(this.getSexe()==h.getSexe() || this.getSexe()==null || h.sexe == null)return null;
        else if (this.getSexe().equals(Sexe.MR)) return "ma poupée";
        else return "mon beau gosse";
    }
    
    @Override
    public String setSexe(Sexe sexe) {
            this.sexe = sexe;
            return "Le sexe de " + this.prenom + " est " + this.sexe + " et son " + super.updateAttributSpecial();
    }
}
