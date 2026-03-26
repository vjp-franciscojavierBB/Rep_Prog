/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03.t11;

/**
 *
 * @author javie
 */
public class Conductor {
    private final String dni;
    private final String nombre;

    public Conductor(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Conductor{dni=" + dni + ", nombre=" + nombre + "}";
    }
}

