/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaCrono;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class Hilo extends Thread{
    
    JTextField txt;
    JFrame hi;
    int tiempo;
    
    public Hilo(JTextField t){
        
        txt=t;
    }
    
    @Override
    public void run(){
        
        String cont;
        
        tiempo=(int)(Math.random()*40+10);
        while(tiempo>40){
            tiempo=(int)(Math.random()*40+10);
        }
        txt.setText(String.valueOf(tiempo));
        cont=txt.getText();
        
        while(!cont.equals("100")){
            
                dormir(1000);
                cont=String.valueOf(Integer.parseInt(cont)+1);
                txt.setText(cont);            
        }
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void dormir(long t){
        
	try{
            sleep(t);
	}catch(InterruptedException e){
            System.err.println("Error: "+e.getMessage());
	}
    }
}
