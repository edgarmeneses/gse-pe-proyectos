package pe.gob.pj.solicitudes.data.domain.ports.out;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import java.util.List;

public interface DiligenciaRepositoryPort {
    Diligencia guardar(Diligencia diligencia);
    List<Diligencia> listarPorSolicitud(Long solicitudId);
}
