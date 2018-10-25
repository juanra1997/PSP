/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class Principal {
    
     public static void main(String[] args){
        
        Ventana obj=new Ventana();
        obj.setVisible(true);
    }
}

class Ventana extends JFrame implements ActionListener{
    
    PanelBotones pb;
    PanelPantalla pp;
    JButton bi, bp;
    JTextField txt;
    Hilo miHilo;
    
    public Ventana(){
        
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        
        pp=new PanelPantalla();
        add(pp);
        
        txt=pp.getPantalla();
        
        pb=new PanelBotones();
        add(pb);
        
        bi=pb.getInicio();
        bi.addActionListener(this);
        
        bp=pb.getParar();
        bp.setEnabled(false);
        bp.addActionListener(this);
        
        miHilo=new Hilo(txt);
        
        setBounds(50, 50, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        
    }

    public JButton getBi() {
        return bi;
    }

    public void setBi(JButton bi) {
        this.bi = bi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==bi){
            
                if(!miHilo.isAlive()){
                    miHilo.start();
                }
                bi.setEnabled(false);
                bp.setEnabled(true);
                miHilo.setEsperar(false);
            
        }
        
        if(e.getSource()==bp){
            //if(!miHilo.isEsperar()){
                miHilo.setEsperar(true);
                bi.setEnabled(true);
                bp.setEnabled(false);
            //}else{
                //miHilo.setEsperar(false);
            //}
        }
    }
}