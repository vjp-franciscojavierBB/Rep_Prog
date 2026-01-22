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
        double[][] notas = null;
        String[] alumnos = {"Pepe", "Juan", "Ana", "Marta", "Pedro", "Maria"};
        String[] asignaturas = {"Lengua", "Mates", "Historia", "Fisica"};
        Scanner lectorMenu = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Rellenar las notas de los alumnos");
            System.out.println("2. Mostrar las notas introducidas");
            System.out.println("3. Alumno mejor de la clase");
            System.out.println("4. Alumno con mas suspensos");
            System.out.println("5. Asignatura mas dificil");
            System.out.println("6. Salir del programa");
            System.out.print("Elige una opcion: ");
            opcion = lectorMenu.nextInt();

            switch (opcion) {
                case 1:
                    notas = rellenarNotas(alumnos, asignaturas);
                    System.out.println("Notas generadas correctamente.");
                    break;
                case 2:
                    if (notas != null) {
                        mostrarNotas(notas, alumnos, asignaturas);
                    } else {
                        System.out.println("Primero debes rellenar las notas (opcion 1).");
                    }
                    break;
                case 3:
                    if (notas != null) {
                        String mejor = obtenerMejorAlumno(notas, alumnos);
                        System.out.println("Alumno mejor de la clase: " + mejor);
                    } else {
                        System.out.println("Primero debes rellenar las notas (opcion 1).");
                    }
                    break;
                case 4:
                    if (notas != null) {
                        String peor = obtenerAlumnoConMasSuspensos(notas, alumnos);
                        System.out.println("Alumno con mas suspensos: " + peor);
                    } else {
                        System.out.println("Primero debes rellenar las notas (opcion 1).");
                    }
                    break;
                case 5:
                    if (notas != null) {
                        String dificil = obtenerAsignaturaMasDificil(notas, asignaturas);
                        System.out.println("Asignatura mas dificil: " + dificil);
                    } else {
                        System.out.println("Primero debes rellenar las notas (opcion 1).");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);

        lectorMenu.close();
    }

    public static double[][] rellenarNotas(String[] alumnos, String[] asignaturas) {
        double[][] notas = new double[alumnos.length][asignaturas.length];
        long semilla = System.currentTimeMillis();
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < asignaturas.length; j++) {
                // Notas entre 0 y 10 (con un decimal)
                notas[i][j] = ((semilla + i * 13 + j * 7) % 101) / 10.0;
            }
        }
        return notas;
    }

    public static void mostrarNotas(double[][] notas, String[] alumnos, String[] asignaturas) {
        System.out.print("Alumno\t\t");
        for (String asig : asignaturas) {
            System.out.print(asig + "\t");
        }
        System.out.println();

        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(alumnos[i] + "\t\t");
            for (int j = 0; j < asignaturas.length; j++) {
                System.out.printf("%.1f\t", notas[i][j]);
            }
            System.out.println();
        }
    }

    public static String obtenerMejorAlumno(double[][] notas, String[] alumnos) {
        double mejorMedia = -1;
        String mejorAlumno = "";
        for (int i = 0; i < alumnos.length; i++) {
            double suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            double media = suma / notas[i].length;
            if (media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = alumnos[i];
            }
        }
        return mejorAlumno + " (media: " + String.format("%.2f", mejorMedia) + ")";
    }

    public static String obtenerAlumnoConMasSuspensos(double[][] notas, String[] alumnos) {
        int maxSuspensos = -1;
        String alumno = "";
        for (int i = 0; i < alumnos.length; i++) {
            int suspensos = 0;
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] < 5.0) {
                    suspensos++;
                }
            }
            if (suspensos > maxSuspensos) {
                maxSuspensos = suspensos;
                alumno = alumnos[i];
            }
        }
        return alumno + " (" + maxSuspensos + " suspensos)";
    }

    public static String obtenerAsignaturaMasDificil(double[][] notas, String[] asignaturas) {
        double menorMedia = Double.MAX_VALUE;
        String asignaturaDificil = "";
        for (int j = 0; j < asignaturas.length; j++) {
            double suma = 0;
            for (int i = 0; i < notas.length; i++) {
                suma += notas[i][j];
            }
            double media = suma / notas.length;
            if (media < menorMedia) {
                menorMedia = media;
                asignaturaDificil = asignaturas[j];
            }
        }
        return asignaturaDificil + " (media: " + String.format("%.2f", menorMedia) + ")";
    }
}