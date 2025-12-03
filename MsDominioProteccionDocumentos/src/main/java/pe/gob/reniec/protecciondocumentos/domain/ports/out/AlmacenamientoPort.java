package pe.gob.reniec.protecciondocumentos.domain.ports.out;

import pe.gob.reniec.protecciondocumentos.domain.model.Documento;
import pe.gob.reniec.protecciondocumentos.domain.model.DocumentoProtegido;

public interface AlmacenamientoPort {
    Documento obtenerDocumento(String documentoId);
    
    String almacenarDocumentoProtegido(DocumentoProtegido documentoProtegido);
}
