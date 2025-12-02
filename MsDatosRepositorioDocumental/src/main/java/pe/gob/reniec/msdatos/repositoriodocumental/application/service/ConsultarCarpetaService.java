package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;
import java.util.Map;

public class ConsultarCarpetaService implements ConsultarCarpetaUseCase {
    private final CarpetaRepositoryPort carpetaRepositoryPort;

    public ConsultarCarpetaService(CarpetaRepositoryPort carpetaRepositoryPort) {
        this.carpetaRepositoryPort = carpetaRepositoryPort;
    }

    @Override
    public Map<String, Object> consultarContenido(String id, String queryParam1, String queryParam2, 
                                                  String queryParam3, Integer page, Integer size) {
        return carpetaRepositoryPort.consultarContenido(id, queryParam1, queryParam2, queryParam3, page, size);
    }
}
