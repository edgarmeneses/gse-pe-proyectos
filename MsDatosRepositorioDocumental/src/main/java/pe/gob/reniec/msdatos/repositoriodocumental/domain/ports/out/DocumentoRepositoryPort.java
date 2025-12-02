package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.List;
import java.util.Map;

public interface DocumentoRepositoryPort {
    Documento guardar(Documento documento);
    Documento buscarPorId(String id);
    Documento actualizar(Documento documento);
    List<Documento> listar(String queryParam1, String queryParam2, String queryParam3, 
                          Integer page, Integer size);
    List<Documento> buscarPorDni(String dni, String tipoDocumento, String fechaDesde, 
                                String fechaHasta, String estadoDocumento, 
                                Integer page, Integer size);
}
