package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EjecucionDetalleResponseDto(
    UUID ejecucionId,
    UUID solicitudId,
    String codigoOrganizacion,
    String nombreOrganizacion,
    String codigoEnvio,
    String numeroLote,
    String codigoEstado,
    String descripcionEstado,
    Integer totalRegistrosEntrada,
    Integer totalRegistrosProcesados,
    Integer totalRegistrosCorrectos,
    Integer totalRegistrosIncorrectos,
    LocalDateTime fechaInicioProceso,
    LocalDateTime fechaFinProceso,
    String documentoSustento,
    String observaciones,
    String urlReporteGenerado,
    String indicadorDomicilio,
    String codigoPrograma,
    ResumenResultadosDetalleDto resumenResultados,
    LocalDateTime fechaCreacion,
    String usuarioCreacion,
    LocalDateTime fechaModificacion,
    String usuarioModificacion,
    LinksDto links
) {}
