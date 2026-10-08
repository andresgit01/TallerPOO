package modelo.activos;

public class Prestamo {

    private int codigo;
    private int codigoActivo;
    private int identificacionPersona;
    private boolean activo;

    public Prestamo(int codigo, int codigoActivo, int identificacionPersona) {
        this.codigo = codigo;
        this.codigoActivo = codigoActivo;
        this.identificacionPersona = identificacionPersona;
        this.activo = true;
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

    public boolean estaActivo() {
        return activo;
    }

    public void registrarDevolucion() {
        activo = false;
    }

    @Override
    public String toString() {
        return "Préstamo " + codigo
                + " | Activo: " + codigoActivo
                + " | Persona: " + identificacionPersona
                + " | Estado: " + (activo ? "Activo" : "Devuelto");
    }
}
