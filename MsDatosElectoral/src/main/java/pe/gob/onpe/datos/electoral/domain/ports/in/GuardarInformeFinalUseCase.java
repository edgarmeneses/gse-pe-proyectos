package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.InformeFinal;

public interface GuardarInformeFinalUseCase {
    InformeFinal guardar(InformeFinal informeFinal);
}
