package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Datos del análisis ejecutado
 */
public class AnalisisDataDto {

    private String analisisId;
    private String numeroAnalisis;
    private String fechaEjecucion;
    private String estadoAnalisis;
    private CriteriosBusquedaDto criteriosBusqueda;
    private ResumenResultadosDto resumenResultados;
    private List<ResultadoDetalladoDto> resultadosDetallados;
    private UsuarioSolicitanteDto usuarioSolicitante;
    private LinksDto links;

    public AnalisisDataDto() {
    }

    public String getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(String analisisId) {
        this.analisisId = analisisId;
    }

    public String getNumeroAnalisis() {
        return numeroAnalisis;
    }

    public void setNumeroAnalisis(String numeroAnalisis) {
        this.numeroAnalisis = numeroAnalisis;
    }

    public String getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(String fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public String getEstadoAnalisis() {
        return estadoAnalisis;
    }

    public void setEstadoAnalisis(String estadoAnalisis) {
        this.estadoAnalisis = estadoAnalisis;
    }

    public CriteriosBusquedaDto getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(CriteriosBusquedaDto criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }

    public ResumenResultadosDto getResumenResultados() {
        return resumenResultados;
    }

    public void setResumenResultados(ResumenResultadosDto resumenResultados) {
        this.resumenResultados = resumenResultados;
    }

    public List<ResultadoDetalladoDto> getResultadosDetallados() {
        return resultadosDetallados;
    }

    public void setResultadosDetallados(List<ResultadoDetalladoDto> resultadosDetallados) {
        this.resultadosDetallados = resultadosDetallados;
    }

    public UsuarioSolicitanteDto getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(UsuarioSolicitanteDto usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public LinksDto getLinks() {
        return links;
    }

    public void setLinks(LinksDto links) {
        this.links = links;
    }
}
