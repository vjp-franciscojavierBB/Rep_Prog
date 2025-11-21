/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio20.t5;

import java.util.Scanner;

/**
 *
 * @author Jav1e7
 */
public class Ejercicio20T5 {

    /**
     * @param args the command line arguments
     */
    // Método principal que inicia la aplicación
    public static void main(String[] args) {
// Creamos un objeto scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);
// Variable para almacenar la opción elegida por el usuario
        int opcion;
// Variable para almacenar el objeto cuenta 
// Inicializamos a null porque aún no se ha creado ninguna cuenta
        cuenta nuevaCuenta = null;
// Bucle para mostrar el menú y ejecutar las opciones hasta que el usuario elija salir
        do {
// Mostramos el menú en pantalla
            System.out.println("     CAJERO AUTOMATICO    ");
            System.out.println("1 Crear cuenta vacia");
            System.out.println("2 Crear cuenta con saldo inicial");
            System.out.println("3 Ingresar dinero");
            System.out.println("4 Sacar dinero");
            System.out.println("5 Ver saldo");
            System.out.println("6 Salir");
            System.out.print("Elija una opcion: ");
// Leemos la opción elegida por el usuario
            opcion = entrada.nextInt();
// Usamos un switch para ejecutar la acción correspondiente a la opción elegida
            switch (opcion) {
                case 1:
//Crear cuenta vacía.
// Creamos un nuevo objeto Cuenta utilizando el constructor por defecto
                    nuevaCuenta = new cuenta();
                    System.out.println("Cuenta creada con saldo 0");
                    break;
                case 2:
// Opción 2: Crear cuenta con saldo inicial.
                    System.out.print("Introduzca el saldo inicial: ");
                    float saldoInicial = entrada.nextFloat();
// Creamos un nuevo objeto cuenta utilizando el constructor con parámetro
                    nuevaCuenta = new cuenta(saldoInicial);
                    System.out.println("Cuenta creada con saldo inicial " + saldoInicial);
                    break;
                case 3:
//Ingresar dinero
// Primero verificamos si ya se ha creado una cuenta
                    if (nuevaCuenta != null) {
                        System.out.print("Introduzca la cantidad a ingresar: ");
                        float cantidad = entrada.nextFloat();
// Llamamos al método ingresar del objeto miCuenta
                        nuevaCuenta.ingresar(cantidad);
                        System.out.println("Se han ingresado " + cantidad + " Saldo actual: " + nuevaCuenta.getSaldo());
                    } else {
// Si no hay cuenta mostramos un mensaje de error
                        System.out.println("Primero debe crear una cuenta");
                    }
                    break;
                case 4:
//Sacar dinero
// Primero verificamos si ya se ha creado una cuenta
                    if (nuevaCuenta != null) {
                        System.out.print("Introduzca la cantidad a sacar: ");
                        float cantidad = entrada.nextFloat();
// Llamamos al método extraer del objeto nuevaCuenta
                        nuevaCuenta.extraer(cantidad);
                        System.out.println("Se han sacado " + cantidad + " Saldo actual: " + nuevaCuenta.getSaldo());
                    } else {
// Si no hay cuenta, mostramos un mensaje de error
                        System.out.println("Primero debe crear una cuenta");
                    }
                    break;
                case 5:
//Ver saldo
// Primero verificamos si ya se ha creado una cuenta
                    if (nuevaCuenta != null) {
// Llamamos al método getSaldo del objeto nuevaCuenta y mostramos el resultado
                        System.out.println("El saldo actual es: " + nuevaCuenta.getSaldo());
                    } else {
// Si no hay cuenta, mostramos un mensaje de error
                        System.out.println("Primero debe crear una cuenta");
                    }
                    break;
                case 6:
//Salir
                    System.out.println("Gracias por usar nuestro cajero automatico");
                    break;
                default:
// Para cualquier otra opción mostramos un mensaje de error
                    System.out.println("Opción no válida elija otra opcion");
                    break;
            }
// Imprimimos una línea en blanco para separar las iteraciones del menú
            System.out.println();
        } while (opcion != 6); // El bucle continúa mientras la opción elegida no sea 6

    }
}
