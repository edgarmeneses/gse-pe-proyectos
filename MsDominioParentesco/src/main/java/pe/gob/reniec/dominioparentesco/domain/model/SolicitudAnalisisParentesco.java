package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa una solicitud de análisis de parentesco.
 * Esta es la entrada del dominio para el caso de uso principal.
 */
public class SolicitudAnalisisParentesco {
    
    private final String idSolicitud;
    private final String idCiudadanoConsultado;
    private final DatosCiudadano datosCiudadano;
    private final String codTipoVinculo;
    private final Integer nivelComplejidad;
    private final CriteriosBusqueda criteriosBusqueda;
    private final OpcionesAnalisis opcionesAnalisis;
    private final String usuarioTecnico;
    private final String observaciones;
    
    private SolicitudAnalisisParentesco(Builder builder) {
        this.idSolicitud = Objects.requireNonNull(builder.idSolicitud, "El ID de solicitud no puede ser nulo");
        this.idCiudadanoConsultado = Objects.requireNonNull(builder.idCiudadanoConsultado, 
            "El ID del ciudadano no puede ser nulo");
        this.datosCiudadano = Objects.requireNonNull(builder.datosCiudadano, 
            "Los datos del ciudadano no pueden ser nulos");
        this.codTipoVinculo = Objects.requireNonNull(builder.codTipoVinculo, 
            "El código de tipo de vínculo no puede ser nulo");
        this.nivelComplejidad = Objects.requireNonNull(builder.nivelComplejidad, 
            "El nivel de complejidad no puede ser nulo");
        this.criteriosBusqueda = builder.criteriosBusqueda;
        this.opcionesAnalisis = builder.opcionesAnalisis;
        this.usuarioTecnico = Objects.requireNonNull(builder.usuarioTecnico, 
            "El usuario técnico no puede ser nulo");
        this.observaciones = builder.observaciones;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getIdSolicitud() { return idSolicitud; }
    public String getIdCiudadanoConsultado() { return idCiudadanoConsultado; }
    public DatosCiudadano getDatosCiudadano() { return datosCiudadano; }
    public String getCodTipoVinculo() { return codTipoVinculo; }
    public Integer getNivelComplejidad() { return nivelComplejidad; }
    public CriteriosBusqueda getCriteriosBusqueda() { return criteriosBusqueda; }
    public OpcionesAnalisis getOpcionesAnalisis() { return opcionesAnalisis; }
    public String getUsuarioTecnico() { return usuarioTecnico; }
    public String getObservaciones() { return observaciones; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudAnalisisParentesco that = (SolicitudAnalisisParentesco) o;
        return Objects.equals(idSolicitud, that.idSolicitud);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud);
    }
    
    @Override
    public String toString() {
        return "SolicitudAnalisisParentesco{" +
                "idSolicitud='" + idSolicitud + '\'' +
                ", idCiudadanoConsultado='" + idCiudadanoConsultado + '\'' +
                ", codTipoVinculo='" + codTipoVinculo + '\'' +
                '}';
    }
    
    public static class Builder {
        private String idSolicitud;
        private String idCiudadanoConsultado;
        private DatosCiudadano datosCiudadano;
        private String codTipoVinculo;
        private Integer nivelComplejidad;
        private CriteriosBusqueda criteriosBusqueda;
        private OpcionesAnalisis opcionesAnalisis;
        private String usuarioTecnico;
        private String observaciones;
        
        public Builder idSolicitud(String idSolicitud) { 
            this.idSolicitud = idSolicitud; 
            return this; 
        }
        public Builder idCiudadanoConsultado(String idCiudadanoConsultado) { 
            this.idCiudadanoConsultado = idCiudadanoConsultado; 
            return this; 
        }
        public Builder datosCiudadano(DatosCiudadano datosCiudadano) { 
            this.datosCiudadano = datosCiudadano; 
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
        public Builder criteriosBusqueda(CriteriosBusqueda criteriosBusqueda) { 
            this.criteriosBusqueda = criteriosBusqueda; 
            return this; 
        }
        public Builder opcionesAnalisis(OpcionesAnalisis opcionesAnalisis) { 
            this.opcionesAnalisis = opcionesAnalisis; 
            return this; 
        }
        public Builder usuarioTecnico(String usuarioTecnico) { 
            this.usuarioTecnico = usuarioTecnico; 
            return this; 
        }
        public Builder observaciones(String observaciones) { 
            this.observaciones = observaciones; 
            return this; 
        }
        
        public SolicitudAnalisisParentesco build() {
            return new SolicitudAnalisisParentesco(this);
        }
    }
}
