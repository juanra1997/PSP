
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
        //DatagramPacket dpr=new DatagramPacket(new byte[1024], 1024);
        //String pet;
        String respuesta=null;
        
        try{
            
            conexion=new DatagramSocket(PTO);
            System.out.println("SERVIDOR ACTIVO");
            
            while(true){
                
                DatagramPacket recibido=new DatagramPacket(new byte[1024], 1024);
                conexion.receive(recibido);
                System.out.println("Conexion recibida");
                String pet=new String(recibido.getData());
                pet.trim();
                //System.out.println(pet);
                //System.out.println(pet.substring(0, 6).equals("saludo"));
                if(pet.substring(0, 4).equals("hora")){
                    respuesta=new String("Hora del servidor: "+new Date());
                }else if(pet.substring(0, 6).equals("saludo")){
                    respuesta=new String("Buenos dias cliente");
                }
                //String respuesta=new String("Hora del servidor: "+new Date());
                byte[] respuestab=respuesta.getBytes();
                DatagramPacket enviado=new DatagramPacket(respuestab, respuestab.length, recibido.getAddress(), recibido.getPort());
                conexion.send(enviado);
                System.out.println("Respuesta enviada");
                System.out.println("\nSERVIDOR ACTIVO");
            }
        } catch(SocketException e){
            
        } catch(IOException e){
            
        }finally{
            
            conexion.close();
        }
    }
    
}
