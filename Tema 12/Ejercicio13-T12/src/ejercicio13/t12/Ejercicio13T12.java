/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio13.t12;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Ejercicio13T12 {


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("DatosBeca.txt", true))) {

            System.out.print("Nombre y apellido: ");
            String nombre = sc.nextLine();

            System.out.print("Sexo (H-M): ");
            String sexo = sc.nextLine();

            System.out.print("Edad (20-60): ");
            int edad = sc.nextInt();
            sc.nextLine();

            System.out.print("Suspensos (0-4): ");
            int suspensos = sc.nextInt();
            sc.nextLine();

            System.out.print("Residencia familiar (SI-NO): ");
            String residencia = sc.nextLine();

            System.out.print("Ingresos anuales: ");
            double ingresos = sc.nextDouble();
            sc.nextLine();

            pw.println(nombre + "," + sexo + "," + edad + "," + suspensos + "," + residencia + "," + ingresos);

            System.out.println("Datos guardados.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero.");
        }
    }
}

