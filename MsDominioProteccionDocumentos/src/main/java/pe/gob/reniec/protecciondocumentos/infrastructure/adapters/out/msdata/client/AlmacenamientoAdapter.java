package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.protecciondocumentos.domain.model.Documento;
import pe.gob.reniec.protecciondocumentos.domain.model.DocumentoProtegido;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.AlmacenamientoPort;

public class AlmacenamientoAdapter implements AlmacenamientoPort {

    @Override
    public Documento obtenerDocumento(String documentoId) {
        throw new UnsupportedOperationException("Implementación pendiente - integración con MsGestorDocumentos");
    }

    @Override
    public String almacenarDocumentoProtegido(DocumentoProtegido documentoProtegido) {
        throw new UnsupportedOperationException("Implementación pendiente - integración con MsGestorDocumentos");
    }
}
