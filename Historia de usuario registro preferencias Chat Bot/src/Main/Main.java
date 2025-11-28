import model.PreferenciaChatDAO;
import controller.PreferenciaChatController;
import view.FrmChatPreferencias;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=TurismoDB;encrypt=false;";
        String user = "usuariodiseño";
        String pass = "12345";

        PreferenciaChatDAO dao = new PreferenciaChatDAO(url, user, pass);
        PreferenciaChatController controller = new PreferenciaChatController(dao);

        SwingUtilities.invokeLater(() -> {
            new FrmChatPreferencias(controller).setVisible(true);
        });
    }
}
