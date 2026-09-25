package vista;
import controlador.DireccionAcademicaController;
import modelo.direccionAcademica.*;

import java.util.Scanner;

public class DireccionAcademicaView {
    private DireccionAcademicaController controller;
    private Scanner scanner;

    // Recibe el scanner del Main de forma segura
    public DireccionAcademicaView(DireccionAcademicaController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void iniciarMenuInteractivo() {
        int opcion = -1;
        do {
            System.out.println("\n==========================================");
            System.out.println(" MÓDULO DIRECCIÓN ACADÉMICA - UNIVERSIDAD");
            System.out.println("==========================================");
            System.out.println("1. Crear Materia");
            System.out.println("2. Modificar Nombre de Materia");
            System.out.println("3. Cambiar Estado (Habilitar/Deshabilitar Materia)");
            System.out.println("4. Registrar Nota de Estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuCrearMateria();
                case 2 -> menuModificarMateria();
                case 3 -> menuCambiarEstadoMateria();
                case 4 -> menuRegistrarNota();
                case 0 -> System.out.println("Saliendo del módulo de Dirección Académica...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void menuCrearMateria() {
        System.out.println("\n--- 📝 CREAR NUEVA MATERIA ---");
        System.out.print("Ingrese el código de la materia (ej. 101): ");
        String codigo = scanner.nextLine().trim();
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine().trim();

        if (codigo.isEmpty() || nombre.isEmpty()) {
            System.out.println("❌ Error: Los campos no pueden estar vacíos.");
            return;
        }

        boolean creado = controller.crearMateria(codigo, nombre);
        if (creado) {
            System.out.println("✅ Materia " + codigo + " creada exitosamente.");
        } else {
            System.out.println("❌ Error: Ya existe una materia con el código " + codigo);
        }
    }

    private void menuModificarMateria() {
        System.out.println("\n--- ✏️ MODIFICAR MATERIA EXISTENTE ---");
        System.out.print("Ingrese el código de la materia a modificar: ");
        String codigo = scanner.nextLine().trim();
        System.out.print("Ingrese el nuevo nombre para la materia: ");
        String nuevoNombre = scanner.nextLine().trim();

        boolean modificado = controller.modificarMateria(codigo, nuevoNombre);
        if (modificado) {
            System.out.println("✅ Nombre de la materia actualizado con éxito.");
        } else {
            System.out.println("❌ Error: No se encontró la materia con código " + codigo);
        }
    }

    private void menuCambiarEstadoMateria() {
        System.out.println("\n--- 🔄 HABILITAR / DESHABILITAR MATERIA ---");
        System.out.print("Ingrese el código de la materia: ");
        String codigo = scanner.nextLine().trim();

        System.out.println("Seleccione el nuevo estado:\n1. Habilitar\n2. Deshabilitar");
        int seleccion = leerEntero();

        if (seleccion != 1 && seleccion != 2) {
            System.out.println("⚠️ Opción inválida. Operación cancelada.");
            return;
        }

        boolean habilitar = (seleccion == 1);
        boolean cambiado = controller.cambiarEstadoMateria(codigo, habilitar);

        if (cambiado) {
            System.out.println("✅ Estado de la materia actualizado correctamente.");
        } else {
            System.out.println("❌ Error: No se encontró la materia solicitada.");
        }
    }

    private void menuRegistrarNota() {
        System.out.println("\n--- 📊 REGISTRAR NOTA DE ACTIVIDAD ---");
        System.out.print("Ingrese la Cédula/ID del estudiante (solo números): ");
        String idEstudiante = scanner.nextLine().trim();
        System.out.print("Ingrese el código de la materia (solo números): ");
        String codigoMateria = scanner.nextLine().trim();

        System.out.println("Seleccione tipo de actividad:\n1. Taller | 2. Quiz | 3. Parcial | 4. Proyecto");
        int tipoAct = leerEntero();
        if (tipoAct < 1 || tipoAct > 4) {
            System.out.println("⚠️ Tipo de actividad no válido. Se asignará Taller por defecto.");
            tipoAct = 1;
        }

        System.out.print("Nombre de la actividad: ");
        String nomAct = scanner.nextLine().trim();

        System.out.print("Porcentaje (ej. 0.20 para 20%): ");
        double pct = leerDouble();

        // Si las clases Quiz, Parcial o Proyecto están dentro de una subcarpeta
        ActividadAcademica actividad = switch (tipoAct) {
            case 1 -> new Taller(nomAct, pct);
            case 2 -> new Quiz(nomAct, pct);
            case 3 -> new Parcial(nomAct, pct);
            case 4 -> new Proyecto(nomAct, pct);
            default -> new Taller(nomAct, pct);
        };

        System.out.print("Ingrese la nota obtenida (0.0 a 5.0): ");
        double notaValor = leerDouble();

        String resultado = controller.registrarNota(idEstudiante, codigoMateria, actividad, notaValor);
        System.out.println(resultado);
    }

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double leerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }
}