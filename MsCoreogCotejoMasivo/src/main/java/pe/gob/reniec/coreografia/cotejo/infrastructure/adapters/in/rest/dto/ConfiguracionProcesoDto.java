package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record ConfiguracionProcesoDto(
    Boolean notificarProgreso,
    Boolean generarReporteDetallado,
    String formatoReporte
) {}
