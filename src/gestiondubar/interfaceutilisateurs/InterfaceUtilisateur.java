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
import java.util.Random;

/**
 *
 * @author ISEN
 */
public class InterfaceUtilisateur {

    public static String monTest1() {
        //try {
        Scanner sc = new Scanner(System.in);

        //initialisation des variables
        
        char reponse = ' ', mode = ' ';
        String NomFinal =" ";

        do {//tant que reponse n'est pas 1 ou 2
            mode = ' ';
            System.out.println("Veuillez choisir un mode de configuration : ");
            System.out.println("1 pour configuration assitée, 2 pour configuration automatique ");
            mode = sc.nextLine().charAt(0);

            if (mode != '1' && mode != '2') {
                System.out.println("Mode inconnu, veuillez réitérer votre choix.");
                                            }

            } while (mode != '1' && mode != '2');

      
        if (mode == '1') {
            System.out.println("vous avez choisi la configuration assitée");
            System.out.println("Choisissez un nom pour la Daronne");
            String NomPatronne = sc.nextLine();
            System.out.println("La patronne s'appelle " + NomPatronne);       
            NomFinal = NomPatronne;
                        }
        
        else if (mode == '2') {
            System.out.println("vous avez choisi la configuration automatique");
            String ChoixPatronne[] = {"Ingrid","Ursule","Roger","Eli","Jeanne","Bob"};
            String AdjectifPatronne[]={"La Soularde", "La Brute","Le Truand","La Cartouche","L'illustre","La Canaille"};
            int j = (int) (Math.random()*(6-0));
            int k = (int) (Math.random()*(6-0));
            String Nom = ChoixPatronne[j];
            String Adjectif = AdjectifPatronne[k];
            System.out.println("La patronne s'appelle " + Nom +" "+ Adjectif);
            NomFinal = Nom +" "+ Adjectif;
                            }
        return (NomFinal);
        
        //String maString = new String();
        //            AbstractClient luc = new Client("Luc");
        //            Patronne patronne = new Patronne("Davida");
         //          Serveur serv = new Serveur("serv", patronne);
        //            patronne.setBarman(new Barman("Babar", patronne));
        
         //} catch (AbstractClientException ex) {
        //Logger.getLogger(InterfaceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
    }

}
