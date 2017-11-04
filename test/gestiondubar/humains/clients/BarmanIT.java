/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.Caisse;
import gestiondubar.decore.bars.BoissonEtQuantite;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * public void setUp(). 
 * luc = new Client("Luc1");<br>
 * patronne = new
 * Patronne("Davida"); <br>
 * serv = new Serveur("serv", patronne);<br>
 * patronne.setBarman(new Barman("Babar", patronne));<br>
 *  babar = patronne.getBarman();<br>
 *
 * @author ISEN
 */
public class BarmanIT {

    public static AbstractClient luc;
    public static Patronne patronne;
    public static Serveur serv;
    public static Barman babar ;

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
        } catch (AbstractClientException ex) {
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
    public void testGetPatronne() {

        System.out.println("getPatronne");
        Barman instance = null;
        Patronne expResult = null;
        Patronne result = instance.getPatronne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaisseDuBar method, of class Barman.
     */
    @Test
    public void testGetCaisseDuBar() {
        System.out.println("getCaisseDuBar");
        Barman instance = null;
        Caisse expResult = null;
        Caisse result = instance.getCaisseDuBar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *
     * Test of setPatronne method, of class Barman.
     */
    @Test
    public void testSetPatronne() {
        System.out.println("setPatronne");
        Patronne patronne = null;
        Barman instance = null;
        instance.setPatronne(patronne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCaisseDuBar method, of class Barman.
     */
    @Test
    public void testSetCaisseDuBar() {
        System.out.println("setCaisseDuBar");
        Caisse caisseDuBar = null;
        Barman instance = null;
        instance.setCaisseDuBar(caisseDuBar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Barman.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Barman instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//INTERFACE SERVIR=====================================================================

    /**
     *
     * Test of getMonnaieDuBar method, of class Barman.
     * test du bon déroulemet d'une transation
     */
    @Test
    public void testGetMonnaieDuBar() {
        try {
            System.out.println("getMonnaieDuBar");
            assertTrue( serv.getMonnaieDuBar().equals(0));
            assertTrue( babar.getMonnaieDuBar().equals(0));
            luc.boire(luc.commanderBoisson(Boisson.RICARD,serv ));
            luc.boire(luc.commanderBoisson(Boisson.RICARD, babar));
            assertTrue( serv.getMonnaieDuBar().equals(2));// ils ont chacun 2 euros
            assertTrue( babar.getMonnaieDuBar().equals(2));
            assertTrue(luc.getDegreAlccolemie().toString() , luc.getDegreAlccolemie().equals(4)); //4 degres d'alcool
            assertTrue( luc.getPorteMonnaie().equals(-4));//-4 euros
            assertTrue(patronne.getBarman().getCaisseDuBar().getArgentDuBar().toString(),patronne.getBarman().getCaisseDuBar().getArgentDuBar().equals(0));
            serv.donnerLaMonnaieAuxResponsables(babar);// ils donnes la monnaie
            babar.donnerLaMonnaieAuxResponsables(babar);
            assertTrue(patronne.getBarman().getCaisseDuBar().getArgentDuBar().toString(),patronne.getBarman().getCaisseDuBar().getArgentDuBar().equals(4));
            assertTrue( serv.getMonnaieDuBar().equals(2));// ils ont chacun 0 euros
            assertTrue( babar.getMonnaieDuBar().equals(2));

        } catch (AbstractClientException ex) {
            fail();
            Logger.getLogger(BarmanIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    /**
     * Test of setMonnaieDuBar method, of class Barman.
     */
    @Test
    public void testSetMonnaieDuBar() {
        System.out.println("setMonnaieDuBar");
        Integer monnaieDubar = null;
        Barman instance = null;
        instance.setMonnaieDuBar(monnaieDubar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *  Test of
     * donnerLaMonnaieAuxResponsables method, of class Barman.
     */
    @Test
    public void testDonnerLaMonnaieAuxResponsables() {
        System.out.println("donnerLaMonnaieAuxResponsables");
        Humain humain = null;
        Barman instance = null;
        instance.donnerLaMonnaieAuxResponsables(humain);

    }

//INTERFACE GERERSTOCK=====================================================================
    /**
     * Test of estPresentDansLeStock method, of class Barman.
     */
    @Test
    public void testEstPresentDansLeStock() {
        System.out.println("estPresentDansLeStock");
        Boisson ceQueJeCherche = null;
        Barman instance = null;
        boolean expResult = false;
        boolean result = instance.estPresentDansLeStock(ceQueJeCherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeDansLeStock method, of class Barman.
     */
    @Test
    public void testExisteDansLeStock() {
        System.out.println("existeDansLeStock");
        Boisson ceQueJeCherche = null;
        Barman instance = null;
        boolean expResult = false;
        boolean result = instance.existeDansLeStock(ceQueJeCherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoissonEtQuantite method, of class Barman.
     */
    @Test
    public void testGetBoissonEtQuantite() {
        System.out.println("getBoissonEtQuantite");
        Boisson ceQueJeCherche = null;
        Barman instance = null;
        BoissonEtQuantite expResult = null;
        BoissonEtQuantite result = instance.getBoissonEtQuantite(ceQueJeCherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantite method, of class Barman.
     */
    @Test
    public void testSetQuantite() throws Exception {
        System.out.println("setQuantite");
        Boisson ceQueJeMets = null;
        Integer quantite = null;
        Barman instance = null;
        instance.setQuantite(ceQueJeMets, quantite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantiteDe method, of class Barman.
     */
    @Test
    public void testGetQuantiteDe() {
        System.out.println("getQuantiteDe");
        Boisson boisson = null;
        Barman instance = null;
        Integer expResult = null;
        Integer result = instance.getQuantiteDe(boisson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
