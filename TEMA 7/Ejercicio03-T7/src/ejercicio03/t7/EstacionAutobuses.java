/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03.t7;

/**
 *
 * @author javie
 */
public class EstacionAutobuses {
    private final Autobus[] darsenas;

    public EstacionAutobuses(int numeroDarsenas) {
        if (numeroDarsenas <= 0) {
            numeroDarsenas = 6;
        }
        this.darsenas = new Autobus[numeroDarsenas];
    }

    public int getNumeroDarsenas() {
        return darsenas.length;
    }

    public boolean estaLibre(int posicion) {
        validarPosicion(posicion);
        return darsenas[posicion] == null;
    }

    public void aparcar(int posicion, Autobus autobus) {
        validarPosicion(posicion);
        if (autobus == null) {
            throw new IllegalArgumentException("El autobús no puede ser null.");
        }
        if (darsenas[posicion] != null) {
            throw new IllegalStateException("La dársena está ocupada.");
        }
        darsenas[posicion] = autobus;
    }

    public Autobus buscarAutobusPorMatricula(String matricula) {
        if (matricula == null) {
            return null;
        }
        String m = matricula.trim();
        for (Autobus a : darsenas) {
            if (a != null && a.getMatricula().equalsIgnoreCase(m)) {
                return a;
            }
        }
        return null;
    }

    public int buscarPosicionPorMatricula(String matricula) {
        if (matricula == null) {
            return -1;
        }
        String m = matricula.trim();
        for (int i = 0; i < darsenas.length; i++) {
            Autobus a = darsenas[i];
            if (a != null && a.getMatricula().equalsIgnoreCase(m)) {
                return i;
            }
        }
        return -1;
    }

    public String buscarMatriculaPorDniConductor(String dni) {
        if (dni == null) {
            return null;
        }
        String d = dni.trim();
        for (Autobus a : darsenas) {
            if (a != null && a.tieneConductor(d)) {
                return a.getMatricula();
            }
        }
        return null;
    }

    public int posicionAutobusConMasConductores() {
        int posicionMax = -1;
        int max = -1;
        for (int i = 0; i < darsenas.length; i++) {
            Autobus a = darsenas[i];
            if (a != null) {
                int n = a.getNumeroConductores();
                if (n > max) {
                    max = n;
                    posicionMax = i;
                }
            }
        }
        return posicionMax;
    }

    public int[] darsenasLibres() {
        int libres = 0;
        for (Autobus a : darsenas) {
            if (a == null) {
                libres++;
            }
        }
        int[] posiciones = new int[libres];
        int idx = 0;
        for (int i = 0; i < darsenas.length; i++) {
            if (darsenas[i] == null) {
                posiciones[idx++] = i;
            }
        }
        return posiciones;
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= darsenas.length) {
            throw new IllegalArgumentException("Posición fuera de rango (0.." + (darsenas.length - 1) + ").");
        }
    }
}

