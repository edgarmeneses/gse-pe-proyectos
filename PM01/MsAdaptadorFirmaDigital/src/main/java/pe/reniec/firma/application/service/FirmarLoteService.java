package pe.reniec.firma.application.service;

import pe.reniec.firma.domain.model.ProcesoLote;
import pe.reniec.firma.domain.model.SolicitudLote;
import pe.reniec.firma.domain.ports.in.FirmarLoteUseCase;
import pe.reniec.firma.domain.ports.out.FirmaDataPort;

public class FirmarLoteService implements FirmarLoteUseCase {

    private final FirmaDataPort firmaDataPort;

    public FirmarLoteService(FirmaDataPort firmaDataPort) {
        this.firmaDataPort = firmaDataPort;
    }

    @Override
    public ProcesoLote firmarLote(SolicitudLote solicitud) {
        return firmaDataPort.firmarLote(solicitud);
    }
}
