package tcp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;


public class Servidor {
    public static void main(String [] args) {
        final int PTO=15000;
        int numcli=1;
        ArrayList<PrintWriter> salidas= new ArrayList<>();
        
        try(
               ServerSocket conp=new ServerSocket(15000);
                )
        {
            mensaje();
            //Iniciamos el HiloHblar para que le servidor hable con los clientes.
            (new Thread(new HiloHablar(salidas))).start();
            while(true){
                HiloServidor h = new HiloServidor(conp.accept(), numcli++, salidas);
                System.out.println("Ha llegado un cliente, Num cli=" + (numcli-1));
                (new Thread(h)).start();
                
            }
        }catch(IOException ex){}
 }
    public static void mensaje(){
        System.out.println("--------------------------------------------");
        System.out.println("#        < Servidor Multicliente >         #");
        System.out.println("#            ( Puerto 15000 )              #");
        System.out.println("------------------------------- ------------");
        
    }
}

