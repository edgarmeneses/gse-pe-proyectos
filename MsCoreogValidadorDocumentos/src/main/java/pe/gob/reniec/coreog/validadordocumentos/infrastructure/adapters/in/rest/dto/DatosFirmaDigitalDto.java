package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa los datos de firma digital en la respuesta
 */
public record DatosFirmaDigitalDto(
    String idFirma,
    String numeroSerieCertificado,
    String subjectDN,
    String algoritmoFirma,
    String fechaFirma,
    String huellaCertificado,
    String entidadCertificadora
) {}
