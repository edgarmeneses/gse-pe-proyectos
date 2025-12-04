package pe.gob.onpe.datos.electoral.domain.ports.out;

import pe.gob.onpe.datos.electoral.domain.model.InformeFinal;

public interface InformeFinalRepositoryPort {
    InformeFinal save(InformeFinal informeFinal);
}
