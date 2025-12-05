package pe.gob.reniec.analizadoractas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Value Object: Representa los criterios utilizados para filtrar las actas a analizar
 */
public class CriteriosBusqueda {

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private List<String> tiposActa;
    private String oficinaRegistral;

    public CriteriosBusqueda() {
    }

    public CriteriosBusqueda(LocalDateTime fechaInicio, LocalDateTime fechaFin,
                             List<String> tiposActa, String oficinaRegistral) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiposActa = tiposActa;
        this.oficinaRegistral = oficinaRegistral;
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

    public List<String> getTiposActa() {
        return tiposActa;
    }

    public void setTiposActa(List<String> tiposActa) {
        this.tiposActa = tiposActa;
    }

    public String getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(String oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }
}
