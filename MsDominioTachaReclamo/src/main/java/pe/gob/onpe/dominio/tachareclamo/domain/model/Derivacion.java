package pe.gob.onpe.dominio.tachareclamo.domain.model;

import java.time.LocalDateTime;

public class Derivacion {
    private Long id;
    private Long tachaReclamoId;
    private String areaOrigen;
    private String areaDestino;
    private String responsable;
    private String observaciones;
    private LocalDateTime fechaDerivacion;

    public Derivacion() {
    }

    public Derivacion(Long id, Long tachaReclamoId, String areaOrigen, String areaDestino,
                      String responsable, String observaciones, LocalDateTime fechaDerivacion) {
        this.id = id;
        this.tachaReclamoId = tachaReclamoId;
        this.areaOrigen = areaOrigen;
        this.areaDestino = areaDestino;
        this.responsable = responsable;
        this.observaciones = observaciones;
        this.fechaDerivacion = fechaDerivacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTachaReclamoId() {
        return tachaReclamoId;
    }

    public void setTachaReclamoId(Long tachaReclamoId) {
        this.tachaReclamoId = tachaReclamoId;
    }

    public String getAreaOrigen() {
        return areaOrigen;
    }

    public void setAreaOrigen(String areaOrigen) {
        this.areaOrigen = areaOrigen;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaDerivacion() {
        return fechaDerivacion;
    }

    public void setFechaDerivacion(LocalDateTime fechaDerivacion) {
        this.fechaDerivacion = fechaDerivacion;
    }
}
