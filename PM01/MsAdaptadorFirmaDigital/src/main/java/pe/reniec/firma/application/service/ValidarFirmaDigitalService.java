package pe.reniec.firma.application.service;

import pe.reniec.firma.domain.model.ProcesoValidacion;
import pe.reniec.firma.domain.model.SolicitudValidacion;
import pe.reniec.firma.domain.ports.in.ValidarFirmaDigitalUseCase;
import pe.reniec.firma.domain.ports.out.FirmaDataPort;

public class ValidarFirmaDigitalService implements ValidarFirmaDigitalUseCase {

    private final FirmaDataPort firmaDataPort;

    public ValidarFirmaDigitalService(FirmaDataPort firmaDataPort) {
        this.firmaDataPort = firmaDataPort;
    }

    @Override
    public ProcesoValidacion validar(SolicitudValidacion solicitud) {
        return firmaDataPort.validar(solicitud);
    }
}
