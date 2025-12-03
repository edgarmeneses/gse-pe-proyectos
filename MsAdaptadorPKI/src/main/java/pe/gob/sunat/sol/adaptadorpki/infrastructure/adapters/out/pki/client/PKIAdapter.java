package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.out.pki.client;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;
import pe.gob.sunat.sol.adaptadorpki.domain.model.Firma;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.out.PKIPort;

public class PKIAdapter implements PKIPort {

    @Override
    public Firma firmarDocumento(Firma firma) {
        throw new UnsupportedOperationException("Implementación pendiente: conexión con sistema PKI externo");
    }

    @Override
    public Certificado validarCertificado(Certificado certificado) {
        throw new UnsupportedOperationException("Implementación pendiente: conexión con sistema PKI externo");
    }

    @Override
    public Certificado consultarCertificado(String numeroCertificado) {
        throw new UnsupportedOperationException("Implementación pendiente: conexión con sistema PKI externo");
    }
}
