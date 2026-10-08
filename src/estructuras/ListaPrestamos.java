package estructuras;

import modelo.activos.Prestamo;

public class ListaPrestamos {

    private NodoPrestamo cabeza;

    public NodoPrestamo getCabeza() {
        return cabeza;
    }

    public void agregar(Prestamo prestamo) {
        NodoPrestamo nuevo = new NodoPrestamo(prestamo);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPrestamo actual = cabeza;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }
    }
}
