package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.List;

public interface ConsultarDocumentoPorDniUseCase {
    List<Documento> consultarPorDni(String dni, String tipoDocumento, String fechaDesde, 
                                   String fechaHasta, String estadoDocumento, 
                                   Integer page, Integer size);
}
