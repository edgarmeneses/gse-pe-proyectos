package pe.gob.reniec.gse.registradores.application.service;

import pe.gob.reniec.gse.registradores.domain.model.Registrador;
import pe.gob.reniec.gse.registradores.domain.ports.in.ConsultarRegistradorUseCase;
import pe.gob.reniec.gse.registradores.domain.ports.out.RegistradorRepositoryPort;

/**
 * Servicio de aplicación: Consultar Registrador
 * Implementa la lógica de negocio para consultar un registrador específico.
 */
public class ConsultarRegistradorService implements ConsultarRegistradorUseCase {
    
    private final RegistradorRepositoryPort registradorRepository;
    
    public ConsultarRegistradorService(RegistradorRepositoryPort registradorRepository) {
        this.registradorRepository = registradorRepository;
    }
    
    @Override
    public Registrador consultarPorId(String idRegistrador) {
        // Buscar el registrador por ID
        Registrador registrador = registradorRepository.buscarPorId(idRegistrador);
        
        // Validar que el registrador existe
        if (registrador == null) {
            throw new UnsupportedOperationException(
                "No se encontró el registrador con ID: " + idRegistrador
            );
        }
        
        return registrador;
    }
}
