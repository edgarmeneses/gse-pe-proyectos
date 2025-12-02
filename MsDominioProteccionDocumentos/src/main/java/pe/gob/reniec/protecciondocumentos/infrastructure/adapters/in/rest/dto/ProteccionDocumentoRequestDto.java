package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record ProteccionDocumentoRequestDto(
    String solicitudId,
    String tipoDocumento,
    String nombreArchivo,
    FuenteDocumentoDto fuenteDocumento,
    MetadatosSolicitudDto metadatos,
    ConfiguracionProteccionDto configuracionProteccion,
    DestinatarioDto destinatario
) {}
