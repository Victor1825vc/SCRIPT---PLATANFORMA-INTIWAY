package view;

import controller.ItinerarioController;

import javax.swing.*;
import java.awt.*;

public class FrmItinerario extends JFrame {

    JComboBox<String> cboTipo;
    JTextArea txtActividades;
    JTextField txtDuracion, txtCosto;
    JButton btnGenerar, btnGuardar, btnSalir;

    private ItinerarioController controller;

    public FrmItinerario(ItinerarioController controller) {
        this.controller = controller;

        setTitle("INTIWAY - Plataforma de Turismo Personalizado");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ============================
        // BARRA SUPERIOR
        // ============================
        JPanel barra = new JPanel();
        barra.setBackground(new Color(30, 30, 30));   // Gris muy oscuro
        barra.setPreferredSize(new Dimension(900, 60));
        barra.setLayout(null);

        JLabel titulo = new JLabel("INTIWAY - Plataforma de Turismo Personalizado", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(0, 5, 900, 25);
        barra.add(titulo);

        String[] botones = {
                "Inicio", "Preferencias Usuario", "Recomendación e Itinerarios",
                "Reservas Turísticas", "Pagos Electrónicos", "Gestión de Servicios"
        };

        int x = 10;
        for (String b : botones) {
            JButton btn = new JButton(b);
            btn.setBounds(x, 32, 145, 23);
            btn.setFocusable(false);
            btn.setBackground(new Color(55,55,55));     // Gris oscuro
            btn.setForeground(Color.WHITE);
            barra.add(btn);
            x += 150;
        }

        add(barra, BorderLayout.NORTH);

        // ============================
        // PANEL CONTENEDOR CENTRAL
        // ============================
        JPanel contenedor = new JPanel(null);
        contenedor.setBackground(new Color(240, 240, 240)); // Gris claro
        add(contenedor, BorderLayout.CENTER);

        // ============================
        // TU FORMULARIO AL CENTRO
        // ============================
        JPanel panelFormulario = new JPanel(null);
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBounds(200, 50, 500, 520);
        panelFormulario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        contenedor.add(panelFormulario);

        // ============================================
        // TU FORMULARIO ORIGINAL (NO CAMBIÉ NADA)
        // ============================================

        JLabel lblTipo = new JLabel("Seleccione tipo de turismo:");
        lblTipo.setBounds(20, 20, 200, 25);
        panelFormulario.add(lblTipo);

        cboTipo = new JComboBox<>(new String[]{
                "Aventura", "Gastronómico", "Cultural", "Relax", "Familiar", "Rural"
        });
        cboTipo.setBounds(20, 50, 200, 30);
        panelFormulario.add(cboTipo);

        btnGenerar = new JButton("Generar Itinerario");
        btnGenerar.setBounds(250, 50, 200, 30);
        panelFormulario.add(btnGenerar);

        txtActividades = new JTextArea();
        txtActividades.setBorder(BorderFactory.createTitledBorder("Actividades recomendadas"));
        txtActividades.setBounds(20, 100, 450, 250);
        panelFormulario.add(txtActividades);

        txtDuracion = new JTextField();
        txtDuracion.setBorder(BorderFactory.createTitledBorder("Duración estimada"));
        txtDuracion.setBounds(20, 370, 200, 50);
        panelFormulario.add(txtDuracion);

        txtCosto = new JTextField();
        txtCosto.setBorder(BorderFactory.createTitledBorder("Costo aproximado"));
        txtCosto.setBounds(250, 370, 220, 50);
        panelFormulario.add(txtCosto);

        // ============================================
        // BOTONES GUARDAR + SALIR (AGREGADO)
        // ============================================
        btnGuardar = new JButton("Guardar Itinerario");
        btnGuardar.setBounds(120, 450, 160, 40);
        panelFormulario.add(btnGuardar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(300, 450, 120, 40);
        panelFormulario.add(btnSalir);

        btnSalir.addActionListener(e -> dispose());

        // EVENTOS ORIGINALES
        btnGenerar.addActionListener(e -> generarItinerario());
        btnGuardar.addActionListener(e -> guardar());
    }

    // ============================================
    // LÓGICA ORIGINAL SIN CAMBIOS
    // ============================================

    private void generarItinerario() {
        String tipo = cboTipo.getSelectedItem().toString();
        String actividades = "";

        switch (tipo) {
            case "Aventura" -> {
                actividades = """
                        • Caminata por la montaña
                        • Canotaje en río
                        • Zipline / Tirolesa
                        • Mirador panorámico
                        """;
                txtDuracion.setText("1 día completo");
                txtCosto.setText("S/. 120 - S/. 180");
            }
            case "Gastronómico" -> {
                actividades = """
                        • Tour de platos típicos
                        • Degustación de cafés
                        • Visita a mercado artesanal
                        • Clase de cocina regional
                        """;
                txtDuracion.setText("6 horas");
                txtCosto.setText("S/. 80 - S/. 150");
            }
            case "Cultural" -> {
                actividades = """
                        • Visita a museos
                        • Recorrido histórico urbano
                        • Taller artesanal tradicional
                        • Presentación folklórica
                        """;
                txtDuracion.setText("8 horas");
                txtCosto.setText("S/. 60 - S/. 110");
            }
            case "Relax" -> {
                actividades = """
                        • Spa natural
                        • Baños termales
                        • Tour de descanso
                        • Caminata ligera
                        """;
                txtDuracion.setText("Medio día");
                txtCosto.setText("S/. 50 - S/. 100");
            }
            case "Familiar" -> {
                actividades = """
                        • Visita al zoológico
                        • Parque recreativo
                        • Paseo turístico seguro
                        • Actividades para niños
                        """;
                txtDuracion.setText("6 horas");
                txtCosto.setText("S/. 70 - S/. 130");
            }
            case "Rural" -> {
                actividades = """
                        • Vivencia con comunidades
                        • Caminata ecológica
                        • Alimentación orgánica
                        • Actividades agrícolas
                        """;
                txtDuracion.setText("1 día");
                txtCosto.setText("S/. 90 - S/. 150");
            }
        }
        txtActividades.setText(actividades);
    }

    private void guardar() {
        String tipo = cboTipo.getSelectedItem().toString();
        String act = txtActividades.getText();
        String dur = txtDuracion.getText();
        String costo = txtCosto.getText();

        String valid = controller.validar(act, dur, costo);
        if (valid != null) {
            JOptionPane.showMessageDialog(this, valid);
            return;
        }

        String msg = controller.guardar(tipo, act, dur, costo);
        JOptionPane.showMessageDialog(this, msg);
    }
}
