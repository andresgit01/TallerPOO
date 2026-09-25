package modelo.direccionAcademica;

/**
 * Interfaz de comunicación desacoplada con el Módulo de Admisiones.
 * Sirve para lograr el Desacoplamiento Absoluto entre componentes, que es justo lo que pide la guía del taller (desarrollo en paralelo).
 * Sirve exactamente para tres cosas:Para que puedas trabajar sin esperar a tu compañero:
 * Necesitamos validar si un estudiante estaba matriculado,
 * pero no podías usar el código de tu compañero porque él apenas lo estaba programando.
 * Al crear esta interfaz, tú creaste tu propia "regla" de lo que necesitabas.Funciona como un "Puente" o "Enchufe Universal":
 * Tu controlador de Dirección Académica no se conecta directamente al controlador de tu compañero. Se conecta a esta interfaz.
 * Es como un enchufe de pared: a ti no te importa cómo la empresa de energía genera la luz, tú solo sabes que si conectas tu cargador ahí,
 * va a funcionar.Permite el Polimorfismo en el Main: Gracias a que creaste esta interfaz, en el Main pudimos usar una expresión Lambda (idStr, codStr)
 * -> { ... } para conectar el botón de tu interfaz con la lógica de tu compañero,
 * traduciendo los datos de String a int sin alterar el código independiente de ninguno de los dos.
 */
public interface IServicioAdmisiones {
    boolean estaEstudianteMatriculado(String idEstudiante, String codigoMateria);
}
