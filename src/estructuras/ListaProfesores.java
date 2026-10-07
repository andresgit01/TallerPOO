package estructuras;

import modelo.Admisiones.Profesor;

public class ListaProfesores {
    private NodoProfesor head;

    public ListaProfesores() {
        this.head = null;
    }

    public void agregarProfesor(Profesor profesor) {
        NodoProfesor nuevoNodo = new NodoProfesor(profesor);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoProfesor actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public boolean eliminarProfesor(Profesor profesor) {
        if (head == null) {
            return false;
        }

        if (head.getProfesor().equals(profesor)) {
            head = head.getSiguiente();
            return true;
        }

        NodoProfesor actual = head;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getProfesor().equals(profesor)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public NodoProfesor getHead() {
        return head;
    }
}