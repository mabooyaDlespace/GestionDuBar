/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import gestiondubar.decore.Boisson;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ISEN
 */
public class AbstractClientIT {

    public AbstractClientIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDegreAlccolemie method, of class AbstractClient.
     */
    @Test
    public void testGetDegreAlccolemie() {
        System.out.println("getDegreAlccolemie");
        AbstractClient instance = new AbstractClientImp("Al");
        Integer expResult = 0;
        Integer result = instance.getDegreAlccolemie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreAlccolemie method, of class AbstractClient.
     */
    @Test
    public void testGetDegreAlccolemie_01() {
        System.out.println("getDegreAlccolemie");
        AbstractClient instance = new AbstractClientImp("Al");
        Integer expResult = 0;
        Integer result = instance.getDegreAlccolemie();
        Integer inte = 2;
        result = inte;

        assertNotSame(instance.getDegreAlccolemie(), inte);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreAlccolemie method, of class AbstractClient. cant be set
     * to null
     */
    @Test
    public void testSetDegreAlccolemie() throws AbstractClientException {
        System.out.println("setDegreAlccolemie");
        Integer degreAlccolemie = null;
        AbstractClient instance = new AbstractClientImp("Al");
        try {
            instance.setDegreAlccolemie(degreAlccolemie);
            fail();
        } catch (AbstractClientException e) {
            assertThat(e.getMessage(), is("Degrealcolemie ne peut pas etre inférieur à 0"));
            //fail();
        }
    }

    /**
     * Test of setDegreAlccolemie method, of class AbstractClient.
     */
    @Test
    public void testSetDegreAlccolemie_01() throws AbstractClientException {
        System.out.println("setDegreAlccolemie");
        Integer degreAlccolemie = 0;
        AbstractClient instance = new AbstractClientImp("Al");
        try {
            instance.setDegreAlccolemie(degreAlccolemie);

        } catch (AbstractClientException e) {
            assertThat(e.getMessage(), is("Degrealcolemie ne peut pas etre inférieur à 0"));
            //fail();
        }
        assertTrue(instance.getDegreAlccolemie().compareTo(degreAlccolemie) == 0);
    }

    /**
     * Test of setDegreAlccolemie method, of class AbstractClient.
     */
    @Test
    public void testSetDegreAlccolemie_02() throws AbstractClientException {
        System.out.println("setDegreAlccolemie");
        Integer degreAlccolemie = 8;
        AbstractClient instance = new AbstractClientImp("Al");
        try {
            instance.setDegreAlccolemie(degreAlccolemie);

        } catch (AbstractClientException e) {
            assertThat(e.getMessage(), is("Degrealcolemie ne peut pas etre inférieur à 0"));
            //fail();
        }
        assertTrue(instance.getDegreAlccolemie().compareTo(degreAlccolemie) == 0);
    }

    /**
     * Test of boire method, of class AbstractClient. cant be null
     */
    @Test
    public void testBoire() {
        System.out.println("boire");
        Boisson boisson = null;
        AbstractClient instance = new AbstractClientImp("Al");

        try {
            instance.boire(boisson);
            fail("The test case is a prototype.");
        } catch (AbstractClientException e) {
            assertThat(e.getMessage(), is("Le parametre boisson doit être une instance de Boisson"));
            //fail();
        }
        //assertTrue(instance.getDegreAlccolemie().compareTo(degreAlccolemie)==0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of boire method, of class AbstractClient. cant be null
     */
    @Test
    public void testBoire_01() {
        System.out.println("boire");
        Boisson boisson = Boisson.RICARD;
        AbstractClient instance = new AbstractClientImp("Al");

        try {
            instance.boire(boisson);
//                 fail("The test case is a prototype.");
        } catch (AbstractClientException e) {
            assertThat(e.getMessage(), is("Le parametre boisson doit être une instance de Boisson"));
            fail();
        }
        assertTrue(instance.getDegreAlccolemie().compareTo(Boisson.RICARD.getPointsAlcool()) == 0);
        //assertTrue(instance.getDegreAlccolemie().compareTo(degreAlccolemie)==0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of payer method, of class AbstractClient. test avec null
     */
    @Test
    public void testPayer() {
        System.out.println("payer");
        Humain humain = null;
        Integer prix = null;
        AbstractClient instance = new AbstractClientImp("Al");
        Integer expResult = 0;
        try {
            instance.payer(humain, prix);
            fail();
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is("Le parametre humain doit etre un barman ou un serveur"));
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(expResult.equals(instance.getPorteMonnaie()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of payer method, of class AbstractClient.
     * test instance non barman/serveur
     */
    @Test
    public void testPayer_01() {
        System.out.println("payer");
        AbstractClient payeur = new AbstractClientImp("Al");
        Integer prix = null;
        AbstractClient instance = new AbstractClientImp("Al");
        Integer expResult = 0;
        try {
            payeur.payer(instance, prix);
            fail();
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is("Le parametre humain doit etre un barman ou un serveur"));
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(expResult.equals(payeur.getPorteMonnaie()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of payer method, of class AbstractClient. 
     * test prix null
     */
    @Test
    public void testPayer_02() {
        System.out.println("payer");
        AbstractClient payeur = new AbstractClientImp("Al");
        Integer prix = null;
        Serveur serveur = new Serveur("Al", new Patronne("Davida"));
        Integer expResult = 0;
        try {
            payeur.payer(serveur, prix);
            fail();
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is("Le prix doit être non null"));
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(expResult.equals(payeur.getPorteMonnaie()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of payer method, of class AbstractClient. 
     * test le fonctionnement attedu de la fonction
     */
    @Test
    public void testPayer_03() {
        System.out.println("payer");
        AbstractClient payeur = new AbstractClientImp("Al");
        Integer prix = 2;
        Patronne patronne=new Patronne("Davida");
        Serveur serveur;
        serveur = new Serveur("AlAin", patronne);
        Integer expResult = -prix;
        try {
            payeur.payer(serveur, prix);
        } catch (AbstractClientException ex) {
            fail();
        }
        //regarder si l'argent du payer a diminué
        assertTrue(expResult.equals(payeur.getPorteMonnaie()));
        expResult=0;//regarder si l'argent du serveur a changé
        assertTrue(expResult.equals(serveur.getPorteMonnaie()));
        expResult=prix;//regarder si la monnaie du bar a augmente
        assertTrue(expResult.equals(serveur.getMonnaieDuBar()));
        
    }

    /**
     * Test of commanderBoisson method, of class AbstractClient.
     */
    @Test
    public void testCommanderBoisson() {
        System.out.println("commanderBoisson");
        AbstractClient payeur = new AbstractClientImp("Al");
        Integer prix = 2;
        Patronne patronne=new Patronne("Davida");
        Serveur serveur;
        serveur = new Serveur("AlAin", patronne);
        Integer expResult = -prix;
        Boisson result = payeur.commanderBoisson(Boisson.RICARD, serveur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class AbstractClient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AbstractClient instance = new AbstractClientImp("Al");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sePresenterA method, of class AbstractClient.
     */
    @Test
    public void testSePresenterA() {
        System.out.println("sePresenterA");
        Humain humain = null;
        AbstractClient instance = new AbstractClientImp("Al");
        String expResult = "";
        String result = instance.sePresenterA(humain);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of offrirUnVerre method, of class AbstractClient.
     */
    @Test
    public void testOffrirUnVerre() throws AbstractClientException {
        System.out.println("offrirUnVerre");
        Humain humainChanceux = null;
        Humain personnelServant = null;
        AbstractClient instance = new AbstractClientImp("Al");
        instance.offrirUnVerre(humainChanceux, personnelServant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractClientImp extends AbstractClient {

        public AbstractClientImp(String prenom) {
            super(prenom);
        }

    }
}
