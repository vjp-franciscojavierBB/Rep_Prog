/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio15.t7;

import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Ejercicio15T7 {

    public static void main(String[] args) {
        int[] ventas = null;
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        Scanner lectorOpciones = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Rellenar ventas mensuales (aleatorias entre 10 y 100)");
            System.out.println("2. Mostrar las ventas introducidas");
            System.out.println("3. Mostrar las ventas al reves");
            System.out.println("4. Suma total de ventas del ano");
            System.out.println("5. Ventas totales de los meses pares");
            System.out.println("6. Mes con mas ventas");
            System.out.println("7. Salir del programa");
            System.out.print("Elige una opcion: ");
            
            opcion = lectorOpciones.nextInt();

            switch (opcion) {
                case 1:
                    ventas = rellenarVentas();
                    System.out.println("Ventas generadas correctamente.");
                    break;
                case 2:
                    if (ventas != null) {
                        mostrarVentas(ventas, meses);
                    } else {
                        System.out.println("Primero debes rellenar las ventas (opcion 1).");
                    }
                    break;
                case 3:
                    if (ventas != null) {
                        mostrarVentasAlReves(ventas, meses);
                    } else {
                        System.out.println("Primero debes rellenar las ventas (opcion 1).");
                    }
                    break;
                case 4:
                    if (ventas != null) {
                        int total = calcularSumaTotal(ventas);
                        System.out.println("Suma total de ventas del ano: " + total);
                    } else {
                        System.out.println("Primero debes rellenar las ventas (opcion 1).");
                    }
                    break;
                case 5:
                    if (ventas != null) {
                        int totalPares = calcularVentasMesesPares(ventas);
                        System.out.println("Ventas totales de los meses pares (Feb, Abr, Jun, Ago, Oct, Dic): " + totalPares);
                    } else {
                        System.out.println("Primero debes rellenar las ventas (opcion 1).");
                    }
                    break;
                case 6:
                    if (ventas != null) {
                        String mesMax = obtenerMesConMasVentas(ventas, meses);
                        System.out.println("Mes con mas ventas: " + mesMax);
                    } else {
                        System.out.println("Primero debes rellenar las ventas (opcion 1).");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        } while (opcion != 7);

        lectorOpciones.close();
    }

    /**
     * Genera un array de 12 enteros con valores aleatorios entre 10 y 100.
     */
    public static int[] rellenarVentas() {
        int[] ventas = new int[12];
        long semilla = System.currentTimeMillis();

        for (int i = 0; i < ventas.length; i++) {
            // Generamos numero entre 10 y 100 (inclusive)
            ventas[i] = (int) ((semilla + i * 37) % 91) + 10; // 91 = 100 - 10 + 1
        }
        return ventas;
    }

    /**
     * Muestra las ventas junto con el nombre del mes.
     */
    public static void mostrarVentas(int[] ventas, String[] meses) {
        System.out.println("Ventas mensuales:");
        for (int i = 0; i < ventas.length; i++) {
            System.out.println(meses[i] + ": " + ventas[i]);
        }
    }

    /**
     * Muestra las ventas en orden inverso (de diciembre a enero).
     */
    public static void mostrarVentasAlReves(int[] ventas, String[] meses) {
        System.out.println("Ventas al reves:");
        for (int i = ventas.length - 1; i >= 0; i--) {
            System.out.println(meses[i] + ": " + ventas[i]);
        }
    }

    /**
     * Calcula la suma total de todas las ventas.
     */
    public static int calcularSumaTotal(int[] ventas) {
        int suma = 0;
        for (int i = 0; i < ventas.length; i++) {
            suma += ventas[i];
        }
        return suma;
    }

    /**
     * Calcula la suma de las ventas de los meses pares:
     * Febrero (1), Abril (3), Junio (5), Agosto (7), Octubre (9), Diciembre (11)
     */
    public static int calcularVentasMesesPares(int[] ventas) {
        int suma = 0;
        // Indices impares (1,3,5,7,9,11) corresponden a meses pares (2º, 4º, etc.)
        for (int i = 1; i < ventas.length; i += 2) {
            suma += ventas[i];
        }
        return suma;
    }

    /**
     * Devuelve el nombre del mes con mayor venta.
     */
    public static String obtenerMesConMasVentas(int[] ventas, String[] meses) {
        int max = ventas[0];
        int indiceMax = 0;
        for (int i = 1; i < ventas.length; i++) {
            if (ventas[i] > max) {
                max = ventas[i];
                indiceMax = i;
            }
        }
        return meses[indiceMax] + " (" + max + " ventas)";
    }
}