import model.PagoDAO;
import controller.PagoController;
import view.PagoForm;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=TurismoDB;encrypt=false;";
        String user = "usuariodiseño";
        String pass = "12345";

        PagoDAO dao = new PagoDAO(url, user, pass);
        PagoController controller = new PagoController(dao);

        SwingUtilities.invokeLater(() -> {
            PagoForm f = new PagoForm(controller);
            f.setVisible(true);
        });
    }
}
