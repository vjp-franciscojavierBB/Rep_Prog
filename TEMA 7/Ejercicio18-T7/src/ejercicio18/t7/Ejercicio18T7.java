/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio18.t7;

/**
 *
 * @author javie
 */
public class Ejercicio18T7 {
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

    public static void main(String[] args) {

        int[] array1 = {7, 2, 15, 9, 1};
        int[] array2 = {8, 3, 14, 6, 4};

        int[] resultado = unirYOrdenar(array1, array2);

        mostrarArray(resultado);
    }

    public static int[] unirYOrdenar(int[] a, int[] b) {

        int[] combinado = new int[10];

        // Copiamos los elementos del primer array
        for (int i = 0; i < a.length; i++) {
            combinado[i] = a[i];
        }

        // Copiamos los elementos del segundo array
        for (int i = 0; i < b.length; i++) {
            combinado[i + 5] = b[i];
        }

        // Ordenamos el array combinado (método burbuja para mantener estilo didáctico)
        for (int i = 0; i < combinado.length - 1; i++) {
            for (int j = 0; j < combinado.length - 1 - i; j++) {
                if (combinado[j] > combinado[j + 1]) {
                    int aux = combinado[j];
                    combinado[j] = combinado[j + 1];
                    combinado[j + 1] = aux;
                }
            }
        }

        return combinado;
    }

    public static void mostrarArray(int[] array) {
        System.out.println("Array combinado y ordenado:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
