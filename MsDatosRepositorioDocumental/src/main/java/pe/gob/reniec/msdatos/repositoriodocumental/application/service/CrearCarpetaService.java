package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.CrearCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;

/**
 * Servicio de aplicación: Crear Carpeta
 * Implementa la lógica de negocio para crear carpetas.
 */
public class CrearCarpetaService implements CrearCarpetaUseCase {

    private final CarpetaRepositoryPort carpetaRepositoryPort;

    public CrearCarpetaService(CarpetaRepositoryPort carpetaRepositoryPort) {
        this.carpetaRepositoryPort = carpetaRepositoryPort;
    }

    @Override
    public Carpeta crear(Carpeta carpeta) {
        // Aquí iría la lógica de validación de negocio antes de persistir
        return carpetaRepositoryPort.guardar(carpeta);
    }
}
