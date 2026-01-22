/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio17.t7;

/**
 *
 * @author javie
 */
public class Ejercicio17T7 {

    public static void main(String[] args) {
        int[] vector = generarVector();
        System.out.print("Vector original: ");
        mostrarVector(vector);
        ordenarVectorDescendente(vector);
        System.out.print("Vector ordenado (mayor a menor): ");
        mostrarVector(vector);
    }

    public static int[] generarVector() {
        int[] vector = new int[10];
        long semilla = System.currentTimeMillis();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) ((semilla + i * 17) % 10); // 0 a 9
        }
        return vector;
    }

    public static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void ordenarVectorDescendente(int[] vector) {
        // Ordenacion burbuja descendente
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - 1 - i; j++) {
                if (vector[j] < vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }
}