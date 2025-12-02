package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record AsignacionActualDto(
    String codigoLocal,
    String descripcionLocal,
    String codigoEstadoRegistrador,
    String descripcionEstado,
    LocalDateTime fechaAsignacion
) {}
