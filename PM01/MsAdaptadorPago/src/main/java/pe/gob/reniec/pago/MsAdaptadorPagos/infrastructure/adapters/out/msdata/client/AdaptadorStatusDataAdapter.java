package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.AdaptadorBancario;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.out.AdaptadorStatusDataPort;
import java.util.List;

public class AdaptadorStatusDataAdapter implements AdaptadorStatusDataPort {

    @Override
    public List<AdaptadorBancario> obtenerEstado() {
        throw new UnsupportedOperationException("Integración con adaptadores bancarios pendiente");
    }
}
