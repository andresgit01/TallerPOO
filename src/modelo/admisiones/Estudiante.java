package modelo.Admisiones;

public class Estudiante extends Persona {
    private int codigoEstudiantil;
    private String carrera;

    public Estudiante(int id, String nombre, String correo, int codigoEstudiantil, String carrera) {
        super(id, nombre, correo);
        this.codigoEstudiantil = codigoEstudiantil;
        this.carrera = carrera;
    }

    public int getCodigoEstudiantil() {
        return codigoEstudiantil;
    }

    public void setCodigoEstudiantil(int codigoEstudiantil) {
        this.codigoEstudiantil = codigoEstudiantil;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
