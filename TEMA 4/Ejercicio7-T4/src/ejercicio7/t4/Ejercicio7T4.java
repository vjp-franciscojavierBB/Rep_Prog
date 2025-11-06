/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7.t4;
import java.util.Scanner;
/**
 *
 * @author Jav1e7
 */
public class Ejercicio7T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[4];

        String[] mensajes = {
            "Por favor, introduzca el primer número: ",
            "Ahora, introduzca un segundo número: ",
            "Introduzca el tercer número: ",
            "Por último, introduzca un cuarto número: "
        };

        for (int i = 0; i < 4; i++) {
            System.out.print(mensajes[i]);
            numeros[i] = scanner.nextInt();
        }

        ordenarManual(numeros);
        mostrarNumeros(numeros);
    }

    // Método para ordenar manualmente usando intercambio
    public static void ordenarManual(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    // Intercambiar valores
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // Método para mostrar los números ordenados
    public static void mostrarNumeros(int[] nums) {
        System.out.print("El orden de los números introducidos es el: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }
}

