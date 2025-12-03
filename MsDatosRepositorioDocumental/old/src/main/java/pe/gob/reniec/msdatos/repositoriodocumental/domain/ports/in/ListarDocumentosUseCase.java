package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.List;

public interface ListarDocumentosUseCase {
    List<Documento> listar(String queryParam1, String queryParam2, String queryParam3, 
                          Integer page, Integer size);
}
