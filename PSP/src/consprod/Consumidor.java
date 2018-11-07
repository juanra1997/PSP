/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consprod;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Consumidor extends Thread {
    
    boolean lleno;
    Contenedor c;
    
    public Consumidor(Contenedor co){
        
        
        c=co;
        lleno=c.lleno;
    }
    
    @Override
    public void run(){
        while(true){
        while(!lleno){
            dormir(1500);
            System.out.println("Se ha quitado: "+c.quitar());
            //System.out.println("Hola");
            lleno=c.lleno;
        }
        //System.out.println(lleno);
        lleno=c.lleno;
        }
    }
    
    public void dormir(long t){
        try {
            sleep(t);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
