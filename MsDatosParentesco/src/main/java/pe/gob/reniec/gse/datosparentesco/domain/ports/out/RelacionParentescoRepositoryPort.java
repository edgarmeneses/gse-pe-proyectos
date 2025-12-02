package pe.gob.reniec.gse.datosparentesco.domain.ports.out;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;
import java.util.List;

public interface RelacionParentescoRepositoryPort {
    RelacionParentesco guardar(RelacionParentesco relacionParentesco);
    List<RelacionParentesco> consultarPorCiudadano(String idCiudadano, String tipoParentesco,
                                                     Integer gradoMaximo, Boolean incluirInactivos);
}
