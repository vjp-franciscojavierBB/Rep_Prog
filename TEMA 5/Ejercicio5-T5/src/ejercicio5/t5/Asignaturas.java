/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5.t5;

/**
 *
 * @author Jav1e7
 */
public class Asignaturas {
    //Atributos privados de la clase
    private String nombre;
    private double nota;
   
    //Constructor que inicializa la asignatura con un nombre
    public Asignaturas(String n){
        nombre = n;
    }
   
    //Método para establecer la nota
    public void establecerNota(double no){
        nota = no;
    }
   
    //Método para obtener{Nota-Nombre}
    public double obtenerNota(){
        return nota;
    }
   
    public String obtenerNombre(){
        return nombre;
    }
   
    //Método para calcular la media
    public static double calcularMedia(double num1, double num2, double num3, double num4, double num5, double num6){
        return (num1 + num2 + num3 + num4 + num5 + num6) / 6;
    }
}
    