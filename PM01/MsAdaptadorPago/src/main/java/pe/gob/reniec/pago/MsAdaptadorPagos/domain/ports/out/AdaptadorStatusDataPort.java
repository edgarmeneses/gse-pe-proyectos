package pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.out;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.AdaptadorBancario;
import java.util.List;

public interface AdaptadorStatusDataPort {
    List<AdaptadorBancario> obtenerEstado();
}
