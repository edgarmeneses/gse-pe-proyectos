package pe.gob.pj.solicitudes.data.domain.ports.out;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import java.util.List;

public interface TrazabilidadRepositoryPort {
    Trazabilidad guardar(Trazabilidad trazabilidad);
    List<Trazabilidad> listarPorSolicitud(Long solicitudId);
}
