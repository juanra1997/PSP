/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Juanra
 */
public class Principal {

    public static void main(String[] args) {

        Cuenta miCuenta = new Cuenta();
        Operaciones op = new Operaciones(miCuenta);
        Thread hilo1 = new Thread(op, "Manuel");
        Thread hilo2 = new Thread(op, "Ana");
        //hilo2.setPriority(Thread.MAX_PRIORITY);
        hilo1.start();
        hilo2.start();

        while (hilo1.isAlive() || hilo2.isAlive()) {

        }
    }
}
