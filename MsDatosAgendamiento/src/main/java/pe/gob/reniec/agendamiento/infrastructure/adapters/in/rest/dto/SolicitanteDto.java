package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record SolicitanteDto(
    String dni,
    String nombres,
    String apellidoPaterno,
    String apellidoMaterno,
    String nombreCompleto,
    String email,
    String telefono
) {}
