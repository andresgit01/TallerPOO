package estructuras;

import modelo.activos.Activo;

public class ListaActivos {

    private NodoActivo cabeza;

    public NodoActivo getCabeza() {
        return cabeza;
    }

    public void agregar(Activo activo) {
        NodoActivo nuevo = new NodoActivo(activo);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoActivo actual = cabeza;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }
    }

    public Activo buscar(int codigo) {
        NodoActivo actual = cabeza;

        while (actual != null) {
            if (actual.getActivo().getCodigo() == codigo) {
                return actual.getActivo();
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
