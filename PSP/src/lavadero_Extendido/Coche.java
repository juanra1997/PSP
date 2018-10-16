/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavadero_Extendido;

/**
 *
 * @author Juanra
 */
public class Coche {
    
    private TamannoCoche tam;
    private TipoLavado tip;
    
    public Coche(TamannoCoche tam, TipoLavado tip){
    
        this.tam=tam;
        this.tip=tip;
    }

    public TamannoCoche getTam() {
        return tam;
    }

    public void setTam(TamannoCoche tam) {
        this.tam = tam;
    }

    public TipoLavado getTip() {
        return tip;
    }

    public void setTip(TipoLavado tip) {
        this.tip = tip;
    }
}
//Lavado de coche pequeño 10s
//Lavado de coche mediano 14s
//Lavado de coche grande 18s
//Lavado normal 0s
//Lavado extra 2s
//Lavado super 4s