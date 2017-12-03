/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import java.util.logging.Level;
import java.util.logging.Logger;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.Humain;
import static gestiondubar.humains.clients.BarmanIT.babar;
import static gestiondubar.humains.clients.BarmanIT.luc;
import static gestiondubar.humains.clients.BarmanIT.patronne;
import static gestiondubar.humains.clients.BarmanIT.serv;
import gestiondubar.humains.clients.exceptions.AbstractClientException;
import gestiondubar.manipulationprotagonistes.Manipuler;
import static org.hamcrest.core.Is.is;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ISEN
 */
public class AbstractClientIT {

    public static AbstractClient luc;
    public static Patronne patronne;
    public static Serveur serv;
    public static Barman babar;

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
        try {
            luc = new Client("Luc1");
            patronne = new Patronne("Davida");
            serv = new Serveur("serv", patronne);
            patronne.setBarman(new Barman("Babar", patronne));
            babar = patronne.getBarman();
            patronne.getBar().serveurs.add(serv);
            patronne.getBar().clients.add(luc);
            babar.setQuantiteDeLaBoisson(Boisson.EAU, 10);
            babar.setQuantiteDeLaBoisson(Boisson.RICARD, 10);
            babar.setQuantiteDeLaBoisson(Boisson.SHOOTER, 10);

        } catch (AbstractClientException | StockException ex) {
            Logger.getLogger(Manipuler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDegreAlccolemie method, of class AbstractClient.
     */
    @Test
    public void testGetDegreAlccolemie_00() {
        try {
            System.out.println("getDegreAlccolemie");
            AbstractClient instance = new AbstractClientImp("Al");
            Integer expResult = 0;
            Integer result = instance.getDegreAlccolemie();
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getDegreAlccolemie method, of class AbstractClient.
     */
    @Test
    public void testGetDegreAlccolemie_01() {
        try {
            System.out.println("getDegreAlccolemie");
            AbstractClient instance = new AbstractClientImp("Al");
            Integer expResult = 0;
            Integer result = instance.getDegreAlccolemie();
            Integer inte = 2;
            result = inte;

            assertNotSame(instance.getDegreAlccolemie(), inte);
            // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setDegreAlccolemie method, of class AbstractClient. cant be set
     * to null
     */
    @Test
    public void testSetDegreAlccolemie_00() throws AbstractClientException {
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
    public void testBoire_00() {
        try {
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
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
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
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of payer method, of class AbstractClient. test avec null
     */
    @Test
    public void testPayer_00() {
        try {
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
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of payer method, of class AbstractClient. test instance non
     * barman/serveur
     */
    @Test
    public void testPayer_01() {
        try {
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
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * Test of payer method, of class AbstractClient. test prix null
     */
    @Test
    public void testPayer_02() {
        try {
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
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of payer method, of class AbstractClient. test le fonctionnement
     * attedu de la fonction
     */
    @Test
    public void testPayer_03() {
        try {
            System.out.println("payer");
            AbstractClient payeur = new AbstractClientImp("Al");
            Integer prix = 2;
            Patronne patronne = new Patronne("Davida");
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
            expResult = 0;//regarder si l'argent du serveur a changé
            assertTrue(expResult.equals(serveur.getPorteMonnaie()));
            expResult = prix;//regarder si la monnaie du bar a augmente
            assertTrue(expResult.equals(serveur.getMonnaieDuBar()));

        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of commanderBoisson method, of class AbstractClient.
     */
    @Test
    public void testCommanderBoisson_00() {
        try {
            assertEquals(Boisson.EAU, luc.commanderBoisson(Boisson.EAU, serv));
            assertEquals(Boisson.EAU, luc.commanderBoisson(Boisson.EAU, babar));
            assertEquals(Boisson.RICARD, luc.commanderBoisson(Boisson.RICARD, babar));
            assertEquals(Boisson.RICARD, luc.commanderBoisson(Boisson.RICARD, babar));
            assertEquals(Boisson.SHOOTER, luc.commanderBoisson(Boisson.SHOOTER, babar));
            assertEquals(Boisson.SHOOTER, luc.commanderBoisson(Boisson.SHOOTER, babar));
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StockException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of toString method, of class AbstractClient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AbstractClient instance = null;
        try {
            instance = new AbstractClientImp("Al");
        } catch (AbstractClientException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void testSePresenterA_00() {
        System.out.println("sePresenterA");
        Humain humain = null;
        AbstractClient instance = null;
        try {
            instance = new AbstractClientImp("Al");

            String expResult = "";
            String result = instance.sePresenterA(humain);
            fail("The test case is a prototype.");
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is("humain est d'intance null ou pas humain"));

            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of sePresenterA method, of class AbstractClient.
     */
    @Test
    public void testSePresenterA_01() {
        System.out.println("sePresenterA");
        ;
        AbstractClient instance = null;
        try {
            instance = new AbstractClientImp("Al");

            String expResult = "Al dit salut";
            String result = instance.sePresenterA(luc);
            assertTrue(result,expResult.equals(result));
        //luc est d'intance null ou pas luc
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            fail("The test case is a prototype.");
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Alcolémie 3
     * Test of sePresenterA method, of class AbstractClient.
     */
    @Test
    public void testSePresenterA_02() {
        System.out.println("sePresenterA");
        ;
        AbstractClient instance = null;
        try {
            instance = new AbstractClientImp("Al");

            String expResult = "Al dit salut c'est cool";
            instance.degreAlccolemie=5;
            String result = instance.sePresenterA(luc);
            assertTrue(result,expResult.equals(result));
        //luc est d'intance null ou pas luc
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            fail("The test case is a prototype.");
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Alcolémie 3
     * Test of sePresenterA method, of class AbstractClient.
     */
    @Test
    public void testSePresenterA_03() {
        System.out.println("sePresenterA");
        ;
        AbstractClient instance = null;
        try {
            instance = new AbstractClientImp("Al");

            String expResult = "Al dit ch'suis pas bourré dabord";
            instance.degreAlccolemie=10;
            String result = instance.sePresenterA(luc);
            assertTrue(result,expResult.equals(result));
        //luc est d'intance null ou pas luc
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            fail("The test case is a prototype.");
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * 
     * Test of offrirUnVerre method, of class AbstractClient.
     */
    @Test
    public void testOffrirUnVerre_00() {
        try {
            System.out.println("offrirUnVerre");
            Humain humainChanceux = null;
            Humain personnelServant = null;
            AbstractClient instance = new AbstractClientImp("Al");
            instance.offrirUnVerre(humainChanceux, personnelServant);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (AbstractClientException ex) {
            assertTrue(ex.getMessage(), ex.getMessage().equals("humainChanceux n'est pas une instance"));
            //assertThat(ex.getMessage(), is("génial"));
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StockException ex) {
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
     * 
     * Test of offrirUnVerre method, of class AbstractClient.
     */
    @Test
    public void testOffrirUnVerre_01() {
        try {
            System.out.println("offrirUnVerre");
            luc.boissonFavorite=Boisson.RICARD;
            Humain humainChanceux = luc;
            Humain personnelServant = serv;
            AbstractClient instance = new AbstractClientImp("Al");
            instance.offrirUnVerre(humainChanceux, personnelServant);
            // TODO review the generated test code and remove the default call to fail.
            assertTrue(luc.degreAlccolemie.toString(), luc.degreAlccolemie==2 );
        } catch (AbstractClientException ex) {
            fail(" error");
            Logger.getLogger(AbstractClientIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public class AbstractClientImp extends AbstractClient {

        public AbstractClientImp(String prenom) throws AbstractClientException {
            super(prenom);
        }

    }

    /**
     * Test of demanderSiPrésentDansLesStcoks method, of class AbstractClient.
     */
    @Test
    public void testDemanderSiPrésentDansLesStocks_3args_1() {
        try {
            System.out.println("demanderSiPr\u00e9sentDansLesStcoks");
            Humain humain = null;
            Boisson boisson = null;
            Integer quantite = null;

            boolean expResult = false;
            boolean result = luc.demanderSiPresentDansLesStocks(humain, boisson, quantite);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is(" n'est pas un membre du personnel "));
        }
    }

    /**
     * Test of demanderSiPrésentDansLesStcoks method, of class AbstractClient.
     */
    @Test
    public void testDemanderSiPresentDansLesStocks_3args_2() {
        try {
            System.out.println("demanderSiPrésentDansLesStcoks");
            Serveur serveur = null;
            Boisson boisson = null;
            Integer quantite = null;
            boolean expResult = false;
            boolean result = luc.demanderSiPresentDansLesStocksServeur(serveur, boisson, quantite);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is("Le parametre humain n'est pas une instance de Personnel"));

        }
    }

    /**
     * Test of demanderSiPrésentDansLesStcoks method, of class AbstractClient.
     */
    @Test
    public void testDemanderSiPrésentDansLesStocks_3args_3() {
        try {
            System.out.println("demanderSiPr\u00e9sentDansLesStcoks");
            Barman serveur = null;
            Boisson boisson = null;
            Integer quantite = null;
            AbstractClient instance = null;
            boolean expResult = false;
            boolean result = luc.demanderSiPresentDansLesStocksBarman(serveur, boisson, quantite);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (AbstractClientException ex) {
            assertThat(ex.getMessage(), is("Le parametre humain n'est pas une instance de Personnel"));
        }
    }

    public class AbstractClientImpl extends AbstractClient {

        public AbstractClientImpl() throws Exception {
            super("");
        }
    }

}
