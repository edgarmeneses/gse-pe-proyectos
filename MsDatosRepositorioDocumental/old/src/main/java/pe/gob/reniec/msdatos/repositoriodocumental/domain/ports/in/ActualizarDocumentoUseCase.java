package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.List;
import java.util.Map;

public interface ActualizarDocumentoUseCase {
    Documento actualizar(String id, String archivoBase64, String carpetaId, 
                        Map<String, Object> metadata, String estadoDocumento);
}
