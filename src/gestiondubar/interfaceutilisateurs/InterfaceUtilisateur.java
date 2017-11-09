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

    public static void monTest1() {
        //try {
        Scanner sc = new Scanner(System.in);

        //initialisation des variables
        
        char reponse = ' ', mode = ' ';

        do {//tant que reponse n'est pas 1 ou 2
            mode = ' ';
            System.out.println("1 pour configuration assitée, 2 pour configuration automatique ");
            mode = sc.nextLine().charAt(0);

            if (mode != '1' && mode != '2') {
                System.out.println("Mode inconnu, veuillez réitérer votre choix.");
            }

        } while (mode != '1' && mode != '2');

        /*saisie de la température à convertir
         System.out.println("Température à convertir :");
         aConvertir = sc.nextDouble();
         //Pensez à vider la ligne lue
         sc.nextLine(); */
        //Selon le mode, on affiche le résultat
        if (mode == '1') {
            System.out.println("vous avez choisi la configuration assitée");
            System.out.println("Choisissez un nom pour la Daronne");
            String NomPatronne = sc.nextLine();
            System.out.println("La patronne s'appelle " + NomPatronne);
            
            
            
        } else if (mode == '2') {
            System.out.println("vous avez choisi la configuration automatique");
            String ChoixPatronne[] = {"Ingrid","Ursule","Roger","Eli","Jeanne","Bob"};
            int j = (int) (Math.random()*(6-0));
            String Nom = ChoixPatronne[j];
            System.out.println("La patronne s'appelle" + Nom );
            
            

        } //String maString = new String();
        //            AbstractClient luc = new Client("Luc");
        //            Patronne patronne = new Patronne("Davida");
        //            Serveur serv = new Serveur("serv", patronne);
        //            patronne.setBarman(new Barman("Babar", patronne));
        else {
        }
        // } catch (AbstractClientException ex) {
        //Logger.getLogger(InterfaceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
    }

}
