package ejercicio5.t12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio5T12 {

    private static final String FILE_NAME = "agenda.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = readInt(scanner, "Elige una opcion: ");

            switch (option) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    showAgenda();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo otra vez.");
            }
        } while (option != 3);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--- MENU AGENDA ---");
        System.out.println("1. Anadir contacto");
        System.out.println("2. Mostrar agenda");
        System.out.println("3. Salir");
    }

    private static void addContact(Scanner scanner) {
        String name = readNonEmpty(scanner, "Nombre: ");
        int age = readInt(scanner, "Edad: ");
        String phone = readNonEmpty(scanner, "Telefono: ");

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(name + " - " + age + " - " + phone);
            System.out.println("Contacto guardado correctamente en " + FILE_NAME + ".");
        } catch (IOException e) {
            System.out.println("Error al guardar el contacto: " + e.getMessage());
        }
    }

    private static void showAgenda() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No existe " + FILE_NAME + " todavia. Anade un contacto primero.");
            return;
        }

        System.out.println("\n--- CONTENIDO DE " + FILE_NAME + " ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean hasLines = false;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasLines = true;
            }

            if (!hasLines) {
                System.out.println("(El fichero esta vacio)");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida. Debes introducir un numero.");
            }
        }
    }

    private static String readNonEmpty(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("El valor no puede estar vacio.");
        }
    }
}
