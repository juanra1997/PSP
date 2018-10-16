/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavadero_Extendido;
/**
 *
 * @author Juanra
 */
public class Operario extends Thread {
    
    int t=0;
    Coche c;
    
    public Operario(String n, Coche c){
        
        super(n);
        this.c=c;
        
        if(c.getTam()==TamannoCoche.PEQUENNO){
            t=t+10;
        } else if(c.getTam()==TamannoCoche.MEDIANO){
            t=t+14;
        } else if(c.getTam()==TamannoCoche.GRANDE){
            t=t+18;
        }
        
        if(c.getTip()==TipoLavado.NORMAL){
            t=t+0;
        } else if(c.getTip()==TipoLavado.EXTRA){
            t=t+2;
        } else if(c.getTip()==TipoLavado.SUPER){
            t=t+4;
        }
    }

    public Coche getCoche() {
        return c;
    }

    public void setCoche(Coche c) {
        this.c = c;
    }

    public int getTiempo() {
        return t;
    }

    public void setTiempo(int t) {
        this.t = t;
    }
    
    public Operario(Coche c){
        
        if(c.getTam()==TamannoCoche.PEQUENNO){
            t=t+10;
        } else if(c.getTam()==TamannoCoche.MEDIANO){
            t=t+14;
        } else if(c.getTam()==TamannoCoche.GRANDE){
            t=t+18;
        }
        
        if(c.getTip()==TipoLavado.NORMAL){
            t=t+0;
        } else if(c.getTip()==TipoLavado.EXTRA){
            t=t+2;
        } else if(c.getTip()==TipoLavado.SUPER){
            t=t+4;
        }
    }
    
    @Override
    public void run(){
	
        if(super.getName().equalsIgnoreCase("Operario 1")){
            System.out.println("Lavando coche: "+super.getName());
        } else {
            System.out.println("\t\t\t\tLavando coche: "+super.getName());
        }
        //System.out.println(t*1000);
        if(super.getName().equalsIgnoreCase("Operario 1")){
            while(this.t>0){
                System.out.println(t);
                dormir(1000);
                t--;
            }
            System.out.println("Fin lavado");
        } else {
            while(this.t>0){
                System.out.println("\t\t\t\t"+(t));
                dormir(1000);
                t--;
            }
            System.out.println("\t\t\t\tFin lavado");
        }
        
        //dormir(this.t*1000);
    }
    
    public void dormir(long t){
        
	try{
            sleep(t);
	}catch(InterruptedException e){
            System.err.println("Error: "+e.getMessage());
	}
    }  
}
//Lavado de coche pequeño 10s
//Lavado de coche mediano 14s
//Lavado de coche grande 18s
//Lavado normal 0s
//Lavado extra 2s
//Lavado super 4s