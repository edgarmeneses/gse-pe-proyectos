package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ConsultarRelacionesUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.RelacionParentescoRepositoryPort;
import java.util.List;

public class ConsultarRelacionesService implements ConsultarRelacionesUseCase {
    private final RelacionParentescoRepositoryPort relacionParentescoRepositoryPort;

    public ConsultarRelacionesService(RelacionParentescoRepositoryPort relacionParentescoRepositoryPort) {
        this.relacionParentescoRepositoryPort = relacionParentescoRepositoryPort;
    }

    @Override
    public List<RelacionParentesco> consultarPorCiudadano(String idCiudadano, String tipoParentesco,
                                                           Integer gradoMaximo, Boolean incluirInactivos) {
        return relacionParentescoRepositoryPort.consultarPorCiudadano(idCiudadano, tipoParentesco,
                gradoMaximo, incluirInactivos);
    }
}
