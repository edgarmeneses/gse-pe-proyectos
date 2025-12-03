package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;

public interface CrearDiligenciaUseCase {
    
    Diligencia ejecutar(Diligencia diligencia);
}
