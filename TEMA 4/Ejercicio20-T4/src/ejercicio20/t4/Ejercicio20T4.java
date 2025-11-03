/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio20.t4;
import java.util.Scanner;

/**
 *
 * @author Jav1e7
 */
public class Ejercicio20T4 {


    // Constantes con las respuestas correctas
    private static final String CAPITAL_ESPANA = "Madrid";
    private static final String DESCUBRIDOR_AMERICA = "Colon";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota = 0;

        System.out.println("EXAMEN DE CULTURA GENERAL");

        // Pregunta 1
        if (preguntaCapital(sc)) {
            nota += 5;
        }

        // Pregunta 2
        if (preguntaDescubridor(sc)) {
            nota += 5;
        }

        // Mostrar nota final
        System.out.println("NOTA DEL EXAMEN: " + nota);
    }

    // Método para la primera pregunta
    public static boolean preguntaCapital(Scanner sc) {
        System.out.print("1 PREGUNTA: Cual es la capital de España?: ");
        String respuesta = sc.nextLine().trim();

        if (respuesta.equalsIgnoreCase(CAPITAL_ESPANA)) {
            System.out.println("Muy bien, respuesta correcta.");
            return true;
        } else {
            System.out.println("No es correcto. La respuesta correcta seria " + CAPITAL_ESPANA);
            return false;
        }
    }

    // Método para la segunda pregunta
    public static boolean preguntaDescubridor(Scanner sc) {
        System.out.print("2 PREGUNTA: Quien descubrio America?: ");
        String respuesta = sc.nextLine().trim();

        if (respuesta.equalsIgnoreCase(DESCUBRIDOR_AMERICA)) {
            System.out.println("Muy bien, respuesta correcta.");
            return true;
        } else {
            System.out.println("No es correcto. La respuesta correcta seria " + DESCUBRIDOR_AMERICA);
            return false;
        }
    }
}

