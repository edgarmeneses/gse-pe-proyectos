package pe.reniec.firma.domain.ports.in;

import pe.reniec.firma.domain.model.ProcesoLote;
import pe.reniec.firma.domain.model.SolicitudLote;

public interface FirmarLoteUseCase {
    ProcesoLote firmarLote(SolicitudLote solicitud);
}
