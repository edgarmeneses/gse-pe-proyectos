package pe.gob.reniec.dominio.parentesco.domain.ports.in;

import pe.gob.reniec.dominio.parentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.model.SolicitudAnalisisParentesco;

public interface EjecutarAnalisisParentescoUseCase {
    AnalisisParentesco ejecutar(SolicitudAnalisisParentesco solicitud);
}
