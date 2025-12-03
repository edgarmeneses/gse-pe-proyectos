package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record FirmaDigitalDto(
    String formato,
    String valorBase64,
    String dispositivoCaptura
) {}
