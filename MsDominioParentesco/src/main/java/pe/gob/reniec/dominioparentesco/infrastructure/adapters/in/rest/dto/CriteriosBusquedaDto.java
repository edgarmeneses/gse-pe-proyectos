package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para los criterios de búsqueda del análisis.
 */
public class CriteriosBusquedaDto {
    private RangoAniosDto rangoAniosPadres;
    private RangoAniosDto rangoAniosHijos;
    private List<String> variacionesNombre;
    private Boolean incluirFallecidos;
    private Boolean incluirActasAnuladas;

    public CriteriosBusquedaDto() {}

    public CriteriosBusquedaDto(RangoAniosDto rangoAniosPadres, RangoAniosDto rangoAniosHijos,
                               List<String> variacionesNombre, Boolean incluirFallecidos,
                               Boolean incluirActasAnuladas) {
        this.rangoAniosPadres = rangoAniosPadres;
        this.rangoAniosHijos = rangoAniosHijos;
        this.variacionesNombre = variacionesNombre;
        this.incluirFallecidos = incluirFallecidos;
        this.incluirActasAnuladas = incluirActasAnuladas;
    }

    public RangoAniosDto getRangoAniosPadres() { return rangoAniosPadres; }
    public void setRangoAniosPadres(RangoAniosDto rangoAniosPadres) { this.rangoAniosPadres = rangoAniosPadres; }

    public RangoAniosDto getRangoAniosHijos() { return rangoAniosHijos; }
    public void setRangoAniosHijos(RangoAniosDto rangoAniosHijos) { this.rangoAniosHijos = rangoAniosHijos; }

    public List<String> getVariacionesNombre() { return variacionesNombre; }
    public void setVariacionesNombre(List<String> variacionesNombre) { this.variacionesNombre = variacionesNombre; }

    public Boolean getIncluirFallecidos() { return incluirFallecidos; }
    public void setIncluirFallecidos(Boolean incluirFallecidos) { this.incluirFallecidos = incluirFallecidos; }

    public Boolean getIncluirActasAnuladas() { return incluirActasAnuladas; }
    public void setIncluirActasAnuladas(Boolean incluirActasAnuladas) { this.incluirActasAnuladas = incluirActasAnuladas; }
}
