package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import java.util.List;

public interface VerTrazabilidadUseCase {
    List<Trazabilidad> ver(Long solicitudId);
}
