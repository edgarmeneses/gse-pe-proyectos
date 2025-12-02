package pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ObtenerCertificadoDigitalResponseDto(
    Boolean success,
    Long statusCode,
    String message,
    DataDto data,
    MetadataDto metadata,
    ErrorDto error
) {
    public record DataDto(
        TransaccionDto transaccion,
        CiudadanoResumenDto ciudadano,
        List<CertificadoDto> certificados,
        PasosProcesoDto pasosProceso,
        AuditoriaDto auditoria
    ) {}

    public record TransaccionDto(
        String transaccionId,
        String codigoSolicitudTramite,
        String estado,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        Long tiempoProcesamientoMs
    ) {}

    public record CiudadanoResumenDto(
        String numeroDocumento,
        String nombreCompleto
    ) {}

    public record CertificadoDto(
        String tipoCertificado,
        String certificadoId,
        String numeroSerie,
        LocalDateTime fechaEmision,
        LocalDateTime fechaVencimiento,
        Long vigenciaAnios,
        String estadoCertificado,
        String algoritmoFirma,
        Long longitudClave,
        String subjectDN,
        String huellaCertificado,
        String certificadoBase64
    ) {}

    public record PasosProcesoDto(
        PasoProcesoDto paso1GeneracionClaves,
        PasoProcesoDto paso2EmisionCertificado
    ) {}

    public record PasoProcesoDto(
        String estado,
        String solicitudPkiId,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        Long intentos
    ) {}

    public record AuditoriaDto(
        String registroAuditoriaId,
        String usuarioEjecutor,
        String oficinaEjecucion,
        String ipCliente
    ) {}

    public record MetadataDto(
        LocalDateTime timestamp,
        String correlationId,
        String version,
        String tiempoRespuesta
    ) {}

    public record ErrorDto(
        String tipo,
        String titulo,
        Long estado,
        List<ErrorDetalleDto> errores
    ) {}

    public record ErrorDetalleDto(
        String detalleError
    ) {}
}
