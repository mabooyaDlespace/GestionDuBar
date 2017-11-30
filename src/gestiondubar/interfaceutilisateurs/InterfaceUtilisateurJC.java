package gestiondubar.interfaceutilisateurs;

import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.Serveur;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import gestiondubar.manipulationprotagonistes.Manipuler;

/**
 *
 * @author ISEN
 */
public class InterfaceUtilisateurJC {

    public Patronne patronne;// La patronne a en attribut la bar et le barman:
    //on peut donc acceder à tout le bar via cette classe
    //Regarde ses attributs

    public Barman barman;

    public Client client;

    ArrayList array;
    public ScanNomMode SNM = new ScanNomMode();

    public InterfaceUtilisateurJC() { // on ne s'ent sert pas, sauf dans le main du projet

    }

    //Baronne
    private InterfaceUtilisateurJC(Patronne patronne) {
        this.patronne = patronne;

        //Barman
    }

    private InterfaceUtilisateurJC(Barman barman) {
        this.barman = barman;
    }

    private InterfaceUtilisateurJC(Client client) {
        this.client = client;
    }

    public ScanNomMode monTest1QuiEstMaMethodeMain() {
        try {

            //Initialisation de la patronne
            InterfaceUtilisateurJC inter = new InterfaceUtilisateurJC(new Patronne("initValue"));

            // remplacé par la fonction
            String patronne = " la patronne";
            inter.SNM = firstScanner(inter.SNM, patronne);
            // On met tout dans une fonction
            //  InterfaceUtilisateurJC.firstScanner();
            Manipuler Bar = null;
            
            if (inter.SNM.mode == '1') {
                AffichageChoixConfigManu("la Patronne");
                String NomPatronne = inter.scanNomUntilNotEmpty(SNM, 5).NomFinalPatronne;
                System.out.println("Choisissez un surnom pour la Daronne");   // choix du surnom de la daronne
                String SurnomPatronne = inter.scanStringUntilNotEmpty(SNM.scan, 6);
                System.out.println("La patronne s'appelle " + NomPatronne + " " + SurnomPatronne);
                inter.SNM.NomFinalPatronne = NomPatronne + SurnomPatronne;
                //et maintenant on crée une instance============================
                inter.patronne = new Patronne(NomPatronne + SurnomPatronne);
                Bar = new Manipuler(inter.patronne);
                inter.barman=this.patronne.getBarman();
                long argentPatronne = Math.round(Math.random() * (200 - 1));
                inter.patronne.setPorteMonnaie((int) argentPatronne);
                inter.patronne.setSexe("Femme");

            } else if (inter.SNM.mode == '2') {
                AffichageChoixConfigAuto("la patronne");
                String NomFinalPatronne = RenvoieNomPatronne() +" "+ RenvoieAdjectifPatronne();
                System.out.println("La patronne s'appelle " + NomFinalPatronne);
                inter.SNM.NomFinalPatronne = NomFinalPatronne;
                //et maintenant on crée une instance============================
                inter.patronne = new Patronne(RenvoieNomPatronne());
                inter.patronne.setSurnom(RenvoieAdjectifPatronne());
                Bar = new Manipuler(inter.patronne);
                inter.patronne.getBarman();
                // inter.barman=this.patronne.getBarman();
                long argentPatronne = Math.round(Math.random() * (200 - 1));
                inter.patronne.setPorteMonnaie((int) argentPatronne);
                inter.patronne.setSexe("Femme");

            }

            //Initialisation Barman
            String barman = "le barman";
            inter.SNM = firstScanner(inter.SNM, barman);

            if (inter.SNM.mode == '1') {
                AffichageChoixConfigManu("le barman");
                String NomBarman = inter.scanNomUntilNotEmpty(SNM, 5).NomFinalBarman;
                System.out.println("Choisissez un surnom pour le barman");   // choix du surnom du barman
                String SurnomBarman = inter.scanStringUntilNotEmpty(SNM.scan, 6);
                System.out.println("Le Barman s'appelle " + NomBarman + " " + SurnomBarman);
                inter.SNM.NomFinalBarman = NomBarman + SurnomBarman;
                //et maintenant on crée une instance============================
                inter.barman = new Barman(NomBarman + SurnomBarman, inter.patronne);
                Bar.RemplacerLeBarmanConserverCaisseEtStock(inter.SNM.NomFinalBarman);
                long argentBarman = Math.round(Math.random() * (500 - 0));
                inter.patronne.getBarman().setPorteMonnaie((int) argentBarman);

            } else if (inter.SNM.mode == '2') {
                AffichageChoixConfigAuto("le barman");
                inter.SNM.NomFinalBarman = CreationBarman();
                //et maintenant on crée une instance============================
                //inter.patronne.getBarman().setSurnom(SurnomBarman);
                Bar.RemplacerLeBarmanConserverCaisseEtStock(inter.SNM.NomFinalBarman);
                long argentBarman = Math.round(Math.random() * (500 - 1));
                inter.patronne.getBarman().setPorteMonnaie((int) argentBarman);
                //inter.patronne.getBarman().setSurnom(SurnomBarman);

            }

            // Initialisation Client
            String client = "le client"; 
            inter.SNM = firstScanner(inter.SNM, client);

            Scanner demande = new Scanner(System.in);
            System.out.println("Combien de client voulez vous creer ? ");
            Integer reponse = demande.nextInt();
            int NombreClient = 0;
            while (NombreClient != reponse) {

                if (inter.SNM.mode == '1') {
                    AffichageChoixConfigManu("un client");
                    String NomClient = inter.scanNomUntilNotEmpty(SNM, 5).NomFinalClient;
                    System.out.println("Choisissez un surnom pour un client");   // choix du surnom d'un client
                    String SurnomClient = inter.scanStringUntilNotEmpty(SNM.scan, 6);
                    System.out.println("Le serveur numero" + NombreClient + "s'appelle " + NomClient + " " + SurnomClient);
                    inter.SNM.NomFinalClient = NomClient + SurnomClient;
                    String NomCompletClient = NomClient + " " + SurnomClient;
                    //et maintenant on crée une instance============================
                    inter.client = new Client(NomClient + SurnomClient);
                    Client client1 = new Client(NomCompletClient);
                    Bar.ajouterUnClient(client1);
                    long argentClient = Math.round(Math.random() * (500 - 1));
                    client1.setPorteMonnaie((int) argentClient);

                } else if (inter.SNM.mode == '2') {
                    AffichageChoixConfigAuto("un client");
                    String NomCompletClient = CreationClient(NombreClient);
                    inter.SNM.NomFinalClient = NomCompletClient;
                    //et maintenant on crée une instance============================               
                    Client client1 = new Client(NomCompletClient);
                    Bar.ajouterUnClient(client1);
                    long argentClient = Math.round(Math.random() * (500 - 1));
                    client1.setPorteMonnaie((int) argentClient);

                }
                NombreClient++;
            }

            //Initialisation serveur
            String serveur = "le serveur";
            inter.SNM = firstScanner(inter.SNM, serveur);
            Scanner demande2 = new Scanner(System.in);
            System.out.println("Combien de serveur voulez vous creer ? ");
            Integer reponse2 = demande2.nextInt();
            int NombreServeur = 0;
            while (NombreServeur != reponse2) {

                if (inter.SNM.mode == '1') {
                    AffichageChoixConfigManu(" un serveur");
                    String NomServeur = inter.scanNomUntilNotEmpty(SNM, 5).NomFinalServeur;
                    System.out.println("Choisissez un surnom pour un serveur");   // choix du surnom d'un serveur
                    String SurnomServeur = inter.scanStringUntilNotEmpty(SNM.scan, 6);
                    System.out.println("Le serveur numéro " + NombreServeur + "  s'appelle " + NomServeur + " " + SurnomServeur);
                    inter.SNM.NomFinalServeur = NomServeur + SurnomServeur;
                    String NomCompletServeur = NomServeur + " " + SurnomServeur;
                    //et maintenant on crée une instance============================
                    inter.client = new Client(NomServeur + SurnomServeur);
                    Serveur serveur1 = new Serveur(NomCompletServeur, inter.patronne);
                    Bar.ajouterUnServeur(serveur1);
                    serveur1.setPorteMonnaie(20);

                } else if (inter.SNM.mode == '2') {
                    AffichageChoixConfigAuto("un serveur");
                    String NomCompletServeur = CreationServeur(NombreServeur);
                    inter.SNM.NomFinalServeur = NomCompletServeur;               
                    //et maintenant on crée une instance============================
                    //inter.patronne.getBarman().setSurnom(SurnomClient);
                    //Client client1 = new Client(NomCompletClient);
                    Serveur serveur1 = new Serveur(NomCompletServeur, inter.patronne);
                    Bar.ajouterUnServeur(serveur1);
                    double argentServeur = Math.round(Math.random() * (200 - 1));
                    serveur1.setPorteMonnaie((int) argentServeur);
                }
                NombreServeur++;
            }

            //----------------------------------------------------------------
            System.out.println(Bar.afficherLesProtagonnistes());
            return (inter.SNM);

        } catch (AbstractClientException ex) {
            Logger.getLogger(InterfaceUtilisateurJC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServirException ex) {
            Logger.getLogger(InterfaceUtilisateurJC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //==================================================
    public class ScanNomMode {

        //initialisation des variables
        public Scanner scan = new Scanner(System.in);
        public char reponse = ' ';
        public char mode = ' ';
        public String NomFinalPatronne = " ";
        public String Surnom = " "; // surnom de la daronne
        public String NomFinalBarman = " ";
        public String SurnomBarman = " ";
        public String NomFinalClient = " ";
        public String SurnomClient = " ";
        public String NomServeur = "";
        public String SurnomServeur = "";
        public String NomFinalServeur = "";

    }
    public void AffichageChoixConfigManu( String NomEntité) {
        System.out.println("vous avez choisi la configuration assitée pour " + NomEntité );
        System.out.println("Choisissez un nom pour " + NomEntité);
        
    }
    public void AffichageChoixConfigAuto(String NomEntité){
        System.out.println("vous avez choisi la configuration assitée pour " + NomEntité );
    }
    
    public static String CreationClient( int NombreClient){
         String ChoixClient[] = {"Clint", "Chriss", "Clock", "Cliff", "Crause", "Chaune", "Claude", "Carl"};
         String AdjectifClient[] = {"The Cid", "The Claustro", "La Canaille", "The Crane", "La Claque", "The Clique", "Le Crapaud", "Le Cretin", "Le Condé", "Le Clifenger", "The Clochard", "Le Crotain", "Le Choco"};
         int j = (int) (Math.random() * (8 - 0));
         int k = (int) (Math.random() * (12 - 0));
         String NomClient = ChoixClient[j];
         String SurnomClient = AdjectifClient[k];
        System.out.println("Le Client numéro " + NombreClient + " s'appelle " + NomClient + " " + SurnomClient);
         String NomCompletClient = NomClient + " " + SurnomClient;
        return NomCompletClient;
            }
    
     public static String CreationServeur(int NombreServeur ){
        String ChoixServeur[] = {"Scott", "Spleen", "Steeve", "Stonne", "Slack", "Skin"};
        String AdjectifServeur[] = {"The Slope", "The Skype", "The Steak", "The Schlake", "The Snake", "The Snooze"};
         int j = (int) (Math.random() * (6 - 0));
         int k = (int) (Math.random() * (6 - 0));
         String NomServeur = ChoixServeur[j];
         String SurnomServeur = AdjectifServeur[k];
        System.out.println("Le serveur numero " +NombreServeur+ " s'appelle " + NomServeur + " " + SurnomServeur);
         String NomCompletServeur = NomServeur + " " + SurnomServeur;
        return NomCompletServeur;
            }
     
     public static String CreationBarman() {
         String ChoixBarman[] = {"Jack", "Tony", "Steeve", "Michael", "Jicey", "Raoul"};
         String AdjectifBarman[] = {"Le Brave", "Le Beau", "Le Saoul", "L'incompetent", "The King", "The Dog"};
         int j = (int) (Math.random() * (6 - 0));
         int k = (int) (Math.random() * (6 - 0));
         String NomBarman = ChoixBarman[j];
         String SurnomBarman = AdjectifBarman[k];
         System.out.println("Le Barman s'appelle " + NomBarman + " " + SurnomBarman);
         String NomCompletBarman = NomBarman + " " + SurnomBarman;
        // inter.patronne.getBarman().setSurnom(SurnomBarman);
     return NomCompletBarman;
     }
    
     public static String RenvoieNomPatronne(){
         String ChoixPatronne[] = {"Ingrid", "Ursule", "Roger", "Eli", "Jeanne", "Bob"};
         int j = (int) (Math.random() * (5 - 0));
         String Nom = ChoixPatronne[j];
         
        return Nom;
             }
     
     public static String RenvoieAdjectifPatronne(){
         String AdjectifPatronne[] = {"La Soularde", "La Brute", "Le Truand", "La Cartouche", "L'illustre", "La Canaille"};
         int k = (int) (Math.random() * (5 - 0));
         String Adjectif = AdjectifPatronne[k];
         
         return Adjectif ;
             }
    /*

    //public String EncoreUn (String reponse){
    // }
    /**
     * Remplace le code du début du scan
     *
     * @param SNM
     * @return
     */
    public ScanNomMode firstScanner(ScanNomMode SNM, String Entite) {
        do {//tant que reponse n'est pas 1 ou 2
            SNM.mode = ' ';
            System.out.println("Veuillez choisir un mode de configuration pour " + Entite);
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
     *
     * @param SNM
     * @param tailleMinimum
     * @return
     */
    public ScanNomMode scanNomUntilNotEmpty(ScanNomMode SNM, Integer tailleMinimum) {
        System.out.println("La taille du nom doit être d'au moins " + tailleMinimum + " char");
        do {//tant que taille inf do
            SNM.NomFinalPatronne = SNM.scan.nextLine();
            if (SNM.NomFinalPatronne.length() < tailleMinimum) {
                System.out.println("Taille minimum: " + tailleMinimum + " ,Taille actuelle : " + SNM.NomFinalPatronne.length());
            }

        } while (SNM.NomFinalPatronne.length() < tailleMinimum);
        return SNM;
    }

    /**
     * tant que la chaine de caratere n'a pas une taille sup à la taille minimum
     * on scan
     *
     * @param scan
     * @param SNM
     * @param tailleMinimum
     * @return
     */
    public String scanStringUntilNotEmpty(Scanner scan, Integer tailleMinimum) {
        System.out.println("La taille du mot doit être d'au moins " + tailleMinimum + " char");
        String mystring = " ";
        do {//tant que taille inf do
            mystring = scan.nextLine();
            if (mystring.length() < tailleMinimum) {
                System.out.println("Taille minimum: " + tailleMinimum + " ,Taille actuelle : " + mystring.length());
            }

        } while (mystring.length() < tailleMinimum);
        return mystring;
    }

}
