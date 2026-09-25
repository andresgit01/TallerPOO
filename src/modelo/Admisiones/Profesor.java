package modelo.Admisiones;

public class Profesor extends Persona {
    private String especialidad;
    private String departamento;

    public Profesor(int id, String nombre, String correo, String departamento, String especialidad) {
        super(id, nombre, correo);
        this.departamento = departamento;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
