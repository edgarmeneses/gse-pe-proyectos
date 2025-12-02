package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ListarEjecucionesService implements ListarEjecucionesUseCase {
    private final EjecucionRepositoryPort ejecucionRepositoryPort;

    public ListarEjecucionesService(EjecucionRepositoryPort ejecucionRepositoryPort) {
        this.ejecucionRepositoryPort = ejecucionRepositoryPort;
    }

    @Override
    public List<Ejecucion> listar(UUID solicitudId, String codigoOrganizacion, String codigoEnvio, 
                                  String codigoEstado, LocalDateTime fechaDesde, LocalDateTime fechaHasta, 
                                  Integer page, Integer size, String sort, String direction) {
        return ejecucionRepositoryPort.listar(solicitudId, codigoOrganizacion, codigoEnvio, 
                                              codigoEstado, fechaDesde, fechaHasta, 
                                              page, size, sort, direction);
    }
}
