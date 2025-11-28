import model.ItinerarioDAO;
import controller.ItinerarioController;
import view.FrmItinerario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=TurismoDB;encrypt=false;";
        String user = "sa";
        String pass = "123";

        ItinerarioDAO dao = new ItinerarioDAO(url, user, pass);
        ItinerarioController controller = new ItinerarioController(dao);

        SwingUtilities.invokeLater(() -> {
            FrmItinerario frm = new FrmItinerario(controller);
            frm.setVisible(true);
        });
    }
}
