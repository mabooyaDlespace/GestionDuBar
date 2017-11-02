/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar;
import gestiondubar.decore.*;
import gestiondubar.humains.clients.*;

/**
 *
 * @author ISEN
 */
public class GestionDuBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AbstractClient luc = new AbstractClient("Luc");
      
        Patronne patronne= new Patronne("Davida");
          Serveur serv = new Serveur("serv",patronne);
//        patronne.
//        Bar bar=patronne.getBar();
          patronne.setBarman(new Barman("Babar", patronne));
        Barman babar=patronne.getBarman();
        
        Boisson b= luc.commanderBoisson(Boisson.SHOOTER, serv);
        luc.boire(b);
        System.out.println(luc.toString());
        
        System.out.println(serv.toString());
        
       serv.donnerLaMonnaieAuxResponsables(babar);
        System.out.println(patronne.getBar().toString());
        System.out.println(babar.toString());
    }
    
}
