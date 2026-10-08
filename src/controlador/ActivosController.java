package controlador;

import estructuras.*;
import modelo.activos.*;

public class ActivosController {

    private ListaActivos listaActivos;
    private ListaReservas listaReservas;
    private ListaPrestamos listaPrestamos;
    private IServicioAdmisionesActivos servicioAdmisiones;

    private int siguienteReserva;
    private int siguientePrestamo;

    public ActivosController(IServicioAdmisionesActivos servicioAdmisiones) {
        this.servicioAdmisiones = servicioAdmisiones;
        this.listaActivos = new ListaActivos();
        this.listaReservas = new ListaReservas();
        this.listaPrestamos = new ListaPrestamos();
        this.siguienteReserva = 1;
        this.siguientePrestamo = 1;
    }

    public boolean registrarActivo(Activo activo) {
        if (activo == null || listaActivos.buscar(activo.getCodigo()) != null) {
            return false;
        }

        listaActivos.agregar(activo);
        return true;
    }

    public Activo buscarActivo(int codigo) {
        return listaActivos.buscar(codigo);
    }

    public ListaActivos getListaActivos() {
        return listaActivos;
    }

    public ListaReservas getListaReservas() {
        return listaReservas;
    }

    public ListaPrestamos getListaPrestamos() {
        return listaPrestamos;
    }

    public boolean reservarActivo(int codigoActivo, int idPersona) {
        Activo activo = buscarActivo(codigoActivo);

        // Antes de reservar, se consulta que la persona exista en Admisiones.
        if (activo == null
                || !servicioAdmisiones.existePersona(idPersona)
                || activo.getEstado() != EstadoActivo.DISPONIBLE) {
            return false;
        }

        Reserva reserva = new Reserva(
                siguienteReserva, codigoActivo, idPersona
        );
        siguienteReserva++;

        listaReservas.agregar(reserva);
        activo.reservar();
        return true;
    }

    public boolean cancelarReserva(int codigoReserva) {
        NodoReserva actual = listaReservas.getCabeza();

        while (actual != null) {
            Reserva reserva = actual.getReserva();

            if (reserva.getCodigo() == codigoReserva
                    && reserva.estaActiva()) {
                reserva.cancelar();

                Activo activo = buscarActivo(reserva.getCodigoActivo());
                if (activo != null) {
                    activo.liberar();
                }

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public boolean prestarActivo(int codigoActivo, int idPersona) {
        Activo activo = buscarActivo(codigoActivo);

        if (activo == null || !servicioAdmisiones.existePersona(idPersona)) {
            return false;
        }

        // La regla del taller permite máximo tres préstamos al mismo tiempo.
        if (contarPrestamosActivos(idPersona) >= 3) {
            return false;
        }

        if (activo.getEstado() == EstadoActivo.PRESTADO) {
            return false;
        }

        Reserva reserva = buscarReservaActiva(codigoActivo);

        // Si está reservado, solo puede recibirlo quien hizo la reserva.
        if (activo.getEstado() == EstadoActivo.RESERVADO
                && (reserva == null
                || reserva.getIdentificacionPersona() != idPersona)) {
            return false;
        }

        if (reserva != null) {
            reserva.cancelar();
        }

        Prestamo prestamo = new Prestamo(
                siguientePrestamo, codigoActivo, idPersona
        );
        siguientePrestamo++;

        listaPrestamos.agregar(prestamo);
        activo.prestar();
        return true;
    }

    public boolean devolverActivo(int codigoPrestamo) {
        NodoPrestamo actual = listaPrestamos.getCabeza();

        while (actual != null) {
            Prestamo prestamo = actual.getPrestamo();

            if (prestamo.getCodigo() == codigoPrestamo
                    && prestamo.estaActivo()) {
                prestamo.registrarDevolucion();

                Activo activo = buscarActivo(prestamo.getCodigoActivo());
                if (activo != null) {
                    activo.liberar();
                }

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public int contarPrestamosActivos(int idPersona) {
        int total = 0;
        NodoPrestamo actual = listaPrestamos.getCabeza();

        while (actual != null) {
            Prestamo prestamo = actual.getPrestamo();

            if (prestamo.getIdentificacionPersona() == idPersona
                    && prestamo.estaActivo()) {
                total++;
            }

            actual = actual.getSiguiente();
        }

        return total;
    }

    private Reserva buscarReservaActiva(int codigoActivo) {
        NodoReserva actual = listaReservas.getCabeza();

        while (actual != null) {
            Reserva reserva = actual.getReserva();

            if (reserva.getCodigoActivo() == codigoActivo
                    && reserva.estaActiva()) {
                return reserva;
            }

            actual = actual.getSiguiente();
        }

        return null;
    }
}
