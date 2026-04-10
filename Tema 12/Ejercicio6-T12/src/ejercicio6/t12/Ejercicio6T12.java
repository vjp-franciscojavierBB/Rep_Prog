package ejercicio6.t12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio6T12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = null;
        int option;

        do {
            showMenu();
            option = readInt(scanner, "Elige una opcion: ");

            switch (option) {
                case 1:
                    fileName = askFileName(scanner);
                    dumpEvenNumbersToFile(fileName);
                    break;
                case 2:
                    showFileContent(fileName);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        } while (option != 3);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--- MENU EJERCICIO 6 ---");
        System.out.println("1. Volcar los 100 primeros pares a un fichero");
        System.out.println("2. Mostrar por pantalla el contenido del fichero");
        System.out.println("3. Salir");
    }

    private static String askFileName(Scanner scanner) {
        while (true) {
            System.out.print("Introduce el nombre del fichero de texto: ");
            String fileName = scanner.nextLine().trim();

            if (fileName.isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
                continue;
            }

            if (!fileName.toLowerCase().endsWith(".txt")) {
                fileName += ".txt";
            }

            return fileName;
        }
    }

    private static void dumpEvenNumbersToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 100; i++) {
                writer.println(i * 2);
            }
            System.out.println("Volcado realizado correctamente en " + fileName + ".");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    private static void showFileContent(String fileName) {
        if (fileName == null) {
            System.out.println("Primero debes crear el fichero con la opcion 1.");
            return;
        }

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No existe el fichero " + fileName + ".");
            return;
        }

        System.out.println("\n--- CONTENIDO DE " + fileName + " ---");
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

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido.");
            }
        }
    }
}
