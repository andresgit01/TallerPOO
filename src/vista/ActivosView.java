package vista;

import controlador.ActivosController;
import estructuras.*;
import modelo.activos.*;
import java.util.Scanner;

public class ActivosView {
    private ActivosController controller;
    private Scanner scanner;

    public ActivosView(ActivosController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n===== MANEJO DE ACTIVOS =====");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar computador");
            System.out.println("3. Registrar video beam");
            System.out.println("4. Consultar activos");
            System.out.println("5. Reservar activo");
            System.out.println("6. Cancelar reserva");
            System.out.println("7. Prestar activo");
            System.out.println("8. Devolver activo");
            System.out.println("0. Volver al menú principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> registrarComputador();
                case 3 -> registrarVideoBeam();
                case 4 -> consultarActivos();
                case 5 -> reservarActivo();
                case 6 -> cancelarReserva();
                case 7 -> prestarActivo();
                case 8 -> devolverActivo();
                case 0 -> System.out.println("Regresando al menú principal.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarLibro() {
        int codigo = leerEntero("Código: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(codigo, nombre, descripcion, autor, isbn);
        informarRegistro(controller.registrarActivo(libro));
    }

    private void registrarComputador() {
        int codigo = leerEntero("Código: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Número de serie: ");
        String serie = scanner.nextLine();

        Computador computador = new Computador(
                codigo, nombre, descripcion, marca, serie
        );
        informarRegistro(controller.registrarActivo(computador));
    }

    private void registrarVideoBeam() {
        int codigo = leerEntero("Código: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        int lumenes = leerEntero("Lúmenes: ");

        VideoBeam videoBeam = new VideoBeam(
                codigo, nombre, descripcion, marca, lumenes
        );
        informarRegistro(controller.registrarActivo(videoBeam));
    }

    private void consultarActivos() {
        NodoActivo actual = controller.getListaActivos().getCabeza();

        if (actual == null) {
            System.out.println("No hay activos registrados.");
            return;
        }

        while (actual != null) {
            System.out.println(actual.getActivo());
            actual = actual.getSiguiente();
        }
    }

    private void reservarActivo() {
        int codigo = leerEntero("Código del activo: ");
        int idPersona = leerEntero(
                "Identificación de estudiante o profesor: "
        );

        if (controller.reservarActivo(codigo, idPersona)) {
            System.out.println("Reserva realizada.");
        } else {
            System.out.println(
                    "No se pudo reservar. Revise el código, disponibilidad "
                            + "y que la persona esté registrada en Admisiones."
            );
        }
    }

    private void cancelarReserva() {
        int codigo = leerEntero("Código de la reserva: ");

        if (controller.cancelarReserva(codigo)) {
            System.out.println("Reserva cancelada.");
        } else {
            System.out.println("No se encontró esa reserva activa.");
        }
    }

    private void prestarActivo() {
        int codigo = leerEntero("Código del activo: ");
        int idPersona = leerEntero(
                "Identificación de estudiante o profesor: "
        );

        if (controller.prestarActivo(codigo, idPersona)) {
            System.out.println("Préstamo realizado.");
            System.out.println(
                    "Préstamos activos de la persona: "
                            + controller.contarPrestamosActivos(idPersona)
            );
        } else {
            System.out.println(
                    "No se pudo prestar. Revise disponibilidad, reserva, "
                            + "registro en Admisiones y el límite de tres préstamos."
            );
        }
    }

    private void devolverActivo() {
        int codigo = leerEntero("Código del préstamo: ");

        if (controller.devolverActivo(codigo)) {
            System.out.println("Devolución registrada.");
        } else {
            System.out.println("No se encontró ese préstamo activo.");
        }
    }

    private void informarRegistro(boolean registrado) {
        if (registrado) {
            System.out.println("Activo registrado correctamente.");
        } else {
            System.out.println("Ya existe un activo con ese código.");
        }
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
