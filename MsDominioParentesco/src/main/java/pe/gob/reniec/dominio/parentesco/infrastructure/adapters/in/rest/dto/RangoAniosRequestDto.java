package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record RangoAniosRequestDto(
    Integer anioInicio,
    Integer anioFin
) {}
