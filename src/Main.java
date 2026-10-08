import controlador.AdmisionesController;
import controlador.DireccionAcademicaController;
import vista.AdmisionesView;
import vista.DireccionAcademicaView;

import controlador.ActivosController;
import vista.ActivosView;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Un solo Scanner para evitar conflictos en la consola de IntelliJ
        Scanner scanner = new Scanner(System.in);

        AdmisionesController admisionesController = new AdmisionesController();

        ActivosController activosController =
                new ActivosController(admisionesController::existePersona);

        ActivosView activosView =
                new ActivosView(activosController, scanner);

        DireccionAcademicaController daController = new DireccionAcademicaController((idStr, codStr) -> {
            try {
                return admisionesController.estaMatriculado(
                        Integer.parseInt(idStr.trim()), Integer.parseInt(codStr.trim()));
            } catch (NumberFormatException e) {
                return false;
            }
        });

        AdmisionesView admisionesView = new AdmisionesView(admisionesController, scanner);
        DireccionAcademicaView daView = new DireccionAcademicaView(daController, scanner);

        // Menú principal que unifica los dos componentes independientes
        int opcion = -1;
        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEMA INTEGRAL - UNIVERSIDAD DE BARBOSA");
            System.out.println("==========================================");
            System.out.println("1. Entrar al Módulo de Admisiones");
            System.out.println("2. Entrar al Módulo de Dirección Académica");
            System.out.println("3. Entrar al Módulo de Manejo de Activos");
            System.out.println("0. Salir del Sistema");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Por favor ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1 -> admisionesView.iniciar();
                case 2 -> daView.iniciarMenuInteractivo();
                case 3 -> activosView.iniciar();
                case 0 -> System.out.println("Cerrando el sistema general...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);





    }
}