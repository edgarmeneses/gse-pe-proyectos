package pe.gob.sunat.sol.adaptadorpki.domain.ports.in;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;

public interface ValidarCertificadoUseCase {
    Certificado validarCertificado(Certificado certificado);
}
