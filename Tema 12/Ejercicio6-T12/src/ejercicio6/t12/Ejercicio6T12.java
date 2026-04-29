/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6.t12;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Ejercicio6T12 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- NUMEROS PARES ---");
            System.out.println("1. Crear fichero con 100 pares");
            System.out.println("2. Mostrar fichero");
            System.out.println("3. Salir");
            System.out.print("Elige opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearFichero();
                    break;
                case 2:
                    mostrarFichero();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 3);
    }

    public static void crearFichero() {
        System.out.print("Nombre del fichero: ");
        String nombre = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(new FileWriter(nombre))) {

            for (int i = 1; i <= 100; i++) {
                pw.println(i * 2);
            }

            System.out.println("Fichero creado.");

        } catch (IOException e) {
            System.out.println("Error al crear el fichero.");
        }
    }

    public static void mostrarFichero() {
        System.out.print("Nombre del fichero: ");
        String nombre = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer el fichero.");
        }
    }
}
