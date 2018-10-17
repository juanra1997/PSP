/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Juanra
 */
public class PanelBotones extends JPanel implements ActionListener{
    
    JButton inicio, parar, salir;
    
    public PanelBotones(){
        
        inicio=new JButton("INICIO");
        parar=new JButton("PARAR");
        salir=new JButton("SALIR");
        
        salir.addActionListener(this);
        
        add(inicio);
        add(parar);
        add(salir);
    }

    public JButton getInicio() {
        return inicio;
    }

    public void setInicio(JButton inicio) {
        this.inicio = inicio;
    }

    public JButton getParar() {
        return parar;
    }

    public void setParar(JButton parar) {
        this.parar = parar;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==salir){
            System.exit(0);
        }
    }
}

/*class Ventana extends JFrame{
    
    public Ventana(){
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new PanelBotones());
        setBounds(50, 50, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class Principal{
    
    public static void main(String[] args){
        
        Ventana obj=new Ventana();
        obj.setVisible(true);
    }
}*/