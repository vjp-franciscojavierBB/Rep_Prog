/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03.t11;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author javie
 */
public class Autobus {
    private final String matricula;
    private final HashMap<String, Conductor> conductores;

    public Autobus(String matricula) {
        this.matricula = matricula;
        this.conductores = new HashMap<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public int getNumeroConductores() {
        return conductores.size();
    }

    public void asignarConductor(Conductor conductor) {
        if (conductor == null) {
            return;
        }
        conductores.put(conductor.getDni(), conductor);
    }

    public boolean tieneConductor(String dni) {
        return conductores.containsKey(dni);
    }

    public Map<String, Conductor> getConductores() {
        return Collections.unmodifiableMap(conductores);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autobús {matrícula=").append(matricula).append("}\n");
        sb.append("Conductores (").append(conductores.size()).append("):\n");
        if (conductores.isEmpty()) {
            sb.append("- (sin conductores)\n");
        } else {
            for (Conductor c : conductores.values()) {
                sb.append("- ").append(c.getDni()).append(" -> ").append(c.getNombre()).append("\n");
            }
        }
        return sb.toString();
    }
}

