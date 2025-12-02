package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record EstadisticasCompresionDto(
    String algoritmo,
    String nivelCompresion,
    int tamanioOriginal,
    int tamanioComprimido,
    float ratioCompresion
) {}
