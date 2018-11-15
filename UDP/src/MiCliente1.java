
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juanra
 */
public class MiCliente1 {
    
    public static void main(String[] args){
        
        if(args.length<2){
            
            System.out.println("Tienes que introducir la direccion IP y el puerto");
            System.exit(0);
        }
        InetAddress destino=null;
        try{
            
            destino=InetAddress.getByName(args[0]);
        }catch(UnknownHostException e){
            
            System.err.println("No es posible verificar la IP");
            System.exit(0);
        }
        int PTO=0;
        try{
            
            PTO=Integer.parseInt(args[1]);
        } catch(NumberFormatException e){
            
            System.out.println("Puerto incorrecto");
            System.exit(0);
        }
        DatagramSocket conexion=null;
        DatagramPacket dp1;
        byte[] msj=new byte[1024];
        try{
            
            conexion=new DatagramSocket();
            dp1=new DatagramPacket(msj, msj.length, destino, PTO);
            conexion.send(dp1);
            System.out.println("Peticion enviada, esperando respuesta");
            
            DatagramPacket dpr=new DatagramPacket(new byte[1024], 1024);
            conexion.receive(dpr);
            System.out.println("Respuesta recibida");
            String resp=new String(dpr.getData());
            System.out.println("La respuesta es: "+resp);
        }catch(SocketException e){
            
            System.out.println("Error abriendo conexion");
            System.exit(0);
        }catch(IOException e){
           
            System.out.println("Error recibiendo respuesta");
        }
    }
}
