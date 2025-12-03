package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.CambioDomicilio;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultarCambiosDomicilioUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CambioDomicilioRepositoryPort;
import java.util.List;

public class ConsultarCambiosDomicilioService implements ConsultarCambiosDomicilioUseCase {
    private final CambioDomicilioRepositoryPort repositoryPort;

    public ConsultarCambiosDomicilioService(CambioDomicilioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<CambioDomicilio> consultar(String fechaDesde, String fechaHasta, String circunscripcionId, 
                                           String queryParam1, String queryParam2, String queryParam3) {
        return repositoryPort.consultar(fechaDesde, fechaHasta, circunscripcionId, queryParam1, queryParam2, queryParam3);
    }
}
