/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio14.t4;
import java.util.Scanner;
/**
 *
 * @author Jav1e7
 */
public class Ejercicio14T4 {
public static void main(String[] args) {
        int numero = pedirNumero();
        int total = mostrarMultiplosDeTres(numero);
        System.out.println("Se han mostrado " + total + " números múltiplos de 3.");
    }

    // Método para pedir el número al usuario
    public static int pedirNumero() {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.print("Introduce un número mayor que 0: ");
            num = scanner.nextInt();
            if (!esMayorQueCero(num)) {
                System.out.println("Error: el número debe ser mayor que 0.");
            }
        } while (!esMayorQueCero(num));
        return num;
    }

    // Método para comprobar si el número es mayor que 0
    public static boolean esMayorQueCero(int n) {
        return n > 0;
    }

    // Método para mostrar los múltiplos de 3 y contar cuántos hay
    public static int mostrarMultiplosDeTres(int limite) {
        int contador = 0;
        System.out.println("Múltiplos de 3 entre 1 y " + limite + ":");
        for (int i = 1; i <= limite; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
                contador++;
            }
        }
        return contador;
    }
}


