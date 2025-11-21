/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1.t5;

/**
 *
 * @author Jav1e7
 */
public class Ejercicio1T5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        //Creamos bici1
        Bicicleta bici1 = new Bicicleta();
        bici1.setMarca("Orbea");
        bici1.setColor("Azul");
        bici1.setTipo("Montaña");
        bici1.setAntiguedad(6);
        
        //Creamos bici2
        Bicicleta bici2 = new Bicicleta();
        bici2.setMarca("Canondale");
        bici2.setColor("Roja");
        bici2.setTipo("Carretera");
        bici2.setAntiguedad(15);
        
        //Mostramos bici1 y bici2
        bici1.mostrarBicicleta();
        System.out.println("");
        bici2.mostrarBicicleta();
        
        //Mostrar antigüedad de bici1 y bici2
        System.out.println("");    
        bici1.mostrarAntiguedad();
        bici2.mostrarAntiguedad();
        
        
    }

    
}
