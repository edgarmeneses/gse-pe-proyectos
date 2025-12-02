package pe.gob.reniec.gse.datosparentesco.domain.ports.in;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;

public interface ConsultarAnalisisUseCase {
    Analisis consultarPorId(String idAnalisis);
}
