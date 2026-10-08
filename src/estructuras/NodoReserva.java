package estructuras;

import modelo.activos.Reserva;
public class NodoReserva {

    private Reserva reserva;
    private NodoReserva siguiente;

    public NodoReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public NodoReserva getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoReserva siguiente) {
        this.siguiente = siguiente;
    }
}
//Cada lista enlaza sus elementos usando nodos; así se almacenan activos, reservas y préstamos sin ArrayList.