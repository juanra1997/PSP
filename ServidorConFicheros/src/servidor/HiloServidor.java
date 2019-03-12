/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import mensaje.ParteFichero;

/**
 *
 * @author Juanra
 */
public class HiloServidor implements Runnable{
    
    private String nombreArchivo="WeAreYoungFun.mp3";
    private Socket con;
    private File fichero;
    private ObjectOutputStream oos;
    private BufferedInputStream bis;
    
    public HiloServidor(Socket c){
        
        con=c;
        System.out.println("Ha llegado una nueva peticion: "+con.getRemoteSocketAddress());
    
    }
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        fichero=new File(nombreArchivo);
        if(!fichero.exists()){
            System.err.println("El fichero no existe");
            System.exit(-1);
        }
        try{
            
            oos=new ObjectOutputStream(con.getOutputStream());
            bis=new BufferedInputStream(new FileInputStream(fichero));
            System.out.println("Mandando fichero a cliente: "+con.getRemoteSocketAddress());
            mandarFichero();
            
        }catch(IOException e){
            
            System.err.println("Error al enviar el archivo");
            
        }finally{
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException ex) {
                    //Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException ex) {
                    //Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }    
    
    public void mandarFichero(){
        
    }
}
