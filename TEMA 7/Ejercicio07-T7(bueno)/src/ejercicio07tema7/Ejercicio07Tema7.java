/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio07tema7;

import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class Ejercicio07Tema7 {

    /**
     * @param args the command line arguments
     */
    
    //Método que rellena el vector con números aleatorios entre 0 y 50
    public static void rellenarVector(int [] vector){
        for(int i = 0; i < vector.length; i++){
            vector[i] = (int)(Math.random() * 51);
        }
    }
    
    //Método que muestra el contenido completo del vector
    public static void mostrarVector(int [] vector){
        System.out.println("Contenido del array con " + vector.length + " numeros aleatorios:");
        //Recorremos el vector mostrando posición y valor
        for(int i = 0; i < vector.length; i++){
            System.out.println("Posicion " + i + " = " + vector[i]);
        }
    }
    
    //Método que muestra los 10 números mayores del vector
    public static void mostrarDiezMayores(int [] vector){       
        System.out.println("\nLos 10 numeros mayores son:");
        //Repetimos 10 veces hasta encontrar los mayores
        for(int rep = 0; rep < 10; rep++){
            int max = -1;//Se pone porque que el más pequeño que cualquier número del vector
            int indice = 0;//Se guarda la posición del mayor
            //Buscamos el mayor del vector
            for(int i = 0; i < vector.length; i++){
                if(vector[i] > max){
                    max = vector[i];
                    indice = i;
                }
            }
            //Mostramos el mayor encontrado
            System.out.print(max + " ");
            //Marcamos ese valor como usado para no volver a cogerlo
            vector[indice] = -1;
        }
    }
    
    public static void main(String[] args) {
        int[] vector = new int[15];//Creamos un vector de 15 posiciones
        
        rellenarVector(vector);//Lo rellenamos con números aleatorios
        mostrarVector(vector);//Mostramos todo el vector
        mostrarDiezMayores(vector);//Mostramos los 10 valores más altos
    }
}