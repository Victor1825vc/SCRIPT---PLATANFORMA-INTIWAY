package model;

import java.sql.*;

public class ReservaDAO {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=TurismoDB;encrypt=false;";
    private String user = "usuariodiseño";
    private String pass = "12345";

    public int insertarReserva(Reserva r) throws SQLException {
        String sql = "{call sp_InsertReserva(?,?,?,?,?,?)}"; // 5 IN + 1 OUT

        Connection conn = DriverManager.getConnection(url, user, pass);
        CallableStatement cs = conn.prepareCall(sql);

        cs.setString(1, r.getTipoServicio());
        cs.setString(2, r.getFechaReserva());
        cs.setDouble(3, r.getCosto());
        cs.setInt(4, r.getCantidadPersonas());
        cs.setString(5, r.getDestino());
        cs.registerOutParameter(6, Types.INTEGER);

        cs.execute();

        int newId = cs.getInt(6);
        r.setIdReserva(newId);

        cs.close();
        conn.close();

        return newId;
    }
}
