/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3.t11; 
import java.util.HashMap ;
import java.util.Scanner ;

/**
 *
 * @author javie
 */
public class Ejercicio3T11 {

   

    static class Conductor {

        private String dni;
        private String nombre;

        public Conductor(String dni, String nombre) {
            this.dni = dni;
            this.nombre = nombre;
        }

        public String getDni() {
            return dni;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return "Conductor{DNI='" + dni + "', Nombre='" + nombre + "'}";
        }
    }

    static class Autobus {

        private String matricula;
        private HashMap<String, Conductor> conductores; // clave = DNI

        public Autobus(String matricula) {
            this.matricula = matricula;
            this.conductores = new HashMap<>();
        }

        public String getMatricula() {
            return matricula;
        }

        public HashMap<String, Conductor> getConductores() {
            return conductores;
        }

        public void agregarConductor(Conductor c) {
            conductores.put(c.getDni(), c);
        }

        public int numeroConductores() {
            return conductores.size();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Autobus: ").append(matricula).append("\n");
            sb.append("Conductores asignados (").append(conductores.size()).append("):\n");
            if (conductores.isEmpty()) {
                sb.append("  (ninguno)\n");
            } else {
                for (Conductor c : conductores.values()) {
                    sb.append("  - ").append(c).append("\n");
                }
            }
            return sb.toString();
        }
    }

    static final int CAPACIDAD = 6;
    static Autobus[] darsenas = new Autobus[CAPACIDAD];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== ESTACION DE PLASENCIA =====");
            System.out.println("1. Aparcar autobus");
            System.out.println("2. Mostrar darsenas libres");
            System.out.println("3. Buscar autobus por matricula");
            System.out.println("4. Buscar conductor");
            System.out.println("5. Autobus con mas conductores");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> aparcarAutobus();
                case 2 -> mostrarDarsenasLibres();
                case 3 -> buscarAutobus();
                case 4 -> buscarConductor();
                case 5 -> autobusMasConductores();
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

        // OPCION 1: Aparcar autobus
    static void aparcarAutobus() {
            System.out.print("Introduce la matricula del autobus: ");
            String matricula = sc.nextLine().trim().toUpperCase();

            int pos;
            do {
                System.out.print("Introduce la posicion (0-" + (CAPACIDAD - 1) + "): ");
                pos = sc.nextInt();
                sc.nextLine();
                if (pos < 0 || pos >= CAPACIDAD) {
                    System.out.println("Posicion fuera de rango. Intentalo de nuevo.");
                } else if (darsenas[pos] != null) {
                    System.out.println("La darsena " + pos + " esta ocupada. Elige otra.");
                }
            } while (pos < 0 || pos >= CAPACIDAD || darsenas[pos] != null);

            Autobus bus = new Autobus(matricula);

            // Anadir conductores
            System.out.print("Cuantos conductores quieres asignar? ");
            int numConductores = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < numConductores; i++) {
                System.out.print("DNI del conductor " + (i + 1) + ": ");
                String dni = sc.nextLine().trim();
                System.out.print("Nombre del conductor " + (i + 1) + ": ");
                String nombre = sc.nextLine().trim();
                bus.agregarConductor(new Conductor(dni, nombre));
            }

            darsenas[pos] = bus;
            System.out.println("Autobus aparcado correctamente en la darsena " + pos + ".");
        }

        // OPCION 2: Mostrar darsenas libres
    static void mostrarDarsenasLibres() {
            System.out.println("\nDarsenas libres:");
            boolean hayLibres = false;
            for (int i = 0; i < CAPACIDAD; i++) {
                if (darsenas[i] == null) {
                    System.out.println("  - Darsena " + i);
                    hayLibres = true;
                }
            }
            if (!hayLibres) {
                System.out.println("  No hay darsenas libres.");
            }
        }

        // OPCION 3: Buscar autobus por matricula
    static void buscarAutobus() {
            System.out.print("Introduce la matricula a buscar: ");
            String matricula = sc.nextLine().trim().toUpperCase();

            boolean encontrado = false;
            for (int i = 0; i < CAPACIDAD; i++) {
                if (darsenas[i] != null && darsenas[i].getMatricula().equals(matricula)) {
                    System.out.println("\nAutobus encontrado en darsena " + i + ":");
                    System.out.println(darsenas[i]);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontro ningun autobus con esa matricula.");
            }
        }

        // OPCION 4: Buscar conductor (muestra la matricula del autobus asignado)
    static void buscarConductor() {
            System.out.print("Introduce el DNI del conductor: ");
            String dni = sc.nextLine().trim();

            boolean encontrado = false;
            for (int i = 0; i < CAPACIDAD; i++) {
                if (darsenas[i] != null && darsenas[i].getConductores().containsKey(dni)) {
                    Conductor c = darsenas[i].getConductores().get(dni);
                    System.out.println("\nConductor encontrado: " + c.getNombre());
                    System.out.println("Tiene asignado el autobus con matricula: " + darsenas[i].getMatricula()
                            + " (darsena " + i + ")");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontro ningun conductor con ese DNI.");
            }
        }

        // OPCION 5: Retorna la posicion del autobus con mas conductores
    static void autobusMasConductores() {
            int posMayor = -1;
            int maxConductores = -1;

            for (int i = 0; i < CAPACIDAD; i++) {
                if (darsenas[i] != null && darsenas[i].numeroConductores() > maxConductores) {
                    maxConductores = darsenas[i].numeroConductores();
                    posMayor = i;
                }
            }

            if (posMayor == -1) {
                System.out.println("No hay autobuses aparcados.");
            } else {
                System.out.println("\nEl autobus con mas conductores esta en la darsena: " + posMayor);
                System.out.println("Matricula: " + darsenas[posMayor].getMatricula());
                System.out.println("Numero de conductores: " + maxConductores);
            }
    }
}