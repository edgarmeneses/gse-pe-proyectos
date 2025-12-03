package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatosciudadano.domain.model.InformePericial;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.InformePericialRepositoryPort;
import java.util.List;

public class InformePericialRepositoryAdapter implements InformePericialRepositoryPort {

    @Override
    public List<InformePericial> buscarPorDocumento(String tipoDocumento, String numeroDocumento) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
