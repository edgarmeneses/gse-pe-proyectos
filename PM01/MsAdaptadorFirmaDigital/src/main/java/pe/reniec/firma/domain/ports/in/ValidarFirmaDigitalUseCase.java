package pe.reniec.firma.domain.ports.in;

import pe.reniec.firma.domain.model.ProcesoValidacion;
import pe.reniec.firma.domain.model.SolicitudValidacion;

public interface ValidarFirmaDigitalUseCase {
    ProcesoValidacion validar(SolicitudValidacion solicitud);
}
