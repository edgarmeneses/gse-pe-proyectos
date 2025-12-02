package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record MetadatosSolicitudDto(
    String tipoTramite,
    String numeroSolicitud,
    String dniSolicitante,
    LocalDateTime fechaGeneracion
) {}
