package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO Request para ejecutar análisis de parentesco.
 */
public class EjecutarAnalisisRequestDto {
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private DatosCiudadanoDto datosCiudadano;
    private String codTipoVinculo;
    private Integer nivelComplejidad;
    private CriteriosBusquedaDto criteriosBusqueda;
    private OpcionesAnalisisDto opcionesAnalisis;
    private String usuarioTecnico;
    private String observaciones;

    public EjecutarAnalisisRequestDto() {}

    public EjecutarAnalisisRequestDto(String idSolicitud, String idCiudadanoConsultado,
                                     DatosCiudadanoDto datosCiudadano, String codTipoVinculo,
                                     Integer nivelComplejidad, CriteriosBusquedaDto criteriosBusqueda,
                                     OpcionesAnalisisDto opcionesAnalisis, String usuarioTecnico,
                                     String observaciones) {
        this.idSolicitud = idSolicitud;
        this.idCiudadanoConsultado = idCiudadanoConsultado;
        this.datosCiudadano = datosCiudadano;
        this.codTipoVinculo = codTipoVinculo;
        this.nivelComplejidad = nivelComplejidad;
        this.criteriosBusqueda = criteriosBusqueda;
        this.opcionesAnalisis = opcionesAnalisis;
        this.usuarioTecnico = usuarioTecnico;
        this.observaciones = observaciones;
    }

    public String getIdSolicitud() { return idSolicitud; }
    public void setIdSolicitud(String idSolicitud) { this.idSolicitud = idSolicitud; }

    public String getIdCiudadanoConsultado() { return idCiudadanoConsultado; }
    public void setIdCiudadanoConsultado(String idCiudadanoConsultado) { this.idCiudadanoConsultado = idCiudadanoConsultado; }

    public DatosCiudadanoDto getDatosCiudadano() { return datosCiudadano; }
    public void setDatosCiudadano(DatosCiudadanoDto datosCiudadano) { this.datosCiudadano = datosCiudadano; }

    public String getCodTipoVinculo() { return codTipoVinculo; }
    public void setCodTipoVinculo(String codTipoVinculo) { this.codTipoVinculo = codTipoVinculo; }

    public Integer getNivelComplejidad() { return nivelComplejidad; }
    public void setNivelComplejidad(Integer nivelComplejidad) { this.nivelComplejidad = nivelComplejidad; }

    public CriteriosBusquedaDto getCriteriosBusqueda() { return criteriosBusqueda; }
    public void setCriteriosBusqueda(CriteriosBusquedaDto criteriosBusqueda) { this.criteriosBusqueda = criteriosBusqueda; }

    public OpcionesAnalisisDto getOpcionesAnalisis() { return opcionesAnalisis; }
    public void setOpcionesAnalisis(OpcionesAnalisisDto opcionesAnalisis) { this.opcionesAnalisis = opcionesAnalisis; }

    public String getUsuarioTecnico() { return usuarioTecnico; }
    public void setUsuarioTecnico(String usuarioTecnico) { this.usuarioTecnico = usuarioTecnico; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
