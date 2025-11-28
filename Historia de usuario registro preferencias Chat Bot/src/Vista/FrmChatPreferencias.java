package view;

import controller.PreferenciaChatController;
import javax.swing.*;
import java.awt.*;

public class FrmChatPreferencias extends JFrame {

    JComboBox<String> cboTipo;
    JTextField txtPresupuesto, txtDestino;
    JTextArea txtChat, txtComentario;
    JButton btnEnviar;

    private PreferenciaChatController controller;

    public FrmChatPreferencias(PreferenciaChatController controller) {

        this.controller = controller;

        setTitle("INTIWAY - Plataforma de Turismo Personalizado");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // ============================================
        //  BARRA SUPERIOR DECORATIVA (texto más negro)
        // ============================================
        JPanel barra = new JPanel();
        barra.setBackground(new Color(35, 35, 35));
        barra.setLayout(null);
        barra.setBounds(0, 0, 900, 80);

        JLabel titulo = new JLabel("INTIWAY - Plataforma de Turismo Personalizado");
        titulo.setForeground(new Color(220, 220, 220));   // más negro
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(200, 10, 600, 30);
        barra.add(titulo);

        // Botones decorativos con texto más negro
        String[] opciones = {
                "Inicio",
                "Preferencias Usuario",
                "Recomendación e Itinerarios",
                "Reservas Turísticas",
                "Pagos Electrónicos",
                "Gestión de Servicios"
        };

        int x = 10;
        for (String op : opciones) {
            JButton b = new JButton(op);
            b.setEnabled(false); // decorativo
            b.setForeground(new Color(210, 210, 210)); // más negro que antes
            b.setBackground(new Color(45, 45, 45));
            b.setBounds(x, 45, 140, 30);
            barra.add(b);
            x += 145;
        }

        add(barra);

        // ============================================
        // PANEL CENTRAL
        // ============================================
        JPanel centro = new JPanel();
        centro.setLayout(null);
        centro.setBackground(new Color(240, 240, 240));
        centro.setBounds(20, 90, 860, 510);

        add(centro);

        // ============================================
        // TU FORMULARIO ORIGINAL (NO CAMBIADO)
        // ============================================
        txtChat = new JTextArea();
        txtChat.setEditable(false);
        txtChat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtChat.setBounds(200, 20, 450, 200);
        centro.add(txtChat);

        cboTipo = new JComboBox<>(new String[]{
                "Aventura", "Gastronómico", "Cultural", "Rural", "Familiar", "Relax"
        });
        cboTipo.setBorder(BorderFactory.createTitledBorder("Tipo de turismo"));
        cboTipo.setBounds(200, 230, 200, 60);
        centro.add(cboTipo);

        txtPresupuesto = new JTextField();
        txtPresupuesto.setBorder(BorderFactory.createTitledBorder("Presupuesto"));
        txtPresupuesto.setBounds(410, 230, 240, 60);
        centro.add(txtPresupuesto);

        txtDestino = new JTextField();
        txtDestino.setBorder(BorderFactory.createTitledBorder("Destino"));
        txtDestino.setBounds(200, 300, 450, 55);
        centro.add(txtDestino);

        txtComentario = new JTextArea();
        txtComentario.setBorder(BorderFactory.createTitledBorder("Comentario adicional"));
        txtComentario.setBounds(200, 360, 450, 70);
        centro.add(txtComentario);

        // ============================================
        //  BOTONES → ENVIAR + SALIR AL COSTADO
        // ============================================
        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(300, 450, 140, 40);
        centro.add(btnEnviar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(450, 450, 140, 40);
        btnSalir.addActionListener(e -> dispose());
        centro.add(btnSalir);

        btnEnviar.addActionListener(e -> procesar());

        introChat();
    }

    private void introChat() {
        txtChat.append("ChatBot: ¡Hola! 👋\n");
        txtChat.append("ChatBot: Estoy aquí para registrar tus preferencias turísticas.\n\n");
    }

    private void procesar() {

        String tipo = cboTipo.getSelectedItem().toString();
        String presu = txtPresupuesto.getText();
        String dest = txtDestino.getText();
        String comen = txtComentario.getText();

        String val = controller.validar(presu, dest);
        if (val != null) {
            JOptionPane.showMessageDialog(this, val);
            return;
        }

        String r = controller.registrar(tipo, presu, dest, comen);

        if (r.equals("OK")) {
            txtChat.append("Tú: Quiero ir a " + dest + "\n");
            txtChat.append("ChatBot: ¡Perfecto! Preferencia guardada ✔\n\n");
            JOptionPane.showMessageDialog(this, "Preferencia registrada");
        } else {
            JOptionPane.showMessageDialog(this, r);
        }

        txtPresupuesto.setText("");
        txtDestino.setText("");
        txtComentario.setText("");
    }
}
