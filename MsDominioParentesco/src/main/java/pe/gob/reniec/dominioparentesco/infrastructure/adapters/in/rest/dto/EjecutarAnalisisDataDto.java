package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO para los datos de ejecución del análisis de parentesco.
 */
public class EjecutarAnalisisDataDto {
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String codTipoVinculo;
    private Integer nivelComplejidad;
    private String estadoSolicitud;
    private CiudadanoAnalizadoDto ciudadanoAnalizado;
    private PoblacionVinculosPosiblesDto poblacionVinculosPosibles;
    private ResumenAnalisisDto resumenAnalisis;
    private List<InconsistenciaDto> inconsistencias;
    private List<ActaPendienteDigitalizacionDto> actasPendientesDigitalizacion;
    private LocalDateTime fechaSolicitud;
    private Long tiempoProcesamientoMs;
    private String usuarioTecnico;

    public EjecutarAnalisisDataDto() {}

    public String getIdSolicitud() { return idSolicitud; }
    public void setIdSolicitud(String idSolicitud) { this.idSolicitud = idSolicitud; }

    public String getIdCiudadanoConsultado() { return idCiudadanoConsultado; }
    public void setIdCiudadanoConsultado(String idCiudadanoConsultado) { this.idCiudadanoConsultado = idCiudadanoConsultado; }

    public String getCodTipoVinculo() { return codTipoVinculo; }
    public void setCodTipoVinculo(String codTipoVinculo) { this.codTipoVinculo = codTipoVinculo; }

    public Integer getNivelComplejidad() { return nivelComplejidad; }
    public void setNivelComplejidad(Integer nivelComplejidad) { this.nivelComplejidad = nivelComplejidad; }

    public String getEstadoSolicitud() { return estadoSolicitud; }
    public void setEstadoSolicitud(String estadoSolicitud) { this.estadoSolicitud = estadoSolicitud; }

    public CiudadanoAnalizadoDto getCiudadanoAnalizado() { return ciudadanoAnalizado; }
    public void setCiudadanoAnalizado(CiudadanoAnalizadoDto ciudadanoAnalizado) { this.ciudadanoAnalizado = ciudadanoAnalizado; }

    public PoblacionVinculosPosiblesDto getPoblacionVinculosPosibles() { return poblacionVinculosPosibles; }
    public void setPoblacionVinculosPosibles(PoblacionVinculosPosiblesDto poblacionVinculosPosibles) { this.poblacionVinculosPosibles = poblacionVinculosPosibles; }

    public ResumenAnalisisDto getResumenAnalisis() { return resumenAnalisis; }
    public void setResumenAnalisis(ResumenAnalisisDto resumenAnalisis) { this.resumenAnalisis = resumenAnalisis; }

    public List<InconsistenciaDto> getInconsistencias() { return inconsistencias; }
    public void setInconsistencias(List<InconsistenciaDto> inconsistencias) { this.inconsistencias = inconsistencias; }

    public List<ActaPendienteDigitalizacionDto> getActasPendientesDigitalizacion() { return actasPendientesDigitalizacion; }
    public void setActasPendientesDigitalizacion(List<ActaPendienteDigitalizacionDto> actasPendientesDigitalizacion) { this.actasPendientesDigitalizacion = actasPendientesDigitalizacion; }

    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public Long getTiempoProcesamientoMs() { return tiempoProcesamientoMs; }
    public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) { this.tiempoProcesamientoMs = tiempoProcesamientoMs; }

    public String getUsuarioTecnico() { return usuarioTecnico; }
    public void setUsuarioTecnico(String usuarioTecnico) { this.usuarioTecnico = usuarioTecnico; }
}
