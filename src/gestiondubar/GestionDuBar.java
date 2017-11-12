/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar;

import gestiondubar.decore.*;
import gestiondubar.humains.clients.*;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.interfaceutilisateurs.InterfaceUtilisateur;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


/**
 *
 * @author ISEN
 */
public class GestionDuBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfaceUtilisateur.monTest1();
        
//        try {
//            // TODO code application logic here
//            AbstractClient luc = new Client("Luc");
//            Patronne patronne = new Patronne(InterfaceUtilisateur.monTest1());
//            Serveur serv = new Serveur("serv", patronne);
//            patronne.setBarman(new Barman("Babar", patronne));
//            Barman babar = patronne.getBarman();
//            
//            Boisson b = luc.commanderBoisson(Boisson.SHOOTER, serv);
//            try {
//                luc.boire(b);
//            } catch (AbstractClientException ex) {
//                Logger.getLogger(GestionDuBar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println(luc.toString());
//            
//            System.out.println(serv.toString());
//            
//            serv.donnerLaMonnaieAuxResponsables(babar);
//            System.out.println(patronne.getBar().toString());
//            System.out.println(babar.toString());
//        } catch (AbstractClientException ex) {
//            Logger.getLogger(GestionDuBar.class.getName()).log(Level.SEVERE, null, ex);
//        }
  }

}
