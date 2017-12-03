/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.manipulationprotagonistes;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.AttributSpecial;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.ClientParent;
import gestiondubar.humains.clients.Enfant;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Serveur;
import gestiondubar.humains.clients.Sexe;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirException;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;

/**
 *
 * @author ISEN
 */
public class Manipuler {

    // ArrayListe<Humain> Protagoniste
    public Patronne patronne;
    public Humain personneEnquestion;
    public ArrayList<Humain> liste;
    public static ArrayList<String> listeDesMethodesDesMenu = new ArrayList<>();

    static {
        listeDesMethodesDesMenu.add("choisirHumainPuisActionEnFonctionDuNombre");
//        listeDesMethodesDesMenus.add("ajouterUnClientAvecSonNom");
//        listeDesMethodesDesMenus.add("ajouterUnServeurAvecSonNom");
//        listeDesMethodesDesMenus.add("RemplacerLeBarmanConserverCaisseEtStock");
    }

    public static void main(String[] args) {
//*
        try {
            Manipuler manip = new Manipuler(new Patronne("Haaha"));
            
            manip.ajouterUnClientAvecSonNom("Client1");
            manip.ajouterUnParentEtSonEnfantAvecLeurNom("Papa1", "Enfant1");

            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.EAU, 10);
            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.RICARD, 10);
            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.SHOOTER, 10);
            manip.manipulerLesProtagonistes(manip);

        } catch (AbstractClientException | StockException ex) {
            Logger.getLogger(Manipuler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Fonction principale de Manipuler.
     * Elle permet de dutilier les actions de chaque protagoniste
     * @param manip Intance maniplation Unique a chaque bar
     */
    public void manipulerLesProtagonistes(Manipuler manip){
        String continuer = "o";
            Scanner scan = new Scanner(System.in);
            while (continuer.equals("o")) {
                try {
                    manip.choisirUnProtagonisteEtUtiliserSesMethodes(manip);

                } catch (Exception ex) {
                    Throwable cause = ex.getCause();
                    System.out.println(ex.getMessage() + "\n\n**La methode n'a pas été executer : paramètre non comforme.**\n"
                            + "Retry? type 'n' to stop Or anything to continue");
                    if (scan.nextLine().equals("n")) {

                        continuer = "n";
                    }

                }

            }
    }

    /**
     * En terme de hierarchie la patronne a acces a toute les entité et créer le
     * minimum sydical.
     * <br> pour le fonctionnement d'un bar a son instanciation
     *
     * @param patronne
     * @throws AbstractClientException
     */
    public Manipuler(Patronne patronne) throws AbstractClientException {
        this.patronne = patronne;
        this.liste = this.updateListeDesProtagonistes(patronne);
    }

    /**
     * On créer une liste des protagonistes pour rendre les chose plus facilement
     * accessibles
     *
     * @param patronne
     * @return
     * @throws AbstractClientException
     */
    public ArrayList<Humain> updateListeDesProtagonistes(Patronne patronne) throws AbstractClientException {
        if (patronne instanceof Patronne) {
            this.liste = new ArrayList<Humain>();
            this.liste.add(patronne);
            this.liste.add(patronne.getBarman());
            this.liste.addAll(patronne.getBar().serveurs);
            this.liste.addAll(patronne.getBar().clients);
            return liste;
        } else {
            throw new AbstractClientException("Patronne cant be null");
        }
    }
    /**
     * 
     * @return renvoie une Une String composse de la liste de protagoniste du bar
     */
    public String afficherLesProtagonnistes() {
        Humain hum;
        String description = "";
        Integer i = 0;
        for (Iterator<Humain> it = this.liste.iterator(); it.hasNext();) {
            hum = it.next();
            description += "\n n°:" + i.toString() + " " + hum.toString();
            i++;
        }
        return description.toString();
    }
/**
 * 
 * @param nom nom du client qu'on veut ajouter
 * @throws AbstractClientException 
 */
    public void ajouterUnClientAvecSonNom(String nom) throws AbstractClientException {
        ajouterUnClient(new Client(nom));

    }
/**
 * 
 * @param client instance du client qu'on veut ajouter
 * @throws AbstractClientException 
 */
    public void ajouterUnClient(Humain client) throws AbstractClientException {
        if (client instanceof Humain && !(client instanceof Barman) && !(client instanceof Serveur) && !(client instanceof Patronne)) {
            patronne.getBar().clients.add(client);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }
/**
 * 
 * @param nom nom du Serveur qu'on veut ajouter
 * @throws AbstractClientException 
 */
    public void ajouterUnServeurAvecSonNom(String nom) throws AbstractClientException {
        ajouterUnServeur(new Serveur(nom, this.patronne));

    }
/**
 * Instance du client qu'on veut ajouter
 * @param serveur
 * @throws AbstractClientException 
 */
    public void ajouterUnServeur(Serveur serveur) throws AbstractClientException {
        if (serveur instanceof Humain && (serveur instanceof Serveur)) {
            patronne.getBar().serveurs.add(serveur);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }
/**
 * Nom du parent et de l'enfant qu'on veut ajouter
 * @param nom
 * @param nomEnfant
 * @throws AbstractClientException 
 */
    public void ajouterUnParentEtSonEnfantAvecLeurNom(String nom, String nomEnfant) throws AbstractClientException {
        ClientParent p = new ClientParent(nom, this.patronne);
        Enfant e = new Enfant(nomEnfant, p);
        ajouterUnParentEtSonEnfant(p, e);

    }

    public void ajouterUnParentEtSonEnfant(ClientParent parent, Enfant enfant) throws AbstractClientException {
        if (parent instanceof ClientParent && (enfant instanceof Enfant)) {
            patronne.getBar().clients.add(parent);
            patronne.getBar().clients.add(enfant);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

    /**
     * On remple ce le barman parce qu'on a ne peut pas changer son nom
     *
     * @param nomBarman
     * @throws AbstractClientException
     * @throws ServirException
     */
    public void RemplacerLeBarmanConserverCaisseEtStock(String nomBarman) throws AbstractClientException, ServirException {
        if (nomBarman instanceof String) {
            patronne.getBarman().donnerLaMonnaieAuxResponsables(patronne.getBarman());
            Barman barman = new Barman(nomBarman, patronne);
            //patronne.setBarman(barman);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("la string ne doit pas être vide");
        }

    }

    /**
     * On met a jour this.personne en question à chaque fois car scanParametre
     * en besoin pour choisir les attribut de l'humain
     *
     * @param i
     * @return renvoie l'Humain don on utilisera les methodes
     * @throws ManipulationException
     */
    public Humain choisirHumainPuisActionEnFonctionDuNombre(Integer i) throws ManipulationException {
        if (i > -1 && i < liste.size()) {
            System.out.println(liste.get(i).toString());
            this.personneEnquestion = liste.get(i);
            return liste.get(i);
        } else {
            throw new ManipulationException("index ou of range");
        }
    }

    /**
     *
     * permet de choisir un protagoniste, et appel une fonction pour executer ses methodes
     * @param o engeneral unObjet manipuler
     */
    public void choisirUnProtagonisteEtUtiliserSesMethodes(Manipuler o) throws Exception {
        //On recupertoutes les methodes
        Method[] m = this.explorerMethodes(o);
        //on filtre celle qui nous intéresse (ici il y en a une seule)
        m = this.filtrerLesMethodesAvecAutorisation(m, Manipuler.listeDesMethodesDesMenu);
        System.out.println("\n**systeme pause**");
        new java.util.Scanner(System.in).nextLine();
        System.out.println("\n\n\n\nDescription: Dans un premier temps choisir le n°du protagoniste");
        Method methodechoisie = m[0];
        System.out.println(this.afficherLesProtagonnistes());
        //la methode[0] de Manipuler a besoin d'un entier pour renvoyer un Humain dont on utilisera les methodes avec analyserLesMethodesDelObjetEtLesLancerHumain
        this.analyserLesMethodesDelObjetEtLesLancerHumain(lancerMethode(o, methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName()));

    }

    /**
     * On utilise cette fonction pour analyser les methodes d'un objet ayant
     * pour parent un humain.
     * <br> Cette methode est coupler avec un choix d'Humain en amont<br>
     * Elle permet pour un certain Object instancié, avec des methodes
     * authorisées prédéfinies, d'executer de manière dynamique ses methodes
     * Utilier pour faire des action sur les classes Humaine
     * <br> Elle inspiré de choisirUnProtagonisteEtUtiliserSesMethodes dou la
     * ressemblance même si elle est plus poussée
     *
     *
     * @param o
     * @throws Exception
     */
    public void analyserLesMethodesDelObjetEtLesLancerHumain(Object o) throws Exception {
        System.out.println("\n\n\n===Description: Dans un second temps choisir le n° de la methode===");
        //on recuper toute les methodes de la classe
        Method[] m = this.explorerMethodes(o);
        // on filtre les methodes autoriser et on les trie dans l'ordre croissant
        m = this.filtrerLesMethodesAvecAutorisationDeLobjet(m, o);
        //on les affiches dans la console
        System.out.println(consulterMethodes(m));
        //on initie un scanner pour choisir
        Integer choix = this.choisirMethode();
        //on choisie la methode
        Method methodechoisie = m[choix];
        //on affiche la methode choisie
        System.out.println(afficherMethode(methodechoisie, choix));
        //si le type du return est void on affiche pa le result
        //n°1 On Scan les parametres que la methode choise a besoin 
        //n°2 On lance la methode et catche les exception de la methode en avale
        if (!(methodechoisie.getReturnType().getSimpleName().equals("void"))) {
            System.out.println("RESULAT:" + lancerMethode(o, methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName()));
        } else {
            lancerMethode(o, methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName());
        }

    }
/**
 * Permet de trouver les parametre nécéssaire a l'execution de la methode
 * @param args le return type de la methode
 * @return renvoie les paremetre instancié
 * @throws Exception 
 */
    public Object[] scanParameters(Object[] args) throws Exception {

        Object[] myargs = new Object[args.length];
        // if(args.length!=0)System.out.println("\n\n===Description: Dans un troisieme temps choisir Les parametre==");
        for (Integer i = 0; i < args.length; ++i) {
            myargs[i] = scanStringParamtre(args[i].toString()/*.getClass().getSimpleName()*/);
        }
        return myargs;
    }

    /**
     * <b>
     * On passe en parametre une string representant la classe d'un parametre de
     * la methode et la methode sadapte a celui ci et le scan .
     * </b> On pourrait la renomer multi-Scan: pour les type de base un scan
     * normal suffit
     * <br> Pour le reste soit on regarde les Parties Static des classes, ou on
     * cherche un protagoniste dans la liste d'une instance Manipuler
     *
     * @param param
     * @return
     * @throws Exception
     */
    public Object scanStringParamtre(String param) throws Exception {
        Object o = null;
        Scanner scan = null;
        Integer i = 0;
        scan = new Scanner(System.in);
        try {
            switch (param) {
                case "class java.lang.Integer":
                    System.out.println("\nLa methode utilise un entier -> Entrez un Entier:");
                    o = scan.nextInt();
                    o = (Integer) o;
                    break;
                case "class gestiondubar.humains.Humain":
                    System.out.print(this.afficherLesProtagonnistes());
                    System.out.println("\nLa methode utilise un Humain -> Choisissez son n° :");
                    i = scan.nextInt();
                    o = this.choisirHumainPuisActionEnFonctionDuNombre(i);
                    break;
                case "class gestiondubar.decore.Boisson":
                    System.out.print(Boisson.afficherLesBoissons());
                    System.out.println("\nLa methode utilise une Boisson-> Choisissez son n° :");
                    i = scan.nextInt();
                    o = Boisson.choisirUneBoisson(i);
                    break;
                case "class gestiondubar.humains.clients.AttributSpecial": {
                    System.out.print(AttributSpecial.afficherLesAttributDeLobjet(this.personneEnquestion));
                    System.out.println("\nLa methode utilise un AttributSpecial-> Choisissez son n° :");
                    i = scan.nextInt();
                    o = AttributSpecial.choisirUnAttribut(personneEnquestion, i);
                }
                break;
                case "class gestiondubar.humains.clients.Sexe": {
                    System.out.print(Sexe.afficherLesSexes());
                    System.out.println("\nLa methode utilise un Sexe-> Choisissez son n° :");
                    i = scan.nextInt();
                    o = Sexe.ChoisirUnSexe(i);
                }
                break;
                case "class java.lang.String":
                    System.out.println("\nLa methode utilise une Chaine de charactère-> Entrez une String:");
                    o = scan.nextLine();
                    o = (String) o;
                    break;
                case "class gestiondubar.manipulationprotagoniste.Manipuler":
                    o = (Manipuler) this;
                    break;
                default:
                    throw new ManipulationException("Le choix pour *" + param + "* n'est pas encore implémenté");
            }
        } catch (ManipulationException ex) {
            System.out.println("Message=" + ex.getMessage());
            throw new Exception("Exception declancher lors du choix du parametre", ex);
        }
        return o;
    }

    /**
     * <b> Permet de le lancer la methode d'un object et de gérer les exceptions
     * occasionnnées.
     * </b>
     *
     * @param o objet contenant le corps de la methode
     * @param methode la methode qu'on va utiliser
     * @param args les parametre de la methode (déjà instancié)
     * @param nomMethode nom de la methode
     * @return revoie le resultat de la methode ex null si void
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws Exception
     * @see java.lang.reflect.Method Methode
     * @see java.lang.reflect.InvocationTargetException
     * InvocationTargetException
     */
    public Object lancerMethode(Object o, Method methode, Object[] args, String nomMethode) throws Exception {
        try {

            methode = o.getClass().getMethod(nomMethode, methode.getParameterTypes());
            return methode.invoke(o, args);

        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
            Throwable cause = ex.getCause();
            System.out.println("Cause : " + cause.getMessage());
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            //pas nécessaire mais on ne sait jamais
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            //primordial pour catcher le message des exception générées par les methodes
            ex.printStackTrace();
            Throwable cause = ex.getCause();
            System.out.println("Cause : " + cause.getMessage());
        } catch (Exception ex) {

            ex.printStackTrace();
            //System.out.println(ex.getMessage());

        }
        throw new Exception("La methode n'a pas pu etre invoquée -> rien n'a été modifié");
    }

    /**
     * une simple fonction pour afficher et scanner le n° de la methode
     * <br> Est utiliser dans analyserLesMethodesDelObjetEtLesLancerHumain
     *
     * @see #analyserLesMethodesDelObjetEtLesLancerHumain
     * analyserLesMethodesDelObjetEtLesLancerHumain
     * @return
     */
    public Integer choisirMethode() {
        Scanner scan = null;
        scan = new Scanner(System.in);
        System.out.println("Choisir n° methode:");
        return scan.nextInt();
    }

    /**
     * utile pour comprendre le getmethode
     *
     * @param o 
     */
    public void explorerChamps(Object o) {
        Field[] f = null;
        Class c = null;

        c = o.getClass();
        f = c.getFields();
        consulterChamps(f, o);
    }

    /**
     * utile pour comprendre le getmethode
     *
     * @param f
     * @param o
     */
    public void consulterChamps(Field[] f, Object o) {
        for (int i = 0; i < f.length; ++i) {
            System.out.print(Modifier.toString(f[i].getModifiers()));
            System.out.print(" ");
            System.out.print(f[i].getType().getName());
            System.out.print(" ");
            System.out.print(f[i].getName());
            System.out.print(" = ");
            try {
                System.out.println(f[i].get(o));
            } catch (IllegalAccessException e) {
                System.out.println("Valeur non consultable");
            }
        }
    }

    /**
     * On fait une introspection de l'objet: on get la classe puis ses methodes
     * On revoie la totalité des methodes qu'on filtra plus tard
     *
     * @param o sujet de l'introspection
     * @return
     */
    public Method[] explorerMethodes(Object o) {
        Method[] m = null;
        Class c = null;

        c = o.getClass();
        m = c.getMethods();
        return m;
    }
/** 
 *  permet d'afficher un tableau de methodes
 * @param m
 * @return 
 */
    public String consulterMethodes(Method[] m) {
        Class[] params = null;
        String mystr = "";
        for (Integer i = 0; i < m.length; ++i) {
//         System.out.print(Modifier.toString(m[i].getModifiers()));
//         System.out.print(" ");
            mystr += "\nMethode n°" + i.toString() + " ->" + " " + m[i].getName() + "(";
            params = m[i].getParameterTypes();
            for (int j = 0; j < params.length; ++j) {

                mystr += params[j].getSimpleName();
                if (j < params.length - 1) {
                    mystr += ",";
                }
            }
            mystr += ")";
            mystr += " Renvoie:" + m[i].getReturnType().getSimpleName();
        }
        return mystr;
    }
/**
 * permet d'afficher une methode choisie (ie vous avez choisi la methode "i")
 * @param m
 * @param i
 * @return 
 */
    public String afficherMethode(Method m, Integer i) {

        Class[] params = null;
        String mystr = "";
        mystr += "\n Vous avez choisit la méthode n°" + i.toString() + " ->" + m.getReturnType().getSimpleName() + " " + m.getName() + "(";
        params = m.getParameterTypes();
        for (int j = 0; j < params.length; ++j) {

            mystr += params[j].getSimpleName();
            if (j < params.length - 1) {
                mystr += ",";
            }
        }
        mystr += ")";
        return mystr;
    }
/**
 * Chaque objet que j'ai défini a une liste de methodes autorisée et pour chaque cas une liste de methodes autorisée
 * @param methodes Liste des methodes que lon veut filtrer
 * @param o objet de la dont on veut filtrer les methodes
 * @return renvoie un tableau de methodes filtrer et triée
 * @throws Exception
 */
    public Method[] filtrerLesMethodesAvecAutorisationDeLobjet(Method[] methodes, Object o) throws Exception {
        Method[] myMet = new Method[methodes.length];
        int j = 0;
        ArrayList<String> listedesmethodes = null;
        String compare = o.getClass().getSimpleName();
        switch (compare) {
            case "Patronne":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Patronne.listeDesMethodesDesMenus);
                break;
            case "Client":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Client.listeDesMethodesDesMenus);
                break;
            case "Barman":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Barman.listeDesMethodesDesMenus);
                break;
            case "Serveur":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Serveur.listeDesMethodesDesMenus);
                break;
            case "Enfant":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Enfant.listeDesMethodesDesMenus);
                break;
            case "ClientParent":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, ClientParent.listeDesMethodesDesMenus);
                break;

            default:
                throw new Exception("La classe n'éxiste pas ou n'est pas implémenté");
        }

        return myMet;
    }
