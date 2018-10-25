/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class Hilo extends Thread{
    
    JTextField txt;
    boolean esperar=false;
    
    public Hilo(JTextField t){
        
        txt=t;
    }
    
    @Override
    public void run(){
        
        String sec, min, cont;
        
        cont=txt.getText();
        min=cont.substring(0, 2);
        sec=cont.substring(3,5);

        while(true){

            dormir(580);
            
            while(esperar){
                //System.out.println(esperar);
            }
            
            if(Integer.parseInt(sec)==59){
                min=String.valueOf(Integer.parseInt(min)+1);
                sec="00";
                if(Integer.parseInt(min)<10){
                    min="0"+min;
                    txt.setText(min+":"+sec);
                }else{
                    
                }
            }else{
                sec=String.valueOf(Integer.parseInt(sec)+1);
                if(Integer.parseInt(sec)<10){
                    txt.setText(min+":0"+sec);
                }else{
                    txt.setText(min+":"+sec);
                }
            }
            
        }
    }

    public boolean isEsperar() {
        return esperar;
    }

    public void setEsperar(boolean esperar) {
        this.esperar = esperar;
    }
    
    public void dormir(long t){
        
        int cont=0;
        
	try{
            System.out.println(!esperar+" "+(cont<t));
            
            while(cont<t){
                while(!esperar&&cont<t){
                    sleep(1);
                    cont++;
                    //System.out.println(cont);
                }
                //System.out.println("Holis");
            }
	}catch(InterruptedException e){
            System.err.println("Error: "+e.getMessage());
	}
    }
}
