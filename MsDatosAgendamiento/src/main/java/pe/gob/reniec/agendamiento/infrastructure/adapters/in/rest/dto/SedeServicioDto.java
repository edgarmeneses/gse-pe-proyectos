package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record SedeServicioDto(
    String codigoSede,
    String nombreSede,
    String direccion,
    String telefono,
    Long capacidadDiariaMaxima,
    Long tiempoAtencionMinutos
) {}
