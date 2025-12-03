package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatosciudadano.domain.model.CambioDomicilio;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultarCambiosDomicilioUseCase;
import java.util.List;

public class DomicilioController {
    private final ConsultarCambiosDomicilioUseCase consultarCambiosDomicilioUseCase;

    public DomicilioController(ConsultarCambiosDomicilioUseCase consultarCambiosDomicilioUseCase) {
        this.consultarCambiosDomicilioUseCase = consultarCambiosDomicilioUseCase;
    }

    public List<CambioDomicilio> consultarCambiosDomicilio(String fechaDesde, String fechaHasta, 
                                                           String circunscripcionId, String queryParam1, 
                                                           String queryParam2, String queryParam3) {
        return consultarCambiosDomicilioUseCase.consultar(fechaDesde, fechaHasta, circunscripcionId, 
                                                          queryParam1, queryParam2, queryParam3);
    }
}
