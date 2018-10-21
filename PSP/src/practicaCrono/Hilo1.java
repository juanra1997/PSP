/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaCrono;

//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class Hilo1 extends Thread{
    
    JLabel txt;
    int tiempo;
    
    public Hilo1(JLabel t, int ti){
        
        txt=t;
        tiempo=ti;
    }
    
    @Override
    public void run(){
            
        dormir(tiempo*1000);
        dormir(300);
        txt.setVisible(true);
    }

    
    
    public void dormir(long t){
        
	try{
            sleep(t);
	}catch(InterruptedException e){
            System.err.println("Error: "+e.getMessage());
	}
    }
}
