package model;

public class Proveedor {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String empresa;
    private String tipoProveedor;

    public Proveedor() {}

    public Proveedor(String nombre, String correo, String telefono,
                     String direccion, String empresa, String tipoProveedor) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empresa = empresa;
        this.tipoProveedor = tipoProveedor;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getTipoProveedor() { return tipoProveedor; }
    public void setTipoProveedor(String tipoProveedor) { this.tipoProveedor = tipoProveedor; }
}

