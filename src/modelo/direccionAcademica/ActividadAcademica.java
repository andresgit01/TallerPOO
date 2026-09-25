package modelo.direccionAcademica;

/**
 * Clase abstracta que representa una actividad académica ponderada (Abstracción).
 */
public abstract class ActividadAcademica {
    private String nombre;
    private double porcentaje; // Ej: 0.20 para 20%

    public ActividadAcademica(String nombre, double porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    /**
     * Método polimórfico para calcular la nota ponderada según el tipo de actividad.
     */
    public abstract double calcularPonderado(double notaObtenida);
}
