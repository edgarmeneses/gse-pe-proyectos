package pe.gob.sunat.sol.adaptadorpki.application.service;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.in.ConsultarCertificadoUseCase;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.out.PKIPort;

public class ConsultarCertificadoService implements ConsultarCertificadoUseCase {
    private final PKIPort pkiPort;

    public ConsultarCertificadoService(PKIPort pkiPort) {
        this.pkiPort = pkiPort;
    }

    @Override
    public Certificado consultarCertificado(String numeroCertificado) {
        return pkiPort.consultarCertificado(numeroCertificado);
    }
}
