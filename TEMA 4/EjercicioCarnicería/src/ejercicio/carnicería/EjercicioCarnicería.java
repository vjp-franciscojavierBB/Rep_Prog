package ejercicio.carnicería;
import java.util.Scanner;

public class EjercicioCarnicería {

    
    public static final char MOSTRADOR_INICIAL = 'A';             //declaramos las constantes
    public static final char MOSTRADOR_FINAL = 'C';

  
    public static int numeroCompra = 1;
    public static int numeroPedido = 1;                           //declaramos las variables1
    public static char mostradorActual = MOSTRADOR_INICIAL;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = pedirOpcion(entrada);

            switch (opcion) {
                case 1:
                    generarNumeroEspera("C", numeroCompra);
                    numeroCompra++;
                    System.out.println("Mostrador asignado: " + obtenerMostrador());
                break;
                case 2:                                                                   //usando cases y dependiendo de la eleccion del comprador asignamos un mostrador a cada persona
                    generarNumeroEspera("P", numeroPedido);
                    numeroPedido++;
                    System.out.println("Mostrador asignado: " + obtenerMostrador());
                break;
                }

        } while (opcion != 3);
    }
public static void mostrarMenu() {
    System.out.println(" Carniceria Valle del Jerte");
    System.out.println("1. Comprar");
    System.out.println("2. Recoger pedido");                        //planteamos las opciones del menú
    System.out.println("3. Salir");
    System.out.print("Elige una opcion: ");
    }
public static int pedirOpcion(Scanner scanner) {
    while (!scanner.hasNextInt()) {
        System.out.println("Entrada invalida. Por favor, introduce un numero.");        // descartamos la entrada incorrecta
        scanner.next(); 
        System.out.print("Elige una opcion: ");
    }
    return scanner.nextInt();
}
public static char obtenerMostrador() {
        char letraAsignada = mostradorActual;
        int siguiente = (int) mostradorActual + 1;

        if (siguiente > (int) MOSTRADOR_FINAL) {                  //asignamos un mostrador dependiendo de la opcción elegida anteriormente y después enseñamos el numero de espera y el mostrador en cuestión
            mostradorActual = MOSTRADOR_INICIAL;
        } else {
            mostradorActual = (char) siguiente;
        }
        return letraAsignada;
    }
    public static void generarNumeroEspera(String tipo, int numero) {
        System.out.println("Numero de espera " + (tipo.equals("C") ? "para comprar" : "para recoger pedido") + ": " + tipo + "-" + numero);
    }
}
