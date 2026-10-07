package estructuras;

import modelo.Admisiones.Estudiante;

public class ListaEstudiantes {
    private NodoEstudiante head;

    public ListaEstudiantes() {
        this.head = null;
    }

    public NodoEstudiante getHead() {
        return head;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        NodoEstudiante nuevoNodo = new NodoEstudiante(estudiante);
        if (head == null) {
            head= nuevoNodo;
        } else{
            NodoEstudiante actual = head;
            while (actual.getEstudiante() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }
    public boolean eliminarEstudiante(Estudiante estudiante) {
        if (head == null) {
            return false;
        }
        if (head.getEstudiante().equals(estudiante)) {
            head = head.getSiguiente();
            return true;
        }
        NodoEstudiante actual = head;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getSiguiente().equals(estudiante)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}
