package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public class VisitaRequestDto {
    private LocalDateTime fechaVisita;
    private String lugar;
    private String observaciones;
    private String responsable;

    public VisitaRequestDto() {
    }

    public VisitaRequestDto(LocalDateTime fechaVisita, String lugar, String observaciones, String responsable) {
        this.fechaVisita = fechaVisita;
        this.lugar = lugar;
        this.observaciones = observaciones;
        this.responsable = responsable;
    }

    public LocalDateTime getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDateTime fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
