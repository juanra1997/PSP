/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class PanelPantalla extends JPanel{
    
    JTextField pantalla;
    
    public PanelPantalla(){
        
        pantalla=new JTextField();
        pantalla.setEditable(false);
        pantalla.setPreferredSize(new Dimension(300,200));
        pantalla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pantalla.setBackground(Color.WHITE);
        pantalla.setHorizontalAlignment(JTextField.CENTER);
        pantalla.setFont(new Font("ARIAL", Font.PLAIN, 36));
        pantalla.setText("00:00");
        add(pantalla);
    }

    public JTextField getPantalla() {
        return pantalla;
    }

    public void setPantalla(JTextField pantalla) {
        this.pantalla = pantalla;
    }
}
