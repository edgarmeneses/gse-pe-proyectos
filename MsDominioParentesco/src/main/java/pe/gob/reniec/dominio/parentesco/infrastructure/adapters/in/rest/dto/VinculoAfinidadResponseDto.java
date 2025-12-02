package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record VinculoAfinidadResponseDto(
    String idVinculoPosible,
    String idCiudadanoRelacionado,
    String nombreCompleto,
    String tipoParentesco,
    String descripcionParentesco,
    Integer gradoAfinidad,
    ConyugeIntermedioResponseDto conyugeIntermedio,
    ActaSustentoResponseDto actaSustento,
    Double nivelConfianza,
    String estadoConfirmacion,
    Boolean requiereValidacionManual,
    String observaciones
) {}
