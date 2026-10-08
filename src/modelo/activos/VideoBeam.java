package modelo.activos;

public class VideoBeam extends Activo{

    private String marca;
    private int lumenes;

    public VideoBeam(int codigo, String nombre, String descripcion,
                     String marca, int lumenes) {
        super(codigo, nombre, descripcion);
        this.marca = marca;
        this.lumenes = lumenes;
    }

    @Override
    public String obtenerDetalle() {
        return "Video beam | Marca: " + marca
                + " | Lúmenes: " + lumenes;
    }
}
