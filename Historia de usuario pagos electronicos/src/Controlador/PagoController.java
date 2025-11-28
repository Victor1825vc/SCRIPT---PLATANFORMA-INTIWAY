package controller;

import model.Pago;
import model.PagoDAO;

public class PagoController {

    private PagoDAO dao;

    public PagoController(PagoDAO dao) {
        this.dao = dao;
    }

    // VALIDACIÓN DE CAMPOS
    public String validar(String c, String m, String s, String mo, String d, String t, String co) {

        if (c.isEmpty() || m.isEmpty() || s.isEmpty() || mo.isEmpty() ||
            d.isEmpty() || t.isEmpty() || co.isEmpty()) {
            return "Complete todos los campos.";
        }

        try {
            Double.parseDouble(mo);
        } catch (NumberFormatException e) {
            return "Monto inválido.";
        }

        return null;
    }

    // REGISTRAR
    public String registrarPago(String cliente, String metodo, String servicio, double monto,
                                String direccion, String telefono, String correo) {

        try {
            Pago p = new Pago(cliente, metodo, servicio, monto, direccion, telefono, correo);
            int id = dao.insertarPago(p);

            return "REGISTRADO ID: " + id;

        } catch (Exception ex) {
            ex.printStackTrace();
            return "ERROR: " + ex.getMessage();
        }
    }
}
