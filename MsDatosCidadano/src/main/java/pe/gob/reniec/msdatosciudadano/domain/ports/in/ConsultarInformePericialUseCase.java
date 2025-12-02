package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.InformePericial;
import java.util.List;

public interface ConsultarInformePericialUseCase {
    List<InformePericial> consultar(String tipoDocumento, String numeroDocumento);
}
