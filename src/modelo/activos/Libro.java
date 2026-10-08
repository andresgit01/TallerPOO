package modelo.activos;

public class Libro extends Activo {

    private String autor;
    private String isbn;

    public Libro(int codigo, String nombre, String descripcion,
                 String autor, String isbn) {
        super(codigo, nombre, descripcion);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String obtenerDetalle() {
        return "Libro | Autor: " + autor + " | ISBN: " + isbn;
    }

}
