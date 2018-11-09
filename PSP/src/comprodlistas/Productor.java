/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprodlistas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Productor extends Thread {
    
    MiLista ml;
    int cont=1;
    
    public Productor(MiLista m){
        
        ml=m;
    }
    
    @Override
    public void run(){
        while(true){
            ml.ponerDato(String.valueOf(cont));
            cont++;
            try {
                sleep(500);
            } catch (InterruptedException ie) {
               
            }
        }
    }
}
