package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public final class DiligenciaResponseDto {
    private final String diligenciaId;
    private final String numeroDiligencia;
    private final String solicitudId;
    private final String numeroSolicitud;
    private final String estado;
    private final String tipoDiligencia;
    private final String entidadDestino;
    private final String motivoDiligencia;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaVencimiento;
    private final Long plazoRespuesta;
    private final Integer diasTranscurridos;
    private final Integer diasRestantes;
    private final String prioridad;
    private final OficinaResponsableDto oficinaResponsable;
    private final String usuarioSolicitante;
    private final String estadoOficio;
    private final List<DocumentoGeneradoDto> documentosGenerados;

    public DiligenciaResponseDto(String diligenciaId, String numeroDiligencia, String solicitudId, String numeroSolicitud, String estado, String tipoDiligencia, String entidadDestino, String motivoDiligencia, LocalDateTime fechaCreacion, LocalDateTime fechaVencimiento, Long plazoRespuesta, Integer diasTranscurridos, Integer diasRestantes, String prioridad, OficinaResponsableDto oficinaResponsable, String usuarioSolicitante, String estadoOficio, List<DocumentoGeneradoDto> documentosGenerados) {
        this.diligenciaId = diligenciaId;
        this.numeroDiligencia = numeroDiligencia;
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.estado = estado;
        this.tipoDiligencia = tipoDiligencia;
        this.entidadDestino = entidadDestino;
        this.motivoDiligencia = motivoDiligencia;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.plazoRespuesta = plazoRespuesta;
        this.diasTranscurridos = diasTranscurridos;
        this.diasRestantes = diasRestantes;
        this.prioridad = prioridad;
        this.oficinaResponsable = oficinaResponsable;
        this.usuarioSolicitante = usuarioSolicitante;
        this.estadoOficio = estadoOficio;
        this.documentosGenerados = documentosGenerados;
    }

    public String diligenciaId() { return diligenciaId; }
    public String numeroDiligencia() { return numeroDiligencia; }
    public String solicitudId() { return solicitudId; }
    public String numeroSolicitud() { return numeroSolicitud; }
    public String estado() { return estado; }
    public String tipoDiligencia() { return tipoDiligencia; }
    public String entidadDestino() { return entidadDestino; }
    public String motivoDiligencia() { return motivoDiligencia; }
    public LocalDateTime fechaCreacion() { return fechaCreacion; }
    public LocalDateTime fechaVencimiento() { return fechaVencimiento; }
    public Long plazoRespuesta() { return plazoRespuesta; }
    public Integer diasTranscurridos() { return diasTranscurridos; }
    public Integer diasRestantes() { return diasRestantes; }
    public String prioridad() { return prioridad; }
    public OficinaResponsableDto oficinaResponsable() { return oficinaResponsable; }
    public String usuarioSolicitante() { return usuarioSolicitante; }
    public String estadoOficio() { return estadoOficio; }
    public List<DocumentoGeneradoDto> documentosGenerados() { return documentosGenerados; }
}
