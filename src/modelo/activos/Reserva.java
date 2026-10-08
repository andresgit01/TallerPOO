package modelo.activos;

public class Reserva {

    private int codigo;
    private int codigoActivo;
    private int identificacionPersona;
    private boolean activa;

    public Reserva(int codigo, int codigoActivo, int identificacionPersona) {
        this.codigo = codigo;
        this.codigoActivo = codigoActivo;
        this.identificacionPersona = identificacionPersona;
        this.activa = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoActivo() {
        return codigoActivo;
    }

    public int getIdentificacionPersona() {
        return identificacionPersona;
    }

    public boolean estaActiva() {
        return activa;
    }

    public void cancelar() {
        activa = false;
    }

    @Override
    public String toString() {
        return "Reserva " + codigo
                + " | Activo: " + codigoActivo
                + " | Persona: " + identificacionPersona;
    }
}
