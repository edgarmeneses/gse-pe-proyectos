package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record CrearAlertaRequestDto(
    Situacion situacion,
    String ciudadanoId,
    String motivo,
    LocalDateTime fechaDeteccion,
    String circunscripcionId,
    MedioVerificacion medioVerificacion,
    String documentoSoporteId,
    String equipoTrabajoId
) {}
