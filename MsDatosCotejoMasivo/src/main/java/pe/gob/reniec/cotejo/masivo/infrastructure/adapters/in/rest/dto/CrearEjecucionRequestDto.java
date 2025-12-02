package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.UUID;

public record CrearEjecucionRequestDto(
    UUID solicitudId,
    String codigoOrganizacion,
    String nombreOrganizacion,
    String codigoEnvio,
    String numeroLote,
    Integer totalRegistrosEntrada,
    String documentoSustento,
    String observaciones,
    String indicadorDomicilio,
    String codigoPrograma
) {}
