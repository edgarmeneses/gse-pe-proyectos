package pe.gob.reniec.datosparentesco.application.service;

import pe.gob.reniec.datosparentesco.domain.ports.in.ListarAnalisisUseCase;
import pe.gob.reniec.datosparentesco.domain.ports.out.AnalisisParentescoRepositoryPort;

/**
 * Servicio de aplicación - Implementa el caso de uso de listar análisis de parentesco.
 */
public class ListarAnalisisService implements ListarAnalisisUseCase {
    
    private final AnalisisParentescoRepositoryPort repositoryPort;
    
    public ListarAnalisisService(AnalisisParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public ResultadoLista listar(String idCiudadano, String idSolicitud, String estado, 
                                String tipoVinculo, String fechaDesde, String fechaHasta, 
                                String usuarioTecnico, Integer pagina, Integer tamanioPagina) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
