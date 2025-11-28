package controller;

import model.Itinerario;
import model.ItinerarioDAO;

public class ItinerarioController {

    private ItinerarioDAO dao;

    public ItinerarioController(ItinerarioDAO dao) {
        this.dao = dao;
    }

    public String validar(String act, String dur, String costo) {
        if (act.isEmpty() || dur.isEmpty() || costo.isEmpty()) {
            return "Complete todos los campos.";
        }
        return null;
    }

    public String guardar(String tipo, String act, String dur, String costo) {
        try {
            Itinerario i = new Itinerario(tipo, act, dur, costo);
            dao.insertar(i);
            return "Itinerario guardado correctamente.";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error al guardar: " + ex.getMessage();
        }
    }
}
