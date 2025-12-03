package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record de petición para verificar firma del registrador
 */
public record VerificarFirmaRequestDto(
    String solicitudId,
    String tramiteId,
    String tipoTramite,
    DocumentoDto documento,
    RegistradorDto registrador,
    FirmaDigitalDto firmaDigital,
    ParametrosValidacionFirmaDto parametrosValidacionFirma,
    String usuarioSolicita,
    String oficinaOrigen,
    String fechaSolicitud,
    String observaciones
) {}
