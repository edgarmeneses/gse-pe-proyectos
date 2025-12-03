package pe.gob.reniec.msdatosciudadano.domain.ports.out;

import pe.gob.reniec.msdatosciudadano.domain.model.InformePericial;
import java.util.List;

public interface InformePericialRepositoryPort {
    List<InformePericial> buscarPorDocumento(String tipoDocumento, String numeroDocumento);
}
