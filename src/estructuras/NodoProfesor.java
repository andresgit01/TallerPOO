package estructuras;

import modelo.Admisiones.Profesor;

public class NodoProfesor {
    private Profesor profesor;
    private NodoProfesor siguiente;

    public NodoProfesor(Profesor profesor) {
        this.profesor = profesor;
        this.siguiente = null;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public NodoProfesor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProfesor siguiente) {
        this.siguiente = siguiente;
    }
}
