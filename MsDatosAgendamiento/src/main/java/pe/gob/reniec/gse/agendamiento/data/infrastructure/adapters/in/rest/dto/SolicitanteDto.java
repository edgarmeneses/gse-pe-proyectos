package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record SolicitanteDto(
    String dni,
    String nombres,
    String apellidoPaterno,
    String apellidoMaterno,
    String email,
    String telefono
) {}
