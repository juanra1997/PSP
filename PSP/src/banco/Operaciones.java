/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static java.lang.Thread.sleep;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Operaciones implements Runnable {

    private final Cuenta miCuenta;

    public Operaciones(Cuenta cuenta) {

        miCuenta = cuenta;
    }

    public /*synchronized */void sacarDinero(int cant) {

        System.out.println("\tEntró: " + Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {

            if (cant <= miCuenta.getBalance()) {

                System.out.println("Retirando una cantidad de: " + cant + " €, por " + Thread.currentThread().getName());
                esperar(2000);
                miCuenta.retirarDinero(cant);
                System.out.println("Retiro realizado, nos queda una cantidad de " + miCuenta.getBalance() + " €");
            } else {

                esperar(2000);
                System.out.println("No hay suficiente dinero en la cuenta para lrealizar el retiro");
                System.out.println("Su saldo actual es de: " + miCuenta.getBalance() + " €");
            }
        }
    }

    @Override
    public void run() {

        sacarDinero(10);
    }

    public void esperar(long t) {

        try {
            sleep(t);
        } catch (InterruptedException ex) {
            
        }
    }
}
