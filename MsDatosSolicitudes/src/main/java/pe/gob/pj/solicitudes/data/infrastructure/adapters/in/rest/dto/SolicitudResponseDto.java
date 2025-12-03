package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para respuesta de Solicitud individual
 * Este DTO representa un item en la lista de data de la respuesta API
 */
public final class SolicitudResponseDto {
    private final String solicitudId;
    private final String numeroSolicitud;
    private final String estado;
    private final String tipoTramite;
    private final String subTipoTramite;
    private final String dniSolicitante;
    private final String nombresSolicitante;
    private final LocalDateTime fechaRegistro;
    private final LocalDateTime fechaVencimiento;
    private final String prioridad;
    private final String usuarioAsignado;
    private final String oficinaRegistro;
    private final Integer diasTranscurridos;
    private final Integer diasRestantes;

    public SolicitudResponseDto(String solicitudId, String numeroSolicitud, String estado, String tipoTramite, String subTipoTramite, String dniSolicitante, String nombresSolicitante, LocalDateTime fechaRegistro, LocalDateTime fechaVencimiento, String prioridad, String usuarioAsignado, String oficinaRegistro, Integer diasTranscurridos, Integer diasRestantes) {
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.estado = estado;
        this.tipoTramite = tipoTramite;
        this.subTipoTramite = subTipoTramite;
        this.dniSolicitante = dniSolicitante;
        this.nombresSolicitante = nombresSolicitante;
        this.fechaRegistro = fechaRegistro;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.usuarioAsignado = usuarioAsignado;
        this.oficinaRegistro = oficinaRegistro;
        this.diasTranscurridos = diasTranscurridos;
        this.diasRestantes = diasRestantes;
    }

    public String solicitudId() { return solicitudId; }
    public String numeroSolicitud() { return numeroSolicitud; }
    public String estado() { return estado; }
    public String tipoTramite() { return tipoTramite; }
    public String subTipoTramite() { return subTipoTramite; }
    public String dniSolicitante() { return dniSolicitante; }
    public String nombresSolicitante() { return nombresSolicitante; }
    public LocalDateTime fechaRegistro() { return fechaRegistro; }
    public LocalDateTime fechaVencimiento() { return fechaVencimiento; }
    public String prioridad() { return prioridad; }
    public String usuarioAsignado() { return usuarioAsignado; }
    public String oficinaRegistro() { return oficinaRegistro; }
    public Integer diasTranscurridos() { return diasTranscurridos; }
    public Integer diasRestantes() { return diasRestantes; }
}
