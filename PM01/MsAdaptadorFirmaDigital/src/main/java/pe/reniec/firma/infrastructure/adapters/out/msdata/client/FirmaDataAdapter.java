package pe.reniec.firma.infrastructure.adapters.out.msdata.client;

import pe.reniec.firma.domain.model.ProcesoFirma;
import pe.reniec.firma.domain.model.ProcesoLote;
import pe.reniec.firma.domain.model.ProcesoValidacion;
import pe.reniec.firma.domain.model.SolicitudFirma;
import pe.reniec.firma.domain.model.SolicitudLote;
import pe.reniec.firma.domain.model.SolicitudValidacion;
import pe.reniec.firma.domain.ports.out.FirmaDataPort;

public class FirmaDataAdapter implements FirmaDataPort {

    @Override
    public ProcesoFirma firmar(SolicitudFirma solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente de integración con proveedor de firma");
    }

    @Override
    public ProcesoLote firmarLote(SolicitudLote solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente de integración con proveedor de firma masiva");
    }

    @Override
    public ProcesoValidacion validar(SolicitudValidacion solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente de integración con servicio de validación");
    }
}
