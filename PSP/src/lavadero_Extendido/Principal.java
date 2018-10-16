/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavadero_Extendido;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Principal {
    
    static Scanner sc;
    static InputMismatchException miExcepcion=new InputMismatchException();
    static Coche[] coches;
    static Operario[] op;
    
    public static void main(String[] args){
        
        coches=new Coche[4];
        op=new Operario[4];
        
        for(int i=0; i<coches.length; i++){
            System.out.println("Coche "+(i+1));
            TamannoCoche tc;
            TipoLavado tl;
            tc=seleccionarTamanno();
            tl=seleccionarLavado();
            coches[i]=new Coche(tc, tl);
        }
        
        for(int i=0; i<op.length; i++){
            if(i%2==0){
                op[i]=new Operario("Operario 1", coches[i]);
            } else {
                op[i]=new Operario("Operario 2", coches[i]);
            }
        }
        
        burbuja(op);
        //----------------------------------------------------------------------
        //System.out.println("Operario 1: "+op[0].getTiempo());
        //System.out.println("Operario 2: "+op[1].getTiempo());
        //System.out.println("Operario 3: "+op[2].getTiempo());
        //System.out.println("Operario 4: "+op[3].getTiempo());
        //----------------------------------------------------------------------
        
        long tinicio=System.currentTimeMillis();
        
        op[0].start();
        op[1].start();

        try {
            /*while(op1.isAlive()){
            
            }*/
            op[0].join();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        op[3].start();
        
        try {
            /*while(op2.isAlive()){
            
            }*/
            op[1].join();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        op[2].start();
        
        try {
            /*while(op3.isAlive()){
            
            }*/
            op[2].join();
            op[3].join();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long tfin=System.currentTimeMillis();
        System.out.println("Fin del programa en: "+((tfin-tinicio)/1000)+" segundos");
    }
    
    public static void burbuja(Operario lista[]){
        
        int cuentaintercambios=0;
        for (boolean ordenado=false;!ordenado;){
            for (int i=0;i<lista.length-1;i++){
                if (lista[i].getTiempo()>lista[i+1].getTiempo()){
                    Operario variableauxiliar=lista[i];
                    lista[i]=lista[i+1];
                    lista[i+1]=variableauxiliar;
                    cuentaintercambios++;
                }
            }
            if (cuentaintercambios==0){
                ordenado=true;
            }
            cuentaintercambios=0;
        }
    }
    
    public static TamannoCoche seleccionarTamanno(){

        sc=new Scanner(System.in);
        TamannoCoche t=TamannoCoche.PEQUENNO;
        int a=0;
        System.out.println("************* Selecciona el coche ***************\n"
        +"1. Coche pequeño\n2. Coche mediano\n3. Coche grande");
        try{
            a=sc.nextInt();
            switch(a){
                case 1:
                    return TamannoCoche.PEQUENNO;
                    //break;
                case 2:
                    return TamannoCoche.MEDIANO;
                    //break;
                case 3:
                    return TamannoCoche.GRANDE;
                    //break;
                default:
                    throw miExcepcion;
            }

        } catch(InputMismatchException e){
            System.out.println("No es una entrada valida");
            t=seleccionarTamanno();
        }
        
        return t;
    }
    
    public static TipoLavado seleccionarLavado(){

        sc=new Scanner(System.in);
        TipoLavado t=TipoLavado.NORMAL;
        int a=0;
        System.out.println("************* Selecciona el lavado ***************\n"
        +"1. Lavado normal\n2. Lavado extra\n3. Lavado super");
        try{
            a=sc.nextInt();
            switch(a){
                case 1:
                    return TipoLavado.NORMAL;
                    //break;
                case 2:
                    return TipoLavado.EXTRA;
                    //break;
                case 3:
                    return TipoLavado.SUPER;
                    //break;
                default:
                    throw miExcepcion;
            }

        } catch(InputMismatchException e){
            System.out.println("No es una entrada valida");
            t=seleccionarLavado();
        }
        
        return t;
    }
}
