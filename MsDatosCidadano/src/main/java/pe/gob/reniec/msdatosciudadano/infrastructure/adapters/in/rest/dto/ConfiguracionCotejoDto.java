package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConfiguracionCotejoDto(
    List<String> camposACotejar,
    Double toleranciaCoincidencia,
    Boolean generarReporteDetallado
) {}