/**
 * filtre le tableau de methodes et le trie en fonction de ArrayListe
 * <br>On créer un hasset pour supprimer d'éventuelle doublons$
 * <br> On regarde cb de "match" il ya
 * <br> On renvoie un exception s'il nya pas de match
 * @param methodes methode que lon veut filtrer
 * @param listedesmethodes filtre que lon veut appliquer
 * @return
 * @throws Exception 
 */
    public Method[] filtrerLesMethodesAvecAutorisation(Method[] methodes, ArrayList<String> listedesmethodes) throws Exception {
        Method[] myMet;
        int j = 0;

        Set set = new HashSet();
        set.addAll(listedesmethodes);
        listedesmethodes = new ArrayList(set);
        Collections.sort(listedesmethodes);
        for (int i = 0; i < methodes.length; ++i) {

            if (Manipuler.stringExiste(methodes[i].getName(), listedesmethodes)) {
                j++;
            }
        }
        myMet = new Method[j];
        int k = 0;
        int whereIsTheMethode;
        if (methodes instanceof Method[] && j > 0) {
            for (int i = 0; i < j; ++i) {
//            if (
                whereIsTheMethode = Manipuler.methodeExistsInArrayList(methodes, listedesmethodes.get(i));//) {
                myMet[k] = methodes[whereIsTheMethode];
                k++;
            }
        } else {
            throw new Exception("Aucune methode na trouver de match: "
                    + "\n -Soit la methode est privée a la classe"
                    + "\n -Soit la methode n'existe pas", new Throwable("probleme"));
        }
        //}
        return myMet;
    }
