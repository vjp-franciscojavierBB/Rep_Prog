/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1.t5;

/**
 *
 * @author Jav1e7
 */


public class coche {
        
    private String marca;
    private String modelo;
    private String color;
    private int velocidad;
    private boolean motorEncendido = false;
    }

public String getMarca(){
        return marca;
    }
    
public void setMarca(String m){
        marca = m;
    }
    
public String getModelo(){
        return modelo;
    }
    
public void setColor(String c){
        color = c;
    }
    
public int Velocidad(){
        return velocidad;
    }
    
public boolean setmotorEncendido(String t){
        tipo = t;
    }
    
public int getAntiguedad(){
        return antiguedad;
    }
    
    public void setAntiguedad(int a){
        antiguedad = a;
    }
    
    //Otros métodos
    public void mostrarAntiguedad(){
        if(antiguedad > 10){
            System.out.println("La bici es antigüa");
        } else {
            System.out.println("La bici es nueva");
        }
    
}
