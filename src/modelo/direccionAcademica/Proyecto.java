package modelo.direccionAcademica;

public class Proyecto extends ActividadAcademica {

    public Proyecto(String nombre, double porcentaje) {
        super(nombre, porcentaje);
    }

    @Override
    public double calcularPonderado(double notaObtenida) {
        return notaObtenida * getPorcentaje();
    }
}
