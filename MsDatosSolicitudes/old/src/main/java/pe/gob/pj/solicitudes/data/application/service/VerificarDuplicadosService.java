package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.ports.in.VerificarDuplicadosUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;

public class VerificarDuplicadosService implements VerificarDuplicadosUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;
    
    public VerificarDuplicadosService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }
    
    @Override
    public Boolean verificar(String criterio) {
        return solicitudRepositoryPort.existePorCriterio(criterio);
    }
}
