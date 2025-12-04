package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate Root - Representa el resultado completo de un análisis de parentesco.
 * Contiene todos los vínculos encontrados, resumen estadístico e inconsistencias.
 */
public class ResultadoAnalisisParentesco {
    
    private final String idSolicitud;
    private final String idCiudadanoConsultado;
    private final String codTipoVinculo;
    private final Integer nivelComplejidad;
    private final String estadoSolicitud;
    private final CiudadanoAnalizado ciudadanoAnalizado;
    private final PoblacionVinculosPosibles poblacionVinculosPosibles;
    private final ResumenAnalisis resumenAnalisis;
    private final List<Inconsistencia> inconsistencias;
    private final List<ActaPendienteDigitalizacion> actasPendientesDigitalizacion;
    private final LocalDateTime fechaSolicitud;
    private final Long tiempoProcesamientoMs;
    private final String usuarioTecnico;
    
    private ResultadoAnalisisParentesco(Builder builder) {
        this.idSolicitud = Objects.requireNonNull(builder.idSolicitud, "El ID de solicitud no puede ser nulo");
        this.idCiudadanoConsultado = Objects.requireNonNull(builder.idCiudadanoConsultado, 
            "El ID del ciudadano no puede ser nulo");
        this.codTipoVinculo = Objects.requireNonNull(builder.codTipoVinculo, 
            "El código de tipo de vínculo no puede ser nulo");
        this.nivelComplejidad = Objects.requireNonNull(builder.nivelComplejidad, 
            "El nivel de complejidad no puede ser nulo");
        this.estadoSolicitud = Objects.requireNonNull(builder.estadoSolicitud, 
            "El estado de solicitud no puede ser nulo");
        this.ciudadanoAnalizado = Objects.requireNonNull(builder.ciudadanoAnalizado, 
            "El ciudadano analizado no puede ser nulo");
        this.poblacionVinculosPosibles = Objects.requireNonNull(builder.poblacionVinculosPosibles, 
            "La población de vínculos no puede ser nula");
        this.resumenAnalisis = Objects.requireNonNull(builder.resumenAnalisis, 
            "El resumen de análisis no puede ser nulo");
        this.inconsistencias = builder.inconsistencias != null ? 
            List.copyOf(builder.inconsistencias) : List.of();
        this.actasPendientesDigitalizacion = builder.actasPendientesDigitalizacion != null ? 
            List.copyOf(builder.actasPendientesDigitalizacion) : List.of();
        this.fechaSolicitud = Objects.requireNonNull(builder.fechaSolicitud, 
            "La fecha de solicitud no puede ser nula");
        this.tiempoProcesamientoMs = Objects.requireNonNull(builder.tiempoProcesamientoMs, 
            "El tiempo de procesamiento no puede ser nulo");
        this.usuarioTecnico = Objects.requireNonNull(builder.usuarioTecnico, 
            "El usuario técnico no puede ser nulo");
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getIdSolicitud() { return idSolicitud; }
    public String getIdCiudadanoConsultado() { return idCiudadanoConsultado; }
    public String getCodTipoVinculo() { return codTipoVinculo; }
    public Integer getNivelComplejidad() { return nivelComplejidad; }
    public String getEstadoSolicitud() { return estadoSolicitud; }
    public CiudadanoAnalizado getCiudadanoAnalizado() { return ciudadanoAnalizado; }
    public PoblacionVinculosPosibles getPoblacionVinculosPosibles() { return poblacionVinculosPosibles; }
    public ResumenAnalisis getResumenAnalisis() { return resumenAnalisis; }
    public List<Inconsistencia> getInconsistencias() { return inconsistencias; }
    public List<ActaPendienteDigitalizacion> getActasPendientesDigitalizacion() { return actasPendientesDigitalizacion; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public Long getTiempoProcesamientoMs() { return tiempoProcesamientoMs; }
    public String getUsuarioTecnico() { return usuarioTecnico; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoAnalisisParentesco that = (ResultadoAnalisisParentesco) o;
        return Objects.equals(idSolicitud, that.idSolicitud) &&
               Objects.equals(idCiudadanoConsultado, that.idCiudadanoConsultado);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, idCiudadanoConsultado);
    }
    
    @Override
    public String toString() {
        return "ResultadoAnalisisParentesco{" +
                "idSolicitud='" + idSolicitud + '\'' +
                ", idCiudadanoConsultado='" + idCiudadanoConsultado + '\'' +
                ", codTipoVinculo='" + codTipoVinculo + '\'' +
                ", estadoSolicitud='" + estadoSolicitud + '\'' +
                '}';
    }
    
    public static class Builder {
        private String idSolicitud;
        private String idCiudadanoConsultado;
        private String codTipoVinculo;
        private Integer nivelComplejidad;
        private String estadoSolicitud;
        private CiudadanoAnalizado ciudadanoAnalizado;
        private PoblacionVinculosPosibles poblacionVinculosPosibles;
        private ResumenAnalisis resumenAnalisis;
        private List<Inconsistencia> inconsistencias;
        private List<ActaPendienteDigitalizacion> actasPendientesDigitalizacion;
        private LocalDateTime fechaSolicitud;
        private Long tiempoProcesamientoMs;
        private String usuarioTecnico;
        
        public Builder idSolicitud(String idSolicitud) { 
            this.idSolicitud = idSolicitud; 
            return this; 
        }
        public Builder idCiudadanoConsultado(String idCiudadanoConsultado) { 
            this.idCiudadanoConsultado = idCiudadanoConsultado; 
            return this; 
        }
        public Builder codTipoVinculo(String codTipoVinculo) { 
            this.codTipoVinculo = codTipoVinculo; 
            return this; 
        }
        public Builder nivelComplejidad(Integer nivelComplejidad) { 
            this.nivelComplejidad = nivelComplejidad; 
            return this; 
        }
        public Builder estadoSolicitud(String estadoSolicitud) { 
            this.estadoSolicitud = estadoSolicitud; 
            return this; 
        }
        public Builder ciudadanoAnalizado(CiudadanoAnalizado ciudadanoAnalizado) { 
            this.ciudadanoAnalizado = ciudadanoAnalizado; 
            return this; 
        }
        public Builder poblacionVinculosPosibles(PoblacionVinculosPosibles poblacionVinculosPosibles) { 
            this.poblacionVinculosPosibles = poblacionVinculosPosibles; 
            return this; 
        }
        public Builder resumenAnalisis(ResumenAnalisis resumenAnalisis) { 
            this.resumenAnalisis = resumenAnalisis; 
            return this; 
        }
        public Builder inconsistencias(List<Inconsistencia> inconsistencias) { 
            this.inconsistencias = inconsistencias; 
            return this; 
        }
        public Builder actasPendientesDigitalizacion(List<ActaPendienteDigitalizacion> actasPendientesDigitalizacion) { 
            this.actasPendientesDigitalizacion = actasPendientesDigitalizacion; 
            return this; 
        }
        public Builder fechaSolicitud(LocalDateTime fechaSolicitud) { 
            this.fechaSolicitud = fechaSolicitud; 
            return this; 
        }
        public Builder tiempoProcesamientoMs(Long tiempoProcesamientoMs) { 
            this.tiempoProcesamientoMs = tiempoProcesamientoMs; 
            return this; 
        }
        public Builder usuarioTecnico(String usuarioTecnico) { 
            this.usuarioTecnico = usuarioTecnico; 
            return this; 
        }
        
        public ResultadoAnalisisParentesco build() {
            return new ResultadoAnalisisParentesco(this);
        }
    }
}
