/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprodlistas;

/**
 *
 * @author Juanra
 */
public class Consumidor extends Thread {
    
    MiLista ml;
    
    public Consumidor(MiLista m){
        
        ml=m;
    }
    
    @Override
    public void run(){
        
        while(true){
            
            if(ml.array.size()==0){
                
                System.out.println("Lista vacia, esperando");
                try{
                    
                    sleep(1000);
                }catch (InterruptedException ie){
                    
                }
            } else {
                
                System.out.println("Consumiendo la palabra: "+ml.quitar()+", quedan: "+ml.array.size());
            }
        }
    }
}
