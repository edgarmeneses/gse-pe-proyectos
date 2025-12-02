package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record ActaSustentoResponseDto(
    String tipoActa,
    String numeroActa,
    LocalDate fechaRegistro,
    String oficinaRegistral
) {}
