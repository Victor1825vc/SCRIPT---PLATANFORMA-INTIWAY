package controller;

import model.PreferenciaChat;
import model.PreferenciaChatDAO;

public class PreferenciaChatController {

    private PreferenciaChatDAO dao;

    public PreferenciaChatController(PreferenciaChatDAO dao) {
        this.dao = dao;
    }

    // Validaciones básicas
    public String validar(String presu, String destino) {
        if (presu.trim().isEmpty() || destino.trim().isEmpty()) {
            return "Debe completar presupuesto y destino.";
        }
        return null;
    }

    public String registrar(String tipo, String presu, String dest, String comen) {
        try {
            PreferenciaChat p = new PreferenciaChat(tipo, presu, dest, comen);
            boolean ok = dao.insertarPreferencia(p);

            return ok ? "OK" : "ERROR";

        } catch (Exception ex) {
            ex.printStackTrace();
            return "ERROR BD: " + ex.getMessage();
        }
    }
}
