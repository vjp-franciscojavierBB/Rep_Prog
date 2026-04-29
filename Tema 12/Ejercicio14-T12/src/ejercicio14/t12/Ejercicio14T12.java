/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio14.t12;
import java.io.*;
/**
 *
 * @author javie
 */
public class Ejercicio14T12 {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("DatosBeca.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] p = linea.split(",");

                String nombre = p[0];
                int edad = Integer.parseInt(p[2]);
                int suspensos = Integer.parseInt(p[3]);
                String residencia = p[4];
                double ingresos = Double.parseDouble(p[5]);

                double beca = 1500; // base

                if (ingresos <= 12000) beca += 500;
                if (edad < 23) beca += 200;

                if (suspensos == 0) beca += 500;
                else if (suspensos == 1) beca += 200;
                else continue; // 2 o más → sin beca

                if (residencia.equalsIgnoreCase("NO")) beca += 1000;

                System.out.println(nombre + " → Beca total: " + beca + "€");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }
}

