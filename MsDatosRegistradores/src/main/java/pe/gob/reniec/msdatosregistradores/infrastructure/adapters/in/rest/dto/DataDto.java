package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record DataDto(
    String idRegistrador,
    String numeroDni,
    String nombreCompleto,
    String codigoLocal,
    String descripcionLocal,
    String codigoEstadoRegistrador,
    String descripcionEstado,
    LocalDateTime fechaRegistro,
    String usuarioRegistro,
    LinksDto _links
) {}
