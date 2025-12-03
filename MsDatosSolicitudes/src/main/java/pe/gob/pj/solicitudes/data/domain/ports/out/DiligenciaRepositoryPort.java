package pe.gob.pj.solicitudes.data.domain.ports.out;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;

public interface DiligenciaRepositoryPort {
    
    Diligencia guardar(Diligencia diligencia);
    
    Diligencia buscarPorId(String diligenciaId);
}
