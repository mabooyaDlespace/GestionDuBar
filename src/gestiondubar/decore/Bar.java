/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore;

import gestiondubar.decore.bars.Stock;
import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.Barman;
// Jean-charles est un peu homo git
/**
 *
 * Bar qui contient Patronne, Caisse, Barman, Serveur, Boissons 
 *  @see Bar#caisseDuBar
 * @see Bar#nomDuBar
 * @author ISEN
 * 
 */
public class Bar {
    private String nomDuBar;
    private  Caisse caisseDuBar;
    private Stock stock ;
    
    /**
     * Initie la Caisse à Zéro
     * @param nomDeLaPatronne 
     */
    public Bar (String nomDeLaPatronne){
        nomDuBar="Chez-"+nomDeLaPatronne;
        caisseDuBar = new Caisse();
        stock=new Stock(nomDeLaPatronne);
        
    }
/**
 * le stock ne peut être controlé que par le barman
 * @param humain
 * @return 
 */
    public Stock getStock(Humain humain) {
        if(humain instanceof Barman){
            return stock;
    
        }else return null;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public Caisse getCaisseDuBar(Humain humain) {
        if(humain instanceof Barman){
            return caisseDuBar;
    
        }else return null;
    }
    

    public String toString(){
        return "CLA:"+this.getClass().getSimpleName()+" NAM:"+this.nomDuBar+" "+caisseDuBar.toString();
    }

}
