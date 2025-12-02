package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultaPaquetesResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        List<PaqueteDto> paquetes,
        ResumenDto resumen,
        PaginacionDto paginacion
    ) {}
}
