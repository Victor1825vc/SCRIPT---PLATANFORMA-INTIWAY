package controller;

import model.Proveedor;
import model.ProveedorDAO;

public class ProveedorController {

    private ProveedorDAO dao;

    public ProveedorController() {
        this.dao = new ProveedorDAO();
    }

    // Validaciones
    public String validar(String nombre, String correo, String telefono,
                          String direccion, String empresa) {

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty() ||
            direccion.isEmpty() || empresa.isEmpty()) {

            return "Todos los campos son obligatorios.";
        }
        return null;
    }

    // Registrar proveedor
    public String registrarProveedor(String nombre, String correo, String telefono,
                                     String direccion, String empresa, String tipo) {

        Proveedor p = new Proveedor(nombre, correo, telefono, direccion, empresa, tipo);

        try {
            int id = dao.insertar(p);
            return "✔ Registrado con ID: " + id;
        } catch (Exception e) {
            return "❌ Error al registrar: " + e.getMessage();
        }
    }
}
