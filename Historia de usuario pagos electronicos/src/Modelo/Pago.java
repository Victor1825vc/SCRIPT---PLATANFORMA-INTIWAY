package model;

public class Pago {
    private int id;
    private String cliente;
    private String metodoPago;
    private String servicio;
    private double monto;
    private String direccion;
    private String telefono;
    private String correo;

    public Pago() {}

    public Pago(String cliente, String metodoPago, String servicio, double monto,
                String direccion, String telefono, String correo) {
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.servicio = servicio;
        this.monto = monto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
