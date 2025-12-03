package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record FotografiaDto(
    String formato,
    String valorBase64,
    String resolucion,
    String modoCaptura
) {}
