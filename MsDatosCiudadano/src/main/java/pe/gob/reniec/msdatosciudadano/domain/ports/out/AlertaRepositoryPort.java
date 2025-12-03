package pe.gob.reniec.msdatosciudadano.domain.ports.out;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import java.util.List;

public interface AlertaRepositoryPort {
    String guardar(Alerta alerta);
    Alerta buscarPorId(String alertaId);
    List<Alerta> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3);
}
