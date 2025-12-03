package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import pe.gob.pj.solicitudes.data.domain.ports.in.VerTrazabilidadUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.TrazabilidadRepositoryPort;
import java.util.List;

public class VerTrazabilidadService implements VerTrazabilidadUseCase {
    
    private final TrazabilidadRepositoryPort trazabilidadRepositoryPort;
    
    public VerTrazabilidadService(TrazabilidadRepositoryPort trazabilidadRepositoryPort) {
        this.trazabilidadRepositoryPort = trazabilidadRepositoryPort;
    }
    
    @Override
    public List<Trazabilidad> ver(Long solicitudId) {
        return trazabilidadRepositoryPort.listarPorSolicitud(solicitudId);
    }
}
