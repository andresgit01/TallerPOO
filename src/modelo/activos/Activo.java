package modelo.activos;

// Clase base: los tres tipos de activos comparten estos datos
public abstract class Activo {

    private int codigo;
    private String nombre;
    private String descripcion;
    private EstadoActivo estado;

    public Activo(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = EstadoActivo.DISPONIBLE;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoActivo getEstado() {
        return estado;
    }

    public void reservar() {
        estado = EstadoActivo.RESERVADO;
    }

    public void prestar() {
        estado = EstadoActivo.PRESTADO;
    }

    public void liberar() {
        estado = EstadoActivo.DISPONIBLE;
    }

    // Cada tipo de activo devuelve sus propios datos.
    public abstract String obtenerDetalle();

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | " + nombre
                + " | Estado: " + estado
                + " | " + obtenerDetalle();

    }
}
