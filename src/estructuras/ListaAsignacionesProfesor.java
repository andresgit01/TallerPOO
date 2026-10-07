package estructuras;

import modelo.Admisiones.AsignacionProfesor;

public class ListaAsignacionesProfesor {
    private NodoAsignacionProfesor head;

    public ListaAsignacionesProfesor() {
        this.head = null;
    }

    public void agregarAsignacionProfesor(AsignacionProfesor asignacionProfesor) {
        NodoAsignacionProfesor nuevoNodo = new NodoAsignacionProfesor(asignacionProfesor);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoAsignacionProfesor actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public NodoAsignacionProfesor getHead() {
        return head;
    }
}