/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore;

/**
 * Classe/valueof/Prix/Degré Alcool<br>
 * EAU("eau",0,0),<br>SHOOTER("vodka grenadine",3,5),<br>RICARD("Ricard",2,2).
 * <br>   <br>
 *
 * Cette classe est une énumeration qui qui permet définir des boissons qui
 * seront <br>
 * consomées par les personnes présentes dans le bar.
 *
 * @see Boisson#getPointsAlcool() getPointsAlcool
 * @see Boisson#getPrix() getPrix
 * @see #isAvecAlcool() isAvecAlcool
 * @see #setPointsAlcool(java.lang.Integer) setPointsAlcool
 * @see #setPrix(java.lang.Integer) setPrix
 * @see #valueOf(java.lang.String) valueOf
 * @see #values() values
 * @author ISEN
 */
public enum Boisson {

    /**
     * nom =eau<br>
     * pointsAlcool = 0 <br>
     * prix =0<br>
     */
    EAU("eau", 0, 0),
    /**
     * nom =vodka grenadine<br>
     * pointsAlcool = 3 <br>
     * prix =5  <br>
     */
    SHOOTER("vodka grenadine", 3, 5),
    /**
     * nom =Ricard<br>
     * pointsAlcool = 2 <br>
     * prix =2 <br>
     */
    RICARD("Ricard", 2, 2);
    
    private final String nom;
    private Integer pointsAlcool;
    private Integer prix;

    Boisson(String nom, Integer pointsAlcool, Integer prix) {
        this.nom = nom;
        this.pointsAlcool = pointsAlcool;
        this.prix = prix;
    }

    /**
     * renvoie le prix de la boisson 
     * @return
     */
    public Integer getPrix() {
        return prix;
    }

    /**
     * permet de modifier le pris de la boisson
     * @param prix
     */
    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    /**
     * Get the value of pointsAlcool de la boisson
     *
     * @return the value of pointsAlcool
     */
    public Integer getPointsAlcool() {
        return pointsAlcool;
    }

    /**
     * Set the value of pointsAlcool de la boisson
     *
     * @param pointsAlcool new value of pointsAlcool
     */
    public void setPointsAlcool(Integer pointsAlcool) {
        this.pointsAlcool = pointsAlcool;
    }

    /**
     * permet de savoir si la boisson est alcolisée
     * @return
     */
    public boolean isAvecAlcool() {
        return this.pointsAlcool > 0;
    }
}
