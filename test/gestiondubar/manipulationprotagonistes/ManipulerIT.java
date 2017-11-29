/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.manipulationprotagonistes;

import gestiondubar.decore.Boisson;
import gestiondubar.decore.bars.exceptions.StockException;
import gestiondubar.humains.clients.AbstractClient;
import static gestiondubar.humains.clients.AbstractClientIT.babar;
import static gestiondubar.humains.clients.AbstractClientIT.luc;
import static gestiondubar.humains.clients.AbstractClientIT.patronne;
import static gestiondubar.humains.clients.AbstractClientIT.serv;
import gestiondubar.humains.clients.Barman;
import gestiondubar.humains.clients.BarmanIT;
import gestiondubar.humains.clients.Client;
import gestiondubar.humains.clients.Patronne;
import gestiondubar.humains.clients.Serveur;
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
        Manipuler instance=null;
        try {
            System.out.println("creerListeDesProtagonistes");
            patronne=null;
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
            Manipuler instance = new Manipuler(patronne);
            //instance.updateListeDesProtagonistes(patronne);
            System.out.println(instance.afficherLesProtagonnistes());
            // TODO review the generated test code and remove the default call to fail.
        } catch (AbstractClientException ex) {
            Logger.getLogger(ManipulerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
