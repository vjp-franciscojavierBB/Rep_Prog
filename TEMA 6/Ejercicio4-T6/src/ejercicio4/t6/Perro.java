/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.t6;

/**
 *
 * @author Jav1e7
 */
public class Perro extends Canido {

    public Perro() {
        super();
    }

    public Perro(String nombre, int edad, int peso) {
        super(nombre, edad, peso);
    }

    @Override
    public void mostrarSonido() {
        System.out.println("Su sonido es el ladrido");
    }

    @Override
    public void mostrarAlimentacion() {
        System.out.println("Su alimentacion es carnivora");
    }

    @Override
    public void mostrarHabitat() {
        System.out.println("Su habitat es domestico");
    }

    @Override
    public void mostrarNombreCientifico() {
        System.out.println("Su nombre cientifico es Canis lupus familiaris");
    }

    @Override
    public String toString() {
        return "Perro: " + super.toString();
    }
}
