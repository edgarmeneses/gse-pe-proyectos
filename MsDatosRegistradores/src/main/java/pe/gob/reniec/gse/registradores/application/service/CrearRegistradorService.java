package pe.gob.reniec.gse.registradores.application.service;

import pe.gob.reniec.gse.registradores.domain.model.Registrador;
import pe.gob.reniec.gse.registradores.domain.ports.in.CrearRegistradorUseCase;
import pe.gob.reniec.gse.registradores.domain.ports.out.RegistradorRepositoryPort;

/**
 * Servicio de aplicación: Crear Registrador
 * Implementa la lógica de negocio para crear un nuevo registrador.
 */
public class CrearRegistradorService implements CrearRegistradorUseCase {
    
    private final RegistradorRepositoryPort registradorRepository;
    
    public CrearRegistradorService(RegistradorRepositoryPort registradorRepository) {
        this.registradorRepository = registradorRepository;
    }
    
    @Override
    public Registrador crear(Registrador registrador) {
        // Validar que el registrador no sea nulo
        if (registrador == null) {
            throw new IllegalArgumentException("El registrador no puede ser nulo");
        }
        
        // Validar que no exista un registrador con el mismo DNI
        if (registradorRepository.existePorDni(registrador.getNumeroDni())) {
            throw new IllegalArgumentException(
                "Ya existe un registrador con el DNI: " + registrador.getNumeroDni()
            );
        }
        
        // El ID es generado en el dominio, validar que sea único si ya viene asignado
        if (registrador.getIdRegistrador() != null && 
            registradorRepository.existePorId(registrador.getIdRegistrador())) {
            throw new IllegalArgumentException(
                "Ya existe un registrador con el ID: " + registrador.getIdRegistrador()
            );
        }
        
        // Persistir el registrador
        return registradorRepository.guardar(registrador);
    }
}
