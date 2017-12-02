/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.decore.Boisson;

/**
 *
 * @author ISEN
 */
public enum Sexe {
    MR("Mr."),MDM("Mdm");
    private final String sexe;

    Sexe(String name){
        sexe = name;
    }

    @Override
    public String toString() {
        return this.sexe;//To change body of generated methods, choose Tools | Templates.
    }
     public static String afficherLesSexes() {
        Integer i = 0;
        String str = "";
        for (Sexe boisson : Sexe.values()) {
            str += "\n"+"N°" + i + " " + boisson.toString();
            i++;
        }
        return str;
    }
    public static Sexe ChoisirUnSexe(Integer i){
        if(i<Sexe.values().length){
            return Sexe.values()[i];
        }
        return null;
    }
}
