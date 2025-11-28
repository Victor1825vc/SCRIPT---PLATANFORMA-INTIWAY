package model;

public class PreferenciaChat {

    private int idPreferencia;
    private String tipoTurismo;
    private String presupuesto;
    private String destino;
    private String comentario;

    public PreferenciaChat() {}

    public PreferenciaChat(String tipoTurismo, String presupuesto, String destino, String comentario) {
        this.tipoTurismo = tipoTurismo;
        this.presupuesto = presupuesto;
        this.destino = destino;
        this.comentario = comentario;
    }

    // Getters y setters
    public int getIdPreferencia() { return idPreferencia; }
    public void setIdPreferencia(int idPreferencia) { this.idPreferencia = idPreferencia; }

    public String getTipoTurismo() { return tipoTurismo; }
    public void setTipoTurismo(String tipoTurismo) { this.tipoTurismo = tipoTurismo; }

    public String getPresupuesto() { return presupuesto; }
    public void setPresupuesto(String presupuesto) { this.presupuesto = presupuesto; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
