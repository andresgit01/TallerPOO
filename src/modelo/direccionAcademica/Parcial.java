package modelo.direccionAcademica;

public class Parcial extends ActividadAcademica {

    public Parcial(String nombre, double porcentaje) {
        super(nombre, porcentaje);
    }

    @Override
    public double calcularPonderado(double notaObtenida) {
        return notaObtenida * getPorcentaje();
    }
}