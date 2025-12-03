package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record HuellaDactilarDto(
    String nombreDedo,
    String formato,
    String valorBase64
) {}
