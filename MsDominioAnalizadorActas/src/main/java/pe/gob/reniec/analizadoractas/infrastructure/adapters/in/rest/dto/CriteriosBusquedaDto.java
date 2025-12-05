package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Criterios utilizados para el análisis
 */
public class CriteriosBusquedaDto {

    private String fechaInicio;
    private String fechaFin;
    private List<String> tiposActa;
    private String oficinaRegistral;

    public CriteriosBusquedaDto() {
    }

    public CriteriosBusquedaDto(String fechaInicio, String fechaFin, List<String> tiposActa, String oficinaRegistral) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiposActa = tiposActa;
        this.oficinaRegistral = oficinaRegistral;
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
