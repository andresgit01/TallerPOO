package modelo.direccionAcademica;

public class Quiz extends ActividadAcademica {

    public Quiz(String nombre, double porcentaje) {
        super(nombre, porcentaje); // Llama al constructor del padre
    }

    @Override
    public double calcularPonderado(double notaObtenida) {
        return notaObtenida * getPorcentaje();
    }
}