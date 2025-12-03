package pe.gob.pj.solicitudes.data.domain.ports.out;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import java.util.List;

public interface SolicitudRepositoryPort {
    Solicitud guardar(Solicitud solicitud);
    Solicitud buscarPorId(Long id);
    List<Solicitud> listar();
    Solicitud actualizar(Long id, Solicitud solicitud);
    Boolean existePorCriterio(String criterio);
}
