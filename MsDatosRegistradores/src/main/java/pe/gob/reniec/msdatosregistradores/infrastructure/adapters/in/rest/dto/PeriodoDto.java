package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record PeriodoDto(
    String idPeriodo,
    String codigoLocal,
    String descripcionLocal,
    LocalDate fechaInicio,
    LocalDate fechaFin,
    String estado
) {}
