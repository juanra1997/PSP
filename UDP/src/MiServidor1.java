
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juanra
 */
public class MiServidor1 {
    
    public static void main(String[] args){
        
        final int PTO=9000;
        byte[] mensaje;
        DatagramSocket conexion=null;
        
        try{
            
            conexion=new DatagramSocket(PTO);
            System.out.println("SERVIDOR ACTIVO");
            
            while(true){
                
                DatagramPacket recibido=new DatagramPacket(new byte[1024], 1024);
                conexion.receive(recibido);
                System.out.println("Conexion recibida");
                String respuesta=new String("Hora del servidor: "+new Date());
                byte[] respuestab=respuesta.getBytes();
                DatagramPacket enviado=new DatagramPacket(respuestab, respuestab.length, recibido.getAddress(), recibido.getPort());
                conexion.send(enviado);
                System.out.println("Respuesta enviada");
            }
        } catch(SocketException e){
            
        } catch(IOException e){
            
        }finally{
            
            conexion.close();
        }
    }
    
}
