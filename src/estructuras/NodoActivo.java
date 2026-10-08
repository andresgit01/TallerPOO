package estructuras;

import modelo.activos.Activo;

public class NodoActivo {

    private NodoActivo siguiente;
    private Activo activo;

    public NodoActivo(Activo activo) {
        this.activo = activo;
        this.siguiente = null;
    }

    public Activo getActivo() {
        return activo;
    }

    public NodoActivo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoActivo siguiente) {
        this.siguiente = siguiente;
    }

}
