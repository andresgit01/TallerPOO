package estructuras;

import modelo.activos.Prestamo;

public class NodoPrestamo {

    private Prestamo prestamo;
    private NodoPrestamo siguiente;

    public NodoPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public NodoPrestamo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPrestamo siguiente) {
        this.siguiente = siguiente;
    }
}
