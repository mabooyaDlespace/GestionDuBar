/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.manipulationprotagonistes;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Serveur;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirException;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISEN
 */
public class Manipuler {

    // ArrayListe<Humain> Protagoniste
    public Patronne patronne;
    public ArrayList<Humain> liste;
    public static ArrayList<String> listeDesMethodesDesMenu = new ArrayList<>();

    static {
        listeDesMethodesDesMenu.add("trouverEnFonctionDuNombre");
    }

    public static void main(String[] args) {
//*
        try {
            Manipuler manip = new Manipuler(new Patronne("Haaha"));
            String continuer = "o";
            manip.patronne.getBarman().setQuantiteDeLaBoisson(Boisson.EAU, 10);
            Scanner scan = new Scanner(System.in);
            while (continuer.equals("o")) {
                try {
                    manip.choisirLesMethodesDeManipulationEtLesExecuter(manip);

                } catch (Exception ex) {
                    System.out.println("**La methode n'a pas été executer : paramètre non comforme.**\n"
                            + "Retry? type 'n' to stop");
                    if (scan.next().equals("n")) {
                        continuer = "n";
                    }

                }

            }
        } catch (AbstractClientException|StockException ex) {
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

    public void ajouterUnClient(Humain client) throws AbstractClientException {
        if (client instanceof Humain && !(client instanceof Barman) && !(client instanceof Serveur) && !(client instanceof Patronne)) {
            patronne.getBar().clients.add(client);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

    public void ajouterUnServeur(Serveur serveur) throws AbstractClientException {
        if (serveur instanceof Humain && (serveur instanceof Serveur)) {
            patronne.getBar().serveurs.add(serveur);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Client can't be null or an instance of personnel");
        }

    }

    public void RemplacerLeBarmanConserverCaisseEtStock(String nomBarman) throws AbstractClientException, ServirException {
        if (nomBarman instanceof String) {
            patronne.getBarman().donnerLaMonnaieAuxResponsables(patronne.getBarman());
            Barman barman = new Barman(nomBarman, patronne);
            patronne.setBarman(barman);
            this.updateListeDesProtagonistes(patronne);
        } else {
            throw new AbstractClientException("Il la string ne doit pas être vide");
        }

    }

    public Humain trouverEnFonctionDuNombre(Integer i) throws ManipulationException {
        if (i < liste.size()) {
            System.out.println(liste.get(i).toString());
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

        System.out.println(consulterMethodes(m));
        int choix = 0;
        Scanner scan = null;
        scan = new Scanner(System.in);
        System.out.println("?Choisir n°?");
        choix = scan.nextInt();
//        System.out.println("Scan int");
//        choix = scan.nextInt();
        Method methodechoisie = m[choix];
        //Object[] my = methodechoisie.getParameterTypes();
        System.out.print(this.afficherLesProtagonnistes());

        this.analyserLesMethodesDelObjetEtLesLancerHumain(lancerMethode(o,methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName()));

    }

    /**
     * Utilier pour faire des action sur les classes Humaine
     *
     * @param o
     * @throws Exception
     */
    public void analyserLesMethodesDelObjetEtLesLancerHumain(Object o) throws Exception {

        //on recuper toute les methodes de la classe
        Method[] m = this.explorerMethodes(o);
        // on filtre les methodes autoriser
        m = this.filtrerLesMethodesAvecAutorisationDeLobjet(m, o);
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
            System.out.println("RESULAT:" + lancerMethode(o,methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName()));
        }
        lancerMethode(o,methodechoisie, this.scanParameters(methodechoisie.getParameterTypes()), methodechoisie.getName());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
        //System.out.println("Methode correctment executée");

    }

    public Object[] scanParameters(Object[] args) {
        Object[] myargs = new Object[args.length];
        for (Integer i = 0; i < args.length; ++i) {
            myargs[i] = scanStringParamtre(args[i].toString()/*.getClass().getSimpleName()*/);
        }
        return myargs;
    }

    public Object scanStringParamtre(String param) {

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
                    o = this.trouverEnFonctionDuNombre(i);
                    break;
                case "class gestiondubar.decore.Boisson":
                    System.out.print(Boisson.afficherLesBoissons());
                    System.out.println("\nLa methode utilise une Boisson-> Choisissez son n° :");
                    i = scan.nextInt();
                    o = Boisson.ChoisirUneBoisson(i);
                    break;
            }

        } catch (ManipulationException ex) {
            Logger.getLogger(Manipuler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public Object lancerMethode(Object o,Method methode, Object[] args, String nomMethode) throws Exception {
        try {
            Humain h=null;
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
             methode = o.getClass().getMethod(nomMethode,methode.getParameterTypes());
//            Method m = o.getClass().getDeclaredMethod(nomMethode, paramTypes);
            return methode.invoke(o, args);
        } catch (NoSuchMethodException x) {
            //x.printStackTrace();
            Throwable cause = x.getCause();
            System.out.println("Cause : " + cause.getMessage());
        } catch (IllegalArgumentException ex) {
            //ex.printStackTrace();
            Throwable cause = ex.getCause();
            System.out.println("Cause : " + cause.getMessage());
        } catch (IllegalAccessException ex) {
            //ex.printStackTrace();
            Throwable cause = ex.getCause();
            System.out.println("Cause : " + cause.getMessage());
        } catch (InvocationTargetException ex) {
            //ex.printStackTrace();
            Throwable cause = ex.getCause();
            System.out.println("Cause : " + cause.getMessage());
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
        // listeDesMethodesDesMenu.add("trouverEnFonctionDuNombre");

        return m;
    }

    private String consulterMethodes(Method[] m) {
        Class[] params = null;
        String mystr = "";
        for (Integer i = 0; i < m.length; ++i) {
//         System.out.print(Modifier.toString(m[i].getModifiers()));
//         System.out.print(" ");
            mystr += "\nMethode n°" + i.toString() + " ->" + m[i].getReturnType().getSimpleName() + " " + m[i].getName() + "(";
            params = m[i].getParameterTypes();
            for (int j = 0; j < params.length; ++j) {

                mystr += params[j].getSimpleName();
                if (j < params.length - 1) {
                    mystr += ",";
                }
            }
            mystr += ")";
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
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Patronne.listeDesMethodesDesMenu);
                break;
            case "Client":
                break;
            case "Barman":
                myMet = this.filtrerLesMethodesAvecAutorisation(methodes, Humain.listeDesMethodesDesMenu);
                break;
            case "Serveur":
                break;
            default:
                // throw new Exception("La classe n'éxiste pas");
                break;
        }

        return myMet;
    }

    private Method[] filtrerLesMethodesAvecAutorisation(Method[] methodes, ArrayList<String> listedesmethodes) {
        Method[] myMet;
        int j = 0;
        for (int i = 0; i < methodes.length; ++i) {
            if (Manipuler.stringExiste(methodes[i].getName(), listedesmethodes)) {
                j++;
            }
        }
        myMet = new Method[j];
        int k = 0;
        for (int i = 0; i < methodes.length; ++i) {
            if (Manipuler.stringExiste(methodes[i].getName(), listedesmethodes)) {
                myMet[k] = methodes[i];
                k++;
            }
        }
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
    
    
    
    
     */
}
