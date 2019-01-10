package tcp3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor implements Runnable {
    private Socket concli;
    private int num;
    ArrayList<PrintWriter> salidas;
    PrintWriter OUT;
    
    public HiloServidor(Socket con, int num, ArrayList<PrintWriter> ls){
        concli=con;
        this.num=num;
        salidas=ls;
    }

    @Override
    public void run() {
        String cad="";
        String cliente="[Cliente_"+num+"]>";
	try(
                 BufferedReader in=new BufferedReader(new InputStreamReader(concli.getInputStream()));
                 PrintWriter out = new PrintWriter(concli.getOutputStream(), true) 
	)
            {
			OUT=out;	
                //Lanzamos el hilo hablar para que el servidor hable conlos clientes
                salidas.add(OUT);
                //Esto es para que al servidor le lleguen los mensajes de los clientes
                while(cad!=null || !cad.equalsIgnoreCase("exit")){
                    cad=in.readLine().trim();
                    if(cad.equalsIgnoreCase("exit")){
			salidas.remove(OUT);
			System.out.println("Cliente: "+num+ " desconectado");
                        break;
                    }
                    System.out.println(cliente+""+cad);
                }
                
            }catch(Exception ex){
			 salidas.remove(OUT);
                         System.out.println("Error en HiloServidor: "+ ex.getMessage());
            }        
  }
   //----------------------------------------------------------------------------  
}
