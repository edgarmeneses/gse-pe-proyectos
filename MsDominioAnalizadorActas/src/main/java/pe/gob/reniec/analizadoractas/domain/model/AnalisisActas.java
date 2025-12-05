package pe.gob.reniec.analizadoractas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aggregate Root: Representa el análisis completo de actas registrales
 * mediante inteligencia artificial
 */
public class AnalisisActas {

    private String analisisId;
    private String numeroAnalisis;
    private LocalDateTime fechaEjecucion;
    private String estadoAnalisis;
    private CriteriosBusqueda criteriosBusqueda;
    private ResumenResultados resumenResultados;
    private List<ResultadoDetallado> resultadosDetallados;
    private UsuarioSolicitante usuarioSolicitante;

    public AnalisisActas() {
    }

    public AnalisisActas(String analisisId, String numeroAnalisis, LocalDateTime fechaEjecucion,
                         String estadoAnalisis, CriteriosBusqueda criteriosBusqueda,
                         ResumenResultados resumenResultados, List<ResultadoDetallado> resultadosDetallados,
                         UsuarioSolicitante usuarioSolicitante) {
        this.analisisId = analisisId;
        this.numeroAnalisis = numeroAnalisis;
        this.fechaEjecucion = fechaEjecucion;
        this.estadoAnalisis = estadoAnalisis;
        this.criteriosBusqueda = criteriosBusqueda;
        this.resumenResultados = resumenResultados;
        this.resultadosDetallados = resultadosDetallados;
        this.usuarioSolicitante = usuarioSolicitante;
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

    public LocalDateTime getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(LocalDateTime fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public String getEstadoAnalisis() {
        return estadoAnalisis;
    }

    public void setEstadoAnalisis(String estadoAnalisis) {
        this.estadoAnalisis = estadoAnalisis;
    }

    public CriteriosBusqueda getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(CriteriosBusqueda criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }

    public ResumenResultados getResumenResultados() {
        return resumenResultados;
    }

    public void setResumenResultados(ResumenResultados resumenResultados) {
        this.resumenResultados = resumenResultados;
    }

    public List<ResultadoDetallado> getResultadosDetallados() {
        return resultadosDetallados;
    }

    public void setResultadosDetallados(List<ResultadoDetallado> resultadosDetallados) {
        this.resultadosDetallados = resultadosDetallados;
    }

    public UsuarioSolicitante getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(UsuarioSolicitante usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }
}
