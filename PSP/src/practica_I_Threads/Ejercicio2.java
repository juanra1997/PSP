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
public class Ejercicio2 implements Runnable{

    private String name;
    
    public Ejercicio2(String s){
        
        name=s;
    }
    
    public String getName(){
        
        return this.name;
    }
    @Override
    public void run(){
        System.out.println("<<<<<<<<< Iniciando hilo: "+getName());
        long ti=System.currentTimeMillis();
        int cont=0;
        int s=6;//Introducir aqui el numero de saludos
        if(s<10&&s>1){
        while(cont<s){
            dormir(1000);
            System.out.println("\tCuenta atras > "+(s-cont));
            cont++;
        }
        }
        long tf=System.currentTimeMillis();
        System.out.println("\tCuenta atras finalizada en: "+((tf-ti)/1000)+" segundos");
    }
    
    public void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("Error, mensaje: "+e.getMessage());
        }
    }
    
}

class Ejercicio21 implements Runnable {

    private String name;
    
    public Ejercicio21(String s){
        
        name=s;
    }
    
    public String getName(){
        
        return this.name;
    }
    
    @Override
    public void run(){
        System.out.println("<<<<<<<<<<<< Iniciando hilo: "+getName());
        long ti=System.currentTimeMillis();
        int cont=0;
        while(cont<10){
            dormir(1000);
            System.out.println("Java es Divertido");
            cont++;
        }
        long tf=System.currentTimeMillis();
        System.out.println("Java es Divertido finalizada en: "+((tf-ti)/1000)+" segundos");
    }
    
    public void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("Error, mensaje: "+e.getMessage());
        }
    }
}

class Principal1 {
    
    public static void main(String[] args){
        
        long ti=System.currentTimeMillis();
        Ejercicio2 ca=new Ejercicio2("Hilo 2");
        Ejercicio21 ca1=new Ejercicio21("Hilo 1");
        Thread tca=new Thread(ca);
        Thread tca1=new Thread(ca1);
        tca.start();
        tca1.start();
        
        int n=1000000;//Inroducir aqui el numero a descomponer
        System.out.println("\t\t\t\t\tLa descomposición de "+n+" es: ");
        dormir(500);
        
        if(n>100000&&n<10000000){
            int cont2=0;
            while(n%2==0){
                n=n/2;
                cont2++;
            }
            int cont3=0;
            while(n%3==0){
                n=n/3;
                cont3++;
            }
            int cont5=0;
            while(n%5==0){
                n=n/5;
                cont5++;
            }
            int cont7=0;
            while(n%7==0){
                n=n/7;
                cont7++;
            }
            int cont9=0;
            while(n%9==0){
                n=n/9;
                cont9++;
            }
            int cont11=0;
            while(n%11==0){
                n=n/11;
                cont11++;
            }
            /*System.out.println("\t\t\t\t\tLa descomposición es: ");
            dormir(500);*/
            if(cont2>0){
                System.out.println("\t\t\t\t\t2^"+cont2);
                dormir(500);
            }
            if(cont3>0){
                System.out.println("\t\t\t\t\t3^"+cont3);
                dormir(500);
            }
            if(cont5>0){
                System.out.println("\t\t\t\t\t5^"+cont5);
                dormir(500);
            }
            if(cont7>0){
                System.out.println("\t\t\t\t\t7^"+cont7);
                dormir(500);
            }
            if(cont9>0){
                System.out.println("\t\t\t\t\t9^"+cont9);
                dormir(500);
            }
            if(cont11>0){
                System.out.println("\t\t\t\t\t11^"+cont11);
                dormir(500);
            }
        }
        
        long tfp=System.currentTimeMillis();
        System.out.println("\t\t\t\t\tLa descomposicion ha finalizado en "+((tfp-ti)/1000)+" segundos");
        
        while(tca.isAlive()||tca1.isAlive()){
            
        }
        long tf=System.currentTimeMillis();
        System.out.println("El programa ha finalizado en "+((tf-ti)/1000)+" segundos");
    }
    
    public static void dormir(long t){
        try{
            sleep(t);
        } catch(InterruptedException e){
            System.err.println("ERROR, mensaje: "+e.getMessage());
        }
    }
}
/*Hacer un programa que pasado un número ‘n’ 100.000<n<1000.000 me los descomponga en factores primos la salida
será tipo n=a² x b⁴ x ….x 1 esto lo hará en un hilo, otro hilo me ira mostrando un saludo un número de veces pasado
como parámetro (entre 1 y 10) separando cada saludo por 1s y otro último hilo me mostrara 10 veces separadas por un
segundo “Java es Divertido”. Tiempo de ejecución de cada hilo y del programa*/