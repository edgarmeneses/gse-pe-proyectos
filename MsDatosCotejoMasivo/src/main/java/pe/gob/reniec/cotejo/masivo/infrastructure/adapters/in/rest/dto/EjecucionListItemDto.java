package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EjecucionListItemDto(
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
    LocalDateTime fechaCreacion,
    String usuarioCreacion
) {}
