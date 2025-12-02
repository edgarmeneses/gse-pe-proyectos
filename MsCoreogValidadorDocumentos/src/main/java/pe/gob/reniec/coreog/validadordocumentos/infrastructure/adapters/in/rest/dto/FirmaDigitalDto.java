package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa una firma digital
 */
public record FirmaDigitalDto(
    String idFirma,
    String numeroSerieCertificado,
    String subjectDN,
    String algoritmoFirma,
    String fechaFirma,
    String huellaCertificado,
    String entidadCertificadora
) {}
