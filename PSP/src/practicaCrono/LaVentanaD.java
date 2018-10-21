/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaCrono;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class LaVentanaD extends JFrame implements ActionListener {

    JTextField pantalla, pantalla2;
    JLabel titulo;
    static JLabel ganador;
    JButton inicio, salir;
    Hilo miHilo, miHilo1;
    Hilo1 cuenta;
    boolean ac = true;
    int t, t1, t2;

    public LaVentanaD() {

        iniciaComponentes();
    }

    public void iniciaComponentes() {

        setLayout(null);

        //--------------------------------Pantalla 1----------------------------
        pantalla = new JTextField();

        pantalla.setEditable(false);
        pantalla.setBounds(20, 80, 300, 200);
        pantalla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pantalla.setBackground(Color.WHITE);
        pantalla.setHorizontalAlignment(JTextField.CENTER);
        pantalla.setFont(new Font("ARIAL", Font.PLAIN, 36));
        pantalla.setText("00");
        add(pantalla);

        //--------------------------------Pantalla 2----------------------------
        pantalla2 = new JTextField();

        pantalla2.setEditable(false);
        pantalla2.setBounds(340, 80, 300, 200);
        pantalla2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pantalla2.setBackground(Color.WHITE);
        pantalla2.setHorizontalAlignment(JTextField.CENTER);
        pantalla2.setFont(new Font("ARIAL", Font.PLAIN, 36));
        pantalla2.setText("00");
        add(pantalla2);

        //--------------------------------Hilos---------------------------------
        miHilo = new Hilo(pantalla);

        miHilo1 = new Hilo(pantalla2);

        //--------------------------------Titulo--------------------------------
        titulo = new JLabel();

        titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titulo.setForeground(Color.RED);
        titulo.setBounds(247, 20, 200, 40);
        titulo.setText("CUENTA HASTA 100");
        add(titulo);

        //--------------------------------Label---------------------------------
        ganador = new JLabel();

        ganador.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ganador.setForeground(Color.RED);
        ganador.setBounds(247, 300, 200, 40);
        ganador.setVisible(false);
        add(ganador);

        //--------------------------------Boton 1-------------------------------
        inicio = new JButton("START");

        inicio.setBounds(120, 300, 100, 35);
        inicio.addActionListener(this);
        add(inicio);

        //--------------------------------Boton 2-------------------------------
        salir = new JButton("EXIT");

        salir.setBounds(440, 300, 100, 35);
        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.exit(0);
            }
        });
        add(salir);

        //----------------------------------------------------------------------
        setBounds(50, 50, 680, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cronometro");
    }

    public Hilo getMiHilo() {
        return miHilo;
    }

    public void setMiHilo(Hilo miHilo) {
        this.miHilo = miHilo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == inicio) {
            inicio.setEnabled(false);
            t=0;
            miHilo.start();
            miHilo1.start();
            t1=miHilo.getTiempo();
            t2=miHilo1.getTiempo();
            while(t1==0||t1>40){
                    t1=miHilo.getTiempo();
                }
            while(t2==0||t2>40){
                    t2=miHilo1.getTiempo();
                }
            if (t1 > t2) {
                ganador.setText("Ganador: jugador 1");
                t=miHilo1.getTiempo();
                add(ganador);
                cuenta = new Hilo1(ganador, (100-t));
            } else if (t1 < t2) {
                ganador.setText("Ganador: jugador 2");
                t=miHilo.getTiempo();
                add(ganador);
                cuenta = new Hilo1(ganador, (100-t));
            } else if (t1 == t2) {
                ganador.setText("Empate");
                t=miHilo.getTiempo();
                add(ganador);
                cuenta = new Hilo1(ganador, (100-t)/*, this*/);
            }
            cuenta.start();
        }
    }
}
