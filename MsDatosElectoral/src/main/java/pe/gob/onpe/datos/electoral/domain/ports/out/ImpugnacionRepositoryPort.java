package pe.gob.onpe.datos.electoral.domain.ports.out;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import java.util.List;

public interface ImpugnacionRepositoryPort {
    Impugnacion findById(Long id);
    List<Impugnacion> findAll();
}
