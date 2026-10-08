package modelo.activos;

@FunctionalInterface
// El controlador de activos utilizo esta interfaz para consultar Admisiones
public interface IServicioAdmisionesActivos {

    boolean existePersona(int identificacion);

}
