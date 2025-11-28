package model;

import java.sql.*;

public class PreferenciaChatDAO {

    private String url;
    private String user;
    private String pass;

    public PreferenciaChatDAO(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public boolean insertarPreferencia(PreferenciaChat p) throws SQLException {

        String sql = "{call sp_InsertarPreferenciaChat(?,?,?,?)}";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, p.getTipoTurismo());
            cs.setString(2, p.getPresupuesto());
            cs.setString(3, p.getDestino());
            cs.setString(4, p.getComentario());

            cs.execute();
            return true;
        }
    }
}
