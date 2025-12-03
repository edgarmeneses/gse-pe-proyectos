package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import java.util.List;

public interface ListarSolicitudesUseCase {
    List<Solicitud> listar();
}
