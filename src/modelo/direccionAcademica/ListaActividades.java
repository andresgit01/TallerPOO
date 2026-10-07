package modelo.direccionAcademica;

import java.util.Iterator;


public class ListaActividades implements Iterable<ActividadAcademica> {
    private static class Nodo {
        ActividadAcademica actividad;
        Nodo siguiente;

        Nodo(ActividadAcademica actividad) {
            this.actividad = actividad;
        }
    }

    private Nodo cabeza, cola;

    public void agregar(ActividadAcademica actividad) {
        Nodo nuevo = new Nodo(actividad);
        if (cabeza == null) cabeza = nuevo;
        else cola.siguiente = nuevo;
        cola = nuevo;
    }

    @Override
    public Iterator<ActividadAcademica> iterator() {
        return new Iterator<>() {
            private Nodo actual = cabeza;

            public boolean hasNext() {
                return actual != null;
            }

            public ActividadAcademica next() {
                ActividadAcademica actividad = actual.actividad;
                actual = actual.siguiente;
                return actividad;
            }
        };
    }
}
