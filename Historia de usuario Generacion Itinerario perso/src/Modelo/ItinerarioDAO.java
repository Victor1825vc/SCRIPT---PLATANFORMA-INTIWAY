package model;

import java.sql.*;

public class ItinerarioDAO {
    private String url;
    private String user;
    private String pass;

    public ItinerarioDAO(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public void insertar(Itinerario i) throws SQLException {
        String sql = "{call sp_InsertItinerarioPersonalizado(?,?,?,?)}";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, i.getTipoTurismo());
            cs.setString(2, i.getActividades());
            cs.setString(3, i.getDuracion());
            cs.setString(4, i.getCosto());

            cs.execute();
        }
    }
}
