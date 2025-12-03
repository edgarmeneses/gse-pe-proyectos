package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record CrearAlertaRequestDto(
    String situacion,
    String ciudadanoId,
    String motivo,
    LocalDateTime fechaDeteccion,
    String circunscripcionId,
    String medioVerificacion,
    String documentoSoporteId,
    String equipoTrabajoId
) {}
