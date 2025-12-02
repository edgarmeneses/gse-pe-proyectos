package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record PaqueteDto(
    String paqueteId,
    String codigoPaquete,
    String idPadron,
    String tipoPadron,
    String codigoCronogramaElectoral,
    String tipoProcesoElectoral,
    UbicacionDto ubicacion,
    String estadoPaquete,
    LocalDateTime fechaGeneracion,
    LocalDateTime fechaUltimaActualizacion,
    String usuarioUltimaActualizacion,
    int totalCiudadanos,
    int totalImagenes,
    Long tamanioArchivoPDF,
    Long tamanioArchivoDatos,
    String hashIntegridad,
    String rutaArchivoPDF,
    String rutaArchivoDatos,
    String rutaArchivoImagenes,
    InformacionPublicacionDto informacionPublicacion,
    AprobacionDto aprobacion,
    LinksDto links
) {}
