/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consprod;

/**
 *
 * @author Juanra
 */
public class Productor extends Thread {
    
    boolean lleno;
    Contenedor c;
    
    public Productor(Contenedor co){
                
        c=co;
        lleno=c.lleno;
    }
    
    @Override
    public void run(){
        System.out.println(lleno);
        while(true){
        while(!lleno){
            //System.out.println("Entro");
        //}
        //while(true){
            dormir(1000);
            System.out.println("Se ha puesto: "+c.poner());
            lleno=c.lleno;
            
        }
        //System.out.println("He salido");
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
