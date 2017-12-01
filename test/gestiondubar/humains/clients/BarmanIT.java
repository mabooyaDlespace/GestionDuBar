/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.Caisse;
import gestiondubar.decore.bars.BoissonEtQuantite;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.humains.clients.exceptions.BarmanException;
import gestiondubar.humains.clients.interfaces.encapsulations.ServirException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * public void setUp(). luc = new Client("Luc1");<br>
 * patronne = new Patronne("Davida"); <br>
 * serv = new Serveur("serv", patronne);<br>
 * patronne.setBarman(new Barman("Babar", patronne));<br>
 * babar = patronne.getBarman();<br>
 *
 * @author ISEN
 */
public class BarmanIT {

    public static AbstractClient luc;
    public static Patronne patronne;
    public static Serveur serv;
    public static Barman babar;

    static {
        ;

    }

    public BarmanIT() {
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

    /**
     * Test of getPatronne method, of class Barman.
     */
    @Test
    public void testGetPatronne_00() {

        System.out.println("getPatronne");
        Barman instance = babar;
        Patronne expResult = patronne;
        Patronne result = instance.getPatronne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCaisseDuBar method, of class Barman.
     * on test si la caisse du barman est la meme que le bar
     */
    @Test
    public void testGetCaisseDuBar_00() {
        System.out.println("getCaisseDuBar");
        Barman instance = babar;
        Caisse expResult =  patronne.getBar().getCaisseDuBar(babar);
        Caisse result = instance.getCaisseDuBar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     *
     * Test of setPatronne method, of class Barman.
     */
    @Test
    public void testSetPatronne_00() {
        try {
            System.out.println("setPatronne");
            Patronne patronne = null;
            Barman instance = babar;
            instance.setPatronne(patronne);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (BarmanException ex) {
            assertTrue(ex.getMessage(),ex.getMessage().equals("La patronne ne peut pas Set to null"));
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setCaisseDuBar method, of class Barman.
     */
    @Test
    public void testSetCaisseDuBar_00() {
        try {
            System.out.println("setCaisseDuBar");
            Caisse caisseDuBar = null;
            Barman instance = babar;
            instance.setCaisseDuBar(caisseDuBar);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (BarmanException ex) {
            assertTrue(ex.getMessage(),ex.getMessage().equals("La Caisse ne peut pas Set to null"));
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of toString method, of class Barman.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Barman instance = babar;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//INTERFACE SERVIR=====================================================================

    /**
     *
     * Test of getMonnaieDuBar method, of class Barman. test du bon déroulemet
     * d'une transation
     */
    @Test
    public void testGetMonnaieDuBar_00() {
        try {
            System.out.println("getMonnaieDuBar");
            assertTrue(serv.getMonnaieDuBar().equals(0));
            assertTrue(babar.getMonnaieDuBar().equals(0));
            luc.boire(luc.commanderBoisson(Boisson.RICARD, serv));
            luc.boire(luc.commanderBoisson(Boisson.RICARD, babar));
            assertTrue(serv.getMonnaieDuBar().equals(2));// ils ont chacun 2 euros
            assertTrue(babar.getMonnaieDuBar().equals(2));
            assertTrue(luc.getDegreAlccolemie().toString(), luc.getDegreAlccolemie().equals(4)); //4 degres d'alcool
            assertTrue(luc.getPorteMonnaie().equals(-4));//-4 euros
            assertTrue(patronne.getBarman().getCaisseDuBar().getArgentDuBar().toString(), patronne.getBarman().getCaisseDuBar().getArgentDuBar().equals(0));
            serv.donnerLaMonnaieAuxResponsables(babar);// ils donnent la monnaie
            babar.donnerLaMonnaieAuxResponsables(babar);
            assertTrue(patronne.getBarman().getCaisseDuBar().getArgentDuBar().toString(), patronne.getBarman().getCaisseDuBar().getArgentDuBar().equals(4));
            assertTrue(serv.getMonnaieDuBar().equals(0));// ils ont chacun 0 euros
            assertTrue(babar.getMonnaieDuBar().equals(0));

        } catch (AbstractClientException ex) {
            fail();
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServirException ex) {
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of setMonnaieDuBar method, of class Barman.
     */
    @Test
    public void testSetMonnaieDuBar_00() {
        System.out.println("setMonnaieDuBar");
        Integer monnaieDubar = 13;
        Barman instance = babar;
        instance.setMonnaieDuBar(monnaieDubar);
        assertTrue(instance.getMonnaieDuBar().toString(),instance.getMonnaieDuBar().equals(13));
    }

    /**
     * Test of donnerLaMonnaieAuxResponsables method, of class Barman.
     */
    @Test
    public void testDonnerLaMonnaieAuxResponsables_00() {
        try {
            System.out.println("donnerLaMonnaieAuxResponsables");
            Humain humain = luc;
            luc.commanderBoisson(Boisson.RICARD, babar);
            Barman instance = babar;
            instance.donnerLaMonnaieAuxResponsables(humain);
            fail();
            
        } catch (Exception  ex) {
            assertTrue(ex.getMessage(), ex.getMessage().equals("doit être un Barman"));
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Test of donnerLaMonnaieAuxResponsables method, of class Barman.
     */
    @Test
    public void testDonnerLaMonnaieAuxResponsables_01() {
        try {
            System.out.println("donnerLaMonnaieAuxResponsables");
            Humain humain = luc;
            luc.commanderBoisson(Boisson.RICARD, babar);
            assertTrue(babar.getMonnaieDuBar().toString().equals("2"));
            
            Barman instance = babar;
            instance.donnerLaMonnaieAuxResponsables(babar);

            assertTrue(luc.getPorteMonnaie().equals(-2));
            
            assertTrue(babar.getMonnaieDuBar().toString().equals("0"));
            
        } catch (Exception  ex) {
            fail(ex.getMessage());
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

//INTERFACE GERERSTOCK=====================================================================
//INTERFACE GERERSTOCK=====================================================================
//INTERFACE GERERSTOCK=====================================================================
    /**
     * Test of estPresentDansLeStock method, of class Barman.
     */
    @Test
    public void testEstPresentDansLeStock_00() {
        System.out.println("estPresentDansLeStock");
        Boisson ceQueJeCherche = null;
        Barman instance = babar;
        boolean expResult = false;
        boolean result = instance.estPresentDansLeStock(ceQueJeCherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of estPresentDansLeStock method, of class Barman.
     */
    @Test
    public void testEstPresentDansLeStock_01() {
        System.out.println("estPresentDansLeStock");
        Boisson ceQueJeCherche = null;//Boisson.EAU;
        Barman instance = babar;
        boolean expResult = false;
        boolean result = instance.estPresentDansLeStock(ceQueJeCherche);
        assertEquals(expResult, result);

        ceQueJeCherche=Boisson.RICARD;
        expResult=true;
        result = instance.estPresentDansLeStock(ceQueJeCherche);

        ceQueJeCherche=Boisson.SHOOTER;
        expResult=true;
        result = instance.estPresentDansLeStock(ceQueJeCherche);
        
    }

    
    
    /**
     * Test of existeDansLeStock method, of class Barman.
     */
    @Test
    public void testExisteDansLeStock_00() {
        System.out.println("existeDansLeStock");
        Boisson ceQueJeCherche = null;
        Barman instance = babar;
        boolean expResult = false;
        boolean result = instance.existeDansLeStock(ceQueJeCherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBoissonEtQuantite method, of class Barman.
     */
    @Test
    public void testGetBoissonEtQuantite() {
        System.out.println("getBoissonEtQuantite");
        Boisson ceQueJeCherche = null;
        Barman instance = babar;
        BoissonEtQuantite expResult = null;
        BoissonEtQuantite result = instance.getBoissonEtQuantite(ceQueJeCherche);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("USELESS pour le moment");
    }

    /**
     * Test of setQuantite method, of class Barman.
     */
    @Test
    public void testSetQuantite_00() throws Exception {
        System.out.println("setQuantite");
        Boisson ceQueJeMets = Boisson.EAU;
        Integer quantite = 1;
        Barman instance = babar;
        instance.setQuantiteDeLaBoisson(ceQueJeMets, quantite);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getQuantiteDeLaBoisson(ceQueJeMets).compareTo(quantite)==0);
    }
    
    /**
     * Test of setQuantite method, of class Barman.
     */
    @Test
    public void testSetQuantite_01()  {
        try {
            System.out.println("setQuantite");
            Boisson ceQueJeMets = null;
            Integer quantite = null;
            Barman instance = babar;
            instance.setQuantiteDeLaBoisson(ceQueJeMets, quantite);
            // TODO review the generated test code and remove the default call to fail.
            fail();

        } catch (StockException ex) {
            assertTrue(ex.getMessage(),ex.getMessage().equals("La quantité doit etre >= zero"));
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getQuantiteDeLaBoisson method, of class Barman.
     */
    @Test
    public void testGetQuantiteDe() {
        System.out.println("getQuantiteDe");
        Boisson boisson = null;
        Barman instance = babar;
        Integer expResult = 0;
        Integer result = instance.getQuantiteDeLaBoisson(boisson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

}
