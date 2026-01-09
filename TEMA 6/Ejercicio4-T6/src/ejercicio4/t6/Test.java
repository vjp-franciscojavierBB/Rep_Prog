/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.t6;

/**
 *
 * @author Jav1e7
 */
public class Test {
    public static void main(String[] args) {
        // Crear instancias de animales
        Perro perro = new Perro("Firulais", 3, 15);
        Lobo lobo = new Lobo("Luna", 5, 40);
        Leon leon = new Leon("Simba", 8, 190);
        Gato gato = new Gato("Michi", 2, 4);

        // Mostrar información de cada animal
        System.out.println("=== PERRO ===");
        System.out.println(perro);
        perro.mostrarSonido();
        perro.mostrarAlimentacion();
        perro.mostrarHabitat();
        perro.mostrarNombreCientifico();

        System.out.println("\n=== LOBO ===");
        System.out.println(lobo);
        lobo.mostrarSonido();
        lobo.mostrarAlimentacion();
        lobo.mostrarHabitat();
        lobo.mostrarNombreCientifico();

        System.out.println("\n=== LEON ===");
        System.out.println(leon);
        leon.mostrarSonido();
        leon.mostrarAlimentacion();
        leon.mostrarHabitat();
        leon.mostrarNombreCientifico();

        System.out.println("\n=== GATO ===");
        System.out.println(gato);
        gato.mostrarSonido();
        gato.mostrarAlimentacion();
        gato.mostrarHabitat();
        gato.mostrarNombreCientifico();
    }
}