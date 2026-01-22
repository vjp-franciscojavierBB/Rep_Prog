/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio11tema7;

/**
 *
 * @author alumno
 */
public class Ejercicio11Tema7 {

    /**
     * @param args the command line arguments
     */
    
    //// Método que rellena el vector con números aleatorios entre 0 y 9 sin repetir
    public static void rellenarVector(int [] vector){
        boolean[] usado = new boolean[10];
        
        int contador = 0;
        //Seguimos hasta llenar las 10 posiciones del vector
        while(contador < vector.length){
            int numero = (int)(Math.random() * 10);//Genera un número aleatorio entre 0 y 9
            
            if(!usado[numero]){//Si el número NO ha salido antes, lo aceptamos
                vector[contador] = numero;//Lo guardamos en el vector
                usado[numero] = true;//Marcamos que ya está usado
                contador++;//Pasamos a la siguiente posición
            }
        }
    }
    
    //Método que muestra el vector con un mensaje previo
    public static void mostrarVector(int [] vector, String mensaje){
        System.out.print(mensaje);
        //Recorremos el vector imprimiendo cada número separado por un espacio
        for(int i = 0; i < vector.length; i++){
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] vector = new int[10];//Creamos un vector de 10 posiciones
        
        rellenarVector(vector);//Lo rellenamos con números aleatorios sin repetir
        mostrarVector(vector, "Se ha generado el siguiente array: ");
    }  
}