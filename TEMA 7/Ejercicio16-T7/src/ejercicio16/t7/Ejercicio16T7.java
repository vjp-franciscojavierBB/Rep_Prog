/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio16.t7;

import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Ejercicio16T7 {

    public static void main(String[] args) {
        int[][] notas = null;
        String[] alumnos = {"Pepe", "Juan", "Ana", "Marta", "Pedro", "Maria"};
        String[] asignaturas = {"Lengua", "Mates", "Historia", "Fisica"};
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n--- MENU ---");
            System.out.println("1. Rellenar las notas de los alumnos");
            System.out.println("2. Mostrar las notas introducidas");
            System.out.println("3. Alumno mejor de la clase");
            System.out.println("4. Alumno con mas suspensos");
            System.out.println("5. Asignatura mas dificil");
            System.out.println("6. Salir del programa");
            System.out.print("Elige una opcion: ");
            
            opcion = lector.nextInt();
            System.out.println(); // Línea en blanco después de leer la opción

            // Procesar opción
            if (opcion == 1) {
                notas = rellenarNotas();
                System.out.println("Notas generadas.");
            } else if (opcion == 2) {
                if (notas != null) {
                    mostrarNotas(notas, alumnos, asignaturas);
                } else {
                    System.out.println("Primero debes generar las notas (opcion 1).");
                }
            } else if (opcion == 3) {
                if (notas != null) {
                    String mejor = obtenerMejorAlumno(notas, alumnos);
                    System.out.println("Mejor alumno: " + mejor);
                } else {
                    System.out.println("Primero debes generar las notas (opcion 1).");
                }
            } else if (opcion == 4) {
                if (notas != null) {
                    String peor = obtenerAlumnoConMasSuspensos(notas, alumnos);
                    System.out.println("Alumno con mas suspensos: " + peor);
                } else {
                    System.out.println("Primero debes generar las notas (opcion 1).");
                }
            } else if (opcion == 5) {
                if (notas != null) {
                    String dificil = obtenerAsignaturaMasDificil(notas, asignaturas);
                    System.out.println("Asignatura mas dificil: " + dificil);
                } else {
                    System.out.println("Primero debes generar las notas (opcion 1).");
                }
            } else if (opcion == 6) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        lector.close();
    }

    public static int[][] rellenarNotas() {
        int filas = 6;
        int cols = 4;
        int[][] notas = new int[filas][cols];
        long semilla = System.currentTimeMillis();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                int valor = (int) ((semilla + i * 19 + j * 7) % 11);
                if (valor < 0) valor = -valor;
                notas[i][j] = valor;
            }
        }
        return notas;
    }

    public static void mostrarNotas(int[][] notas, String[] alumnos, String[] asignaturas) {
        System.out.println("NOTAS:");
        System.out.print("Alumno\t\t");
        for (int j = 0; j < asignaturas.length; j++) {
            System.out.print(asignaturas[j] + "\t");
        }
        System.out.println();

        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(alumnos[i] + "\t\t");
            for (int j = 0; j < asignaturas.length; j++) {
                System.out.print(notas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static String obtenerMejorAlumno(int[][] notas, String[] alumnos) {
        int indiceMejor = 0;
        int sumaMejor = -1;

        for (int i = 0; i < alumnos.length; i++) {
            int suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            if (suma > sumaMejor) {
                sumaMejor = suma;
                indiceMejor = i;
            }
        }
        int media = sumaMejor / notas[0].length;
        return alumnos[indiceMejor] + " (media: " + media + ")";
    }

    public static String obtenerAlumnoConMasSuspensos(int[][] notas, String[] alumnos) {
        int maxSuspensos = -1;
        int indicePeor = 0;

        for (int i = 0; i < alumnos.length; i++) {
            int suspensos = 0;
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] < 5) {
                    suspensos++;
                }
            }
            if (suspensos > maxSuspensos) {
                maxSuspensos = suspensos;
                indicePeor = i;
            }
        }
        return alumnos[indicePeor] + " (" + maxSuspensos + " suspensos)";
    }

    public static String obtenerAsignaturaMasDificil(int[][] notas, String[] asignaturas) {
        int minSuma = Integer.MAX_VALUE;
        int indiceDificil = 0;

        for (int j = 0; j < asignaturas.length; j++) {
            int suma = 0;
            for (int i = 0; i < notas.length; i++) {
                suma += notas[i][j];
            }
            if (suma < minSuma) {
                minSuma = suma;
                indiceDificil = j;
            }
        }
        int media = minSuma / notas.length;
        return asignaturas[indiceDificil] + " (media: " + media + ")";
    }
}