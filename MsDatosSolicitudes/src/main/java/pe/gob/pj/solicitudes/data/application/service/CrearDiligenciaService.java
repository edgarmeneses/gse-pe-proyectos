package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.domain.ports.in.CrearDiligenciaUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.DiligenciaRepositoryPort;

public class CrearDiligenciaService implements CrearDiligenciaUseCase {
    
    private final DiligenciaRepositoryPort diligenciaRepositoryPort;
    
    public CrearDiligenciaService(DiligenciaRepositoryPort diligenciaRepositoryPort) {
        this.diligenciaRepositoryPort = diligenciaRepositoryPort;
    }
    
    @Override
    public Diligencia crear(Long solicitudId, Diligencia diligencia) {
        diligencia.setSolicitudId(solicitudId);
        return diligenciaRepositoryPort.guardar(diligencia);
    }
}
