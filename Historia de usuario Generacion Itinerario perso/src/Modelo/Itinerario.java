package model;

public class Itinerario {
    private int id;
    private String tipoTurismo;
    private String actividades;
    private String duracion;
    private String costo;

    public Itinerario() {}

    public Itinerario(String tipoTurismo, String actividades, String duracion, String costo) {
        this.tipoTurismo = tipoTurismo;
        this.actividades = actividades;
        this.duracion = duracion;
        this.costo = costo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoTurismo() { return tipoTurismo; }
    public void setTipoTurismo(String tipoTurismo) { this.tipoTurismo = tipoTurismo; }

    public String getActividades() { return actividades; }
    public void setActividades(String actividades) { this.actividades = actividades; }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }

    public String getCosto() { return costo; }
    public void setCosto(String costo) { this.costo = costo; }
}
