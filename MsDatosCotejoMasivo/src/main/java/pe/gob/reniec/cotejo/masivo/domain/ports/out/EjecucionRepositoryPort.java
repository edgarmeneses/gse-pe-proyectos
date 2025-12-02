package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EjecucionRepositoryPort {
    Ejecucion guardar(Ejecucion ejecucion);
    Ejecucion buscarPorId(UUID ejecucionId);
    List<Ejecucion> listar(UUID solicitudId, String codigoOrganizacion, String codigoEnvio, 
                           String codigoEstado, LocalDateTime fechaDesde, LocalDateTime fechaHasta, 
                           Integer page, Integer size, String sort, String direction);
    Ejecucion actualizar(Ejecucion ejecucion);
}
