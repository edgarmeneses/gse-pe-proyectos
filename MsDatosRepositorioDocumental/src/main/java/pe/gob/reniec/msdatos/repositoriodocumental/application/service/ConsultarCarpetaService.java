package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;
import java.util.Map;

/**
 * Servicio de aplicación: Consultar Carpeta
 * Implementa la lógica de negocio para consultar el contenido de carpetas.
 */
public class ConsultarCarpetaService implements ConsultarCarpetaUseCase {

    private final CarpetaRepositoryPort carpetaRepositoryPort;

    public ConsultarCarpetaService(CarpetaRepositoryPort carpetaRepositoryPort) {
        this.carpetaRepositoryPort = carpetaRepositoryPort;
    }

    @Override
    public pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarCarpetaResponseDto consultarContenido(String id, Map<String, String> filtros, Integer page, Integer size) {
        return carpetaRepositoryPort.consultarContenido(id, filtros, page, size);
    }
}
