package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ActualizarCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;

/**
 * Servicio de aplicación: Actualizar Carpeta
 * Implementa la lógica de negocio para actualizar carpetas.
 */
public class ActualizarCarpetaService implements ActualizarCarpetaUseCase {

    private final CarpetaRepositoryPort carpetaRepositoryPort;

    public ActualizarCarpetaService(CarpetaRepositoryPort carpetaRepositoryPort) {
        this.carpetaRepositoryPort = carpetaRepositoryPort;
    }

    @Override
    public Carpeta actualizar(String id, Carpeta carpeta) {
        // Aquí iría la lógica de validación y reglas de negocio
        return carpetaRepositoryPort.actualizar(id, carpeta);
    }
}
