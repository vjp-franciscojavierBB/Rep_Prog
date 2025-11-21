/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5.t5;
import java.util.Scanner;
/**
 *
 * @author Jav1e7
 */
public class Ejercicio5T5 {
  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
      
        //Los objetos de la clase Asignatura con el nombre de la materia
        Asignaturas prog = new Asignaturas("Programacion");
        Asignaturas lmsgi = new Asignaturas("Lenguajes de Marcas");
        Asignaturas bd = new Asignaturas("Bases de Datos");
        Asignaturas ed = new Asignaturas("Entornos de Desarrollo");
        Asignaturas si = new Asignaturas("Sistemas Informaticos");
        Asignaturas fol = new Asignaturas("Formacion y Orientacion Laboral");
       
        //Pedir al usuario que introduzca la nota y en nombre se pone solo por un método
        System.out.print("Por favor, introduzc  a la nota de " + prog.obtenerNombre() + ": ");
        prog.establecerNota(entrada.nextDouble());
        System.out.print("Introduzca la nota de " + lmsgi.obtenerNombre() + ": ");
        lmsgi.establecerNota(entrada.nextDouble());
        System.out.print("Introduzca la nota de " + bd.obtenerNombre() + ": ");
        bd.establecerNota(entrada.nextDouble());
        System.out.print("Introduzca la nota de " + ed.obtenerNombre() + ": ");
        ed.establecerNota(entrada.nextDouble());
        System.out.print("Introduzca la nota de " + si.obtenerNombre() + ": ");
        si.establecerNota(entrada.nextDouble());
        System.out.print("Por ultimo, introduzca la nota de " + fol.obtenerNombre() + ": ");
        fol.establecerNota(entrada.nextDouble());
       
        //Calcular la media de todas las asignatura utilizando un método
        double media = Asignaturas.calcularMedia(prog.obtenerNota(), lmsgi.obtenerNota(), bd.obtenerNota(), ed.obtenerNota(), si.obtenerNota(), fol.obtenerNota());
       
        System.out.println("Su nota media del curso es: " + media);//Resultado
    }
}
