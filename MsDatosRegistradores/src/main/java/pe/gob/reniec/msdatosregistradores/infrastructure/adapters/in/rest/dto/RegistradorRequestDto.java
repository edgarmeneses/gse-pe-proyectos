package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

public record RegistradorRequestDto(
    String idRegistrador,
    String numeroDni,
    String primerApellido,
    String segundoApellido,
    String prenombres,
    String codigoLocal,
    String tipoRegistrador,
    String observaciones
) {}
