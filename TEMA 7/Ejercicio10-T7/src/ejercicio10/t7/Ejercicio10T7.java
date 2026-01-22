/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10.t7;

/**
 *
 * @author javie
 */
public class Ejercicio10T7 {

    public static void main(String[] args) {
        int[] vector = generarVector();
        mostrarVector(vector, "Se han generado los siguientes números:");
        sustituirRepetidosPorCero(vector);
        mostrarVector(vector, "Sustituimos los elementos repetidos por un 0:");
    }

    /**
     * Genera un vector de 10 enteros con valores entre 1 y 8 (inclusive),
     * usando la hora del sistema para variar los valores.
     */
    public static int[] generarVector() {
        int[] vector = new int[10];
        
        // Semilla basada en el tiempo actual
        long semilla = System.currentTimeMillis();
        
        for (int i = 0; i < vector.length; i++) {
            // Generamos un número pseudoaleatorio entre 1 y 8
            // Usamos una fórmula simple: (semilla + i) % 8 + 1
            int valor = (int)((semilla + i) % 8) + 1;
            vector[i] = valor;
        }
        return vector;
    }

    /**
     * Muestra el contenido del vector con un mensaje descriptivo.
     */
    public static void mostrarVector(int[] vector, String mensaje) {
        System.out.print(mensaje + " ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    /**
     * Sustituye por 0 todos los elementos cuyo valor aparece más de una vez en el vector.
     * Por ejemplo: [8,1,5,7,2,1,5,4,3,6] → [8,0,0,7,2,0,0,4,3,6]
     */
    public static void sustituirRepetidosPorCero(int[] vector) {
        // Contador para los valores del 1 al 8
        int[] contador = new int[9]; // índice 0 no se usa; usamos 1..8

        // Contar cuántas veces aparece cada número
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] >= 1 && vector[i] <= 8) {
                contador[vector[i]]++;
            }
        }

        // Reemplazar por 0 si el número aparece más de una vez
        for (int i = 0; i < vector.length; i++) {
            if (contador[vector[i]] > 1) {
                vector[i] = 0;
            }
        }
    }
}