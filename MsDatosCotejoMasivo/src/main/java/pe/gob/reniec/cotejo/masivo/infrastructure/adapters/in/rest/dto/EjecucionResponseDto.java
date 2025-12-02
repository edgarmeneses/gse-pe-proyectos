package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EjecucionResponseDto(
    UUID ejecucionId,
    UUID solicitudId,
    String codigoOrganizacion,
    String nombreOrganizacion,
    String codigoEnvio,
    String numeroLote,
    String codigoEstado,
    String descripcionEstado,
    Integer totalRegistrosEntrada,
    LocalDateTime fechaCreacion,
    String usuarioCreacion,
    LinksDto links
) {}
