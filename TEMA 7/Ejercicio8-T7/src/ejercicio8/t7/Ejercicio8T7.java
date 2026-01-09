/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio8.t7;

/**
 *
 * @author javie
 */

import java.util.Scanner;

public class Ejercicio8T7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el número al usuario
        int numero = solicitarNumero(scanner);

        // Dividir el número en dígitos y almacenarlos en un array
        int[] digitos = dividirEnDigitos(numero);

        // Visualizar los dígitos del array al revés
        System.out.println("El numero introducido escrito al reves es: " + visualizarAlReves(digitos));
        
        scanner.close();
    }

    // Método para solicitar el número al usuario
    public static int solicitarNumero(Scanner scanner) {
        while (true) {
            System.out.print("Introduzca un numero entero de 5 cifras: ");
            int numero = scanner.nextInt();

            if (numero >= 10000 && numero <= 99999) {
                return numero;
            } else {
                System.out.println("El numero debe tener exactamente 5 cifras. Intentelo de nuevo.");
            }
        }
    }

    // Método para dividir el número en dígitos y almacenarlos en un array
    public static int[] dividirEnDigitos(int numero) {
        int[] digitos = new int[5];
        for (int i = 0; i < 5; i++) {
            digitos[i] = numero % 10;
            numero /= 10;
        }
        return digitos;
    }         

    // Método para visualizar los dígitos del array al revés
    public static String visualizarAlReves(int[] digitos) {
        StringBuilder reversedNumber = new StringBuilder();
        for (int i = digitos.length - 1; i >= 0; i--) {
            reversedNumber.append(digitos[i]);
        }
        return reversedNumber.toString();
    }
}



