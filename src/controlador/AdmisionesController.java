package controlador;
import modelo.Admisiones.AsignacionProfesor;
import modelo.Admisiones.Estudiante;
import modelo.Admisiones.Matricula;
import modelo.Admisiones.Profesor;

import java.util.List;
import java.util.ArrayList;

public class AdmisionesController {
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();
    private  List<AsignacionProfesor> asignaciones = new ArrayList<>();

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public  Estudiante buscarEstudiante(int id){
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public boolean actualizarEstudiante(int id, String nuevoNombre, String nuevoCorreo,String nuevaCarrera) {
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            estudiante.setNombre(nuevoNombre);
            estudiante.setCorreo(nuevoCorreo);
            estudiante.setCarrera(nuevaCarrera);
            return true;
        }
        return false;
    }

    public boolean eliminarEstudiante(int id) {
        Estudiante estudiante = buscarEstudiante(id);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            return true;
        }
        return false;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void registrarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public Profesor buscarProfesor(int id) {
        for(Profesor profesor : profesores) {
            if (profesor.getId() == id) {
                return profesor;
            }
        }
        return null;
    }
    public Boolean actualizarProfesor(int id, String nuevoNombre, String nuevoCorreo, String nuevaEspecialidad, String setDepartamento){
        Profesor profesor = buscarProfesor(id);
        if (profesor != null) {
            profesor.setNombre(nuevoNombre);
            profesor.setCorreo(nuevoCorreo);
            profesor.setEspecialidad(nuevaEspecialidad);
            return true;
        }
        return false;
    }

    public boolean eliminarProfesor(int id) {
        Profesor profesor = buscarProfesor(id);
        if (profesor != null) {
            profesores.remove(profesor);
            return true;
        }
        return false;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public boolean matricularEstudiante(int idEstudiante, int codigoMatieria) {
        if (buscarEstudiante(idEstudiante) == null) {
            System.out.println("ERROR: El estudiante no existe en admisiones.");
            return false;
        }
        if (estaMatriculado(idEstudiante, codigoMatieria)) {
            System.out.println("ERROR: El estudiante ya esta matriculado en esta materia.");
            return false;
        }
        Matricula nuevaMatricula = new Matricula(idEstudiante, codigoMatieria);
        matriculas.add(nuevaMatricula);
        return true;
    }

    public boolean asignarProfesorAMateria(int idProfesor, int codigoMateria) {
        if (buscarProfesor(idProfesor) == null) {
            System.out.println("ERROR: El profesor no existe en admisiones.");
            return false;
        }
        AsignacionProfesor nuevaAsignacion = new AsignacionProfesor(idProfesor, codigoMateria);
        asignaciones.add(nuevaAsignacion);
        return true;
    }


    //Metodos para otros modulos:
    //Existe persona es usado por MANEJO DE ACTIVOS para consultar si la persoba existe...

    public boolean existePersona(int id) {
        return buscarEstudiante(id) != null || buscarProfesor(id) != null;
    }

    //Esto lo usa DIRECCION ACADEMICA para verificar antes de registrar notas...

    public boolean estaMatriculado(int idEstudiante, int codigoMateria) {
        for(Matricula matricula : matriculas) {
            if (matricula.getIdEstudiante() == idEstudiante && matricula.getCodigoMateria() == codigoMateria){
                return true;
            }
        }
        return false;
    }

}
