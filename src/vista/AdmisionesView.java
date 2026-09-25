package vista;
import modelo.Admisiones.Estudiante;
import modelo.Admisiones.Profesor;
import controlador.AdmisionesController;

import java.util.Scanner;

public class AdmisionesView {
    private AdmisionesController controller;
    private Scanner scanner;

    public AdmisionesView(AdmisionesController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }
    public void iniciar() {
    int opcion = 0;
    while (opcion !=9) {
        System.out.println("\n============== COMPONENTE DE ADMISIONES /n==============");
        System.out.println("1. Registrar Estudiante.");
        System.out.println("2. Consultar Estudiante.");
        System.out.println("3. Actualizar Estudiante.");
        System.out.println("4. Eliminar Estudiante.");
        System.out.println("5. Registrar Profesor.");
        System.out.println("6. Consultar Profesor.");
        System.out.println("7. Matricular Estudiante en una Materia");
        System.out.println("8. Asignar Profesor a una Materia.");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opcion: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                registrarEstudianteView();
                break;
            case 2:
                consultarEstudianteView();
                break;

            case 3:
                actualizarEstudianteView();
                break;
            case 4:
                eliminarEstudianteView();
                break;
            case 5:
                registrarProfesorView();
                break;
            case 6:
                consultarPorfesorView();
                break;
            case 7:
                matricularEstudianteView();
                break;
            case 8:
                asignarProfesorView();
                break;
            case 9:
                System.out.println("Saliendo del componente admisiones...");
                break;
            default:
                System.out.println("Opcion no valida.");

        }

    }
    }
    private void registrarEstudianteView() {
        System.out.println("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese un correo electronico: ");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su codigo estudiantil: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la carrera: ");
        String carrera = scanner.nextLine();

        Estudiante estudiante = new Estudiante(id, nombre, correo, codigo, carrera);
        controller.registrarEstudiante(estudiante);
        System.out.println("Estudiante registrado correctamente.");
    }
    private void consultarEstudianteView() {
        System.out.println("Ingrese el ID del estudiante que desea buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = controller.buscarEstudiante(id);
        if (estudiante != null) {
            System.out.println("Datos del estudiante: ");
            System.out.println("ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Correo: " + estudiante.getCorreo());
            System.out.println("Codigo estudiantil: " + estudiante.getCodigoEstudiantil());
            System.out.println("Carrera: " + estudiante.getCarrera());
        }else{
            System.out.println("Estudiante no encontrado.");
        }
    }
    public void actualizarEstudianteView() {
        System.out.println("Ingrese el ID del estudiante a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Nuevo correo: ");
        String correo = scanner.nextLine();

        System.out.println("Nueva carrera: ");
        String carrera = scanner.nextLine();

        if (controller.actualizarEstudiante(id, correo, carrera, nombre)) {
            System.out.println("Los datos del estudiante an sido actualizados correctamente.");
        }else {
            System.out.println("No se pudo actualizar. Estudiante no encontrado.");
        }
    }
    private void eliminarEstudianteView() {
        System.out.println("Ingrese el ID del estudiante que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (controller.eliminarEstudiante(id)) {
            System.out.println("Estudiante eliminado correctamente.");
        }else {
            System.out.println("Estudiante no encontrado.");
        }
    }
    private void registrarProfesorView() {
        System.out.println("Ingrese su ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su correo: ");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.println("Ingrese departamento: ");
        String departamento = scanner.nextLine();

        Profesor profesor = new Profesor(id, nombre, correo, especialidad, departamento);
        controller.registrarProfesor(profesor);
        System.out.println("Porfesor registrado correctamente.");
    }
    private void consultarPorfesorView() {
        System.out.println("Ingrese el ID del profesor que desea consultar: ");
        int id = scanner.nextInt();
        Profesor profesor = controller.buscarProfesor(id);
        if (profesor != null) {
            System.out.println("ID: " + profesor.getId());
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Correo: " + profesor.getCorreo());
            System.out.println("Especialidad: " + profesor.getEspecialidad());
            System.out.println("Departamento: " + profesor.getDepartamento());
        }else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private void matricularEstudianteView() {
        System.out.println("Ingrese el ID del estudiante: ");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el codigo de la materia: ");
        int codigoMateria = scanner.nextInt();
        scanner.nextLine();

        if (controller.matricularEstudiante(idEstudiante, codigoMateria)) {
            System.out.println("El estudiante ha sido matriculado correctamente.");
        }
    }

    private void asignarProfesorView() {
        System.out.println("Ingrese el ID del profesor: ");
        int idProfesor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el codigo de la materia: ");
        int codigoMateria = scanner.nextInt();
        scanner.nextLine();

        if (controller.asignarProfesorAMateria(idProfesor, codigoMateria)) {
            System.out.println("Profesor asignado correctamente.");
        }
    }

}
