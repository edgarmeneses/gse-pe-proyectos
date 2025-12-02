package pe.gob.reniec.protecciondocumentos.domain.ports.in;

import pe.gob.reniec.protecciondocumentos.domain.model.ProteccionDocumento;
import pe.gob.reniec.protecciondocumentos.domain.model.SolicitudProteccion;

public interface CrearProteccionDocumentoUseCase {
    ProteccionDocumento crearProteccionDocumento(SolicitudProteccion solicitudProteccion);
}
