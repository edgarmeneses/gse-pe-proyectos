package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record ProteccionDocumentoDataDto(
    String proteccionId,
    String solicitudId,
    ArchivoProtegidoDto archivoProtegido,
    InformacionSeguridadDto seguridad,
    EstadisticasCompresionDto compresion,
    String estado,
    LocalDateTime fechaProcesamiento,
    LinksDto _links
) {}
