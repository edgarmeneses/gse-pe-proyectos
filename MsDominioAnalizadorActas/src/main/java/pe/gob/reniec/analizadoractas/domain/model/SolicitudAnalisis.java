package pe.gob.reniec.analizadoractas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Value Object: Representa la solicitud de análisis de actas con sus criterios de búsqueda
 */
public class SolicitudAnalisis {

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String tipoEvento;
    private List<TipoActa> tipoActa;
    private OficinaRegistral oficinaRegistral;
    private Boolean inconsistenciasPrevias;

    public SolicitudAnalisis() {
    }

    public SolicitudAnalisis(LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoEvento,
                             List<TipoActa> tipoActa, OficinaRegistral oficinaRegistral,
                             Boolean inconsistenciasPrevias) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoEvento = tipoEvento;
        this.tipoActa = tipoActa;
        this.oficinaRegistral = oficinaRegistral;
        this.inconsistenciasPrevias = inconsistenciasPrevias;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<TipoActa> getTipoActa() {
        return tipoActa;
    }

    public void setTipoActa(List<TipoActa> tipoActa) {
        this.tipoActa = tipoActa;
    }

    public OficinaRegistral getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(OficinaRegistral oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }

    public Boolean getInconsistenciasPrevias() {
        return inconsistenciasPrevias;
    }

    public void setInconsistenciasPrevias(Boolean inconsistenciasPrevias) {
        this.inconsistenciasPrevias = inconsistenciasPrevias;
    }
}
