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
public class Cuenta {
    
    private int balance;

    public Cuenta() {
        
        this.balance = 50;
    }

    public int getBalance() {
        
        return balance;
    }

    public void retirarDinero(int balance) {
        
        this.balance = this.balance - balance;
    }

}
