package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import java.util.List;

public interface ListarImpugnacionesUseCase {
    List<Impugnacion> listar();
}
