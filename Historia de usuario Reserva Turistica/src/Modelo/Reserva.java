package model;

public class Reserva {
    private int idReserva;
    private String tipoServicio;
    private String fechaReserva;
    private double costo;
    private int cantidadPersonas;
    private String destino;

    public Reserva() {}

    public Reserva(String tipoServicio, String fechaReserva, double costo, int cantidadPersonas, String destino) {
        this.tipoServicio = tipoServicio;
        this.fechaReserva = fechaReserva;
        this.costo = costo;
        this.cantidadPersonas = cantidadPersonas;
        this.destino = destino;
    }

    // Getters y Setters
    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }
    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public int getCantidadPersonas() { return cantidadPersonas; }
    public void setCantidadPersonas(int cantidadPersonas) { this.cantidadPersonas = cantidadPersonas; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
}
