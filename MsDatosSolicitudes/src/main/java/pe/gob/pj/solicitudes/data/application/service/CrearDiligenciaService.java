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
    public Diligencia ejecutar(Diligencia diligencia) {
        return diligenciaRepositoryPort.guardar(diligencia);
    }
}
