package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record InformacionElectoralDto(
    Boolean inscritoVotacion,
    String departamentoVotacion,
    String provinciaVotacion,
    String distritoVotacion,
    String lugarVotacion
) {}
