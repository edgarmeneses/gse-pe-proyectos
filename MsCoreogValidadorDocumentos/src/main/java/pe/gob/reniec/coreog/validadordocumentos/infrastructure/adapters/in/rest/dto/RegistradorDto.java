package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa un registrador
 */
public record RegistradorDto(
    String codigoRegistrador,
    String nombreRegistrador,
    String documentoIdentidad,
    String oficinaRegistral,
    String periodoInicio,
    String periodoFin
) {}
