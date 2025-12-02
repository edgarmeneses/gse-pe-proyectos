package pe.gob.reniec.dominio.parentesco.domain.model;

public class SolicitudAnalisisParentesco {
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private DatosCiudadano datosCiudadano;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private CriteriosBusqueda criteriosBusqueda;
    private OpcionesAnalisis opcionesAnalisis;
    private String usuarioTecnico;
    private String observaciones;

    public SolicitudAnalisisParentesco() {
    }

    public SolicitudAnalisisParentesco(String idSolicitud, String idCiudadanoConsultado,
                                      DatosCiudadano datosCiudadano, String tipoVinculo,
                                      Integer nivelComplejidad, CriteriosBusqueda criteriosBusqueda,
                                      OpcionesAnalisis opcionesAnalisis, String usuarioTecnico,
                                      String observaciones) {
        this.idSolicitud = idSolicitud;
        this.idCiudadanoConsultado = idCiudadanoConsultado;
        this.datosCiudadano = datosCiudadano;
        this.tipoVinculo = tipoVinculo;
        this.nivelComplejidad = nivelComplejidad;
        this.criteriosBusqueda = criteriosBusqueda;
        this.opcionesAnalisis = opcionesAnalisis;
        this.usuarioTecnico = usuarioTecnico;
        this.observaciones = observaciones;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getIdCiudadanoConsultado() {
        return idCiudadanoConsultado;
    }

    public void setIdCiudadanoConsultado(String idCiudadanoConsultado) {
        this.idCiudadanoConsultado = idCiudadanoConsultado;
    }

    public DatosCiudadano getDatosCiudadano() {
        return datosCiudadano;
    }

    public void setDatosCiudadano(DatosCiudadano datosCiudadano) {
        this.datosCiudadano = datosCiudadano;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public Integer getNivelComplejidad() {
        return nivelComplejidad;
    }

    public void setNivelComplejidad(Integer nivelComplejidad) {
        this.nivelComplejidad = nivelComplejidad;
    }

    public CriteriosBusqueda getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(CriteriosBusqueda criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }

    public OpcionesAnalisis getOpcionesAnalisis() {
        return opcionesAnalisis;
    }

    public void setOpcionesAnalisis(OpcionesAnalisis opcionesAnalisis) {
        this.opcionesAnalisis = opcionesAnalisis;
    }

    public String getUsuarioTecnico() {
        return usuarioTecnico;
    }

    public void setUsuarioTecnico(String usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
