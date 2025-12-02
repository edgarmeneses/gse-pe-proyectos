package pe.gob.reniec.siirc.msdatosgrafos.application.service;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.ConsultaVinculosResult;
import pe.gob.reniec.siirc.msdatosgrafos.domain.ports.in.ConsultarVinculosParentescoUseCase;
import pe.gob.reniec.siirc.msdatosgrafos.domain.ports.out.VinculoParentescoRepositoryPort;

/**
 * Servicio de aplicación que implementa el caso de uso de consultar vínculos de parentesco
 */
public class ConsultarVinculosParentescoService implements ConsultarVinculosParentescoUseCase {
    
    private final VinculoParentescoRepositoryPort repositoryPort;

    public ConsultarVinculosParentescoService(VinculoParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ConsultaVinculosResult consultar(String idCiudadano, Long gradoMaximo, 
                                           String categoriaParentesco, Boolean soloVigentes, 
                                           Long pagina, Long registrosPorPagina) {
        return repositoryPort.consultarVinculosParentesco(idCiudadano, gradoMaximo, 
                                                          categoriaParentesco, soloVigentes, 
                                                          pagina, registrosPorPagina);
    }
}
