package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record FuenteDocumentoDto(
    String tipo,
    String contenidoBase64,
    ReferenciaRepositorioDto referenciaRepositorio
) {}
