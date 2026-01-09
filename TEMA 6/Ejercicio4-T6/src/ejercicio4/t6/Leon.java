/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.t6;

/**
 *
 * @author Jav1e7
 */
public class Leon extends Felino {

    public Leon() {
        super();
    }

    public Leon(String nombre, int edad, int peso) {
        super(nombre, edad, peso);
    }

    @Override
    public void mostrarSonido() {
        System.out.println("Su sonido es el rugido");
    }

    @Override
    public void mostrarAlimentacion() {
        System.out.println("Su alimentacion es carnívora");
    }

    @Override
    public void mostrarHabitat() {
        System.out.println("Su habitat es la sabana");
    }

    @Override
    public void mostrarNombreCientifico() {
        System.out.println("Su nombre cientifico es Panthera leo");
    }

    @Override
    public String toString() {
        return "Leon: " + super.toString();
    }
}
