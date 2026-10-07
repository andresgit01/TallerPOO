package controlador;

import modelo.direccionAcademica.*;

import java.util.HashMap;
import java.util.Map;

public class DireccionAcademicaController {
    private Map<String, Materia> materiasMap;
    private ListaNotas notasRegistradas;
    private final IServicioAdmisiones servicioAdmisiones;

    public DireccionAcademicaController(IServicioAdmisiones servicioAdmisiones) {
        this.servicioAdmisiones = servicioAdmisiones;
        this.materiasMap = new HashMap<>();
        this.notasRegistradas = new ListaNotas();
    }

    public boolean crearMateria(String codigo, String nombre) {
        if (materiasMap.containsKey(codigo)) return false;
        // Asumimos que la materia nace habilitada por defecto
        materiasMap.put(codigo, new Materia(codigo, nombre));
        return true;
    }

    public boolean modificarMateria(String codigo, String nuevoNombre) {
        Materia m = materiasMap.get(codigo);
        if (m != null) {
            m.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }

    public boolean cambiarEstadoMateria(String codigo, boolean habilitada) {
        Materia m = materiasMap.get(codigo);
        if (m != null) {
            m.setHabilitada(habilitada);
            return true;
        }
        return false;
    }

    public ListaMaterias obtenerMateriasDisponibles() {
        ListaMaterias disponibles = new ListaMaterias();
        for (Materia m : materiasMap.values()) {
            if (m.isHabilitada()) disponibles.agregar(m);
        }
        return disponibles;
    }

    public String registrarNota(String idEstudiante, String codigoMateria, ActividadAcademica actividad, double valorNota) {
        // 1. Validación de existencia y estado de la materia
        Materia materia = materiasMap.get(codigoMateria);
        if (materia == null) {
            return " ERROR: La materia " + codigoMateria + " no existe. Registre la materia primero.";
        }
        if (!materia.isHabilitada()) {
            return " ERROR: La materia " + codigoMateria + " está deshabilitada. Habilítela para registrar notas.";
        }

        // 2. Validación de rangos permitidos (Regla de negocio de la institución)
        if (valorNota < 0.0 || valorNota > 5.0) {
            return " ERROR: La nota (" + valorNota + ") está fuera del rango permitido (0.0 a 5.0).";
        }

        if (actividad.getPorcentaje() <= 0.0 || actividad.getPorcentaje() > 1.0) {
            return " ERROR: El porcentaje de la actividad (" + (actividad.getPorcentaje() * 100) + "%) no es válido.";
        }

        // 3. Validación de regla de negocio cruzada con el Módulo de Admisiones
        if (!servicioAdmisiones.estaEstudianteMatriculado(idEstudiante, codigoMateria)) {
            return " REGLA DE NEGOCIO VIOLADA: El estudiante [" + idEstudiante + "] NO está matriculado en la materia [" + codigoMateria + "] según Admisiones.";
        }

        // 4. Inserción segura de datos
        Nota nuevaNota = new Nota(idEstudiante, codigoMateria, actividad, valorNota);
        notasRegistradas.agregar(nuevaNota);
        return " ÉXITO: Nota de " + actividad.getNombre() + " (" + valorNota + ") registrada correctamente para el estudiante [" + idEstudiante + "].";
    }

    public ListaNotas obtenerNotasEstudiante(String idEstudiante) {
        return notasRegistradas.deEstudiante(idEstudiante);
    }
}
