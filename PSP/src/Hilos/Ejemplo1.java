package Hilos;

import static java.lang.Thread.sleep;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juanra
 */
public class Ejemplo1 extends Thread {
    
    public Ejemplo1(String s){
        
        super(s);
    }
    
    @Override
    public void run(){
        System.out.println("<<<<<<<<< Iniciando hilo: "+getName());
        int cont=0;
        while(cont<20){
            dormir(1000);
            System.out.println("\t\tCuenta atras > "+(20-cont));
            cont++;
        }
    }
    
    public void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("Error, mensaje: "+e.getMessage());
        }
    }
    /*public static void main(String args){
        
        
    }*/
}

class Principal {
    
    public static void main(String[] args){
        
        Ejemplo1 ca=new Ejemplo1("Hilo1");
        long ti=System.currentTimeMillis();
        System.out.println("##Hilos ejemplo 1\n<CASO 1 Heredando de Thread \n");
        ca.start();
        for(int i=0; i<10; i++){
            System.out.println("Saludo: "+i);
            dormir(500);
        }
        
        while(ca.isAlive()){
            
        }
        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de programa, tiempo de ejecución: "+te);
    }
    
    public static void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("ERROR, mensaje: "+e.getMessage());
        }
    }
}