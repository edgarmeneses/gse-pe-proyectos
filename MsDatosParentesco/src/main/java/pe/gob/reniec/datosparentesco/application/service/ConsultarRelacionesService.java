package pe.gob.reniec.datosparentesco.application.service;

import pe.gob.reniec.datosparentesco.domain.ports.in.ConsultarRelacionesUseCase;
import pe.gob.reniec.datosparentesco.domain.ports.out.RelacionParentescoRepositoryPort;

/**
 * Servicio de aplicación - Implementa el caso de uso de consultar relaciones de parentesco.
 */
public class ConsultarRelacionesService implements ConsultarRelacionesUseCase {
    
    private final RelacionParentescoRepositoryPort repositoryPort;
    
    public ConsultarRelacionesService(RelacionParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public ResultadoConsulta consultar(String idCiudadano, String tipoParentesco, 
                                      Integer gradoMaximo, Boolean incluirInactivos) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
