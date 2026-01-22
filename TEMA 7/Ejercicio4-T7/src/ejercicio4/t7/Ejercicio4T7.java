/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4.t7;

/**
 *
 * @author javie
 */
public class Ejercicio4T7 {

    public static void main(String[] args) {
        int[][] matriz = generarMatriz();
        mostrarPares(matriz);
    }

    public static int[][] generarMatriz() {
        int[][] matriz = new int[4][3];

        // Usamos la hora del sistema para que cambie cada vez
        long base = System.currentTimeMillis() % 50;  
        int valor = 100 + (int) base;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = valor;
                valor += 5;
            }
        }
        return matriz;
    }

    public static void mostrarPares(int[][] matriz) {
        System.out.println("Numeros pares en la matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    System.out.print(matriz [i][j] + " ");
                }
            }
        }
    }
}