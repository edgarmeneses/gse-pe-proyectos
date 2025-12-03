package pe.gob.sunat.sol.adaptadorpki.domain.ports.in;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Firma;

public interface FirmarDocumentoUseCase {
    Firma firmarDocumento(Firma firma);
}
