package pe.gob.reniec.gse.datosparentesco.domain.ports.in;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;
import java.util.List;

public interface ConsultarRelacionesUseCase {
    List<RelacionParentesco> consultarPorCiudadano(String idCiudadano, String tipoParentesco,
                                                    Integer gradoMaximo, Boolean incluirInactivos);
}
