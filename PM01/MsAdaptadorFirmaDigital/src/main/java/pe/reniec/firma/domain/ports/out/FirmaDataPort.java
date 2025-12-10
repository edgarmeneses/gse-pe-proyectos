package pe.reniec.firma.domain.ports.out;

import pe.reniec.firma.domain.model.ProcesoFirma;
import pe.reniec.firma.domain.model.ProcesoLote;
import pe.reniec.firma.domain.model.ProcesoValidacion;
import pe.reniec.firma.domain.model.SolicitudFirma;
import pe.reniec.firma.domain.model.SolicitudLote;
import pe.reniec.firma.domain.model.SolicitudValidacion;

public interface FirmaDataPort {
    ProcesoFirma firmar(SolicitudFirma solicitud);
    ProcesoLote firmarLote(SolicitudLote solicitud);
    ProcesoValidacion validar(SolicitudValidacion solicitud);
}
