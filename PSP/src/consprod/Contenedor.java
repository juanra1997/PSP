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
public class Contenedor {
    
    boolean lleno=false;
    int numero;
    
    public synchronized int poner(){
        while(!lleno){
            try{
                wait();
            } catch(InterruptedException e){
            
            }
        }
        notify();
        numero=(int)(Math.random()*10+1);
        lleno=true;
        //System.out.println(lleno);
        return numero;
    }
    
    public synchronized int quitar(){
        while(lleno){
            try{
                wait();
                //System.out.println("Entro");
            } catch(InterruptedException e){
            
            }
        }
        notify();
        lleno=false;
        //System.out.println(lleno);
        return numero;
    }
}
