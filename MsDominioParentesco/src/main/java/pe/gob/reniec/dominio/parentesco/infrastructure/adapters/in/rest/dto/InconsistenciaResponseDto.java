package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record InconsistenciaResponseDto(
    String tipo,
    String descripcion,
    List<String> ciudadanosInvolucrados,
    String severidad,
    String accionRecomendada
) {}
