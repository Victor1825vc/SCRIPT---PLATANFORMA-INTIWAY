package model;

import java.sql.*;

public class ProveedorDAO {

    private String url = "jdbc:sqlserver://localhost:1433;databaseName=TurismoDB;encrypt=false;";
    private String user = "usuariodiseño";
    private String pass = "12345";

    public int insertar(Proveedor p) throws SQLException {
        String sql = "{call sp_InsertProveedor(?,?,?,?,?,?,?)}";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, p.getNombre());
            cs.setString(2, p.getCorreo());
            cs.setString(3, p.getTelefono());
            cs.setString(4, p.getDireccion());
            cs.setString(5, p.getEmpresa());
            cs.setString(6, p.getTipoProveedor());
            cs.registerOutParameter(7, Types.INTEGER);

            cs.execute();

            int newId = cs.getInt(7);
            p.setId(newId);

            return newId;
        }
    }
}
