package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatosciudadano.domain.model.CambioDomicilio;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CambioDomicilioRepositoryPort;
import java.util.List;

public class CambioDomicilioRepositoryAdapter implements CambioDomicilioRepositoryPort {

    @Override
    public List<CambioDomicilio> consultar(String fechaDesde, String fechaHasta, String circunscripcionId, 
                                           String queryParam1, String queryParam2, String queryParam3) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
