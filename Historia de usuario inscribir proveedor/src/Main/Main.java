import view.ProveedorForm;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProveedorForm().setVisible(true);
        });
    }
}
