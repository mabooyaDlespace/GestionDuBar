package gestiondubar.interfaceutilisateurs;

import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISEN
 */
public class InterfaceUtilisateurJC {

    public Patronne patronne;// La patronne a en attribut la bar et le barman:
    //on peut donc acceder à tout le bar via cette class
    //Regarde ses attributs
    ArrayList array;
    public ScanNomMode SNM = new ScanNomMode();

    public InterfaceUtilisateurJC() { // on ne s'ent sert pas, sauf dans le main du projet

    }

    private InterfaceUtilisateurJC(Patronne patronne) {
        this.patronne = patronne;

    }

    public String monTest1QuiEstMaMethodeMain() {
        try {
            InterfaceUtilisateurJC inter = new InterfaceUtilisateurJC(new Patronne("initValue"));

            // remplacé par la fonction
            inter.SNM = firstScanner(inter.SNM);
            // On met tout dans une fonction
            //  InterfaceUtilisateurJC.firstScanner();
            if (inter.SNM.mode == '1') {
                System.out.println("vous avez choisi la configuration assitée");
                System.out.println("Choisissez un nom pour la Daronne");
                //==============================================================
                String NomPatronne = inter.scanNomUntilNotEmpty(SNM, 5).NomFinal;
                System.out.println("La patronne s'appelle " + NomPatronne);
                inter.SNM.NomFinal = NomPatronne;
                //et maintenant on crée une instance============================
                this.patronne = new Patronne(NomPatronne);
            } else if (inter.SNM.mode == '2') {
                System.out.println("vous avez choisi la configuration automatique");
                String ChoixPatronne[] = {"Ingrid", "Ursule", "Roger", "Eli", "Jeanne", "Bob"};
                String AdjectifPatronne[] = {"La Soularde", "La Brute", "Le Truand", "La Cartouche", "L'illustre", "La Canaille"};
                int j = (int) (Math.random() * (6 - 0));
                int k = (int) (Math.random() * (6 - 0));
                String Nom = ChoixPatronne[j];
                String Adjectif = AdjectifPatronne[k];
                System.out.println("La patronne s'appelle " + Nom + " " + Adjectif);
                inter.SNM.NomFinal = Nom + " " + Adjectif;
                //et maintenant on crée une instance============================
                inter.patronne = new Patronne(Nom);
                inter.patronne.setSurnom(Adjectif);
            }
            return (inter.SNM.NomFinal);

        } catch (AbstractClientException ex) {
            Logger.getLogger(InterfaceUtilisateurJC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //===================================================
    /**
     * exemple de sous class créer car on utilise bcp le nom la reponse et etc... <br>
     * tu peux te simplifier la vie avec les ArrayList
     */
    public class ScanNomMode {

        //initialisation des variables
        public Scanner scan = new Scanner(System.in);
        public char reponse = ' ';
        public char mode = ' ';
        public String NomFinal = " ";

    }
    /**
     * Remplace le code du début du scan
     * @param SNM
     * @return 
     */
    public ScanNomMode firstScanner(ScanNomMode SNM) {
        do {//tant que reponse n'est pas 1 ou 2
            SNM.mode = ' ';
            System.out.println("Veuillez choisir un mode de configuration : ");
            System.out.println("1 pour configuration assitée, 2 pour configuration automatique ");
            SNM.mode = SNM.scan.nextLine().charAt(0);

            if (SNM.mode != '1' && SNM.mode != '2') {
                System.out.println("Mode inconnu, veuillez réitérer votre choix.");
            }

        } while (SNM.mode != '1' && SNM.mode != '2');
        return SNM;
    }

    /**
     * tatn que le nom de fait pas la taille minimum on scan
     * @param SNM
     * @param tailleMinimum
     * @return 
     */
    public ScanNomMode scanNomUntilNotEmpty(ScanNomMode SNM, Integer tailleMinimum) {
        System.out.println("La taille du nom doit être d'aumoins " + tailleMinimum + " char");
        do {//tant que taille inf do
            SNM.NomFinal = SNM.scan.nextLine();
            if (SNM.NomFinal.length() < tailleMinimum) {
                System.out.println("Taille minimum: " + tailleMinimum + " Taille actuelle : " + SNM.NomFinal.length());
            }

        } while (SNM.NomFinal.length() < tailleMinimum);
        return SNM;
    }

}
