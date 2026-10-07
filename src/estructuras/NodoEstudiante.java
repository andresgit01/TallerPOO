package estructuras;

import modelo.admisiones.Estudiante;

public class NodoEstudiante {
    private Estudiante estudiante;
    private NodoEstudiante siguiente;

    public NodoEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public NodoEstudiante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstudiante siguiente) {
        this.siguiente = siguiente;
    }
}
