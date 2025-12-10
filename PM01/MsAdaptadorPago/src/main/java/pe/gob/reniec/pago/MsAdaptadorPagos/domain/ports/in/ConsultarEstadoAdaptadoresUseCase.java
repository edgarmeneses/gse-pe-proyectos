package pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.in;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.AdaptadorBancario;
import java.util.List;

public interface ConsultarEstadoAdaptadoresUseCase {
    List<AdaptadorBancario> consultar();
}
