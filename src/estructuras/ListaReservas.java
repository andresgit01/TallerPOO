package estructuras;
import modelo.activos.Reserva;
public class ListaReservas {

    private NodoReserva cabeza;

    public NodoReserva getCabeza() {
        return cabeza;
    }

    public void agregar(Reserva reserva) {
        NodoReserva nuevo = new NodoReserva(reserva);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoReserva actual = cabeza;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }
    }
}
