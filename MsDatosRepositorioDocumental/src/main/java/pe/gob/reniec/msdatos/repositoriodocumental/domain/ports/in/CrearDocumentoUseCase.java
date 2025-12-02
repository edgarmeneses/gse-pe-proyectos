package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.Map;

public interface CrearDocumentoUseCase {
    Documento crear(String archivoBase64, String carpetaId, Map<String, Object> metadata);
}
