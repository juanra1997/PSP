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
public class Main {
    
    static Contenedor c;
    static Consumidor cs;
    static Productor p;
    
    public static void main(String[] args){
        
        c=new Contenedor();
        
        cs=new Consumidor(c);
        p=new Productor(c);
        
        //while(true){
            p.start();
            cs.start();
        //}
    }
}
