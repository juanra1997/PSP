/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprodlistas;

import java.util.ArrayList;

/**
 *
 * @author Juanra
 */
public class MiLista {
    
    public ArrayList<String> array=new ArrayList<String>();
    
    public synchronized void ponerDato(String c){
        
        //----------------------------------------------------------------------
        if(array.size()<=10){
        //----------------------------------------------------------------------
        /**/array.add(c);
        /**/notify();
        //----------------------------------------------------------------------
        }
        //----------------------------------------------------------------------
    }
    
    public synchronized String quitar(){
        
        if(array.size()==0){
            
            try{
                
                wait();
            } catch(InterruptedException ie){
                
            }
        }
        String cadena=array.get(0);
        array.remove(0);
        return cadena;
    }
}
