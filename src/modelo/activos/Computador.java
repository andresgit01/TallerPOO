package modelo.activos;

public class Computador extends Activo {

    private String marca;
    private String numeroSerie;

    public Computador(int codigo, String nombre, String descripcion,
                      String marca, String numeroSerie) {
        super(codigo, nombre, descripcion);
        this.marca = marca;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String obtenerDetalle() {
        return "Computador | Marca: " + marca
                + " | Número de serie: " + numeroSerie;
    }
}
