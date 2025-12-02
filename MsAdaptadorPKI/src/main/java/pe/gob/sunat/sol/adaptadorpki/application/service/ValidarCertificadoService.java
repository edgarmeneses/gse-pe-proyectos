package pe.gob.sunat.sol.adaptadorpki.application.service;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.in.ValidarCertificadoUseCase;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.out.PKIPort;

public class ValidarCertificadoService implements ValidarCertificadoUseCase {
    private final PKIPort pkiPort;

    public ValidarCertificadoService(PKIPort pkiPort) {
        this.pkiPort = pkiPort;
    }

    @Override
    public Certificado validarCertificado(Certificado certificado) {
        return pkiPort.validarCertificado(certificado);
    }
}
