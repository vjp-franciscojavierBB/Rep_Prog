/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.t6;

/**
 *
 * @author Jav1e7
 */
public abstract class Animal {

    private String nombre;
    private int edad;
    private int peso;

    public Animal() {
        this.nombre = "";
        this.edad = 0;
        this.peso = 0;
    }

    public Animal(String nombre, int edad, int peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public abstract void mostrarSonido();

    public abstract void mostrarAlimentacion();

    public abstract void mostrarHabitat();

    public abstract void mostrarNombreCientifico();

    @Override
    public String toString() {
        return "Animal{nombre='" + nombre + "', edad=" + edad + ", peso=" + peso + "}";
    }
}
