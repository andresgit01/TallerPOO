package controlador;

import modelo.Admisiones.AsignacionProfesor;
import modelo.Admisiones.Estudiante;
import modelo.Admisiones.Matricula;
import modelo.Admisiones.Profesor;

import estructuras.ListaEstudiantes;
import estructuras.ListaProfesores;
import estructuras.ListaMatriculas;
import estructuras.ListaAsignacionesProfesor;

import estructuras.NodoEstudiante;
import estructuras.NodoProfesor;
import estructuras.NodoMatricula;

public class AdmisionesController {
    private ListaEstudiantes listaEstudiantes = new ListaEstudiantes();
    private ListaProfesores listaProfesores = new ListaProfesores();
    private ListaMatriculas listaMatriculas = new ListaMatriculas();
    private ListaAsignacionesProfesor listaAsignaciones = new ListaAsignacionesProfesor();

    public void registrarEstudiante(Estudiante estudiante) {
        listaEstudiantes.agregarEstudiante(estudiante);
    }

    public Estudiante buscarEstudiante(int identificacion) {
        NodoEstudiante actual = listaEstudiantes.getHead();
        while (actual != null) {
            if (actual.getEstudiante().getId() == identificacion) {
                return actual.getEstudiante();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean actualizarEstudiante(int identificacion, String nuevoNombre, String nuevoCorreo, String nuevaCarrera) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            estudiante.setNombre(nuevoNombre);
            estudiante.setCorreo(nuevoCorreo);
            estudiante.setCarrera(nuevaCarrera);
            return true;
        }
        return false;
    }

    public boolean eliminarEstudiante(int identificacion) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            return listaEstudiantes.eliminarEstudiante(estudiante);
        }
        return false;
    }

    public ListaEstudiantes getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void registrarProfesor(Profesor profesor) {
        listaProfesores.agregarProfesor(profesor);
    }

    public Profesor buscarProfesor(int identificacion) {
        NodoProfesor actual = listaProfesores.getHead();
        while (actual != null) {
            if (actual.getProfesor().getId() == identificacion) {
                return actual.getProfesor();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public Boolean actualizarProfesor(int identificacion, String nuevoNombre, String nuevoCorreo, String nuevaEspecialidad, String nuevoDepartamento) {
        Profesor profesor = buscarProfesor(identificacion);
        if (profesor != null) {
            profesor.setNombre(nuevoNombre);
            profesor.setCorreo(nuevoCorreo);
            profesor.setEspecialidad(nuevaEspecialidad);
            profesor.setDepartamento(nuevoDepartamento);
            return true;
        }
        return false;
    }

    public boolean eliminarProfesor(int identificacion) {
        Profesor profesor = buscarProfesor(identificacion);
        if (profesor != null) {
            return listaProfesores.eliminarProfesor(profesor);
        }
        return false;
    }

    public ListaProfesores getListaProfesores() {
        return listaProfesores;
    }

    public boolean matricularEstudiante(int identificacionEstudiante, int codigoMateria) {
        if (buscarEstudiante(identificacionEstudiante) == null) {
            System.out.println("ERROR: El estudiante no existe en admisiones.");
            return false;
        }
        if (estaMatriculado(identificacionEstudiante, codigoMateria)) {
            System.out.println("ERROR: El estudiante ya esta matriculado en esta materia.");
            return false;
        }
        Matricula nuevaMatricula = new Matricula(identificacionEstudiante, codigoMateria);
        listaMatriculas.agregarMatricula(nuevaMatricula);
        return true;
    }

    public boolean asignarProfesorAMateria(int identificacionProfesor, int codigoMateria) {
        if (buscarProfesor(identificacionProfesor) == null) {
            System.out.println("ERROR: El profesor no existe en admisiones.");
            return false;
        }
        AsignacionProfesor nuevaAsignacion = new AsignacionProfesor(identificacionProfesor, codigoMateria);
        listaAsignaciones.agregarAsignacionProfesor(nuevaAsignacion);
        return true;
    }

    public boolean existePersona(int identificacion) {
        return buscarEstudiante(identificacion) != null || buscarProfesor(identificacion) != null;
    }

    public boolean estaMatriculado(int identificacionEstudiante, int codigoMateria) {
        NodoMatricula actual = listaMatriculas.getHead();
        while (actual != null) {
            Matricula matricula = actual.getMatricula();
            if (matricula.getIdEstudiante() == identificacionEstudiante && matricula.getCodigoMateria() == codigoMateria) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}