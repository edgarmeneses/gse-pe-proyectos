package pe.gob.reniec.gse.datosparentesco.domain.ports.in;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;

public interface RegistrarRelacionParentescoUseCase {
    RelacionParentesco registrar(RelacionParentesco relacionParentesco);
}
