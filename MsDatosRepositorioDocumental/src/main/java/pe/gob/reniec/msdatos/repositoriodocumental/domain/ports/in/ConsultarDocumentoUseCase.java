package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;

public interface ConsultarDocumentoUseCase {
    Documento consultarPorId(String id);
}
