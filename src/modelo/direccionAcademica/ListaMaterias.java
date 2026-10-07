package modelo.direccionAcademica;

import java.util.Iterator;

public class ListaMaterias implements Iterable<Materia> {
    private static class Nodo {
        Materia materia;
        Nodo siguiente;

        Nodo(Materia materia) {
            this.materia = materia;
        }
    }

    private Nodo cabeza, cola;

    public void agregar(Materia materia) {
        Nodo nuevo = new Nodo(materia);
        if (cabeza == null) cabeza = nuevo;
        else cola.siguiente = nuevo;
        cola = nuevo;
    }

    @Override
    public Iterator<Materia> iterator() {
        return new Iterator<>() {
            private Nodo actual = cabeza;

            public boolean hasNext() {
                return actual != null;
            }

            public Materia next() {
                Materia materia = actual.materia;
                actual = actual.siguiente;
                return materia;
            }
        };
    }
}
