package estructuras;

import modelo.Admisiones.Matricula;

public class ListaMatriculas {
    private NodoMatricula head;

    public ListaMatriculas() {
        this.head = null;
    }

    public void agregarMatricula(Matricula matricula) {
        NodoMatricula nuevoNodo = new NodoMatricula(matricula);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoMatricula actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public NodoMatricula getHead() {
        return head;
    }
}