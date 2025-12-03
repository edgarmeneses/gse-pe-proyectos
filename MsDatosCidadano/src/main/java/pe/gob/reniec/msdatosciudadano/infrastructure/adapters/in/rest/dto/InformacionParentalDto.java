package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record InformacionParentalDto(
    String primerNombrePaterno,
    String segundoNombrePaterno,
    String primerApellidoPaterno,
    String segundoApellidoPaterno,
    String primerNombreMaterno,
    String segundoNombreMaterno,
    String primerApellidoMaterno,
    String segundoApellidoMaterno,
    String tipoDocumentoPaterno,
    String numeroDocumentoPaterno,
    String tipoDocumentoMaterno,
    String numeroDocumentoMaterno
) {}
