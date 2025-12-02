package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record RegistradorListItemDto(
    String idRegistrador,
    String numeroDni,
    String nombreCompleto,
    String primerApellido,
    String segundoApellido,
    String prenombres,
    String codigoLocal,
    String descripcionLocal,
    String codigoEstadoRegistrador,
    String descripcionEstado,
    Boolean tieneFirmaRegistrada,
    Boolean tieneSellosRegistrado,
    LocalDateTime fechaCreacion,
    LinksDto _links
) {}
