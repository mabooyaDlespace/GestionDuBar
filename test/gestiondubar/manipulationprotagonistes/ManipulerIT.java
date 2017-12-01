/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.manipulationprotagonistes;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.AbstractClient;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.BarmanIT;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Serveur;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @see gestiondubar.manipulationprotagonistes.Manipuler manipuler
 *
 * @author ISEN
 */
public class ManipulerIT {

    public static AbstractClient luc;
    public static Patronne patronne;
    public static Serveur serv;
    public static Barman babar;

    public ManipulerIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            luc = new Client("Luc1");
            patronne = new Patronne("Davida");
            serv = new Serveur("serv", patronne);
            patronne.setBarman(new Barman("Babar", patronne));
            babar = patronne.getBarman();
            babar.setQuantiteDeLaBoisson(Boisson.EAU, 10);
            babar.setQuantiteDeLaBoisson(Boisson.RICARD, 10);
            babar.setQuantiteDeLaBoisson(Boisson.SHOOTER, 10);

        } catch (AbstractClientException | StockException ex) {
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }
//=============================================================================
//=============================================================================
//=============================================================================

    /**
     * Test of creerListeDesProtagonistes method, of class Manipuler.
     */
    @Test
    public void testCreerListeDesProtagonistes_00() {
        Manipuler instance = null;
        try {
            System.out.println("creerListeDesProtagonistes");
            patronne = null;
            instance = new Manipuler(patronne);
            System.out.println(instance.afficherLesProtagonnistes());
            fail();
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            assertFalse(instance instanceof Manipuler);
            Logger.getLogger(ManipulerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of creerListeDesProtagonistes method, of class Manipuler.
     */
    @Test
    public void testCreerListeDesProtagonistes_01() {
        try {
            System.out.println("creerListeDesProtagonistes");
            Manipuler instance;
            instance = new Manipuler(patronne);
            //instance.updateListeDesProtagonistes(patronne);
            System.out.println(instance.afficherLesProtagonnistes());
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            Logger.getLogger(ManipulerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of main method, of class Manipuler.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Manipuler.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherLesProtagonnistes method, of class Manipuler.
     */
    @Test
    public void testAfficherLesProtagonnistes() {
        System.out.println("afficherLesProtagonnistes");
        Manipuler instance = null;
        String expResult = "";
        String result = instance.afficherLesProtagonnistes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterUnClient method, of class Manipuler.
     */
    @Test
    public void testAjouterUnClient() throws Exception {
        System.out.println("ajouterUnClient");
        Humain client = null;
        Manipuler instance = null;
        instance.ajouterUnClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterUnServeur method, of class Manipuler.
     */
    @Test
    public void testAjouterUnServeur() throws Exception {
        System.out.println("ajouterUnServeur");
        Serveur serveur = null;
        Manipuler instance = null;
        instance.ajouterUnServeur(serveur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemplacerLeBarmanConserverCaisseEtStock method, of class
     * Manipuler.
     */
    @Test
    public void testRemplacerLeBarmanConserverCaisseEtStock() throws Exception {
        System.out.println("RemplacerLeBarmanConserverCaisseEtStock");
        String nomBarman = "";
        Manipuler instance = null;
        instance.RemplacerLeBarmanConserverCaisseEtStock(nomBarman);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trouverEnFonctionDuNombre method, of class Manipuler.
     */
    @Test
    public void testTrouverEnFonctionDuNombre() throws Exception {
        System.out.println("trouverEnFonctionDuNombre");
        Integer i = null;
        Manipuler instance = null;
        Humain expResult = null;
        Humain result = instance.trouverEnFonctionDuNombre(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeHumainDo method, of class Manipuler.
     */
    @Test
    public void testMakeHumainDo() {
        System.out.println("makeHumainDo");
        Humain humain = null;
        Integer choix = null;
        Manipuler instance = null;
        instance.makeHumainDo(humain, choix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choisirLesMethodesDeManipulationEtLesExecuter method, of class
     * Manipuler.
     */
    @Test
    public void testChoisirLesMethodesDeManipulationEtLesExecuter() throws Exception {
        System.out.println("choisirLesMethodesDeManipulationEtLesExecuter");
        Object o = null;
        Manipuler instance = null;
        instance.choisirLesMethodesDeManipulationEtLesExecuter(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyserLesMethodesDelObjetEtLesLancerHumain method, of class
     * Manipuler.
     */
    @Test
    public void testAnalyserLesMethodesDelObjetEtLesLancerHumain() throws Exception {
        System.out.println("analyserLesMethodesDelObjetEtLesLancerHumain");
        Object o = null;
        Manipuler instance = null;
        instance.analyserLesMethodesDelObjetEtLesLancerHumain(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scanParameters method, of class Manipuler.
     */
    @Test
    public void testScanParameters() {
        System.out.println("scanParameters");
        Object[] args = null;
        Manipuler instance = null;
        Object[] expResult = null;
        Object[] result = instance.scanParameters(args);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scanStringParamtre method, of class Manipuler.
     */
    @Test
    public void testScanStringParamtre() {
        System.out.println("scanStringParamtre");
        String param = "";
        Manipuler instance = null;
        Object expResult = null;
        Object result = instance.scanStringParamtre(param);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lancerMethode method, of class Manipuler.
     */
    @Test
    public void testLancerMethode() throws Exception {
        System.out.println("lancerMethode");
        try{
        String nomMethode = "commanderBoisson";
        Manipuler instance = new Manipuler(new Patronne("HAHA"));
        Object expResult = null;
        Object o = instance.patronne;
        Humain h = instance.patronne.getBarman();
        Object[] args = {Boisson.EAU,h} ;
        
        instance.patronne.commanderBoisson(Boisson.EAU, h);
         instance.lancerMethode(o,null, args, nomMethode);
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
            Throwable cause = ex.getCause();
            System.out.println("Cause : " + cause.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choisirMethode method, of class Manipuler.
     */
    @Test
    public void testChoisirMethode() {
        System.out.println("choisirMethode");
        Manipuler instance = null;
        Integer expResult = null;
        Integer result = instance.choisirMethode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of explorerChamps method, of class Manipuler.
     */
    @Test
    public void testExplorerChamps() {
        System.out.println("explorerChamps");
        Object o = null;
        Manipuler instance = null;
        instance.explorerChamps(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of explorerMethodes method, of class Manipuler.
     */
    @Test
    public void testExplorerMethodes() {
        System.out.println("explorerMethodes");
        Object o = null;
        Manipuler instance = null;
        Method[] expResult = null;
        Method[] result = instance.explorerMethodes(o);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stringExiste method, of class Manipuler.
     */
    @Test
    public void testStringExiste() {
        System.out.println("stringExiste");
        String str = "";
        ArrayList<String> liste = null;
        boolean expResult = false;
        boolean result = Manipuler.stringExiste(str, liste);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
