package view;

import controller.ProveedorController;
import javax.swing.*;
import java.awt.*;

public class ProveedorForm extends JFrame {

    private JTextField txtNombre, txtCorreo, txtTelefono, txtDireccion, txtEmpresa;
    private JComboBox<String> cboTipo;
    private JButton btnRegistrar, btnSalir;

    private ProveedorController controller = new ProveedorController();

    public ProveedorForm() {

        setTitle("INTIWAY - Plataforma de Turismo Personalizado");
        setSize(750, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // PANEL SUPERIOR DECORATIVO
        JPanel barraTop = new JPanel();
        barraTop.setBackground(new Color(30, 30, 30));
        barraTop.setBounds(0, 0, 750, 90);
        barraTop.setLayout(null);

        JLabel lblTituloTop = new JLabel("INTIWAY - Plataforma de Turismo Personalizado", SwingConstants.CENTER);
        lblTituloTop.setForeground(Color.WHITE);
        lblTituloTop.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTituloTop.setBounds(0, 5, 750, 30);
        barraTop.add(lblTituloTop);

        String[] botones = {
                "Inicio", "Preferencias Usuario", "Recomendación e Itinerarios",
                "Reservas Turísticas", "Pagos Electrónicos", "Gestión de Servicios"
        };

        int x = 10;
        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setBounds(x, 45, 150, 30);
            btn.setBackground(Color.DARK_GRAY);
            btn.setForeground(Color.WHITE);
            btn.setFocusable(false);
            barraTop.add(btn);
            x += 155;
        }

        add(barraTop);

        // PANEL CENTRAL (TU FORMULARIO)
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(null);
        panelCentro.setBounds(0, 100, 750, 460);
        panelCentro.setBackground(new Color(240, 240, 240));
        add(panelCentro);

        int centerX = 225; // para centrar mejor tu formulario

        JLabel lblTitulo = new JLabel("INSCRIPCIÓN DE PROVEEDORES", SwingConstants.CENTER);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(18f));
        lblTitulo.setBounds(180, 10, 380, 30);
        panelCentro.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(centerX - 120, 60, 200, 20);
        panelCentro.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(centerX - 120, 85, 190, 25);
        panelCentro.add(txtNombre);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(centerX + 110, 60, 200, 20);
        panelCentro.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(centerX + 110, 85, 190, 25);
        panelCentro.add(txtCorreo);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(centerX - 120, 130, 200, 20);
        panelCentro.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(centerX - 120, 155, 190, 25);
        panelCentro.add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(centerX + 110, 130, 200, 20);
        panelCentro.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(centerX + 110, 155, 190, 25);
        panelCentro.add(txtDireccion);

        JLabel lblEmpresa = new JLabel("Empresa:");
        lblEmpresa.setBounds(centerX - 120, 200, 200, 20);
        panelCentro.add(lblEmpresa);

        txtEmpresa = new JTextField();
        txtEmpresa.setBounds(centerX - 120, 225, 420, 25);
        panelCentro.add(txtEmpresa);

        JLabel lblTipo = new JLabel("Tipo de Proveedor:");
        lblTipo.setBounds(centerX - 120, 270, 200, 20);
        panelCentro.add(lblTipo);

        cboTipo = new JComboBox<>(new String[]{
                "Transporte", "Restaurante", "Tour",
                "Hospedaje", "Equipos / Materiales",
                "Agencia de viajes", "Otro"
        });
        cboTipo.setBounds(centerX - 120, 295, 200, 25);
        panelCentro.add(cboTipo);

        // BOTÓN REGISTRAR
        btnRegistrar = new JButton("Registrar Proveedor");
        btnRegistrar.setBounds(centerX - 20, 360, 180, 35);
        panelCentro.add(btnRegistrar);

        // BOTÓN SALIR (A LA DERECHA)
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(centerX + 170, 360, 120, 35);
        panelCentro.add(btnSalir);

        // Acción botón Salir
        btnSalir.addActionListener(e -> dispose());

        // Acción registrar
        btnRegistrar.addActionListener(e -> registrar());
    }

    private void registrar() {
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String empresa = txtEmpresa.getText().trim();
        String tipo = cboTipo.getSelectedItem().toString();

        String msg = controller.validar(nombre, correo, telefono, direccion, empresa);
        if (msg != null) {
            JOptionPane.showMessageDialog(this, msg);
            return;
        }

        String resultado = controller.registrarProveedor(
                nombre, correo, telefono, direccion, empresa, tipo
        );

        JOptionPane.showMessageDialog(this, resultado);
    }
}
