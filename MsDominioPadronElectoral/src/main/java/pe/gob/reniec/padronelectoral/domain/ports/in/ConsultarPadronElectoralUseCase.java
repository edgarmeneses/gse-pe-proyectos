package pe.gob.reniec.padronelectoral.domain.ports.in;

import pe.gob.reniec.padronelectoral.domain.model.Ciudadano;
import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import java.util.List;

public interface ConsultarPadronElectoralUseCase {
    PadronElectoral consultarPorId(String id, Integer page, Integer size);
    List<Ciudadano> obtenerCiudadanosPaginados(String id, Integer page, Integer size);
}
