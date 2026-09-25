package modelo.direccionAcademica;

public class Taller extends ActividadAcademica {
    public Taller(String nombre, double porcentaje) {
        super(nombre, porcentaje);
    }

    @Override
    public double calcularPonderado(double notaObtenida) {
        return notaObtenida * getPorcentaje();
    }
}
