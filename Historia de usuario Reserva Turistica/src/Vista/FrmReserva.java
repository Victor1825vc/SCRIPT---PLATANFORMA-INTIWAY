package view;

import controller.ReservaController;
import javax.swing.*;
import java.awt.*;

public class FrmReserva extends JFrame {

    private JComboBox<String> cboTipoServicio;
    private JTextField txtFecha;
    private JTextField txtCosto;
    private JTextField txtPersonas;
    private JComboBox<String> cboDestino;
    private JButton btnRegistrar;
    private JButton btnSalir;

    private ReservaController controller = new ReservaController();

    public FrmReserva() {

        setTitle("INTIWAY - Plataforma de Turismo Personalizado");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -------------------------
        //  PANEL SUPERIOR NEGRO
        // -------------------------
        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(30, 30, 30));
        panelTop.setBounds(0, 0, 1000, 90);
        panelTop.setLayout(null);
        add(panelTop);

        // TÍTULO
        JLabel lblTitulo = new JLabel("INTIWAY - Plataforma de Turismo Personalizado");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setBounds(230, 5, 600, 30);
        panelTop.add(lblTitulo);

        // -------------------------
        // BOTONES DE MENÚ
        // -------------------------
        String[] menu = {
                "Inicio",
                "Preferencias Usuario",
                "Recomendación e Itinerarios",
                "Reservas Turísticas",
                "Pagos Electrónicos",
                "Gestión de Servicios"
        };

        int x = 10;
        for (String m : menu) {
            JButton btn = new JButton(m);
            btn.setBounds(x, 45, 150, 30);
            btn.setBackground(new Color(50, 50, 50));
            btn.setForeground(Color.WHITE);
            panelTop.add(btn);
            x += 160;
        }

        // -------------------------
        //  FORMULARIO ORIGINAL
        // -------------------------
        JPanel panelForm = new JPanel();
        panelForm.setLayout(null);
        panelForm.setBackground(new Color(245, 245, 245));
        panelForm.setBounds(0, 100, 1000, 470);
        add(panelForm);

        JLabel lblTituloForm = new JLabel("RESERVAR SERVICIO TURÍSTICO");
        lblTituloForm.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTituloForm.setBounds(330, 20, 400, 30);
        panelForm.add(lblTituloForm);

        JLabel lblTipo = new JLabel("Tipo de servicio:");
        lblTipo.setBounds(300, 80, 150, 20);
        panelForm.add(lblTipo);

        cboTipoServicio = new JComboBox<>(new String[]{"Hospedaje", "Tour", "Restaurante", "Transporte"});
        cboTipoServicio.setBounds(450, 80, 200, 25);
        panelForm.add(cboTipoServicio);

        JLabel lblFecha = new JLabel("Fecha de Reserva:");
        lblFecha.setBounds(300, 130, 150, 20);
        panelForm.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(450, 130, 200, 25);
        panelForm.add(txtFecha);

        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setBounds(300, 180, 150, 20);
        panelForm.add(lblCosto);

        txtCosto = new JTextField();
        txtCosto.setBounds(450, 180, 200, 25);
        panelForm.add(txtCosto);

        JLabel lblPersonas = new JLabel("Cantidad Personas:");
        lblPersonas.setBounds(300, 230, 150, 20);
        panelForm.add(lblPersonas);

        txtPersonas = new JTextField();
        txtPersonas.setBounds(450, 230, 200, 25);
        panelForm.add(txtPersonas);

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(300, 280, 150, 20);
        panelForm.add(lblDestino);

        cboDestino = new JComboBox<>(new String[]{"Huancayo", "Concepción", "Jauja", "Tarma", "La Merced"});
        cboDestino.setBounds(450, 280, 200, 25);
        panelForm.add(cboDestino);

        // -------------------------
        // BOTONES
        // -------------------------
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(430, 340, 120, 35);
        panelForm.add(btnRegistrar);

        // → Botón añadido
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(560, 340, 120, 35);
        panelForm.add(btnSalir);

        btnRegistrar.addActionListener(e -> registrarReserva());
        btnSalir.addActionListener(e -> dispose());
    }

    private void registrarReserva() {
        String tipo = cboTipoServicio.getSelectedItem().toString();
        String fecha = txtFecha.getText();
        String costo = txtCosto.getText();
        String personas = txtPersonas.getText();
        String destino = cboDestino.getSelectedItem().toString();

        String valid = controller.validar(fecha, costo, personas);
        if (valid != null) {
            JOptionPane.showMessageDialog(this, valid, "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String r = controller.registrar(
                tipo,
                fecha,
                Double.parseDouble(costo),
                Integer.parseInt(personas),
                destino
        );

        JOptionPane.showMessageDialog(this, r);
    }
}
