package controlador;

import modelo.direccionAcademica.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DireccionAcademicaController {
    private Map<String, Materia> materiasMap;
    private List<Nota> listaNotas;
    private IServicioAdmisiones servicioAdmisiones;

    public DireccionAcademicaController(IServicioAdmisiones servicioAdmisiones) {
        this.materiasMap = new HashMap<>();
        this.listaNotas = new ArrayList<>();
        this.servicioAdmisiones = servicioAdmisiones;
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

    public List<Materia> obtenerMateriasDisponibles() {
        List<Materia> disponibles = new ArrayList<>();
        for (Materia m : materiasMap.values()) {
            if (m.isHabilitada()) disponibles.add(m);
        }
        return disponibles;
    }

    public String registrarNota(String idEstudiante, String codigoMateria, ActividadAcademica actividad, double valorNota) {
        // 1. Validación de existencia y estado de la materia
        Materia materia = materiasMap.get(codigoMateria);
        if (materia == null || !materia.isHabilitada()) {
            return "❌ ERROR: La materia " + codigoMateria + " no existe en el sistema o está deshabilitada. (Recuerde crearla primero).";
        }

        // 2. Validación de rangos permitidos (Regla de negocio de la institución)
        if (valorNota < 0.0 || valorNota > 5.0) {
            return "❌ ERROR: La nota (" + valorNota + ") está fuera del rango permitido (0.0 a 5.0).";
        }

        if (actividad.getPorcentaje() <= 0.0 || actividad.getPorcentaje() > 1.0) {
            return "❌ ERROR: El porcentaje de la actividad (" + (actividad.getPorcentaje() * 100) + "%) no es válido.";
        }

        // 3. Validación de regla de negocio cruzada con el Módulo de Admisiones
        boolean estaMatriculado = servicioAdmisiones.estaEstudianteMatriculado(idEstudiante, codigoMateria);
        if (!estaMatriculado) {
            return "🚫 REGLA DE NEGOCIO VIOLADA: El estudiante [" + idEstudiante + "] NO está matriculado en la materia [" + codigoMateria + "] según Admisiones.";
        }

        // 4. Inserción segura de datos
        Nota nuevaNota = new Nota(idEstudiante, codigoMateria, actividad, valorNota);
        listaNotas.add(nuevaNota);
        return "✅ ÉXITO: Nota de " + actividad.getNombre() + " (" + valorNota + ") registrada correctamente para el estudiante [" + idEstudiante + "].";
    }

    public List<Nota> obtenerNotasEstudiante(String idEstudiante) {
        List<Nota> resultado = new ArrayList<>();
        for (Nota n : listaNotas) {
            if (n.getIdEstudiante().equals(idEstudiante)) {
                resultado.add(n);
            }
        }
        return resultado;
    }
}
