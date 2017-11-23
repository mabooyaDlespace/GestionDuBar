/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients.interfaces;

import gestiondubar.humains.Humain;
import gestiondubar.humains.clients.*;
/**
 *@see gestiondubar.humains.clients.interfaces.encapsulations.ServirClient
 * @author ISEN
 */
public interface Servir {
   
    public Integer getMonnaieDuBar();
    public void setMonnaieDuBar(Integer monnaieDubar);  
    public void donnerLaMonnaieAuxResponsables(Humain humain);
}
