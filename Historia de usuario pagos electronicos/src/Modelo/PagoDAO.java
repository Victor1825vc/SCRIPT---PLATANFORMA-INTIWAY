package model;

import java.sql.*;

public class PagoDAO {

    private String url;
    private String user;
    private String pass;

    public PagoDAO(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public int insertarPago(Pago p) throws Exception {

        String sql = "{call sp_InsertPago(?,?,?,?,?,?,?,?)}";

        Connection con = DriverManager.getConnection(url, user, pass);
        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, p.getCliente());
        cs.setString(2, p.getMetodoPago());
        cs.setString(3, p.getServicio());
        cs.setDouble(4, p.getMonto());
        cs.setString(5, p.getDireccion());
        cs.setString(6, p.getTelefono());
        cs.setString(7, p.getCorreo());
        cs.registerOutParameter(8, Types.INTEGER);

        cs.execute();

        int idGenerado = cs.getInt(8);
        p.setId(idGenerado);

        cs.close();
        con.close();
        return idGenerado;
    }
}
