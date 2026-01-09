/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.t6;

/**
 *
 * @author Jav1e7
 */
public abstract class Felino extends Animal {
    public Felino() {
        super();
    }

    public Felino(String nombre, int edad, int peso) {
        super(nombre, edad, peso);
    }

    @Override
    public String toString() {
        return "Felino: " + super.toString();
    }
}