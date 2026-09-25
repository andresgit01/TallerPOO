package modelo.direccionAcademica;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String codigo;
    private String nombre;
    private boolean habilitada;
    private List<ActividadAcademica> actividades;

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.habilitada = true;
        this.actividades = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public void agregarActividad(ActividadAcademica actividad) {
        this.actividades.add(actividad);
    }

    public List<ActividadAcademica> getActividades() {
        return actividades;
    }
}
