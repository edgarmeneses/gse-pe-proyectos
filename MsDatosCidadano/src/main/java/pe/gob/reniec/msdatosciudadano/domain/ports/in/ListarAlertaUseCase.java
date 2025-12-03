package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import java.util.List;

public interface ListarAlertaUseCase {
    List<Alerta> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields);
}
