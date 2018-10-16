/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lavadero;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Principal {
    
    public static void main(String[] args){
        
        long tinicio=System.currentTimeMillis();
        Coche coche1=new Coche(TamannoCoche.PEQUENNO, TipoLavado.EXTRA);//12
        Coche coche2=new Coche(TamannoCoche.MEDIANO, TipoLavado.NORMAL);//14
        Coche coche3=new Coche(TamannoCoche.GRANDE, TipoLavado.SUPER);//22
        Coche coche4=new Coche(TamannoCoche.GRANDE, TipoLavado.NORMAL);//18
        Operario op1=new Operario("Operario 1", coche1);
        Operario op2=new Operario("Operario 2", coche2);
        Operario op3=new Operario("Operario 1", coche3);
        Operario op4=new Operario("Operario 2", coche4);
        op1.start();
        op2.start();

        try {
            /*while(op1.isAlive()){
            
            }*/
            op1.join();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        op3.start();
        
        try {
            /*while(op2.isAlive()){
            
            }*/
            op2.join();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        op4.start();
        
        try {
            /*while(op3.isAlive()){
            
            }*/
            op3.join();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long tfin=System.currentTimeMillis();
        System.out.println("Fin del programa en: "+((tfin-tinicio)/1000)+" segundos");
    }
    
}
