package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.List;
import java.util.Map;

public interface ConsultarCarpetaUseCase {
    Map<String, Object> consultarContenido(String id, String queryParam1, String queryParam2, 
                                           String queryParam3, Integer page, Integer size);
}
