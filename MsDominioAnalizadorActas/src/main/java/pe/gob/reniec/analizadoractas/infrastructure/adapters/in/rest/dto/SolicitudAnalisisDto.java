package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Criterios de búsqueda para el análisis de actas
 */
public class SolicitudAnalisisDto {

    private String fechaInicio;
    private String fechaFin;
    private String tipoEvento;
    private List<TipoActaDto> tipoActa;
    private OficinaRegistralDto oficinaRegistral;
    private Boolean inconsistenciasPrevias;

    public SolicitudAnalisisDto() {
    }

    public SolicitudAnalisisDto(String fechaInicio, String fechaFin, String tipoEvento,
                                List<TipoActaDto> tipoActa, OficinaRegistralDto oficinaRegistral,
                                Boolean inconsistenciasPrevias) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoEvento = tipoEvento;
        this.tipoActa = tipoActa;
        this.oficinaRegistral = oficinaRegistral;
        this.inconsistenciasPrevias = inconsistenciasPrevias;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<TipoActaDto> getTipoActa() {
        return tipoActa;
    }

    public void setTipoActa(List<TipoActaDto> tipoActa) {
        this.tipoActa = tipoActa;
    }

    public OficinaRegistralDto getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(OficinaRegistralDto oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }

    public Boolean getInconsistenciasPrevias() {
        return inconsistenciasPrevias;
    }

    public void setInconsistenciasPrevias(Boolean inconsistenciasPrevias) {
        this.inconsistenciasPrevias = inconsistenciasPrevias;
    }
}
