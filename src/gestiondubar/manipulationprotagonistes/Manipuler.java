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
    private Humain personneEnquestion;
    public ArrayList<Humain> liste;
    public static ArrayList<String> listeDesMethodesDesMenu = new ArrayList<>();

    static {
        listeDesMethodesDesMenu.add("ChoisirHumainPuisActionEnFonctionDuNombre");
//        listeDesMethodesDesMenus.add("ajouterUnClientAvecSonNom");
//        listeDesMethodesDesMenus.add("ajouterUnServeurAvecSonNom");
//        listeDesMethodesDesMenus.add("RemplacerLeBarmanConserverCaisseEtStock");
    }

    public static void main(String[] args) {
//*
        try {
            Manipuler manip = new Manipuler(new Patronne("Haaha"));
            String continuer = "o";
            manip.ajouterUnClientAvecSonNom("Client1");
            manip.ajouterUnParentEtSonEnfantAvecLeurNom("Papa1", "Enfant1");

            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.EAU, 10);
            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.RICARD, 10);
            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.SHOOTER, 10);
            Scanner scan = new Scanner(System.in);
            while (continuer.equals("o")) {
                try {
                    manip.choisirLesMethodesDeManipulationEtLesExecuter(manip);

                } catch (Exception ex) {
                    Throwable cause = ex.getCause();
                    System.out.println(ex.getMessage() + "\n\n**La methode n'a pas été executer : paramètre non comforme.**\n"
                            + "Retry? type 'n' to stop Or anything to continue");
                    if (scan.nextLine().equals("n")) {

                        continuer = "n";
                    }

                }

            }
        } catch (AbstractClientException | StockException ex) {
            Logger.getLogger(Manipuler.class.getName()).log(Level.SEVERE, null, ex);
        }
