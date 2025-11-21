/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio20.t5;

/**
 *
 * @author Jav1e7
 */
public class cuenta {
// Atributo privado para almacenar el saldo actual de la cuenta.
    private float saldo;

// Constructor por defecto: crea una cuenta con saldo inicial 0.
    public cuenta() {
        saldo = 0;
    }

// Constructor con parámetro
    public cuenta(float saldoInicial) {
        saldo = saldoInicial;
    }

// Método público para ingresar dinero en la cuenta.
    public void ingresar(float c) {
// Agrega la cantidad recibida al saldo actual.
        saldo += c;
    }

// Método público para extraer dinero de la cuenta.
    public void extraer(float c) {
// Descuenta la cantidad recibida del saldo actual.
// El saldo puede quedar en negativo, como se indica en el enunciado.
        saldo -= c;
    }

// Método público para obtener el saldo actual de la cuenta.
    public float getSaldo() {
// Devuelve el valor del atributo saldo.
        return saldo;
    }
}
