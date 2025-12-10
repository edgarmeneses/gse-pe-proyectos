package pe.reniec.firma.domain.ports.in;

import pe.reniec.firma.domain.model.ProcesoFirma;
import pe.reniec.firma.domain.model.SolicitudFirma;

public interface FirmarDocumentoUseCase {
    ProcesoFirma firmar(SolicitudFirma solicitud);
}
