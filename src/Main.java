import controlador.AdmisionesController;
import vista.AdmisionesView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdmisionesController controller = new AdmisionesController();
        Scanner scanner = new Scanner(System.in);

        AdmisionesView view = new AdmisionesView(controller, scanner);
        view.iniciar();
    }
}
