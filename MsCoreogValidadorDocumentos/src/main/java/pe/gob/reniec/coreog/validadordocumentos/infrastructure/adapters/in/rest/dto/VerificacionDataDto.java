package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record que representa los datos de verificación de firma
 */
public record VerificacionDataDto(
    String verificacionId,
    String solicitudId,
    String tramiteId,
    String documentoId,
    String fechaVerificacion,
    ResultadoVerificacionDto resultadoVerificacion,
    DatosRegistradorDto datosRegistrador,
    DatosFirmaDigitalDto datosFirmaDigital,
    List<AlertaDto> alertas
) {}
