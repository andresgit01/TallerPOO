package modelo.Admisiones;

public class AsignacionProfesor {
    private int idProfesor;
    private int codigoMateria;

    public AsignacionProfesor(int idProfesor, int codigoMateria) {
        this.idProfesor = idProfesor;
        this.codigoMateria = codigoMateria;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }
}
