package controller;

import model.Reserva;
import model.ReservaDAO;

public class ReservaController {
    
    private ReservaDAO dao;

    public ReservaController() {
        dao = new ReservaDAO();
    }

    // Validación simple
    public String validar(String fecha, String costo, String personas) {
        if (fecha.trim().isEmpty()) return "Fecha requerida";
        if (costo.trim().isEmpty()) return "Costo requerido";
        if (personas.trim().isEmpty()) return "Cantidad requerida";

        try { Double.parseDouble(costo); }
        catch (Exception e) { return "Costo inválido"; }

        try { Integer.parseInt(personas); }
        catch (Exception e) { return "Cantidad inválida"; }

        return null;
    }

    // Registrar reserva
    public String registrar(String tipoServicio, String fecha, double costo, int personas, String destino) {
        Reserva r = new Reserva(tipoServicio, fecha, costo, personas, destino);
        try {
            int id = dao.insertarReserva(r);
            return "✔ Reserva registrada con ID: " + id;
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}
