package pe.gob.reniec.dominio.parentesco.domain.ports.out;

import pe.gob.reniec.dominio.parentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.model.SolicitudAnalisisParentesco;

public interface ParentescoDataPort {
    AnalisisParentesco crearAnalisis(AnalisisParentesco analisis);
    AnalisisParentesco actualizarAnalisis(AnalisisParentesco analisis);
    AnalisisParentesco consultarAnalisis(String idAnalisis);
}
