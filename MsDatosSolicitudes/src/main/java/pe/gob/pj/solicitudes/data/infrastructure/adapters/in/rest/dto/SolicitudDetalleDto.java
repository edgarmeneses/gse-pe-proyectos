package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO para respuesta detallada de una Solicitud individual
 * Usado en GET /solicitudes/{id}
 */
public final class SolicitudDetalleDto {
    private final String solicitudId;
    private final String numeroSolicitud;
    private final String estado;
    private final String tipoTramite;
    private final String subTipoTramite;
    private final String prioridad;
    private final String tipoSolicitante;

    // Solicitante
    private final SolicitanteDto solicitante;

    // Requisitos y datos específicos
    private final List<RequisitoCumplidoDto> requisitosCumplidos;
    private final DatosEspecificosTramiteDto datosEspecificosTramite;
    private final List<DocumentoAdjuntoDto> documentosAdjuntos;

    // Pago
    private final PagoDto pago;

    // Observaciones
    private final String observaciones;

    // Auditoría y seguimiento
    private final LocalDateTime fechaRegistro;
    private final LocalDateTime fechaVencimiento;
    private final String usuarioRegistro;
    private final String usuarioAsignado;
    private final OficinaRegistroDto oficinaRegistro;

    // Estimaciones y estado
    private final Long tiempoEstimadoResolucion;
    private final Boolean requiereDiligencia;

    // Campos calculados (presentación)
    private final Integer diasTranscurridos;
    private final Integer diasRestantes;
    private final String urlSeguimiento;
    private final List<SiguientePasoDto> siguientesPasos;

    public SolicitudDetalleDto(String solicitudId, String numeroSolicitud, String estado, String tipoTramite, String subTipoTramite, String prioridad, String tipoSolicitante, SolicitanteDto solicitante, List<RequisitoCumplidoDto> requisitosCumplidos, DatosEspecificosTramiteDto datosEspecificosTramite, List<DocumentoAdjuntoDto> documentosAdjuntos, PagoDto pago, String observaciones, LocalDateTime fechaRegistro, LocalDateTime fechaVencimiento, String usuarioRegistro, String usuarioAsignado, OficinaRegistroDto oficinaRegistro, Long tiempoEstimadoResolucion, Boolean requiereDiligencia, Integer diasTranscurridos, Integer diasRestantes, String urlSeguimiento, List<SiguientePasoDto> siguientesPasos) {
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.estado = estado;
        this.tipoTramite = tipoTramite;
        this.subTipoTramite = subTipoTramite;
        this.prioridad = prioridad;
        this.tipoSolicitante = tipoSolicitante;
        this.solicitante = solicitante;
        this.requisitosCumplidos = requisitosCumplidos;
        this.datosEspecificosTramite = datosEspecificosTramite;
        this.documentosAdjuntos = documentosAdjuntos;
        this.pago = pago;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
        this.fechaVencimiento = fechaVencimiento;
        this.usuarioRegistro = usuarioRegistro;
        this.usuarioAsignado = usuarioAsignado;
        this.oficinaRegistro = oficinaRegistro;
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
        this.requiereDiligencia = requiereDiligencia;
        this.diasTranscurridos = diasTranscurridos;
        this.diasRestantes = diasRestantes;
        this.urlSeguimiento = urlSeguimiento;
        this.siguientesPasos = siguientesPasos;
    }

    public String solicitudId() { return solicitudId; }
    public String numeroSolicitud() { return numeroSolicitud; }
    public String estado() { return estado; }
    public String tipoTramite() { return tipoTramite; }
    public String subTipoTramite() { return subTipoTramite; }
    public String prioridad() { return prioridad; }
    public String tipoSolicitante() { return tipoSolicitante; }
    public SolicitanteDto solicitante() { return solicitante; }
    public List<RequisitoCumplidoDto> requisitosCumplidos() { return requisitosCumplidos; }
    public DatosEspecificosTramiteDto datosEspecificosTramite() { return datosEspecificosTramite; }
    public List<DocumentoAdjuntoDto> documentosAdjuntos() { return documentosAdjuntos; }
    public PagoDto pago() { return pago; }
    public String observaciones() { return observaciones; }
    public LocalDateTime fechaRegistro() { return fechaRegistro; }
    public LocalDateTime fechaVencimiento() { return fechaVencimiento; }
    public String usuarioRegistro() { return usuarioRegistro; }
    public String usuarioAsignado() { return usuarioAsignado; }
    public OficinaRegistroDto oficinaRegistro() { return oficinaRegistro; }
    public Long tiempoEstimadoResolucion() { return tiempoEstimadoResolucion; }
    public Boolean requiereDiligencia() { return requiereDiligencia; }
    public Integer diasTranscurridos() { return diasTranscurridos; }
    public Integer diasRestantes() { return diasRestantes; }
    public String urlSeguimiento() { return urlSeguimiento; }
    public List<SiguientePasoDto> siguientesPasos() { return siguientesPasos; }
}
