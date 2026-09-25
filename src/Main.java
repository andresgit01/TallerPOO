import controlador.AdmisionesController;
import controlador.DireccionAcademicaController;
import vista.AdmisionesView;
import vista.DireccionAcademicaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Un solo Scanner para evitar conflictos en la consola de IntelliJ
        Scanner scanner = new Scanner(System.in);

        // Instanciamos el controlador que hizo tu compañero
        AdmisionesController admisionesController = new AdmisionesController();

        // Instanciamos TU controlador y hacemos el "puente" de comunicación independiente
        DireccionAcademicaController daController = new DireccionAcademicaController((idStr, codStr) -> {
            try {
                int idInt = Integer.parseInt(idStr.trim());
                int codInt = Integer.parseInt(codStr.trim());
                // Llamamos de manera independiente al método de validación de tu compañero
                return admisionesController.estaMatriculado(idInt, codInt);
            } catch (NumberFormatException e) {
                return false;
            }
        });

        // Instanciamos las vistas de ambos
        AdmisionesView admisionesView = new AdmisionesView(admisionesController, scanner);
        DireccionAcademicaView daView = new DireccionAcademicaView(daController, scanner);

        // Menú principal que unifica los dos componentes independientes
        int opcion = -1;
        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEMA INTEGRAL - UNIVERSIDAD DE BARBOSA");
            System.out.println("==========================================");
            System.out.println("1. Entrar al Módulo de Admisiones (Compañero)");
            System.out.println("2. Entrar al Módulo de Dirección Académica (Tuyo)");
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
                case 0 -> System.out.println("Cerrando el sistema general...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }
}