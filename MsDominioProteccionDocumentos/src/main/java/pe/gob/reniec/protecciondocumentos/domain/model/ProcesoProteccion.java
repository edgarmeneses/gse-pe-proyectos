package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class ProcesoProteccion {
    private String procesoId;
    private String solicitudId;
    private EstadoProceso estado;
    private LocalDateTime fechaProcesamiento;
    private List<DocumentoProtegido> documentosProtegidos;
    private ResultadoSeguridad resultadoSeguridad;
    private Estadisticas estadisticas;

    public ProcesoProteccion() {
    }

    public ProcesoProteccion(String procesoId, String solicitudId, EstadoProceso estado, 
                            LocalDateTime fechaProcesamiento, List<DocumentoProtegido> documentosProtegidos,
                            ResultadoSeguridad resultadoSeguridad, Estadisticas estadisticas) {
        this.procesoId = procesoId;
        this.solicitudId = solicitudId;
        this.estado = estado;
        this.fechaProcesamiento = fechaProcesamiento;
        this.documentosProtegidos = documentosProtegidos;
        this.resultadoSeguridad = resultadoSeguridad;
        this.estadisticas = estadisticas;
    }

    public String getProcesoId() {
        return procesoId;
    }

    public void setProcesoId(String procesoId) {
        this.procesoId = procesoId;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public EstadoProceso getEstado() {
        return estado;
    }

    public void setEstado(EstadoProceso estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public List<DocumentoProtegido> getDocumentosProtegidos() {
        return documentosProtegidos;
    }

    public void setDocumentosProtegidos(List<DocumentoProtegido> documentosProtegidos) {
        this.documentosProtegidos = documentosProtegidos;
    }

    public ResultadoSeguridad getResultadoSeguridad() {
        return resultadoSeguridad;
    }

    public void setResultadoSeguridad(ResultadoSeguridad resultadoSeguridad) {
        this.resultadoSeguridad = resultadoSeguridad;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }
}
