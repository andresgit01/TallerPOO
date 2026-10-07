package modelo.direccionAcademica;

import java.util.Iterator;


public class ListaNotas implements Iterable<Nota> {
    private static class Nodo {
        Nota nota;
        Nodo siguiente;

        Nodo(Nota nota) {
            this.nota = nota;
        }
    }

    private Nodo cabeza, cola;

    public void agregar(Nota nota) {
        Nodo nuevo = new Nodo(nota);
        if (cabeza == null) cabeza = nuevo;
        else cola.siguiente = nuevo;
        cola = nuevo;
    }

    /** Solo las notas de un estudiante, en una lista nueva. */
    public ListaNotas deEstudiante(String idEstudiante) {
        ListaNotas resultado = new ListaNotas();
        for (Nota n : this) {
            if (n.getIdEstudiante().equals(idEstudiante)) resultado.agregar(n);
        }
        return resultado;
    }

    @Override
    public Iterator<Nota> iterator() {
        return new Iterator<>() {
            private Nodo actual = cabeza;

            public boolean hasNext() {
                return actual != null;
            }

            public Nota next() {
                Nota nota = actual.nota;
                actual = actual.siguiente;
                return nota;
            }
        };
    }
}
