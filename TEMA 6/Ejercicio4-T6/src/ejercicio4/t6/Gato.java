/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.t6;

/**
 *
 * @author Jav1e7
 */
public class Gato extends Felino {

    public Gato() {
        super();
    }

    public Gato(String nombre, int edad, int peso) {
        super(nombre, edad, peso);
    }

    @Override
    public void mostrarSonido() {
        System.out.println("Su sonido es el maullido");
    }

    @Override
    public void mostrarAlimentacion() {
        System.out.println("Se alimenta de ratones");
    }

    @Override
    public void mostrarHabitat() {
        System.out.println("Su habitat es doméstico");
    }

    @Override
    public void mostrarNombreCientifico() {
        System.out.println("Su nombre cientifico es Felis silvestris catus");
    }

    @Override
    public String toString() {
        return "Gato: " + super.toString();
    }
}
