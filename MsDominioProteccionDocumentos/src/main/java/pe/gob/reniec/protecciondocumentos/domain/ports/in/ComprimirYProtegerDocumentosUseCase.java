package pe.gob.reniec.protecciondocumentos.domain.ports.in;

import pe.gob.reniec.protecciondocumentos.domain.model.ProcesoProteccion;
import pe.gob.reniec.protecciondocumentos.domain.model.SolicitudProteccion;

public interface ComprimirYProtegerDocumentosUseCase {
    ProcesoProteccion ejecutar(SolicitudProteccion solicitud);
}
