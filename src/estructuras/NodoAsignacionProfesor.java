package estructuras;

import modelo.admisiones.AsignacionProfesor;

public class NodoAsignacionProfesor {
    private AsignacionProfesor asignacionProfesor;
    private NodoAsignacionProfesor siguiente;

    public NodoAsignacionProfesor(AsignacionProfesor asignacionProfesor) {
        this.asignacionProfesor = asignacionProfesor;
        this.siguiente = null;
    }

    public AsignacionProfesor getAsignacionProfesor() {
        return asignacionProfesor;
    }

    public void setAsignacionProfesor(AsignacionProfesor asignacionProfesor) {
        this.asignacionProfesor = asignacionProfesor;
    }

    public NodoAsignacionProfesor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAsignacionProfesor siguiente) {
        this.siguiente = siguiente;
    }
}
