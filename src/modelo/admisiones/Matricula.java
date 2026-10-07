package modelo.Admisiones;

public class Matricula {
    private int idEstudiante;
    private  int codigoMateria;

    public Matricula(int idEstudiante, int codigoMateria) {
        this.idEstudiante = idEstudiante;
        this.codigoMateria = codigoMateria;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }
}
