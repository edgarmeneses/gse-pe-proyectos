package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper.EjecucionPersistenceMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class EjecucionRepositoryAdapter implements EjecucionRepositoryPort {

    @Override
    public Ejecucion guardar(Ejecucion ejecucion) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public Ejecucion buscarPorId(UUID ejecucionId) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public List<Ejecucion> listar(UUID solicitudId, String codigoOrganizacion, String codigoEnvio, 
                                  String codigoEstado, LocalDateTime fechaDesde, LocalDateTime fechaHasta, 
                                  Integer page, Integer size, String sort, String direction) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public Ejecucion actualizar(Ejecucion ejecucion) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }
}
