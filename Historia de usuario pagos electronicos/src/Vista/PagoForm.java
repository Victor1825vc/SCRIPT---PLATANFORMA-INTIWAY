// PagoForm centrado + botón SALIR (sin cambiar tu estilo)
// SOLO se agregó centrado y botón salir al costado

package view;

import controller.PagoController;
import javax.swing.*;
import java.awt.*;

public class PagoForm extends JFrame {

    private JTextField txtCliente = new JTextField(15);
    private JComboBox<String> cboMetodo =
            new JComboBox<>(new String[]{"Efectivo","Yape","Plin","Tarjeta"});
    private JTextField txtServicio = new JTextField(15);
    private JTextField txtMonto = new JTextField(15);
    private JTextField txtDireccion = new JTextField(15);
    private JTextField txtTelefono = new JTextField(15);
    private JTextField txtCorreo = new JTextField(15);
    private JTextArea txtResultado = new JTextArea(12, 30);

    private JButton btnRegistrar = new JButton("Registrar Pago");
    private JButton btnSalir = new JButton("Salir"); // *** NUEVO ***

    private PagoController controller;

    public PagoForm(PagoController controller) {
        this.controller = controller;

        setTitle("INTIWAY - Plataforma de Turismo Personalizado");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(900, 650);
        setLocationRelativeTo(null); // *** CENTRADO DE LA VENTANA ***

        // ▬▬▬▬▬▬▬▬▬▬▬ PANEL SUPERIOR ▬▬▬▬▬▬▬▬▬▬▬
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(30, 30, 30));
        topBar.setPreferredSize(new Dimension(0, 70));

        JLabel lblTitulo = new JLabel("INTIWAY - Plataforma de Turismo Personalizado", SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JPanel menuPanel = new JPanel(new GridLayout(1, 6, 8, 0));
        menuPanel.setBackground(new Color(30, 30, 30));

        String[] botones = {
                "Inicio", "Preferencias Usuario", "Recomendación e Itinerarios",
                "Reservas Turísticas", "Pagos Electrónicos", "Gestión de Servicios"
        };

        for (String t : botones) {
            JButton btn = new JButton(t);
            btn.setBackground(new Color(60, 60, 60));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            menuPanel.add(btn);
        }

        topBar.add(lblTitulo, BorderLayout.NORTH);
        topBar.add(menuPanel, BorderLayout.SOUTH);

        add(topBar, BorderLayout.NORTH);

        // ▬▬▬▬▬▬▬▬▬▬▬ PANEL CENTRAL ▬▬▬▬▬▬▬▬▬▬▬
        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(new Color(240, 240, 240));

        JLabel lblBienvenido = new JLabel("REGISTRO DE PAGOS", SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblBienvenido.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JPanel form = new JPanel(new GridLayout(9, 2, 10, 12)); // más espacio para el botón salir
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        form.setBackground(new Color(240, 240, 240));

        form.add(new JLabel("Cliente:"));
        form.add(txtCliente);

        form.add(new JLabel("Método Pago:"));
        form.add(cboMetodo);

        form.add(new JLabel("Servicio:"));
        form.add(txtServicio);

        form.add(new JLabel("Monto:"));
        form.add(txtMonto);

        form.add(new JLabel("Dirección:"));
        form.add(txtDireccion);

        form.add(new JLabel("Teléfono:"));
        form.add(txtTelefono);

        form.add(new JLabel("Correo:"));
        form.add(txtCorreo);

        // *** BOTONES JUNTOS ***
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        botonesPanel.setBackground(new Color(240, 240, 240));
        botonesPanel.add(btnRegistrar);
        botonesPanel.add(btnSalir);

        form.add(new JLabel("")); // celda vacía
        form.add(botonesPanel);

        JPanel panelDer = new JPanel();
        panelDer.setBorder(BorderFactory.createTitledBorder("Registros"));
        txtResultado.setEditable(false);
        panelDer.add(new JScrollPane(txtResultado));

        JPanel contenidoAbajo = new JPanel(new BorderLayout());
        contenidoAbajo.add(form, BorderLayout.WEST);
        contenidoAbajo.add(panelDer, BorderLayout.CENTER);

        centro.add(lblBienvenido, BorderLayout.NORTH);
        centro.add(contenidoAbajo, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // Acción registrar
        btnRegistrar.addActionListener(e -> onRegistrar());

        // Acción salir
        btnSalir.addActionListener(e -> dispose());
    }

    private void onRegistrar() {
        String c = txtCliente.getText();
        String m = cboMetodo.getSelectedItem().toString();
        String s = txtServicio.getText();
        String mo = txtMonto.getText();
        String d = txtDireccion.getText();
        String t = txtTelefono.getText();
        String co = txtCorreo.getText();

        String err = controller.validar(c, m, s, mo, d, t, co);
        if (err != null) {
            JOptionPane.showMessageDialog(this, err, "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double monto = Double.parseDouble(mo);

        String res = controller.registrarPago(c, m, s, monto, d, t, co);
        txtResultado.append(res + "\n");
    }
}