/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.decore.bars.exceptions;

/**
 *
 * @author ISEN
 */
public class StockException extends Exception{

    public StockException(String string) {
        super(string);
    }

    public StockException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
