/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6t12;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author javie
 */
public class Ejercicio6T12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreFichero = "";
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Elige una opcion: ");

            switch (opcion) {
                case 1:
                    nombreFichero = pedirNombreFichero(scanner);
                    volcarParesEnFichero(nombreFichero);
                    break;
                case 2:
                    mostrarContenidoFichero(nombreFichero);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU EJERCICIO 6 ---");
        System.out.println("1. Volcar los 100 primeros pares a un fichero");
        System.out.println("2. Mostrar por pantalla el contenido del fichero");
        System.out.println("3. Salir");
    }

    private static String pedirNombreFichero(Scanner scanner) {
        while (true) {
            System.out.print("Introduce el nombre del fichero de texto: ");
            String nombre = scanner.nextLine();

            if (nombre.length() == 0) {
                System.out.println("El nombre no puede estar vacio.");
            } else {
                if (!nombre.toLowerCase().endsWith(".txt")) {
                    nombre = nombre + ".txt";
                }
                return nombre;
            }
        }
    }

    private static int[] crearArrayPares() {
        int[] pares = new int[100];

        for (int i = 0; i < pares.length; i++) {
            pares[i] = (i + 1) * 2;
        }

        return pares;
    }

    private static void volcarParesEnFichero(String ficheroDestino) {
        int[] arrayPares = crearArrayPares();

        try (PrintWriter writer = new PrintWriter(new FileWriter(ficheroDestino))) {
            for (int i = 0; i < arrayPares.length; i++) {
                writer.println(arrayPares[i]);
            }
            System.out.println("Volcado realizado correctamente en " + ficheroDestino + ".");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    private static void mostrarContenidoFichero(String ficheroAVisualizar) {
        if (ficheroAVisualizar.length() == 0) {
            System.out.println("Primero debes crear el fichero con la opcion 1.");
            return;
        }

        File file = new File(ficheroAVisualizar);
        if (!file.exists()) {
            System.out.println("No existe el fichero " + ficheroAVisualizar + ".");
            return;
        }

        System.out.println("\n--- CONTENIDO DE " + ficheroAVisualizar + " ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean hasContent = false;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasContent = true;
            }

            if (!hasContent) {
                System.out.println("(El fichero esta vacio)");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido.");
            }
        }
    }
}

