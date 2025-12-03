package pe.gob.reniec.siirc.msdatosgrafos.application.service;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.CategoriaParentesco;
import pe.gob.reniec.siirc.msdatosgrafos.domain.model.GrafoParentesco;
import pe.gob.reniec.siirc.msdatosgrafos.domain.ports.in.ConsultarVinculosParentescoUseCase;
import pe.gob.reniec.siirc.msdatosgrafos.domain.ports.out.VinculoParentescoRepositoryPort;

/**
 * Servicio de aplicación que implementa el caso de uso de consultar vínculos de parentesco.
 * Esta capa orquesta la lógica de dominio sin contener lógica de negocio.
 */
public class ConsultarVinculosParentescoService implements ConsultarVinculosParentescoUseCase {
    
    private final VinculoParentescoRepositoryPort repositoryPort;

    public ConsultarVinculosParentescoService(VinculoParentescoRepositoryPort repositoryPort) {
        if (repositoryPort == null) {
            throw new IllegalArgumentException("El repositoryPort es obligatorio");
        }
        this.repositoryPort = repositoryPort;
    }

    @Override
    public GrafoParentesco consultar(String idCiudadano, 
                                     Integer gradoMaximo, 
                                     CategoriaParentesco categoria, 
                                     Boolean soloVigentes) {
        if (idCiudadano == null || idCiudadano.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del ciudadano es obligatorio");
        }
        
        return repositoryPort.consultarGrafoParentesco(
            idCiudadano, 
            gradoMaximo, 
            categoria, 
            soloVigentes
        );
    }
}
