package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.util.List;

public final class DiligenciaRequestDto {
    private final String tipoDiligencia;
    private final String entidadDestino;
    private final String tipoEntidad;
    private final DatosContactoEntidadDto datosContactoEntidad;
    private final String motivoDiligencia;
    private final String fundamentoLegal;
    private final String informacionRequerida;
    private final List<DocumentoRequeridoDto> documentosRequeridos;
    private final Long plazoRespuesta;
    private final String unidadPlazo;
    private final String prioridad;
    private final Boolean requiereRespuestaOficial;
    private final Boolean permitoRespuestaDigital;
    private final String observaciones;
    private final String oficinaResponsableSeguimiento;

    public DiligenciaRequestDto(String tipoDiligencia, String entidadDestino, String tipoEntidad, DatosContactoEntidadDto datosContactoEntidad, String motivoDiligencia, String fundamentoLegal, String informacionRequerida, List<DocumentoRequeridoDto> documentosRequeridos, Long plazoRespuesta, String unidadPlazo, String prioridad, Boolean requiereRespuestaOficial, Boolean permitoRespuestaDigital, String observaciones, String oficinaResponsableSeguimiento) {
        this.tipoDiligencia = tipoDiligencia;
        this.entidadDestino = entidadDestino;
        this.tipoEntidad = tipoEntidad;
        this.datosContactoEntidad = datosContactoEntidad;
        this.motivoDiligencia = motivoDiligencia;
        this.fundamentoLegal = fundamentoLegal;
        this.informacionRequerida = informacionRequerida;
        this.documentosRequeridos = documentosRequeridos;
        this.plazoRespuesta = plazoRespuesta;
        this.unidadPlazo = unidadPlazo;
        this.prioridad = prioridad;
        this.requiereRespuestaOficial = requiereRespuestaOficial;
        this.permitoRespuestaDigital = permitoRespuestaDigital;
        this.observaciones = observaciones;
        this.oficinaResponsableSeguimiento = oficinaResponsableSeguimiento;
    }

    public String tipoDiligencia() { return tipoDiligencia; }
    public String entidadDestino() { return entidadDestino; }
    public String tipoEntidad() { return tipoEntidad; }
    public DatosContactoEntidadDto datosContactoEntidad() { return datosContactoEntidad; }
    public String motivoDiligencia() { return motivoDiligencia; }
    public String fundamentoLegal() { return fundamentoLegal; }
    public String informacionRequerida() { return informacionRequerida; }
    public java.util.List<DocumentoRequeridoDto> documentosRequeridos() { return documentosRequeridos; }
    public Long plazoRespuesta() { return plazoRespuesta; }
    public String unidadPlazo() { return unidadPlazo; }
    public String prioridad() { return prioridad; }
    public Boolean requiereRespuestaOficial() { return requiereRespuestaOficial; }
    public Boolean permitoRespuestaDigital() { return permitoRespuestaDigital; }
    public String observaciones() { return observaciones; }
    public String oficinaResponsableSeguimiento() { return oficinaResponsableSeguimiento; }
}
