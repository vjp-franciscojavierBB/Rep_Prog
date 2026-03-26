/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio03.t7;

import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Ejercicio03T7 {

    private static final Scanner sc = new Scanner(System.in);
    private static final EstacionAutobuses estacion = new EstacionAutobuses(6);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> opcionAparcar();
                case 2 -> opcionMostrarDarsenasLibres();
                case 3 -> opcionBuscarAutobus();
                case 4 -> opcionBuscarConductor();
                case 5 -> opcionAutobusConMasConductores();
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== ESTACION DE PLASENCIA =====");
        System.out.println("1. Aparcar autobus");
        System.out.println("2. Mostrar darsenas libres");
        System.out.println("3. Buscar autobus por matricula");
        System.out.println("4. Buscar conductor (por DNI)");
        System.out.println("5. Autobus con mas conductores (posicion)");
        System.out.println("0. Salir");
    }

    private static void opcionAparcar() {
        System.out.print("Introduce la matricula del autobus: ");
        String matricula = sc.nextLine().trim().toUpperCase();

        int pos;
        while (true) {
            pos = leerEntero("Introduce la posicion (0-" + (estacion.getNumeroDarsenas() - 1) + "): ");
            try {
                if (!estacion.estaLibre(pos)) {
                    System.out.println("La darsena " + pos + " esta ocupada. Elige otra.");
                    continue;
                }
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Autobus bus = new Autobus(matricula);
        int numConductores = leerEntero("Cuantos conductores quieres asignar? ");
        for (int i = 0; i < numConductores; i++) {
            System.out.print("DNI del conductor " + (i + 1) + ": ");
            String dni = sc.nextLine().trim();
            System.out.print("Nombre del conductor " + (i + 1) + ": ");
            String nombre = sc.nextLine().trim();
            bus.asignarConductor(new Conductor(dni, nombre));
        }

        try {
            estacion.aparcar(pos, bus);
            System.out.println("Autobus aparcado correctamente en la darsena " + pos + ".");
        } catch (RuntimeException ex) {
            System.out.println("No se pudo aparcar: " + ex.getMessage());
        }
    }

    private static void opcionMostrarDarsenasLibres() {
        int[] libres = estacion.darsenasLibres();
        System.out.println("\nDarsenas libres:");
        if (libres.length == 0) {
            System.out.println("  No hay darsenas libres.");
            return;
        }
        for (int p : libres) {
            System.out.println("  - Darsena " + p);
        }
    }

    private static void opcionBuscarAutobus() {
        System.out.print("Introduce la matricula a buscar: ");
        String matricula = sc.nextLine().trim().toUpperCase();

        Autobus bus = estacion.buscarAutobusPorMatricula(matricula);
        if (bus == null) {
            System.out.println("No se encontro ningun autobus con esa matricula.");
            return;
        }
        int pos = estacion.buscarPosicionPorMatricula(matricula);
        System.out.println("\nAutobus encontrado en darsena " + pos + ":");
        System.out.println(bus);
    }

    private static void opcionBuscarConductor() {
        System.out.print("Introduce el DNI del conductor: ");
        String dni = sc.nextLine().trim();

        String matricula = estacion.buscarMatriculaPorDniConductor(dni);
        if (matricula == null) {
            System.out.println("No se encontro ningun conductor con ese DNI.");
            return;
        }
        int pos = estacion.buscarPosicionPorMatricula(matricula);
        System.out.println("Tiene asignado el autobus con matricula: " + matricula + " (darsena " + pos + ")");
    }

    private static void opcionAutobusConMasConductores() {
        int pos = estacion.posicionAutobusConMasConductores();
        if (pos == -1) {
            System.out.println("No hay autobuses aparcados.");
            return;
        }
        System.out.println("El autobus con mas conductores esta en la darsena: " + pos);
    }

    private static int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.println("Introduce un numero valido.");
            }
        }
    }
}

