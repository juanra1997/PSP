/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.ServerSocket;

/**
 *
 * @author Juanra
 */
public class Servidor {
    
    public static final int puerto=15000;
    
    public static void main(String[] args){
        
        try(ServerSocket con=new ServerSocket(puerto);){
          
            System.out.println("-------------------------------------");
            System.out.println("SERVIDOR CONECTADO EN EL PUERTO 15000");
            System.out.println("-------------------------------------");
            
            while(true){
                
                (new Thread(new HiloServidor(con.accept()))).start();
                
            }
                       
        }catch(Exception e){
            
            System.out.println("Error en el servidor");
            System.exit(-1);
            
    }
    }
}
