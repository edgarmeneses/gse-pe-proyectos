package pe.gob.sunat.sol.adaptadorpki.domain.ports.out;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;
import pe.gob.sunat.sol.adaptadorpki.domain.model.Firma;

public interface PKIPort {
    Firma firmarDocumento(Firma firma);
    Certificado validarCertificado(Certificado certificado);
    Certificado consultarCertificado(String numeroCertificado);
}
