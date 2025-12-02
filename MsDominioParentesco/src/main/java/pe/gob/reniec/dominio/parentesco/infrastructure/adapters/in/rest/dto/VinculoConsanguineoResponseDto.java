package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record VinculoConsanguineoResponseDto(
    String idVinculoPosible,
    String idCiudadanoRelacionado,
    String nombreCompleto,
    String tipoParentesco,
    String descripcionParentesco,
    Integer gradoConsanguinidad,
    String lineaParentesco,
    ActaSustentoResponseDto actaSustento,
    Double nivelConfianza,
    String estadoConfirmacion,
    Boolean requiereValidacionManual,
    String observaciones
) {}
