/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio20.t5;

/**
 *
 * @author Jav1e7
 */
public class CuentaClave extends cuenta {

    private String clave;

    public CuentaClave() {
        super();
        clave = "";

    }

    public CuentaClave(float saldo, String clave) {
        super(saldo);
        this.clave = clave;
    }
//getters,setters de clave

    @Override
    public void extraer(float c) {
        // Sólo permite la extracción si hay saldo suficiente
        if (getSaldo() >= c) {
            super.extraer(c);
        }
    }
}
