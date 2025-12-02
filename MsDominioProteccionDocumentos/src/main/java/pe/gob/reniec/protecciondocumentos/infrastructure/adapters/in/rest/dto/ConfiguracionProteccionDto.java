package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record ConfiguracionProteccionDto(
    Boolean usarConfiguracionPorDefecto,
    String algoritmoCompresion,
    String nivelCompresion
) {}
