package practicatema12;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PracticaTema12 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Productos> productos = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            // Menu
            System.out.println("\n--- MENU PRODUCTOS ---");
            System.out.println("1. Introducir producto");
            System.out.println("2. Guardar productos en fichero");
            System.out.println("3. Leer fichero y calcular total");
            System.out.println("4. Mostrar productos");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();  
            sc.nextLine();           // limpiar salto

            switch (opcion) {
                case 1:
                    introducirProducto(); 
                    break;
                case 2:
                    guardarEnFichero();   
                    break;
                case 3:
                    leerFicheroYCalcularTotal(); 
                    break;
                case 4:
                    mostrarProductos();   
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    public static void introducirProducto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine(); 

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();   
        sc.nextLine();                

        System.out.print("Precio: ");
        double precio = sc.nextDouble(); 
        sc.nextLine();                   

        productos.add(new Productos(nombre, cantidad, precio));

        System.out.println("Producto añadido correctamente.");
    }

    public static void guardarEnFichero() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("productos.txt"))) {

            for (Productos p : productos) {
                pw.println(p.getNombre() + "," + p.getCantidad() + "," + p.getPrecio());
            }

            System.out.println("Productos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el fichero.");
        }
    }

    public static void leerFicheroYCalcularTotal() {
        double total = 0; 

        try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); 

                String nombre = partes[0];
                int cantidad = Integer.parseInt(partes[1]);
                double precio = Double.parseDouble(partes[2]);

                double subtotal = cantidad * precio; 
                total += subtotal;

                System.out.println(nombre + " - " + cantidad + " x " + precio + " = " + subtotal);
            }

            System.out.println("TOTAL: " + total);

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }

    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            for (Productos p : productos) {
                System.out.println(p.getNombre() + " - Cantidad: " + p.getCantidad() + " - Precio: " + p.getPrecio());
            }
        }
    }
}