/**
 * Permet de verifier si le nom d'une methode existe dans l"array liste
 * @param str
 * @param liste
 * @return 
 */
    public static boolean stringExiste(String str, ArrayList<String> liste) {
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).equals(str)) {
                return true;
            }

        }
        return false;
    }
/**
 * permet de verifier s'il y a un match entre le nom de la methode et le parametre
 * @param m
 * @param mName
 * @return renvoie la position dans le tableau
 * @throws Exception 
 */
    public static Integer methodeExistsInArrayList(Method[] m, String mName) throws Exception {
        if (m instanceof Method[] && m.length > 0) {
            for (int i = 0; i < m.length; i++) {
                if (m[i].getName().equals(mName)) {
                    return i;
                }
            }
        }
        throw new Exception("La methode " + mName + " n'existe pas ou est déclarée comme privée", new Throwable(mName));
    }

    /*/ public Object lancerMethode(Object o, Method methode, Object[] args, String nomMethode) throws Exception {
     try {
     //            Humain h = null;
     //            Class[] paramTypes = null;
     //            if (args != null) {
     //                paramTypes = new Class[args.length];
     //                for (int i = 0; i < args.length; ++i) {
     ////                    if (args[i].getClass().equals("Barman")) {
     ////                        paramTypes[i] = h.getClass();
     ////                    } else {
     //                    paramTypes[i] = args[i].getClass();
     ////                    }
     //                }
     //            }
     methode = o.getClass().getMethod(nomMethode, methode.getParameterTypes());
     return methode.invoke(o, args);
     } catch (NoSuchMethodException ex) {
     ex.printStackTrace();
     Throwable cause = ex.getCause();
     System.out.println("Cause : " + cause.getMessage());
     } catch (IllegalArgumentException ex) {
     ex.printStackTrace();
     //System.out.println("Cause : " + cause.getMessage());
     } catch (IllegalAccessException ex) {
     ex.printStackTrace();
     //System.out.println("Cause : " + cause.getMessage());
     } catch (InvocationTargetException ex) {
     ex.printStackTrace();
     //System.out.println(ex.getMessage());
     Throwable cause = ex.getCause();
     System.out.println("Cause : " + cause.getMessage());
     }
     catch (Exception ex) {
            
     ex.printStackTrace();
     //System.out.println(ex.getMessage());
            
     }
     throw new Exception("La methode n'a pas pu etre invoquée -> rien n'a été modifié");
     }
     //*/
}
