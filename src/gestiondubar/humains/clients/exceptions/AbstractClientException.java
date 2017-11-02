/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients.exceptions;

/**
 *
 * @author ISEN
 */
public class AbstractClientException  extends Exception{
    private static final long serialVersionUID = 1L;

    public AbstractClientException(String string) {
        super(string);
    }
    
//     L'encapsulation est réalisée généralement grâce au constructeur de la classe Exception qui prend en paramètre un Throwable. 
    
// try {  
// 	maMéthodeQuiRenvoitPlusieursTypesDException(); 
// }catch (Exception e) {
//   // En englobe toutes les exceptions dans une exception unique  
//   throw new Exception("Un problème est survenue", e); 
// }

    public AbstractClientException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
