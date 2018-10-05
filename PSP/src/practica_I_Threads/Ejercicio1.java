/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_I_Threads;

import static java.lang.Thread.sleep;

/**
 *
 * @author Juanra
 */
public class Ejercicio1 extends Thread {
    
    public Ejercicio1(String s){
        
        super(s);
    }
    @Override
    public void run(){
        System.out.println("<<<<<<<<< Iniciando hilo: "+getName());
        long ti=System.currentTimeMillis();
        int cont=0;
        while(cont<15){
            dormir(1000);
            System.out.println("\t\tCuenta atras > "+(15-cont));
            cont++;
        }
        long tf=System.currentTimeMillis();
        System.out.println("Cuenta atras finalizada en: "+((tf-ti)/1000)+" segundos");
    }
    
    public void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("Error, mensaje: "+e.getMessage());
        }
    }
}

class Principal {
    
    public static void main(String[] args){
        
        Ejercicio1 ca=new Ejercicio1("Hilo 1");
        ca.start();
        int n=20;//Introducir aqui la cantidad de numeros primos, tiene que ser mayor de 10;
        int cont=0;
        long tfi=System.currentTimeMillis();
        if(n>10){
            for(int x=0; cont<n; x++){
                if(esPrimo(x)){
                    System.out.println(x);
                    cont++;
                }
                dormir(50);
            }
        }    
        long tfp=System.currentTimeMillis();
        System.out.println("Primos finalizado en: "+((tfp-tfi)/1000)+" segundos");
        
        while(ca.isAlive()){
            
        }
        
        long tf=System.currentTimeMillis();
        System.out.println("Programa finalizado en: "+((tf-tfi)/1000)+" segundos");
    }
    
    public static void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("ERROR, mensaje: "+e.getMessage());
        }
    }
    
    public static boolean esPrimo(int num){
        int cont = 2;
        boolean primo=true;
        while ((primo) && (cont!=num)){
            if (num % cont == 0)
                primo = false;
                cont++;
            }
        return primo;
        }
}

/*Hacer un programa donde desde un hilo nos muestren los primeros ‘n’ números primos donde n>10 lo pasaremos como
parámetros y en otro hilo muestre una cuenta atrás de 15s a 1s. Tiempo de ejecución de cada hilo y del programa*/