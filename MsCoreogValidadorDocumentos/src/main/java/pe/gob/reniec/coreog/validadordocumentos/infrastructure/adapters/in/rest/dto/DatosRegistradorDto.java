package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa los datos del registrador en la respuesta
 */
public record DatosRegistradorDto(
    String codigoRegistrador,
    String nombreRegistrador,
    String documentoIdentidad,
    String oficinaRegistral,
    String periodoInicio,
    String periodoFin,
    Boolean enPeriodoVigencia
) {}
