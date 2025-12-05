package pe.gob.reniec.adaptadorbanconacion.domain.ports.in;

import pe.gob.reniec.adaptadorbanconacion.domain.model.SolicitudValidacion;
import pe.gob.reniec.adaptadorbanconacion.domain.model.Validacion;

public interface ValidarPagoBancoNacionUseCase {

    Validacion validar(SolicitudValidacion solicitud);
}
