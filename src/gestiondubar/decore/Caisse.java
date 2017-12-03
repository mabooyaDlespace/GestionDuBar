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
public class Caisse {
    private Integer argentDuBar=0;
    private String HistoriqueDubar="";

    public Caisse() {
    }

    public Integer getArgentDuBar() {
        return argentDuBar;
    }

    public void setArgentDuBar(Integer argentDuBar) {
        Integer delta =(argentDuBar-this.argentDuBar);
        HistoriqueDubar+="\n "+this.argentDuBar.toString()+" + "+delta+"  =" +argentDuBar.toString();
        this.argentDuBar = argentDuBar;
        
    }

    public String getHistoriqueDubar() {
        
        return HistoriqueDubar;
        
    }

    public void setHistoriqueDubar(String HistoriqueDubar) {
        this.HistoriqueDubar = HistoriqueDubar;
    }
    public String toString(){
        return "ARG-CAI:"+this.argentDuBar;
    }
}
