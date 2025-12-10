package pe.reniec.firma.application.service;

import pe.reniec.firma.domain.model.ProcesoFirma;
import pe.reniec.firma.domain.model.SolicitudFirma;
import pe.reniec.firma.domain.ports.in.FirmarDocumentoUseCase;
import pe.reniec.firma.domain.ports.out.FirmaDataPort;

public class FirmarDocumentoService implements FirmarDocumentoUseCase {

    private final FirmaDataPort firmaDataPort;

    public FirmarDocumentoService(FirmaDataPort firmaDataPort) {
        this.firmaDataPort = firmaDataPort;
    }

    @Override
    public ProcesoFirma firmar(SolicitudFirma solicitud) {
        return firmaDataPort.firmar(solicitud);
    }
}
