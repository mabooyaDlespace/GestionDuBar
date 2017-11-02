/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore;

/**
 *
 * @author ISEN
 */
public enum Boisson {
   EAU("eau",0,0),SHOOTER("vodka grenadine",3,5),RICARD("Ricard",2,2);
   private final String nom;
    private Integer pointsAlcool;
    private Integer prix;

    Boisson(String nom, Integer pointsAlcool,Integer prix){
       this.nom=nom;
       this.pointsAlcool= pointsAlcool;
       this.prix=prix;
   }
    
    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
   
    /**
     * Get the value of pointsAlcool
     *
     * @return the value of pointsAlcool
     */
    public Integer getPointsAlcool() {
        return pointsAlcool;
    }

    /**
     * Set the value of pointsAlcool
     *
     * @param pointsAlcool new value of pointsAlcool
     */
    public void setPointsAlcool(Integer pointsAlcool) {
        this.pointsAlcool = pointsAlcool;
    }
    public boolean isAvecAlcool(){
       return this.pointsAlcool>0;
    }
}
