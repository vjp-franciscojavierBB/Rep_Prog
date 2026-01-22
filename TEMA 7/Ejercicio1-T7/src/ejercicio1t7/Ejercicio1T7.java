    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1t7;
import java.util.Scanner;


/**
 *
 * @author javie
 */
public class Ejercicio1T7 {
    public static void main(String[] args) {
        int[] numeros = leerDiezNumeros();
        mostrarPares(numeros);
    }

    // Pide 10 números enteros al usuario y los devuelve en un array
    public static int[] leerDiezNumeros() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Introduce el numero " + (i + 1) + ": ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada no valida. Introduce un entero: ");
                sc.next();
            }
            arr[i] = sc.nextInt();
        }
        return arr; 
    }

    // Recorre el array y muestra solo los números pares
    public static void mostrarPares(int[] arr) {
        System.out.print("Numeros pares:  ");
        
        for (int n : arr) {        boolean hayPar = false;

            if (n % 2 == 0) {
                System.out.println(n + " ");
                hayPar = true;
            }
        }
    }
}
