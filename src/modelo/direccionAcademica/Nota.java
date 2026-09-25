package modelo.direccionAcademica;

public class Nota {
    private String idEstudiante;
    private String codigoMateria;
    private ActividadAcademica actividad;
    private double valor;

    public Nota(String idEstudiante, String codigoMateria, ActividadAcademica actividad, double valor) {
        this.idEstudiante = idEstudiante;
        this.codigoMateria = codigoMateria;
        this.actividad = actividad;
        this.valor = valor;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public ActividadAcademica getActividad() {
        return actividad;
    }

    public double getValor() {
        return valor;
    }

    public double getValorPonderado() {
        return actividad.calcularPonderado(valor);
    }
}
