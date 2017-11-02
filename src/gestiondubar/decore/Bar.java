/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore;

import gestiondubar.decore.bars.Stock;
import gestiondubar.humains.Humain;
//
/**
 *
 * Bar qui contient Patronne, Caisse, Barman, Serveur, Boissons 
 *  @see Bar#caisseDuBar
 * @see Bar#nomDuBar
 * @author ISEN
 * 
 */
public class Bar {
    private String nomDuBar=null;
    private  Caisse caisseDuBar = new Caisse();
    private Stock stock;
    
    /**
     * Initie la Caisse à Zéro
     * @param nomDeLaPatronne 
     */
    public Bar (String nomDeLaPatronne){
        nomDuBar="Chez-"+nomDeLaPatronne;
        stock=new Stock(nomDeLaPatronne);
        
    }
    public Caisse getCaisseDuBar(Humain humain) {
        if(humain.getClass().getSimpleName().equals("Barman")){
            return caisseDuBar;
    
        }else return null;
    }

    public String toString(){
        return "CLA:"+this.getClass().getSimpleName()+" NAM:"+this.nomDuBar+" "+caisseDuBar.toString();
    }

}