//*/

    }

    public Manipuler(Patronne patronne) throws AbstractClientException {
        this.patronne = patronne;
        this.liste = this.updateListeDesProtagonistes(patronne);
    }

    private ArrayList<Humain> updateListeDesProtagonistes(Patronne patronne) throws AbstractClientException {
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

    public void ajouterUnClientAvecSonNom(String nom) throws AbstractClientException {
        ajouterUnClient(new Client(nom));

    }

    public void ajouterUnClient(Humain client) throws AbstractClientException {
        if (client instanceof Humain && !(client instanceof Barman) && !(client instanceof Serveur) && !(client instanceof Patronne)) {
            patronne.getBar().clients.add(client);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

    public void ajouterUnServeurAvecSonNom(String nom) throws AbstractClientException {
        ajouterUnServeur(new Serveur(nom, this.patronne));

    }

    public void ajouterUnServeur(Serveur serveur) throws AbstractClientException {
        if (serveur instanceof Humain && (serveur instanceof Serveur)) {
            patronne.getBar().serveurs.add(serveur);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

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

    public Humain ChoisirHumainPuisActionEnFonctionDuNombre(Integer i) throws ManipulationException {
        if (i > -1 && i < liste.size()) {
            System.out.println(liste.get(i).toString());
            this.personneEnquestion = liste.get(i);
            return liste.get(i);
        } else {
            throw new ManipulationException("index ou of range");
        }
    }

    //*
    public void makeHumainDo(Humain humain, Integer choix) {

    }

    /**
     * On explore les mothodes filtrée<br>
     * On consulte les methodes <br>
     * On recupère la methode<br>
     * On récupère les paramètres<br>
     * On lance la methode<br>
     *
     * @param o
     */
    public void choisirLesMethodesDeManipulationEtLesExecuter(Object o) throws Exception {
        Method[] m = this.explorerMethodes(o);
        m = this.filtrerLesMethodesAvecAutorisation(m, Manipuler.listeDesMethodesDesMenu);
        System.out.println("\n**systeme pause**");
        new java.util.Scanner(System.in).nextLine();
        System.out.println("\n\n\n\nDescription: Dans un premier temps choisir le n°du protagoniste");
        //+ "\n Les autres sont la pour ajouter un client ou renomer le barman");
        //   System.out.println(consulterMethodes(m));
        int choix = 0;
        //Scanner scan = null;
        //scan = new Scanner(System.in);
        // System.out.println("Taper 0 pour executer la methode");
        //choix = scan.nextInt();
//        System.out.println("Scan int");
//        choix = scan.nextInt();
        Method methodechoisie = m[choix];
        //     System.out.println(afficherMethode(methodechoisie, choix));
        //Object[] my = methodechoisie.getParameterTypes();
        System.out.println(this.afficherLesProtagonnistes());

        this.analyserLesMethodesDelObjetEtLesLancerHumain(lancerMethode(o, methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName()));

    }

    /**
     * Utilier pour faire des action sur les classes Humaine
     *
     * @param o
     * @throws Exception
     */
    public void analyserLesMethodesDelObjetEtLesLancerHumain(Object o) throws Exception {
        System.out.println("\n\n\n===Description: Dans un second temps choisir le n° de la methode===");
        //on recuper toute les methodes de la classe
        Method[] m = this.explorerMethodes(o);
        // on filtre les methodes autoriser
        m = this.filtrerLesMethodesAvecAutorisationDeLobjet(m, o);
//        trierMethode
        //on les affiches dans la console
        System.out.println(consulterMethodes(m));
        //on initie un scanner pour choisir
        Integer choix = this.choisirMethode();
        Method methodechoisie = m[choix];
        System.out.println(afficherMethode(methodechoisie, choix));
//        Object[] my = methodechoisie.getParameterTypes();
//            Object type=my[0].getClass().getTypeName();
//            Object[] args=this.scanParameters(methodechoisie.getParameterTypes());

        if (!(methodechoisie.getReturnType().getSimpleName().equals("void"))) {
            System.out.println("RESULAT:" + lancerMethode(o, methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName()));
        } else {
            lancerMethode(o, methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName());
        }//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
        //System.out.println("Methode correctment executée");

    }

    public Object[] scanParameters(Object[] args) throws Exception {

        Object[] myargs = new Object[args.length];
        // if(args.length!=0)System.out.println("\n\n===Description: Dans un troisieme temps choisir Les parametre==");
        for (Integer i = 0; i < args.length; ++i) {
            myargs[i] = scanStringParamtre(args[i].toString()/*.getClass().getSimpleName()*/);
        }
        return myargs;
    }

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
                    o = this.ChoisirHumainPuisActionEnFonctionDuNombre(i);
                    break;
                case "class gestiondubar.decore.Boisson":
                    System.out.print(Boisson.afficherLesBoissons());
                    System.out.println("\nLa methode utilise une Boisson-> Choisissez son n° :");
                    i = scan.nextInt();
                    o = Boisson.ChoisirUneBoisson(i);
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

    public Object lancerMethode(Object o, Method methode, Object[] args, String nomMethode) throws Exception {
        try {
            Humain h = null;
            Class[] paramTypes = null;
            if (args != null) {
                paramTypes = new Class[args.length];
                for (int i = 0; i < args.length; ++i) {
//                    if (args[i].getClass().equals("Barman")) {
//                        paramTypes[i] = h.getClass();
//                    } else {
                    paramTypes[i] = args[i].getClass();
//                    }
                }
            }
            methode = o.getClass().getMethod(nomMethode, methode.getParameterTypes());
//            Method m = o.getClass().getDeclaredMethod(nomMethode, paramTypes);
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
            
            //System.out.println("Cause : " + cause.getMessage());
        }
        return null;
    }

    //*/
    public Integer choisirMethode() {
        Scanner scan = null;
        scan = new Scanner(System.in);
        System.out.println("Choisir n° methode:");
        return scan.nextInt();
    }

    public void explorerChamps(Object o) {
        Field[] f = null;
        Class c = null;

        c = o.getClass();
        f = c.getFields();
        consulterChamps(f, o);
    }

    private void consulterChamps(Field[] f, Object o) {
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

    public Method[] explorerMethodes(Object o) {
        Method[] m = null;
        Class c = null;

        c = o.getClass();
        m = c.getMethods();
        //ArrayList<String> listeM = new ArrayList<>();
        // listeDesMethodesDesMenus.add("ChoisirHumainPuisActionEnFonctionDuNombre");

        return m;
    }

    private String consulterMethodes(Method[] m) {
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

    private String afficherMethode(Method m, Integer i) {

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

    private Method[] filtrerLesMethodesAvecAutorisationDeLobjet(Method[] methodes, Object o) throws Exception {
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

    private Method[] filtrerLesMethodesAvecAutorisation(Method[] methodes, ArrayList<String> listedesmethodes) throws Exception {
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
        for (int i = 0; i < j; ++i) {
//            if (
            whereIsTheMethode = Manipuler.methodeExistsInArrayList(methodes, listedesmethodes.get(i));//) {
            myMet[k] = methodes[whereIsTheMethode];
            k++;
        }
        //}
        return myMet;
    }

    public static boolean stringExiste(String str, ArrayList<String> liste) {
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).equals(str)) {
                return true;
            }

        }
        return false;
    }

    public static Integer methodeExistsInArrayList(Method[] m, String mName) throws Exception {
        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals(mName)) {
                return i;
            }
        }
        throw new Exception("La methode " + mName + " n'existe pas", new Throwable(mName));
    }

    /*
     en soit une action peut avoir un nom, des paramètre , une fonction
     1? actionProtagoniste 
     Tu veux quelle Humain  ? -> classe
     Tu veux quelle methode ? -> int
     Remplie les paramètre if Humain alors toruver else scan
     DO
     //*/
//    public void RemplacerLaPatronne() {
//
//    }

    /*
     private 
     AutoClear
     updatelisteDesProtagonistes /maj
     trouverUnProtagoniste
     afficherLesPortagoniste
     changerPatronne  faiblesse sur les attributs propres
     changerBarman    faiblesse sur les attributs propres
     ajouterUnServeur /maj 
     retirerUnServeur /maj 
     ajouterunClient /maj
     retierUnclient  /maj 
     faireUnHumainparler
     faireUnHumainJouer
    
    
    
    
     //     */
//    private class  ComparerMethodes  extends ClassValue<Methode> implements Comparable<Object>{
//        
//      
//        @Override
//        public int compareTo(Class t) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        protected Methode computeValue(Class<?> type) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
}
