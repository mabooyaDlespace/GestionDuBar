/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.interfaceutilisateurs;

import gestiondubar.humains.clients.AbstractClient;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Serveur;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISEN
 */
public class InterfaceUtilisateur {
    public static void monTest1(){
        try {
            Scanner demande = new Scanner(System.in);
            System.out.println("1 pour configuration assitée, 2 pour configuration automatique");
            String reponse = demande.nextLine();
            String maString = new String();
//            AbstractClient luc = new Client("Luc");
//            Patronne patronne = new Patronne("Davida");
//            Serveur serv = new Serveur("serv", patronne);
//            patronne.setBarman(new Barman("Babar", patronne));
            if ( reponse == "1") {
                System.out.println("Comment voulez vous appelez la patronne ?");
                String NomPatronne = demande.nextLine();
                Patronne patronne = new Patronne(NomPatronne);
            }
            else if (reponse == "2"){
            
        }
            else{}
        } catch (AbstractClientException ex) {
            Logger.getLogger(InterfaceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

