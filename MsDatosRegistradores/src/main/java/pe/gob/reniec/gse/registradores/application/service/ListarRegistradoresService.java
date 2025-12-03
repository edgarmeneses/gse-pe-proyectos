package pe.gob.reniec.gse.registradores.application.service;

import pe.gob.reniec.gse.registradores.application.query.BuscarRegistradoresCriteria;
import pe.gob.reniec.gse.registradores.application.query.RegistradoresPaginados;
import pe.gob.reniec.gse.registradores.domain.ports.in.ListarRegistradoresUseCase;
import pe.gob.reniec.gse.registradores.domain.ports.out.RegistradorRepositoryPort;

/**
 * Servicio de aplicación: Listar Registradores
 * Implementa la lógica de negocio para listar registradores con filtros.
 */
public class ListarRegistradoresService implements ListarRegistradoresUseCase {
    
    private final RegistradorRepositoryPort registradorRepository;
    
    public ListarRegistradoresService(RegistradorRepositoryPort registradorRepository) {
        this.registradorRepository = registradorRepository;
    }
    
    @Override
    public RegistradoresPaginados listar(BuscarRegistradoresCriteria criteria) {
        // Validar criterios de entrada
        if (criteria == null) {
            throw new IllegalArgumentException("Los criterios de búsqueda no pueden ser nulos");
        }
        
        // Aplicar valores por defecto y validaciones
        Long pagina = criteria.pagina() != null && criteria.pagina() >= 1 ? criteria.pagina() : 1L;
        Long registrosPorPagina = criteria.registrosPorPagina() != null && criteria.registrosPorPagina() >= 1 
            ? criteria.registrosPorPagina() : 10L;
        
        // Limitar el máximo de registros por página
        if (registrosPorPagina > 100) {
            registrosPorPagina = 100L;
        }
        
        // Crear criterios normalizados
        BuscarRegistradoresCriteria criteriaNormalizado = new BuscarRegistradoresCriteria(
            criteria.codigoLocal(),
            criteria.estado(),
            criteria.numeroDni(),
            criteria.nombreRegistrador(),
            pagina,
            registrosPorPagina
        );
        
        // Buscar registradores con los filtros aplicados
        return registradorRepository.buscarConFiltros(criteriaNormalizado);
    }
}
