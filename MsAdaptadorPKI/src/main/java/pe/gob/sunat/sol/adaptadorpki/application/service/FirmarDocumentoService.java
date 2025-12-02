package pe.gob.sunat.sol.adaptadorpki.application.service;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Firma;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.in.FirmarDocumentoUseCase;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.out.PKIPort;

public class FirmarDocumentoService implements FirmarDocumentoUseCase {
    private final PKIPort pkiPort;

    public FirmarDocumentoService(PKIPort pkiPort) {
        this.pkiPort = pkiPort;
    }

    @Override
    public Firma firmarDocumento(Firma firma) {
        return pkiPort.firmarDocumento(firma);
    }
}
